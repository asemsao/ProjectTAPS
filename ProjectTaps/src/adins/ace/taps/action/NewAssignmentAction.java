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

import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.form.assignment.NewAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class NewAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String userDomain = (String) session.getAttribute("username");
		String taskCode = (String) session.getAttribute("taskCode");
		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();
		boolean success = false;
		boolean assign = false;
		if (aForm.getNewTask() == null) {
			saveToken(request);
			if (taskCode != null) {
				aForm.setAssignmentBean(aMan.searchRecordAssignment(taskCode));
				return mapping.findForward("EditAssignment");
			}
			else {
				return mapping.findForward("NewAssignment");
			}
		} else {
			if ("cancel".equals(aForm.getNewTask())) {
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else if ("delete".equals(aForm.getNewTask())) {
				if (isTokenValid(request)) {
					Map paramDelete = new HashMap();
					paramDelete.put("taskCode", taskCode);
					paramDelete.put("updatedBy", userDomain);
					success = aMan.deleteAssignment(paramDelete);
					if (success) {
						session.setAttribute("message", "Success Delete Assignment");
						session.setAttribute("color", "green");
					} else {
						session.setAttribute("message", "Failed Delete Assignment");
						session.setAttribute("color", "red");
					}
					session.removeAttribute("taskCode");
					resetToken(request);
					return mapping.findForward("Cancel");
				} else {
					resetToken(request);
					return mapping.findForward("Cancel");
				}
			} else {
				if (isTokenValid(request)) {
					aForm.getAssignmentBean().setAssignmentType(aForm.getAssignmentType());
					aForm.getAssignmentBean().setReportTo(userDomain);
					String paramCode = "";
					if ("BU".equals(aForm.getAssignmentType())) {
						aForm.getAssignmentBean().setProjectCode(null);
						aForm.getAssignmentBean().setOrganizationCode((String) session.getAttribute("organizationCode"));
						paramCode = (String)session.getAttribute("organizationCode") + dateFormat.format(date);
						paramCode = paramCode + aMan.getMaxTaskCodeOrganization(paramCode);
						
					} else if ("PROJECT".equals(aForm.getAssignmentType())) {
						paramCode = aForm.getAssignmentBean().getProjectCode() + dateFormat.format(date);
						paramCode = paramCode + aMan.getMaxTaskCodeProject(paramCode);
						
					}
					aForm.getAssignmentBean().setTaskCode(paramCode);
					aForm.getAssignmentBean().setCreatedBy(userDomain);
					
					if ("save".equals(aForm.getNewTask())) {
						aForm.getAssignmentBean().setCurrentStatus("DRAFT");
						aForm.getAssignmentBean().setFlag("ACTIVE");
					} else if ("assign".equals(aForm.getNewTask())) {
						aForm.getAssignmentBean().setCurrentStatus("CLAIM");
						aForm.getAssignmentBean().setFlag("INACTIVE");

						/* checking assign an assignment */
						assign = true;
					}

					if (taskCode != null) {
						aForm.getAssignmentBean().setTaskCode(taskCode);
						aForm.getAssignmentBean().setUpdatedBy(userDomain);
						success = aMan.editAssignment(aForm.getAssignmentBean());
					} else {
						success = aMan.addAssignment(aForm.getAssignmentBean());
					}

					if (success) {
						session.setAttribute("message", "Create Assignment Success!");
						session.setAttribute("color", "green");
						/* sending notification on email */
						if (assign) {
							Map paramStatus = new HashMap();
							paramStatus.put("updatedBy", aForm.getAssignmentBean().getReportTo());
							paramStatus.put("taskCode", aForm.getAssignmentBean().getTaskCode());
							aForm.setClaimBean(aMan.emailToEmployeeAssignment(paramStatus));
							
							Map params = new HashMap();
							params.put("toMail", aForm.getClaimBean().getEmailReceiver());
							params.put("assignmentType", "Assignment");
							params.put("phase", "ASSIGN");
							params.put("taskCode", aForm.getAssignmentBean().getTaskCode());
							params.put("fromEmployee", aForm.getClaimBean().getSenderName());
							params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
							SendMailTls.SendMail(params);
						}
					} else {
						session.setAttribute("message", "Create Assignment Failed!");
						session.setAttribute("color", "red");
					}
					session.removeAttribute("taskCode");
					resetToken(request);
					return mapping.findForward("Cancel");
				} 
				else {
					resetToken(request);
					return mapping.findForward("Cancel");
				}
			}
		}
	}
}
