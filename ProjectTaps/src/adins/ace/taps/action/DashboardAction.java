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
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.manager.DashboardManager;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.LoginManager;
import adins.ace.taps.module.ExtractPhoto;
import adins.ace.taps.module.SendMailTls;

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
		boolean success = true;
		boolean claim = true;
		boolean comment = true;
		boolean update = true;
		boolean starSuccess = true;
		Map params = new HashMap();
		Map rankingLast = new HashMap();
		Map rankingCurrent = new HashMap();
		params.put("maxDate", App.getConfiguration("max_date"));
		params.put("taskCode", dForm.getTaskCode());

		/* code to change password */
		if ("changePassword".equals(dForm.getTask())
				&& session.getAttribute("username") != null) {
			LoginManager lMan = new LoginManager();
			EmployeeManager mMan = new EmployeeManager();
			Map user = new HashMap();
			user.put("username", session.getAttribute("username"));
			user.put("password", dForm.getOldPassword());
			session.setAttribute("messagecolor", "red");
			if (lMan.tryLogin(user)) {
				if (dForm.getNewPassword().equals(
						dForm.getNewPasswordConfirmation())) {
					if (dForm.getNewPassword().length() > 5) {
						user.put("password", dForm.getNewPassword());
						if (mMan.updateLoginEmployee(user)) {
							session.setAttribute("messagecp",
									"Change Password SUCCESSFULL!");
							session.setAttribute("messagecolor", "green");
						} else {
							session.setAttribute("messagecp",
									"Change Password FAILED!");
						}
					} else {
						session.setAttribute("messagecp",
								"Password must be contain min. 6 characters");
					}

				} else {
					session.setAttribute("messagecp",
							"Change Password FAILED! Your Password is Doesn't Match");
				}
			} else {
				session.setAttribute("messagecp",
						"Change Password FAILED! Your Old Password is Incorrect!");
			}
			return mapping.findForward("Dashboard");
		}
		
		String userDomain = (String) session.getAttribute("username");
		/* code to display detail record each status */
		if ("CLAIM".equals(dForm.getTask())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setStringClaimDate(aMan.getClaimDate(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordAssignment(dForm.getTaskCode()));
			return mapping.findForward("Claim");
		}
		if ("CORRECTION".equals(dForm.getTask()) && "SELF ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(params));
			dForm.getSelfAssignBean().setCurrentStatus("CORRECTION");
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			return mapping.findForward("CorrectionSelf");
		}
		if ("CORRECTION".equals(dForm.getTask()) && "ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(params));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Correction");
		}
		if ("RFA".equals(dForm.getTask()) && "SELF ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(params));
			session.setAttribute("type", dForm.getSelfAssignBean().getAssignmentType());
			session.setAttribute("adhoc", dForm.getSelfAssignBean().getActivityType());
			return mapping.findForward("ApprovalSelf");
		}
		if ("RFA".equals(dForm.getTask()) && "ASSIGNMENT".equals(dForm.getTaskType())) {
			aMan.updateFlag(dForm.getTaskCode());
			dForm.setListDetailClaim(aMan.searchListDetailClaim(dForm.getTaskCode()));
			dForm.setClaimBean(aMan.searchRecordClaimAssignment(params));
			dForm.setTotalManHours(aMan.getTotalManHours(dForm.getTaskCode()));
			return mapping.findForward("Approval");
		}
		// -------------------------------------------------------------//

		// --------------Code for Action Button-------------------------//
		if ("updateDetailClaim".equals(dForm.getTask())) {
			PrintWriter out = response.getWriter();
			ClaimAssignmentBean claimBean = new ClaimAssignmentBean();
			claimBean.setUpdatedBy(userDomain);
			claimBean.setManHours(Double.parseDouble(request.getParameter("manHour")));
			claimBean.setDetailId(Integer.parseInt(request.getParameter("detailId")));
			aMan.editDetailClaimAssignment(claimBean);
			aMan.getTotalManHours(dForm.getTaskCode());
			out.print("Success");
			return null;
		}
		if ("claim".equals(dForm.getTask())) {
			// check if that day you've already claim assignment, add to detail
			// claim assignment -> back to list
			dForm.getClaimBean().setCreatedBy(userDomain);
			Map checkDetailClaim = new HashMap();
			checkDetailClaim.put("taskCode",dForm.getClaimBean().getTaskCode());
			checkDetailClaim.put("claimDate",dForm.getClaimBean().getClaimDate());
			aMan.startTransaction();
			success = aMan.addDetailClaimAssignment(dForm.getClaimBean());
			if (success){
				aMan.commitTransaction();
			} else {
				aMan.rollback();
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rfa".equals(dForm.getTask())) {
			// add to detail claim assignment / add to history comment -> back
			// to list
			aMan.startTransaction();
			String taskCode = dForm.getClaimBean().getTaskCode();
			if (dForm.getClaimBean().getDetailDescription() != null) {
				claim = aMan.addDetailClaimAssignment(dForm.getClaimBean());
			}

			if (dForm.getClaimBean().getComment() != null) {
				dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getReportTo());
				dForm.getClaimBean().setCreatedBy(userDomain);
				dForm.getClaimBean().setStatus("RFA");
				comment = aMan.addHistoryComment(dForm.getClaimBean());
			}

			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);

			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));
			if (claim && comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Assignment");
				emailParams.put("phase", "RFA");
				emailParams.put("taskCode", taskCode);
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rfaSelf".equals(dForm.getTask())) {
			// add to history comment -> back to list
			dForm.getSelfAssignBean().setCommentTo(dForm.getSelfAssignBean().getReportTo());
			dForm.getSelfAssignBean().setCreatedBy(userDomain);
			String tmpDescription="";
			String tmpManHours="";
			String tmpActivityType="";
			String tmpAdhocUserDomain="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			tmpActivityType = request.getParameter("tmpActivityType");
			tmpAdhocUserDomain = request.getParameter("tmpAdhocDomain");
			if (dForm.getSelfAssignBean().getActivityType().equals("Routine") || dForm.getSelfAssignBean().getActivityType().equals("Initiative")){
				dForm.getSelfAssignBean().setAdhocUserDomain(null);
			}
			if (!tmpDescription.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			if (!tmpActivityType.equals(dForm.getSelfAssignBean().getActivityType())) {
				aMan.editActivityType(dForm.getSelfAssignBean());
			}
			if (!tmpAdhocUserDomain.equals(dForm.getSelfAssignBean().getAdhocUserDomain())) {
				aMan.editAdhocUserDomain(dForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			dForm.getSelfAssignBean().setCurrentStatus("RFA");
			comment = aMan.addHistorySelfComment(dForm.getSelfAssignBean());

			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);

			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));
			
			
			if (comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Self Assignment");
				emailParams.put("phase", "RFA");
				emailParams.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("approved".equals(dForm.getTask())) {
			aMan.startTransaction();
			String taskCode = dForm.getClaimBean().getTaskCode();
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("APPROVED");
			comment = aMan.addHistoryComment(dForm.getClaimBean());

			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			// update table star
			dForm.getClaimBean().setStarBefore(0);
			starSuccess = aMan.addAssignmentStar(dForm.getClaimBean());
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update && starSuccess) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Assignment");
				emailParams.put("phase", "APPROVE");
				emailParams.put("taskCode", taskCode);
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("correction".equals(dForm.getTask())) {
			aMan.startTransaction();
			String taskCode = dForm.getClaimBean().getTaskCode();
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("CORRECTION");
			comment = aMan.addHistoryComment(dForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Assignment");
				emailParams.put("phase", "CORRECT");
				emailParams.put("taskCode", taskCode);
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("reject".equals(dForm.getTask())) {
			aMan.startTransaction();
			String taskCode = dForm.getClaimBean().getTaskCode();
			dForm.getClaimBean().setCommentTo(dForm.getClaimBean().getAssignTo());
			dForm.getClaimBean().setCreatedBy(userDomain);
			dForm.getClaimBean().setStatus("REJECTED");
			comment = aMan.addHistoryComment(dForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "REJECTED");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Assignment");
				emailParams.put("phase", "REJECT");
				emailParams.put("taskCode", taskCode);
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("approvedSelf".equals(dForm.getTask())) {
			dForm.getSelfAssignBean().setCommentTo(dForm.getSelfAssignBean().getAssignTo());
			dForm.getSelfAssignBean().setCreatedBy(userDomain);
			String tmpDescription = "";
			String tmpManHours = "";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDescription.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			dForm.getSelfAssignBean().setCurrentStatus("APPROVED");
			comment = aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			// update table star
			dForm.getSelfAssignBean().setStarBefore(0);
			starSuccess = aMan.addSelfAssignmentStar(dForm.getSelfAssignBean());
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update && starSuccess) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Self Assignment");
				emailParams.put("phase", "APPROVE");
				emailParams.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("correctionSelf".equals(dForm.getTask())) {
			dForm.getSelfAssignBean().setCommentTo(dForm.getSelfAssignBean().getAssignTo());
			dForm.getSelfAssignBean().setCreatedBy(userDomain);
			String tmpDesctiption = "";
			String tmpManHours = "";
			tmpDesctiption = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDesctiption.equals(dForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(dForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(dForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(dForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			dForm.getSelfAssignBean().setCurrentStatus("CORRECTION");
			comment = aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Self Assignment");
				emailParams.put("phase", "CORRECT");
				emailParams.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("rejectSelf".equals(dForm.getTask())) {
			aMan.startTransaction();
			dForm.getSelfAssignBean().setCommentTo(dForm.getSelfAssignBean().getAssignTo());
			dForm.getSelfAssignBean().setCreatedBy(userDomain);
			dForm.getSelfAssignBean().setCurrentStatus("REJECTED");
			comment = aMan.addHistorySelfComment(dForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", dForm.getSelfAssignBean().getCurrentStatus());
			paramStatus.put("updatedBy", userDomain);
			paramStatus.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			/* sending notification on email */
			dForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
			if (comment && update) {
				aMan.commitTransaction();
				Map emailParams = new HashMap();
				emailParams.put("toMail", dForm.getClaimBean().getEmailReceiver());
				emailParams.put("assignmentType", "Self Assignment");
				emailParams.put("phase", "REJECT");
				emailParams.put("taskCode", dForm.getSelfAssignBean().getTaskCode());
				emailParams.put("fromEmployee", dForm.getClaimBean().getSenderName());
				emailParams.put("nameReceiver", dForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(emailParams);
			} else {
				aMan.rollback();
			}
			// return to list dashboard
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		if ("cancel".equals(dForm.getTask())) {
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		// -------------------------------------------------------------//

		if (session.getAttribute("taskCode") != null) {
			session.removeAttribute("taskCode");
		}

		if (dForm.getPage() == null) {
			dForm.setPage(1);
		}

		if ("first".equals(dForm.getTask())) {
			dForm.setPage(1);
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}

		else if ("last".equals(dForm.getTask())) {
			dForm.setPage(dForm.getMaxPage());
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}

		else if ("prev".equals(dForm.getTask())) {
			if (dForm.getPage() > 1) {
				dForm.setPage(dForm.getPage() - 1);
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}

		else if ("next".equals(dForm.getTask())) {
			if (dForm.getPage() < dForm.getMaxPage()) {
				dForm.setPage(dForm.getPage() + 1);
			}
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		
		if ("search".equals(dForm.getTask())) {
			dForm.setTask((String) session.getAttribute("listDashboard"));
		}
		
		params.put("start", (dForm.getPage() - 1) * 10 + 1);
		params.put("end", (dForm.getPage() * 10));
		params.put("category", dForm.getCategory());
		params.put("keyword", dForm.getKeyword());
		params.put("startDate", dForm.getStartDate());
		params.put("endDate", dForm.getEndDate());
		params.put("userDomain", userDomain);

		if ("approvalDashboard".equals(dForm.getTask())) {
			// params.put("userDomain", "DOMAIN205");
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
			// params.put("userDomain", "DOMAIN205");
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
			if (dForm.getCountRecord() == 0){
				dForm.setMaxPage(1);
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
						buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/") + "images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
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
		dForm.setUnreadClaim(dMan.unreadClaim(userDomain));
		dForm.setUnreadApproval(dMan.unreadApproval(userDomain));
		dForm.setUnreadApprovalSelf(dMan.unreadApprovalSelf(userDomain));
		dForm.setUnreadCorrection(dMan.unreadCorrection(userDomain));
		dForm.setUnreadCorrectionSelf(dMan.unreadCorrectionSelf(userDomain));

		if ("autoRefresh".equals(dForm.getMode())) {
			PrintWriter out = response.getWriter();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(dForm);
			out.print(json);
			return null;
		}

		rankingLast.put("lastMonth", "true");
		rankingLast.put("organizationCode", session.getAttribute("organizationCode"));

		rankingCurrent.put("currentMonth", "true");
		rankingCurrent.put("organizationCode", session.getAttribute("organizationCode"));

		dForm.setListTopTen(dMan.searchTopTen(rankingCurrent));
		dForm.setListTopTenOrganization(dMan.searchTopTenOrganization(rankingCurrent));

		dForm.setListTopTenPrev(dMan.searchTopTen(rankingLast));
		dForm.setListTopTenOrganizationPrev(dMan.searchTopTenOrganization(rankingLast));

		return mapping.findForward("Dashboard");
	}
}
