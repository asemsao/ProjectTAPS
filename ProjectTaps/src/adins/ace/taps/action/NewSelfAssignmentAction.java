package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.NewSelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class NewSelfAssignmentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NewSelfAssignmentForm aForm = (NewSelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		
		if ("save".equals(aForm.getNewTask())){
			aForm.getSelfAssignBean().setCurrentStatus("DRAFT");
//			boolean success = aMan.addAssignment(aForm.getSelfAssignBean());
//			System.out.println(success);
			return mapping.findForward("NewSelfAssignment");
		}
		else if ("assign".equals(aForm.getNewTask())){
			aForm.getSelfAssignBean().setCurrentStatus("CLAIM");
//			boolean success = aMan.addAssignment(aForm.getSelfAssignBean());
//			System.out.println(success);
			return mapping.findForward("NewSelfAssignment");
		}
		else if ("cancel".equals(aForm.getNewTask())){
			System.out.println("masuk cancel");
			return mapping.findForward("Cancel");
		}
		return mapping.findForward("NewSelfAssignment");
	}
}
