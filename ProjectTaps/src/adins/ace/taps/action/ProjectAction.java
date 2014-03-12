package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;
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
		if("saveProject".equals(pForm.getTask()))
		{
			System.out.println(pForm.getAddProject().getStartDate());
			pMan.addProject(pForm.getAddProject());
			return mapping.findForward("ListProject");
		}
		if("cancel".equals(pForm.getTask()))
		{
			return mapping.findForward("ListProject");
		}
		if("edit".equals(pForm.getTask()))
		{
			
			return mapping.findForward("EditProject");
		}
		if("member".equals(pForm.getTask()))
		{
			pForm.setListProject(pMan.getAllMember(pForm.getParam()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParam());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if("addMember".equals(pForm.getTask()))
		{
			return mapping.findForward("AddMember");
		}
		if("back".equals(pForm.getTask()))
		{
			pForm.setListProject(pMan.getAllMember(pForm.getParam()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParam());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if("editMember".equals(pForm.getTask()))
		{
			return mapping.findForward("EditMember");
		}
		
		return mapping.findForward("ListProject");
	}
}
