package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class ClaimSupervisorAssignmentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm)form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		
		String taskCode = (String) session.getAttribute("taskCode");
		if ("cancel".equals(aForm.getTask())){
			return mapping.findForward("Cancel");
		}
		
		if ("RFA".equals(session.getAttribute("status")) || "APPROVED".equals(session.getAttribute("status"))){
			aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
			aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
			return mapping.findForward("Approval");
		} else {
			aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
			aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
			return mapping.findForward("Claim");
		}
	}
}
