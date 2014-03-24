package adins.ace.taps.action;

import java.io.PrintWriter;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.assignment.SelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class NewSelfAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SelfAssignmentForm aForm = (SelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();
		String sessionUserDomain = (String) session.getAttribute("username");
		String taskCode = (String) session.getAttribute("taskCode");
		boolean rfa = false;
		boolean insertToAssignment = false;
		boolean insertToDetailClaim = false;
		boolean success = false;

		if ("retreiveReportTo".equals(aForm.getNewTask())) {
			Map param = new HashMap();
			param.put("userDomain", "domain3");
			param.put("projectCode", request.getParameter("projectCode"));
			PrintWriter out = response.getWriter();
			NewAssignmentBean bean = aMan.searchDirectReportProject(param);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(bean);
			out.print(json);
			return null;
		}

		if (aForm.getNewTask() == null) {
			if (taskCode != null) {
				aForm.setSelfAssignBean(aMan.searchRecordSelfAssignmentDraft(taskCode));
				return mapping.findForward("EditSelfAssignment");
			} else {
//				Map params = new HashMap();
//				params.put("taskCode", taskCode);
//				params.put("maxDate", App.getConfiguration("max_date"));
//				aForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(params));
				aForm.setSelfAssignBean(aMan.searchHeadOrganizationCode(sessionUserDomain));
				return mapping.findForward("NewSelfAssignment");
			}
		} else {
			if ("cancel".equals(aForm.getNewTask())) {
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else if ("delete".equals(aForm.getNewTask())) {
				success = aMan.deleteAssignment(taskCode);
				if (success) {
					session.setAttribute("message", "Success Delete Assignment");
					session.setAttribute("color", "green");
				} else {
					session.setAttribute("message", "Failed Delete Assignment");
					session.setAttribute("color", "red");
				}
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else {
				aForm.getSelfAssignBean().setAssignmentType(
						aForm.getAssignmentType());
				aForm.getSelfAssignBean().setActivityType(
						aForm.getActivityType());

				String paramCode = "";
				if ("BU".equals(aForm.getAssignmentType())) {
					aForm.getSelfAssignBean().setOrganizationCode(
							aMan.searchOrganizationCode(sessionUserDomain));
					aForm.getSelfAssignBean().setReportTo(
							aForm.getSelfAssignBean().getHeadUserDomain());
					aForm.getSelfAssignBean().setProjectCode(null);
					paramCode = aForm.getSelfAssignBean().getOrganizationCode()
							+ dateFormat.format(date);
					paramCode = paramCode
							+ aMan.getMaxTaskCodeOrganization(paramCode);
				} else if ("PROJECT".equals(aForm.getAssignmentType())) {
					paramCode = aForm.getSelfAssignBean().getProjectCode()
							+ dateFormat.format(date);
					paramCode = paramCode
							+ aMan.getMaxTaskCodeProject(paramCode);
				}

				if (!("ADHOC".equals(aForm.getActivityType()))) {
					aForm.getSelfAssignBean().setAdhocUserDomain(null);
				}

				aForm.getSelfAssignBean().setTaskCode(paramCode);
				aForm.getSelfAssignBean().setCreatedBy(sessionUserDomain);
				aForm.getSelfAssignBean().setAssignTo(sessionUserDomain);
				String assignmentDate = aForm.getSelfAssignBean().getAssignmentDate() + ", " + aForm.getSelfAssignBean().getAssignmentTime();
				aForm.getSelfAssignBean().setClaimDate(assignmentDate);
				if ("save".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("DRAFT");
					aForm.getSelfAssignBean().setFlag("ACTIVE");
				} else if ("RFA".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("RFA");
					aForm.getSelfAssignBean().setFlag("INACTIVE");
					/* checking rfa an assignment */
					rfa = true;
				}

				if (taskCode != null) {
					aForm.getSelfAssignBean().setTaskCode(taskCode);
					aForm.getSelfAssignBean().setUpdatedBy(sessionUserDomain);
					insertToAssignment = aMan.editSelfAssignment(aForm
							.getSelfAssignBean());
					insertToDetailClaim = aMan.editDetailClaim(aForm
							.getSelfAssignBean());
				} else {
					insertToAssignment = aMan.addSelfAssignment(aForm
							.getSelfAssignBean());
					insertToDetailClaim = aMan.addDetailClaim(aForm
							.getSelfAssignBean());
					if (insertToDetailClaim && insertToAssignment) {
						session.setAttribute("message", "Create Self Assignment Success!");
						session.setAttribute("color", "green");
						if (rfa) {
							Map paramStatus = new HashMap();
							paramStatus.put("updatedBy", aForm.getSelfAssignBean().getCreatedBy());
							paramStatus.put("taskCode", aForm.getSelfAssignBean().getTaskCode());
							aForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));
							
							Map params = new HashMap();
							params.put("toMail", aForm.getClaimBean().getEmailReceiver());
							params.put("assignmentType", "Self Assignment");
							params.put("phase", "RFA");
							params.put("taskCode",  aForm.getSelfAssignBean().getTaskCode());
							params.put("fromEmployee", aForm.getClaimBean().getSenderName());
							params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
							SendMailTls.SendMail(params);
						}
					} else {
						session.setAttribute("message", "Create Self Assignment Failed!");
						session.setAttribute("color", "red");
					}
				}

				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			}
		}
	}
}
