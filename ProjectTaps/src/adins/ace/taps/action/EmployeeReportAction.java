package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.EmployeeReportForm;
import adins.ace.taps.manager.AssignmentManager;

public class EmployeeReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		EmployeeReportForm eForm = (EmployeeReportForm) form;
		AssignmentManager eMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("link"));

		if ("employeeReport".equals(session.getAttribute("link"))) {
			
			if ("search".equals(eForm.getTask())) {
				if (eForm.getPage() == null) {
					eForm.setPage(1);
				}

				eForm.setListAssignment(eMan.searchAssignmentEmployee(eForm.getPage(), eForm.getSearch(), eForm.getValue()));
				return mapping.findForward("SearchAssignment");
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddAssignment");
			}
			
			if (eForm.getPage() == null) {
				eForm.setPage(1);
			}
			eForm.setListAssignment(eMan.getListAssignmentEmployee(eForm.getPage()));
			
		} else if ("employeeReportSupervisor".equals(session.getAttribute("link"))) {
			
			if ("search".equals(eForm.getTask())) {
				 if (eForm.getPage() == null) {
					 eForm.setPage(1);
				 }
			
				 eForm.setListAssignment(eMan.searchAssignmentSupervisor(eForm.getPage(), eForm.getSearch(), eForm.getValue()));
				 return mapping.findForward("SearchAssignment");
			}
			
			if (eForm.getPage() == null) {
				eForm.setPage(1);
			}
			eForm.setListAssignment(eMan.getListAssignmentSupervisor(eForm.getPage()));
			
		} else if ("assignment".equals(session.getAttribute("link"))) {
			
			if ("search".equals(eForm.getTask())) {
				if (eForm.getPage() == null) {
					eForm.setPage(1);
				}
			
				eForm.setListAssignment(eMan.searchAssignment(eForm.getPage(), eForm.getSearch(), eForm.getValue()));
				return mapping.findForward("SearchAssignment");
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddAssignment");
			}
			 
			if (eForm.getPage() == null) {
				eForm.setPage(1);
			}
			eForm.setListAssignment(eMan.getListAssignment(eForm.getPage()));
		}

		return mapping.findForward("ListAssignment");
	}
}
