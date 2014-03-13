package adins.ace.taps.action;

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

public class CorrectionAssignmentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm)form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		
		String taskCode = (String) session.getAttribute("taskCode");

		if ("assginment".equals(aForm.getTask())) {
			aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
			aForm.setHistoryComment(null);
			aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
			return mapping.findForward("Correction");
		}
		else if("selfAssginment".equals(aForm.getTask())){
			return mapping.findForward("SelfCorrection");
		}
		else if ("claim".equals(aForm.getTask())){
			aForm.getClaimBean().setStatus("CORRECTION");
			if(!("".equals(aForm.getClaimBean().getComment()))){
				aMan.addHistoryComment(aForm.getClaimBean());
			}
			return mapping.findForward("Cancel");
		}
		else if ("RFA".equals(aForm.getTask())){
			aForm.getClaimBean().setStatus("RFA");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy","domain3");
			paramStatus.put("taskCode",taskCode);
			paramStatus.put("flag","INACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			System.out.println(success);
			return mapping.findForward("Cancel");
		}
		else if ("cancel".equals(aForm.getTask())){
			return mapping.findForward("Cancel");
		}
		System.out.println(aForm.getTask());
		return mapping.findForward("Cancel");
	}
}
