package adins.ace.taps.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.assignment.NewSelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class NewSelfAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NewSelfAssignmentForm aForm = (NewSelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();
		
		if (aForm.getNewTask() == null) {
			aForm.setSelfAssignBean(aMan.searchHeadOrganizationCode("domain3"));
			System.out.println(session.getAttribute("taskCode"));
			if (session.getAttribute("taskCode") != null) {
				aForm.setSelfAssignBean(aMan.searchRecordSelfAssignment((String) session.getAttribute("taskCode")));
			}
			return mapping.findForward("NewSelfAssignment");
		}
		else {
			if ("cancel".equals(aForm.getNewTask())) {
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else {
				aForm.getSelfAssignBean().setAssignmentType(
						aForm.getAssignmentType());
				aForm.getSelfAssignBean().setActivityType(aForm.getActivityType());
	
				String paramCode = "";
				if ("BU".equals(aForm.getAssignmentType())) {
					aForm.getSelfAssignBean().setOrganizationCode(aMan.searchOrganizationCode("domain3"));
					aForm.getSelfAssignBean().setReportTo(aForm.getSelfAssignBean().getHeadUserDomain());
					paramCode = aForm.getSelfAssignBean().getOrganizationCode() + dateFormat.format(date);
				} else if ("PROJECT".equals(aForm.getAssignmentType())) {
					paramCode = aForm.getSelfAssignBean().getProjectCode() + dateFormat.format(date);
				}
				paramCode = paramCode + aMan.getMaxTaskCode(paramCode);
				aForm.getSelfAssignBean().setTaskCode(paramCode);
				aForm.getSelfAssignBean().setCreatedBy("domain3");
				aForm.getSelfAssignBean().setAssignTo("domain3");
	
				if ("save".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("DRAFT");
					aForm.getSelfAssignBean().setFlag("ACTIVE");
				} else if ("RFA".equals(aForm.getNewTask())) {
					aForm.getSelfAssignBean().setCurrentStatus("RFA");
					aForm.getSelfAssignBean().setFlag("INACTIVE");
				}
	
				boolean insertToAssignment = false;
				boolean insertToDetailClaim = false;
				if (session.getAttribute("taskCode") != null) {
					aForm.getSelfAssignBean().setTaskCode((String) session.getAttribute("taskCode"));
					aForm.getSelfAssignBean().setUpdatedBy("domain3");
					insertToAssignment = aMan.editSelfAssignment(aForm.getSelfAssignBean());
					insertToDetailClaim = aMan.editDetailClaim(aForm.getSelfAssignBean());
				}
				else {
					insertToAssignment = aMan.addSelfAssignment(aForm.getSelfAssignBean());
					insertToDetailClaim = aMan.addDetailClaim(aForm.getSelfAssignBean());
				}
				
				System.out.println(insertToAssignment + " " + insertToDetailClaim);
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			}
		}
	}
}
