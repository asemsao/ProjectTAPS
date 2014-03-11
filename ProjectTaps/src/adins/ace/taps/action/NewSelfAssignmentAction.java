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

public class NewSelfAssignmentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NewSelfAssignmentForm aForm = (NewSelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		
		DateFormat dateFormat = new SimpleDateFormat("yyMM");
		Date date = new Date();
		
		if (aForm.getNewTask() == null){
			aForm.setSelfAssignBean(aMan.searchHeadOrganizationCode("domain3"));
			return mapping.findForward("NewSelfAssignment");
		}
		
		if ("cancel".equals(aForm.getNewTask())) {
			System.out.println("masuk cancel");
			return mapping.findForward("Cancel");
		} else {
			aForm.getSelfAssignBean().setAssignmentType(aForm.getAssignmentType());
			aForm.getSelfAssignBean().setActivityType(aForm.getActivityType());
			
			String paramCode = "";
			
			if ("BU".equals(aForm.getAssignmentType())){
				aForm.getSelfAssignBean().setOrganizationCode(aMan.searchOrganizationCode("domain3"));
				paramCode = aForm.getSelfAssignBean().getOrganizationCode() + dateFormat.format(date);
			}
			else if ("Project".equals(aForm.getAssignmentType())){
				paramCode = aForm.getSelfAssignBean().getProjectCode().substring(0,3) + dateFormat.format(date);
			}
			
			paramCode = paramCode + aMan.getMaxTaskCode(paramCode);
			
			aForm.getSelfAssignBean().setTaskCode(paramCode);
			aForm.getSelfAssignBean().setReportTo("domain100");
			aForm.getSelfAssignBean().setCreateBy("domain3");
			
			if ("save".equals(aForm.getNewTask())) {
				aForm.getSelfAssignBean().setCurrentStatus("DRAFT");
			} else if ("RFA".equals(aForm.getNewTask())) {
				aForm.getSelfAssignBean().setCurrentStatus("RFA");
			}
			
			boolean success = aMan.addSelfAssignment(aForm.getSelfAssignBean());
			System.out.println(success);
			return mapping.findForward("Cancel");
		}
	}
}
