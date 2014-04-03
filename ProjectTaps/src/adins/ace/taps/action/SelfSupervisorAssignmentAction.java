package adins.ace.taps.action;

import java.io.PrintWriter;
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
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.form.assignment.SelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class SelfSupervisorAssignmentAction extends Action {
	//this is action for self assignment from supervisor view
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SelfAssignmentForm sForm = (SelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("assignmentCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		sForm.getSelfAssignBean().setTaskCode(taskCode);
		sForm.getSelfAssignBean().setCommentTo(sForm.getSelfAssignBean().getAssignTo());
		sForm.getSelfAssignBean().setCreatedBy(sessionUserDomain);
		boolean comment = false;
		boolean update = false;
		boolean starSuccess = false;
		if ("cancel".equals(sForm.getTask())) {
			return mapping.findForward("Cancel");
		} else if ("approved".equals(sForm.getTask())) {
			//add comment and change status to approved
			String tmpDescription="";
			String tmpManHours="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDescription.equals(sForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(sForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(sForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(sForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("APPROVED");
			comment = aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			
			//update table star
			sForm.getSelfAssignBean().setStarBefore(0);
			starSuccess = aMan.addSelfAssignmentStar(sForm.getSelfAssignBean());
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (comment && update && starSuccess) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "APPROVED");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			
			return mapping.findForward("Cancel");
		} else if ("reapproved".equals(sForm.getTask())) {
			//add comment and change status to approved
			String tmpDescription="";
			String tmpManHours="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDescription.equals(sForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(sForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(sForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(sForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("APPROVED");
			comment = aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (comment && update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "APPROVED");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			
			return mapping.findForward("Cancel");
		} else if ("correction".equals(sForm.getTask())) {
			//add comment and change status to correction
			String tmpDesctiption="";
			String tmpManHours="";
			tmpDesctiption = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			if (!tmpDesctiption.equals(sForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(sForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(sForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(sForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("CORRECTION");
			comment = aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (comment && update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "CORRECTION");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			
			return mapping.findForward("Cancel");
		} else if ("reject".equals(sForm.getTask())) {
			//add comment and change status to rejected
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("REJECTED");
			comment = aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", sForm.getSelfAssignBean().getCurrentStatus());
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (comment && update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "REJECTED");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			
			
			return mapping.findForward("Cancel");
		} else if ("updateStar".equals(sForm.getTask())) {
			// update tabel star 
			if(aMan.searchLastStar(taskCode) == null){
				sForm.getSelfAssignBean().setStarBefore(0);
			}else{
				sForm.getSelfAssignBean().setStarBefore(aMan.searchLastStar(taskCode));
			}
			aMan.startTransaction();
			starSuccess = aMan.addSelfAssignmentStar(sForm.getSelfAssignBean());
			if (starSuccess){
				aMan.commitTransaction();
			} else {
				aMan.rollback();
			}
			
			return mapping.findForward("Cancel");
		} else if ("reopen".equals(sForm.getTask())) {
			//add comment and change status to correction
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("REOPEN");
			Map paramStatus = new HashMap();
			paramStatus.put("status", "REOPEN");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "REOPEN");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			
			return mapping.findForward("Cancel");
		}
		
		//show record self assignment
		//for approved self assignment, update-star button only show within certain days after it's been approved
		//to set the range date for update star, change the value max_date from config.properties
		Map params = new HashMap();
		params.put("taskCode", taskCode);
		params.put("maxDate", App.getConfiguration("max_date"));
		sForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(params));
		
		/*this session to check assignment type in self_correction.jsp*/
		session.setAttribute("type", sForm.getSelfAssignBean().getAssignmentType());
		/*this session to check activity type in self_correction.jsp*/
		session.setAttribute("adhoc", sForm.getSelfAssignBean().getActivityType());
		return mapping.findForward("Correction");
	}
}
