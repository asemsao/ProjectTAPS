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
		Map params = new HashMap();
		
		if (eForm.getPage() == null) {
			eForm.setPage(1);
		}
		
		if ("first".equals(eForm.getTask())) {
			eForm.setPage(1);
		}

		else if ("last".equals(eForm.getTask())) {
			eForm.setPage(eForm.getMaxpage());
		}

		else if ("prev".equals(eForm.getTask())) {
			if (eForm.getPage() > 1) {
				eForm.setPage(eForm.getPage() - 1);
			}
		}
		else if ("next".equals(eForm.getTask())) {
			System.out.println(eForm.getMaxpage());
			if (eForm.getPage() < eForm.getMaxpage()) {
				eForm.setPage(eForm.getPage() + 1);
			}
		}
		
		if ("employeeReport".equals(session.getAttribute("link"))) {
			if ("search".equals(eForm.getTask())) {
				eForm.setPage(1);
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddSelfAssignment");
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("Draft");
				}
				else if("CLAIM".equals(eForm.getCurrentStatus())){
					return mapping.findForward("Claim");
				}
//				else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFA");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("Correction");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("Approved");
//				}
				return mapping.findForward("View");
			}
			
			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			eForm.setCountRecord(eMan.countEmployeeReportEmployee(params));
			if (eForm.getCountRecord() % 10 == 0) {
				eForm.setMaxpage((int) Math.ceil(eForm.getCountRecord() / 10));
			} else {
				eForm.setMaxpage(((int) Math.ceil(eForm.getCountRecord() / 10)) + 1);
			}
			eForm.setListAssignment(eMan.searchEmployeeReportEmployee(params));
			
		} else if ("employeeReportSupervisor".equals(session.getAttribute("link"))) {			
			if ("search".equals(eForm.getTask())) {
				eForm.setPage(1);
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("DraftSupervisor");
				}
				else if("CLAIM".equals(eForm.getCurrentStatus())){
					return mapping.findForward("ClaimSupervisor");
				}
//				else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFASupervisor");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("CorrectionSupervisor");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ApprovedSupervisor");
//				}
//				
			}
			
			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			eForm.setCountRecord(eMan.countEmployeeReportSupervisor(params));
			if (eForm.getCountRecord() % 10 == 0) {
				eForm.setMaxpage((int) Math.ceil(eForm.getCountRecord() / 10));
			} else {
				eForm.setMaxpage(((int) Math.ceil(eForm.getCountRecord() / 10)) + 1);
			}
			eForm.setListAssignment(eMan.searchEmployeeReportSupervisor(params));
			
		} else if ("assignment".equals(session.getAttribute("link"))) {
			
			if ("search".equals(eForm.getTask())) {
				eForm.setPage(1);
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddAssignment");
			} else if ("view".equals(eForm.getTask())){
				session.setAttribute("taskCode", eForm.getTaskCode());
				if("DRAFT".equals(eForm.getCurrentStatus())){
					return mapping.findForward("DraftSupervisor");
				}
				else if("CLAIM".equals(eForm.getCurrentStatus())){
					return mapping.findForward("ClaimSupervisor");
				}
//				else if("RFA".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("RFASupervisor");
//				} else if("CORRECTION".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("CorrectionSupervisor");
//				} else if("APPROVED".equals(eForm.getCurrentStatus())){
//					return mapping.findForward("ApprovedSupervisor");
//				}
				
			}
			 
			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			eForm.setCountRecord(eMan.countAssignmentSupervisor(params));

			if (eForm.getCountRecord() % 10 == 0) {
				eForm.setMaxpage((int) Math.ceil(eForm.getCountRecord() / 10));
			} else {
				eForm.setMaxpage(((int) Math.ceil(eForm.getCountRecord() / 10)) + 1);
			}

			eForm.setListAssignment(eMan.searchAssignmentSupervisor(params));
		}		
			
		return mapping.findForward("ListAssignment");
	}
}
