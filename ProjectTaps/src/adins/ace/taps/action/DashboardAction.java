package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

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

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.DashboardManager;

public class DashboardAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DashboardForm dForm = (DashboardForm) form;
		DashboardManager dMan = new DashboardManager();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("taskCode") != null) {
			session.removeAttribute("taskCode");
		}
		Map params = new HashMap();
		String userDomain = "domain3";
		
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

		if ("approvalDashboard".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListApproval(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListApproval(params));
			return mapping.findForward("ListAssignment");
		} else if ("claimDashboard".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListClaim(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListClaim(params));
			return mapping.findForward("ListAssignment");
		} else if ("approvalSelfDashboard".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListApprovalSelf(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListApprovalSelf(params));
			return mapping.findForward("ListAssignment");
		} else if ("correctionDashboard".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListCorrection(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListCorrection(params));
			return mapping.findForward("ListAssignment");
		} else if ("correctionSelfDashboard".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListCorrectionSelf(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListCorrectionSelf(params));
			return mapping.findForward("ListAssignment");
		} 
		
		if ("getPhoto".equals(dForm.getTask())) {
			DashboardBean bean = new DashboardBean();
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
		dForm.setListTopTen(dMan.searchTopTen());
		dForm.setListTopTenOrganization(dMan.searchTopTenOrganization("CDD"));
		return mapping.findForward("Dashboard");
	}
	
	/*extract image in project resources to byte[]*/
	public byte[] extractBytes (String ImageName) throws IOException {
		File fnew = null;
		fnew = new File(getServlet().getServletContext().getRealPath("/")+ImageName);
		
		BufferedImage bufferedImage = ImageIO.read(fnew);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bufferedImage, "png", baos);
	    byte[] res=baos.toByteArray();
	    return res;
	}
}
