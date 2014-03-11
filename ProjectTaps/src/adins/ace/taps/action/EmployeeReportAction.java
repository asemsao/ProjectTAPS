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

		if ("employeeReport".equals(session.getAttribute("link"))) {
			
			if ("search".equals(eForm.getTask())) {
				if (eForm.getPage() == null) {
					eForm.setPage(1);
				}
				
				eForm.setListAssignment(eMan.searchAssignmentEmployee(eForm.getPage(), eForm.getSearchCategory(), eForm.getSearchKeyword(), eForm.getStartDate(), eForm.getEndDate()));
				return mapping.findForward("SearchAssignment");
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddSelfAssignment");
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("Draft");
				}
//				else if("CLAIM".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("Claim");
//				} else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFA");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("Correction");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("Approved");
//				}
				return mapping.findForward("View");
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
			
				 eForm.setListAssignment(eMan.searchAssignmentSupervisor(eForm.getPage(), eForm.getSearchCategory(), eForm.getSearchKeyword(), eForm.getStartDate(), eForm.getEndDate()));
				 return mapping.findForward("SearchAssignment");
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("DraftSupervisor");
				}
//				else if("CLAIM".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ClaimSupervisor");
//				} else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFASupervisor");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("CorrectionSupervisor");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ApprovedSupervisor");
//				}
//				
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
			
				eForm.setListAssignment(eMan.searchAssignment(eForm.getPage(), eForm.getSearchCategory(), eForm.getSearchKeyword(), eForm.getStartDate(), eForm.getEndDate()));
				return mapping.findForward("SearchAssignment");
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddAssignment");
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("DraftSupervisor");
				}
//				else if("CLAIM".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ClaimSupervisor");
//				} else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFASupervisor");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("CorrectionSupervisor");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ApprovedSupervisor");
//				}
				
			}
			 
			if (eForm.getPage() == null) {
				eForm.setPage(1);
			}
			eForm.setListAssignment(eMan.getListAssignment(eForm.getPage()));
		}

		return mapping.findForward("ListAssignment");
	}
}
