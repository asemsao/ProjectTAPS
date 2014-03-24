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
		String taskCode = (String) session.getAttribute("taskCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		sForm.getSelfAssignBean().setTaskCode(taskCode);
		sForm.getSelfAssignBean().setCommentTo(sForm.getSelfAssignBean().getAssignTo());
		sForm.getSelfAssignBean().setCreatedBy(sessionUserDomain);
		
		if ("cancel".equals(sForm.getTask())) {
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}else if ("approved".equals(sForm.getTask())) {
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
			sForm.getSelfAssignBean().setCurrentStatus("APPROVED");
			aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			session.removeAttribute("taskCode");
			//update table star
			sForm.getSelfAssignBean().setStarBefore(0);
			boolean starSuccess = aMan.addSelfAssignmentStar(sForm.getSelfAssignBean());
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success && starSuccess) {
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "APPROVE");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
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
			sForm.getSelfAssignBean().setCurrentStatus("CORRECTION");
			aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "CORRECT");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
			System.out.println(success);
			return mapping.findForward("Cancel");
		} else if ("reject".equals(sForm.getTask())) {
			//add comment and change status to rejected
			sForm.getSelfAssignBean().setCurrentStatus("REJECTED");
			aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", sForm.getSelfAssignBean().getCurrentStatus());
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "REJECT");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
			
			return mapping.findForward("Cancel");
		} else if ("updateStar".equals(sForm.getTask())) {
			// update tabel star 
			System.out.println(aMan.searchLastStar(taskCode));
			if(aMan.searchLastStar(taskCode) == null){
				sForm.getSelfAssignBean().setStarBefore(0);
			}else{
				sForm.getSelfAssignBean().setStarBefore(aMan.searchLastStar(taskCode));
			}
			
			aMan.addSelfAssignmentStar(sForm.getSelfAssignBean());
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} 
		
		//show record self assignment
		//for approved self assignment, update-star button only show within certain days after it's being approved
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
