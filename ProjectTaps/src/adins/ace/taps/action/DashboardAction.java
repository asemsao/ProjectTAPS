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

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
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
		boolean success = false;
		Map params = new HashMap();
		Map rankingLast = new HashMap();
		Map rankingCurrent = new HashMap();

		String userDomain = "domain3";
		/* code to display detail record each status */
		if ("CLAIM".equals(dForm.getTask())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setClaimBean(aMan.searchRecordAssignment(dForm.getTaskCode()));
			return mapping.findForward("Claim");
		}
		if ("CORRECTION".equals(dForm.getTask())
				&& "SELF ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(dForm.getTaskCode()));
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			session.setAttribute("adhoc", dForm.getSelfAssignBean().getActivityType());
			return mapping.findForward("CorrectionSelf");
		}
		if ("CORRECTION".equals(dForm.getTask())
				&& "ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(dForm.getTaskCode()));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Correction");
		}
		if ("RFA".equals(dForm.getTask())
				&& "SELF ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(dForm.getTaskCode()));
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			session.setAttribute("adhoc", dForm.getSelfAssignBean().getActivityType());
			return mapping.findForward("ApprovalSelf");
		}
		if ("RFA".equals(dForm.getTask()) && "ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(dForm.getTaskCode()));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Approval");
		}
		//-------------------------------------------------------------//
		
		//--------------Code for Action Button-------------------------//
		if("updateDetailClaim".equals(dForm.getTask())){
			PrintWriter out = response.getWriter();
			ClaimAssignmentBean claimBean = new ClaimAssignmentBean();
			claimBean.setUpdatedBy("DOMAIN205");
			claimBean.setManHours(Double.parseDouble(request.getParameter("manHour")));
			claimBean.setDetailId(Integer.parseInt(request.getParameter("detailId")));
			aMan.editDetailClaimAssignment(claimBean);
			aMan.getTotalManHours(dForm.getTaskCode());
			out.print("Success");
			return null;
		}
		if ("claim".equals(dForm.getTask())){
			//add to detail claim assignment -> back to list
			dForm.getClaimBean().setCreatedBy(userDomain);
			success = aMan.addDetailClaimAssignment(dForm.getClaimBean());
			System.out.println(success);
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rfa".equals(dForm.getTask())){
			//add to detail claim assignment / add to history comment -> back to list
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getClaimBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println("update status, success = " + success);
			
			if (dForm.getClaimBean().getDetailDescription() != null){
				success = aMan.addDetailClaimAssignment(dForm.getClaimBean());
				System.out.println("add detail claim, success = " + success);
			}
			
			if (dForm.getClaimBean().getComment() != null){
				dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getReportTo());
				dForm.getClaimBean().setCreatedBy(userDomain);
				dForm.getClaimBean().setStatus("RFA");
				aMan.addHistoryComment(dForm.getClaimBean());
				System.out.println("add history comment, success = " + success);
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rfaSelf".equals(dForm.getTask())){
			// add to history comment -> back to list
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			success = aMan.updateStatus(paramStatus);
			
			dForm.getSelfAssignBean().setCommentTo(dForm.getSelfAssignBean().getReportTo());
			dForm.getSelfAssignBean().setCreatedBy(userDomain);
			String tmpDescription="";
			String tmpManHours="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDescription.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			dForm.getSelfAssignBean().setCurrentStatus("RFA");
			aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("approved".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("APPROVED");
			aMan.addHistoryComment(dForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy",userDomain);
			paramStatus.put("taskCode",dForm.getClaimBean().getTaskCode());
			paramStatus.put("flag","ACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//update table star
			dForm.getClaimBean().setStarBefore(0);
			aMan.addAssignmentStar(dForm.getClaimBean());
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("correction".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("CORRECTION");
			aMan.addHistoryComment(dForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getClaimBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("reject".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("REJECTED");
			aMan.addHistoryComment(dForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "REJECTED");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getClaimBean().getTaskCode());
			paramStatus.put("flag", "ACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("approvedSelf".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			String tmpDescription="";
			String tmpManHours="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDescription.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			dForm.getSelfAssignBean().setCurrentStatus("APPROVED");
			aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "ACTIVE");
			success = aMan.updateStatus(paramStatus);
			session.removeAttribute("taskCode");
			System.out.println(success);
			//update table star
			dForm.getSelfAssignBean().setStarBefore(0);
			aMan.addSelfAssignmentStar(dForm.getSelfAssignBean());
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("correctionSelf".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			String tmpDesctiption="";
			String tmpManHours="";
			tmpDesctiption = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDesctiption.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			dForm.getSelfAssignBean().setCurrentStatus("CORRECTION");
			aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rejectSelf".equals(dForm.getTask())){
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getSelfAssignBean().setCurrentStatus("REJECTED");
			aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", dForm.getSelfAssignBean().getCurrentStatus());
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "ACTIVE");
			success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("cancel".equals(dForm.getTask())){
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		//-------------------------------------------------------------//
		
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
			session.setAttribute("listDashboard", "approvalDashboard");
			dForm.setListAssignment(dMan.searchListApproval(params));
			dForm.setCountRecord(dMan.countListApproval(params));
		}
		if ("claimDashboard".equals(dForm.getTask())) {
			session.setAttribute("listDashboard", "claimDashboard");
			dForm.setListAssignment(dMan.searchListClaim(params));
			dForm.setCountRecord(dMan.countListClaim(params));
		}
		if ("approvalSelfDashboard".equals(dForm.getTask())) {
			session.setAttribute("listDashboard", "approvalSelfDashboard");
			params.put("userDomain", "DOMAIN205");
			dForm.setListAssignment(dMan.searchListApprovalSelf(params));
			dForm.setCountRecord(dMan.countListApprovalSelf(params));
		}
		if ("correctionDashboard".equals(dForm.getTask())) {
			session.setAttribute("listDashboard", "correctionDashboard");
			dForm.setListAssignment(dMan.searchListCorrection(params));
			dForm.setCountRecord(dMan.countListCorrection(params));
		}
		if ("correctionSelfDashboard".equals(dForm.getTask())) {
			session.setAttribute("listDashboard", "correctionSelfDashboard");
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

		if ("autoRefresh".equals(dForm.getMode())) {
			PrintWriter out = response.getWriter();			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(dForm);
			out.print(json);
			return null;
		}

		rankingLast.put("lastMonth", "true");
		rankingLast.put("organizationCode", "CDD");
		
		rankingCurrent.put("currentMonth", "true");
		rankingCurrent.put("organizationCode", "CDD");

		dForm.setListTopTen(dMan.searchTopTen(rankingCurrent));
		dForm.setListTopTenOrganization(dMan
				.searchTopTenOrganization(rankingCurrent));

		dForm.setListTopTenPrev(dMan.searchTopTen(rankingLast));
		dForm.setListTopTenOrganizationPrev(dMan
				.searchTopTenOrganization(rankingLast));

		return mapping.findForward("Dashboard");
	}

	/* extract image in project resources to byte[] */
	public byte[] extractBytes(String ImageName) throws IOException {
		File fnew = null;
		fnew = new File(getServlet().getServletContext().getRealPath("/")
				+ ImageName);
		BufferedImage bufferedImage = ImageIO.read(fnew);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);
		byte[] res = baos.toByteArray();
		return res;
	}
}
