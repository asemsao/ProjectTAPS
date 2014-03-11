package adins.ace.taps.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.ViewAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class ViewAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ViewAssignmentForm aForm = (ViewAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		
		if ("DRAFT".equals(session.getAttribute("taskCode"))){
			
			return mapping.findForward(null);
		}
		else if ("CLAIM".equals(session.getAttribute("taskCode"))){
			
		}
		else if ("RFA".equals(session.getAttribute("taskCode"))){
					
				}
		else if ("CORRECTION".equals(session.getAttribute("taskCode"))){
			
		}
		else if ("APPROVED".equals(session.getAttribute("taskCode"))){
			
		}
		return mapping.findForward(null);
	}
}
