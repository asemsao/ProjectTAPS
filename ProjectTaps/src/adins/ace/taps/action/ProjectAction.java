package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
			StructureProjectBean spBean = new StructureProjectBean();
			spBean = (StructureProjectBean) pForm.getListProject().get(0);
			pForm.setOrganizationName(spBean.getOrganizationName());
			pForm.setProjectName(spBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if("addMember".equals(pForm.getTask()))
		{
			return mapping.findForward("AddMember");
		}
		if("back".equals(pForm.getTask()))
		{
			pForm.setListProject(pMan.getAllMember(pForm.getParam()));
			StructureProjectBean spBean = new StructureProjectBean();
			spBean = (StructureProjectBean) pForm.getListProject().get(0);
			pForm.setOrganizationName(spBean.getOrganizationName());
			pForm.setProjectName(spBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		
		
		return mapping.findForward("ListProject");
	}
}
