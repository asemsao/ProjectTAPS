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

import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.form.assignment.NewAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class NewAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();
		boolean success = false;
		//coba pake domain3
		session.setAttribute("username", "domain3");
		//nanti dihapus
		
		if (aForm.getNewTask() == null) {
			if (session.getAttribute("taskCode") != null) {
				aForm.setAssignmentBean(aMan
						.searchRecordAssignment((String) session
								.getAttribute("taskCode")));
				return mapping.findForward("EditAssignment");
			}
			return mapping.findForward("NewAssignment");
		} else {
			if ("cancel".equals(aForm.getNewTask())) {
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else {
				aForm.getAssignmentBean().setAssignmentType(
						aForm.getAssignmentType());
				aForm.getAssignmentBean().setReportTo((String) session.getAttribute("username"));
				String paramCode = "";
				if ("BU".equals(aForm.getAssignmentType())) {
					aForm.getAssignmentBean().setOrganizationCode(
							aMan.searchOrganizationCode((String) session.getAttribute("username")));
					aForm.getAssignmentBean().setProjectCode(null);
					paramCode = aForm.getAssignmentBean().getOrganizationCode()
							+ dateFormat.format(date);
					paramCode = paramCode + aMan.getMaxTaskCodeOrganization(paramCode);
				} else if ("PROJECT".equals(aForm.getAssignmentType())) {
					paramCode = aForm.getAssignmentBean().getProjectCode()
							+ dateFormat.format(date);
					paramCode = paramCode + aMan.getMaxTaskCodeProject(paramCode);
				}
				
				aForm.getAssignmentBean().setTaskCode(paramCode);
				aForm.getAssignmentBean().setCreatedBy((String) session.getAttribute("username"));

				if ("save".equals(aForm.getNewTask())) {
					aForm.getAssignmentBean().setCurrentStatus("DRAFT");
					aForm.getAssignmentBean().setFlag("ACTIVE");
				} else if ("assign".equals(aForm.getNewTask())) {
					aForm.getAssignmentBean().setCurrentStatus("CLAIM");
					aForm.getAssignmentBean().setFlag("INACTIVE");
				}

				if (session.getAttribute("taskCode") != null) {
					aForm.getAssignmentBean().setTaskCode(
							(String) session.getAttribute("taskCode"));
					aForm.getAssignmentBean().setUpdatedBy((String) session.getAttribute("username"));
					success = aMan.editAssignment(aForm.getAssignmentBean());
				} else {
					success = aMan.addAssignment(aForm.getAssignmentBean());
				}

				if (success) {
					session.setAttribute("message",
							"Create Assignment Success!");
				} else {
					session.setAttribute("message", "Create Assignment Failed!");
				}

				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			}
		}
	}
}