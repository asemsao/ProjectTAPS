package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.NewAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class NewAssignmentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		NewAssignmentForm aForm = (NewAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		
		System.out.println(aForm.getTask());
		if ("save".equals(aForm.getTask())){
			aForm.getAssignmentBean().setCurrentStatus("DRAFT");
			boolean success = aMan.addAssignment(aForm.getAssignmentBean());
			System.out.println(success);
			return mapping.findForward("add");
		}
		else if ("assign".equals(aForm.getTask())){
			aForm.getAssignmentBean().setCurrentStatus("CLAIM");
			boolean success = aMan.addAssignment(aForm.getAssignmentBean());
			System.out.println(success);
			return mapping.findForward("add");
		}
		else if ("cancel".equals(aForm.getTask())){
			System.out.println("masuk cancel");
			return mapping.findForward("indexSupervisor");
		}
		return mapping.findForward("add");
	}
}