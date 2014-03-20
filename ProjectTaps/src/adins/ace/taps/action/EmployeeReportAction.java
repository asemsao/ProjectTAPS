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
		
		//testing pake domain 205
		//session.setAttribute("username", "DOMAIN205");
		//nanti dihapus
		
		if (session.getAttribute("taskCode") != null) {
			session.removeAttribute("taskCode");
		}

		if (session.getAttribute("message") != null) {
			eForm.setMessage(session.getAttribute("message").toString());
			session.removeAttribute("message");
		}

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
		} else if ("next".equals(eForm.getTask())) {
			if (eForm.getPage() < eForm.getMaxpage()) {
				eForm.setPage(eForm.getPage() + 1);
			}
		}

		if ("employeeReport".equals(session.getAttribute("link"))) {
			session.setAttribute("username", "domain3");
			if ("search".equals(eForm.getTask())) {
				eForm.setPage(1);
			} else if ("add".equals(eForm.getTask())) {
				return mapping.findForward("AddSelfAssignment");
			} else if ("view".equals(eForm.getTask())) {
				session.setAttribute("taskCode", eForm.getTaskCode());
				session.setAttribute("status", eForm.getCurrentStatus());
				if ("DRAFT".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("Draft");
				} else if ("CLAIM".equals(eForm.getCurrentStatus())) {
					eMan.updateFlag(eForm.getTaskCode());
					return mapping.findForward("Claim");
				} else if ("CORRECTION".equals(eForm.getCurrentStatus())) {
					eMan.updateFlag(eForm.getTaskCode());
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("Correction");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("SelfAssignmentCorrection");
					}
				} else if ("RFA".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("RFA");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("RFASelfAssignment");
					}
				} else if ("APPROVED".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("Approved");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("ApprovedSelfAssignment");
					}
				} else if ("REJECTED".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("Approved");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("ApprovedSelfAssignment");
					}
				}
				return mapping.findForward("View");
			}

			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			params.put("sessionUserDomain", session.getAttribute("username"));
			eForm.setCountRecord(eMan.countEmployeeReportEmployee(params));
			if (eForm.getCountRecord() % 10 == 0) {
				eForm.setMaxpage((int) Math.ceil(eForm.getCountRecord() / 10));
			} else {
				eForm.setMaxpage(((int) Math.ceil(eForm.getCountRecord() / 10)) + 1);
			}
			eForm.setListAssignment(eMan.searchEmployeeReportEmployee(params));

		} else if ("employeeReportSupervisor".equals(session
				.getAttribute("link"))) {
			if ("search".equals(eForm.getTask())) {
				eForm.setPage(1);
			} else if ("view".equals(eForm.getTask())) {
				session.setAttribute("taskCode", eForm.getTaskCode());
				session.setAttribute("status", eForm.getCurrentStatus());
				if ("DRAFT".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("DraftSupervisor");
				} else if ("CLAIM".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("ClaimSupervisor");
				} else if ("CORRECTION".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("CorrectionSupervisor");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping
								.findForward("SelfAssignmentCorrectionSupervisor");
					}
				} else if ("RFA".equals(eForm.getCurrentStatus())) {
					eMan.updateFlag(eForm.getTaskCode());
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("RFASupervisor");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping
								.findForward("RFASelfSupervisorAssignment");
					}
				} else if ("APPROVED".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("ApprovedSupervisor");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping
								.findForward("ApprovedSupervisorSelfAssignment");
					}
				} else if ("REJECTED".equals(eForm.getCurrentStatus())) {
					if ("ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping.findForward("CorrectionSupervisor");
					} else if ("SELF ASSIGNMENT".equals(eForm.getTaskType())) {
						return mapping
								.findForward("SelfAssignmentCorrectionSupervisor");
					}
				}
			}

			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			params.put("sessionUserDomain", session.getAttribute("username"));
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
			} else if ("view".equals(eForm.getTask())) {
				session.setAttribute("taskCode", eForm.getTaskCode());
				session.setAttribute("status", eForm.getCurrentStatus());
				if ("DRAFT".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("DraftSupervisor");
				} else if ("CLAIM".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("ClaimSupervisor");
				} else if ("CORRECTION".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("CorrectionSupervisor");
				} else if ("RFA".equals(eForm.getCurrentStatus())) {
					eMan.updateFlag(eForm.getTaskCode());
					return mapping.findForward("RFASupervisor");
				} else if ("APPROVED".equals(eForm.getCurrentStatus())) {
					return mapping.findForward("ApprovedSupervisor");
				}
			}

			params.put("start", (eForm.getPage() - 1) * 10 + 1);
			params.put("end", (eForm.getPage() * 10));
			params.put("category", eForm.getCategory());
			params.put("keyword", eForm.getKeyword());
			params.put("startDate", eForm.getStartDate());
			params.put("endDate", eForm.getEndDate());
			params.put("sessionUserDomain", session.getAttribute("username"));
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
