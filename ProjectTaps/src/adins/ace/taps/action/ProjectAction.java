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
		
		if ("addProject".equals(pForm.getTask())) {
			return mapping.findForward("AddProject");
		}
//		if("new".equals(mForm.getTask())){
//			return mapping.findForward("New");
//		}
//		if("cancel".equals(mForm.getTask())){
//			return mapping.findForward("ListEmployee");
//		}
		
		return mapping.findForward("ListProject");
	}
}
