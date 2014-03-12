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

import adins.ace.taps.form.assignment.NewAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class NewAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		NewAssignmentForm aForm = (NewAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);

		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();

		if (aForm.getNewTask() == null) {
			if (session.getAttribute("taskCode") != null) {
				aForm.setAssignmentBean(aMan.searchRecordAssignment((String) session.getAttribute("taskCode")));
			}
			return mapping.findForward("NewAssignment");
		}
		else {
			if ("cancel".equals(aForm.getNewTask())) {
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			} else {
				aForm.getAssignmentBean().setAssignmentType(
						aForm.getAssignmentType());
	
				String paramCode = "";
	
				if ("BU".equals(aForm.getAssignmentType())) {
					aForm.getAssignmentBean().setOrganizationCode(aMan.searchOrganizationCode("domain3"));
					paramCode = aForm.getAssignmentBean().getOrganizationCode() + dateFormat.format(date);
				} else if ("Project".equals(aForm.getAssignmentType())) {
					paramCode = aForm.getAssignmentBean().getProjectCode().substring(0, 3) + dateFormat.format(date);
				}
	
				paramCode = paramCode + aMan.getMaxTaskCode(paramCode);
				System.out.println(paramCode);
				aForm.getAssignmentBean().setTaskCode(paramCode);
				aForm.getAssignmentBean().setReportTo("domain100");
				aForm.getAssignmentBean().setCreateBy("domain100");
	
				if ("save".equals(aForm.getNewTask())) {
					aForm.getAssignmentBean().setCurrentStatus("DRAFT");
					aForm.getAssignmentBean().setFlag("ACTIVE");
				} else if ("assign".equals(aForm.getNewTask())) {
					aForm.getAssignmentBean().setCurrentStatus("CLAIM");
					aForm.getAssignmentBean().setFlag("INACTIVE");
				}
	
				boolean success = false;
				if (session.getAttribute("taskCode") != null) {
					aForm.getAssignmentBean().setTaskCode((String) session.getAttribute("taskCode"));
					success = aMan.editAssignment(aForm.getAssignmentBean());
				}
				else {
					success = aMan.addAssignment(aForm.getAssignmentBean());
				}
				
				System.out.println(success);
				session.removeAttribute("taskCode");
				return mapping.findForward("Cancel");
			}
		}
	}
}