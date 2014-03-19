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

import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class ClaimSupervisorAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		aForm.getClaimBean().setTaskCode(taskCode);
		aForm.getClaimBean().setCommentTo("domain10");
		aForm.getClaimBean().setCreatedBy("DOMAIN205");
		
		if ("approved".equals(aForm.getTask())) {
			aForm.getClaimBean().setStatus("APPROVED");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "APPROVED");
			paramStatus.put("updatedBy","domain3");
			paramStatus.put("taskCode",taskCode);
			paramStatus.put("flag","ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			//update table star
			aForm.getClaimBean().setStarBefore(0);
			aMan.addAssignmentStar(aForm.getClaimBean());
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				SendMailTls.SendMail(aForm.getClaimBean().getEmailReceiver(), "Assignment", "APPROVE", taskCode, aForm.getClaimBean().getSenderName());
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("correction".equals(aForm.getTask())) {
			aForm.getClaimBean().setStatus("CORRECTION");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "CORRECTION");
			paramStatus.put("updatedBy", "domain3");
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				SendMailTls.SendMail(aForm.getClaimBean().getEmailReceiver(), "Assignment", "CORRECT", taskCode, aForm.getClaimBean().getSenderName());
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("reject".equals(aForm.getTask())) {
			aForm.getClaimBean().setStatus("REJECTED");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "REJECTED");
			paramStatus.put("updatedBy", "domain3");
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "ACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));			
			if (success) {
				SendMailTls.SendMail(aForm.getClaimBean().getEmailReceiver(), "Assignment", "REJECT", taskCode, aForm.getClaimBean().getSenderName());
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

		aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
		aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
		aForm.setTotalManhours(aMan.getTotalManHours(taskCode));
		return mapping.findForward("Approval");
	}
}
