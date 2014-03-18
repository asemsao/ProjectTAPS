package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.manager.DashboardManager;

public class DashboardAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DashboardForm dForm = (DashboardForm) form;
		DashboardManager dMan = new DashboardManager();
		AssignmentManager aMan = new AssignmentManager();
		DashboardBean bean = new DashboardBean();
		HttpSession session = request.getSession(true);
		Map params = new HashMap();
		String userDomain = "domain3";
		System.out.println(dForm.getTask() + dForm.getTaskType());
		/*code for each record and their own status*/
		if ("CLAIM".equals(dForm.getTask())){
			dForm.setdBean(dMan.searchRecordAssignment(dForm.getTaskCode()));
			return mapping.findForward("Claim");
		}
		if ("CORRECTION".equals(dForm.getTask()) && "SELF ASSIGNMENT".equals(dForm.getTaskType())){
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(dForm.getTaskCode()));
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			session.setAttribute("adhoc", dForm.getSelfAssignBean().getActivityType());
			return mapping.findForward("CorrectionSelf");
		}
		if ("CORRECTION".equals(dForm.getTask()) && "ASSIGNMENT".equals(dForm.getTaskType())){
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(dForm.getTaskCode()));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Correction");
		}
		if ("RFA".equals(dForm.getTask())  && "SELF ASSIGNMENT".equals(dForm.getTaskType())){
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(dForm.getTaskCode()));
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			session.setAttribute("adhoc", dForm.getSelfAssignBean().getActivityType());
			return mapping.findForward("ApprovalSelf");
		}
		if ("RFA".equals(dForm.getTask())  && "ASSIGNMENT".equals(dForm.getTaskType())){
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(dForm.getTaskCode()));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Approval");
		}
		
		if (session.getAttribute("taskCode") != null) {
			session.removeAttribute("taskCode");
		}

		if (dForm.getPage() == null) {
			dForm.setPage(1);
		}

		if ("first".equals(dForm.getTask())) {
			dForm.setPage(1);
		}

		else if ("last".equals(dForm.getTask())) {
			dForm.setPage(dForm.getMaxPage());
		}

		else if ("prev".equals(dForm.getTask())) {
			if (dForm.getPage() > 1) {
				dForm.setPage(dForm.getPage() - 1);
			}
		} else if ("next".equals(dForm.getTask())) {
			if (dForm.getPage() < dForm.getMaxPage()) {
				dForm.setPage(dForm.getPage() + 1);
			}
		}

		params.put("start", (dForm.getPage() - 1) * 10 + 1);
		params.put("end", (dForm.getPage() * 10));
		params.put("category", dForm.getCategory());
		params.put("keyword", dForm.getKeyword());
		params.put("startDate", dForm.getStartDate());
		params.put("endDate", dForm.getEndDate());
		params.put("userDomain", userDomain);

		if ("approvalDashboard".equals(dForm.getTask())) {
			params.put("userDomain", "DOMAIN205");
			dForm.setListAssignment(dMan.searchListApproval(params));
			dForm.setCountRecord(dMan.countListApproval(params));
		}
		if ("claimDashboard".equals(dForm.getTask())) {
			dForm.setListAssignment(dMan.searchListClaim(params));
			dForm.setCountRecord(dMan.countListClaim(params));
		}
		if ("approvalSelfDashboard".equals(dForm.getTask())) {
			params.put("userDomain", "DOMAIN205");
			dForm.setListAssignment(dMan.searchListApprovalSelf(params));
			dForm.setCountRecord(dMan.countListApprovalSelf(params));
			return mapping.findForward("ListAssignment");
		}
		if ("correctionDashboard".equals(dForm.getTask())) {
			dForm.setListAssignment(dMan.searchListCorrection(params));
			dForm.setCountRecord(dMan.countListCorrection(params));
		}
		if ("correctionSelfDashboard".equals(dForm.getTask())) {
			dForm.setListAssignment(dMan.searchListCorrectionSelf(params));
			dForm.setCountRecord(dMan.countListCorrectionSelf(params));
		}
		
		if ("approvalDashboard".equals(dForm.getTask())
				|| "claimDashboard".equals(dForm.getTask())
				|| "approvalSelfDashboard".equals(dForm.getTask())
				|| "correctionDashboard".equals(dForm.getTask())
				|| "correctionSelfDashboard".equals(dForm.getTask())) {
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ListAssignment");
		}
		
		if ("getPhoto".equals(dForm.getTask())) {
			
			bean = dMan.getPhotoEmployees(dForm.getEmployeeDomain());
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			OutputStream outStream = response.getOutputStream();
			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					byte[] buffer = bean.getProfilePicture();
					if (buffer == null) {
						buffer = extractBytes("images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					System.out.println("catch 1");
					e.printStackTrace();
				} finally {
					if (output != null)
						try {
							output.flush();
							output.close();
						} catch (IOException logOrIgnore) {
							System.err.println(logOrIgnore);
						}
					if (input != null)
						try {
							input.close();
						} catch (IOException logOrIgnore) {
							System.err.println(logOrIgnore);
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		dForm.setTotalClaim(dMan.searchTotalClaim(userDomain));
		dForm.setTotalRFA(dMan.searchTotalRFA(userDomain));
		dForm.setTotalRFAself(dMan.searchTotalRFASelf(userDomain));
		dForm.setTotalCorrection(dMan.searchTotalCorrection(userDomain));
		dForm.setTotalCorrectionSelf(dMan.searchTotalCorrectionSelf(userDomain));

		if ("autoRefresh".equals(dForm.getTask())) {
			PrintWriter out = response.getWriter();			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(dForm);
			out.print(json);
			return null;
		}

		dForm.setListTopTen(dMan.searchTopTen());
		dForm.setListTopTenOrganization(dMan.searchTopTenOrganization("CDD"));
		return mapping.findForward("Dashboard");
	}

	/* extract image in project resources to byte[] */
	public byte[] extractBytes(String ImageName) throws IOException {
		File fnew = null;
		fnew = new File(getServlet().getServletContext().getRealPath("/")+ImageName);
		BufferedImage bufferedImage = ImageIO.read(fnew);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);
		byte[] res = baos.toByteArray();
		return res;
	}
}
