package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.project.ProjectForm;
import adins.ace.taps.manager.ProjectManager;

public class ProjectAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProjectForm pForm = (ProjectForm) form;
		ProjectManager pMan = new ProjectManager();
		
		pForm.setListProject(pMan.getAllProject());			
		
		if ("new".equals(pForm.getTask())) 
		{
			return mapping.findForward("AddProject");
		}
		if("cancel".equals(pForm.getTask()))
		{
			return mapping.findForward("ListProject");
		}
		if("edit".equals(pForm.getTask()))
		{
			return mapping.findForward("AddProject");
		}
		if("member".equals(pForm.getTask()))
		{
			pForm.setListProject(pMan.getAllMember(pForm.getParam()));
			return mapping.findForward("ViewMember");
		}
		
		return mapping.findForward("ListProject");
	}
}
