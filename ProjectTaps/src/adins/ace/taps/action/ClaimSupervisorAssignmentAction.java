package adins.ace.taps.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.configuration.App;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class ClaimSupervisorAssignmentAction extends Action {
	//this is action for assignment from supervisor view
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		aForm.getClaimBean().setTaskCode(taskCode);
		aForm.getClaimBean().setCommentTo(aForm.getClaimBean().getAssignTo());
		aForm.getClaimBean().setCreatedBy(sessionUserDomain);
		
		if ("approved".equals(aForm.getTask())) {
			//add comment and change status to approved
			aForm.getClaimBean().setStatus("APPROVED");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy",sessionUserDomain);
			paramStatus.put("taskCode",taskCode);
			paramStatus.put("flag","ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			//update table star
			aForm.getClaimBean().setStarBefore(0);
			boolean starSuccess = aMan.addAssignmentStar(aForm.getClaimBean());
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success && starSuccess) {
				Map params = new HashMap();
				params.put("toMail", aForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Assignment");
				params.put("phase", "APPROVE");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", aForm.getClaimBean().getSenderName());
				params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("correction".equals(aForm.getTask())) {
			//add comment and change status to correction
			aForm.getClaimBean().setStatus("CORRECTION");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				Map params = new HashMap();
				params.put("toMail", aForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Assignment");
				params.put("phase", "CORRECT");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", aForm.getClaimBean().getSenderName());
				params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("reject".equals(aForm.getTask())) {
			//add comment and change status to rejected
			aForm.getClaimBean().setStatus("REJECTED");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "REJECTED");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				Map params = new HashMap();
				params.put("toMail", aForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Assignment");
				params.put("phase", "REJECT");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", aForm.getClaimBean().getSenderName());
				params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("updateStar".equals(aForm.getTask())) {
			// update tabel star
			aForm.getClaimBean().setStarBefore(aMan.searchLastStar(taskCode));
			aMan.addAssignmentStar(aForm.getClaimBean());
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("cancel".equals(aForm.getTask())) {
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}

		//show record assignment
		//for approved assignment, update-star button only show within certain days after it's being approved
		//to set the range date for update star, change the value max_date from config.properties
		Map params = new HashMap();
		params.put("taskCode", taskCode);
		params.put("maxDate", App.getConfiguration("max_date"));
		
		aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
		aForm.setClaimBean(aMan.searchRecordClaimAssignment(params));
		aForm.setTotalManhours(aMan.getTotalManHours(taskCode));
		return mapping.findForward("Approval");
	}
}
