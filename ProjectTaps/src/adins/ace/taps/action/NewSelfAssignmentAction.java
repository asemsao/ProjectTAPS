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
		boolean rfa = false;
		boolean insertToAssignment = false;
		boolean insertToDetailClaim = false;
		// coba pake domain3
		session.setAttribute("username", "domain3");
		// nanti dihapus
		
		System.out.println(aForm.getNewTask());
		if ("retreiveReportTo".equals(aForm.getNewTask())) {
			Map param = new HashMap();
			param.put("userDomain", "domain3");
			param.put("projectCode", request.getParameter("projectCode"));
			System.out.println("Params");
			System.out.println(param);
			PrintWriter out = response.getWriter();
			NewAssignmentBean bean = aMan.searchDirectReportProject(param);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(bean);
			out.print(json);
			System.out.println(json);
			return null;
		}

		if (aForm.getNewTask() == null) {
			System.out.println(session.getAttribute("taskCode"));
			if (session.getAttribute("taskCode") != null) {
				aForm.setSelfAssignBean(aMan
						.searchRecordSelfAssignment((String) session
								.getAttribute("taskCode")));
				return mapping.findForward("EditSelfAssignment");
			} else {
				aForm.setSelfAssignBean(aMan
						.searchHeadOrganizationCode((String) session
								.getAttribute("username")));
			}
			return mapping.findForward("NewSelfAssignment");
		} else {
			if ("cancel".equals(aForm.getNewTask())) {
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
							aMan.searchOrganizationCode((String) session
									.getAttribute("username")));
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
				aForm.getSelfAssignBean().setCreatedBy(
						(String) session.getAttribute("username"));
				aForm.getSelfAssignBean().setAssignTo(
						(String) session.getAttribute("username"));
				aForm.getSelfAssignBean().setClaimDate(
						aForm.getSelfAssignBean().getAssignmentDate());
				if ("save".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("DRAFT");
					aForm.getSelfAssignBean().setFlag("ACTIVE");
				} else if ("RFA".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("RFA");
					aForm.getSelfAssignBean().setFlag("INACTIVE");
					/* checking rfa an assignment */
					rfa = true;
				}

				if (session.getAttribute("taskCode") != null) {
					aForm.getSelfAssignBean().setTaskCode(
							(String) session.getAttribute("taskCode"));
					aForm.getSelfAssignBean().setUpdatedBy(
							(String) session.getAttribute("username"));
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
						if (rfa) {
							Map paramStatus = new HashMap();
							paramStatus.put("updatedBy", aForm
									.getSelfAssignBean().getCreatedBy());
							paramStatus.put("taskCode", aForm
									.getSelfAssignBean().getTaskCode());
							aForm.setClaimBean(aMan
									.emailToSupervisorAssignment(paramStatus));
							SendMailTls.SendMail(aForm.getClaimBean()
									.getEmailReceiver(), "Self Assignment",
									"RFA", aForm.getSelfAssignBean()
											.getTaskCode(), aForm
											.getClaimBean().getSenderName());
						}
					}
				}

				System.out.println(insertToAssignment + " "
						+ insertToDetailClaim);
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			}
		}
	}
}
