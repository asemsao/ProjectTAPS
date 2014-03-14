package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

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

public class ProjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProjectForm pForm = (ProjectForm) form;
		ProjectManager pMan = new ProjectManager();
		Map params = new HashMap();

		if (pForm.getPage() == null) {
			pForm.setPage(1);
		}

		if ("first".equals(pForm.getTask())) {
			pForm.setPage(1);
		}

		if ("last".equals(pForm.getTask())) {
			pForm.setPage(pForm.getMaxpage());
		}

		if ("prev".equals(pForm.getTask())) {
			if (pForm.getPage() > 1) {
				pForm.setPage(pForm.getPage() - 1);
			}
		}
		if ("next".equals(pForm.getTask())) {
			if (pForm.getPage() < pForm.getMaxpage()) {
				pForm.setPage(pForm.getPage() + 1);
			}
		}

		if ("search".equals(pForm.getTask())) {
			pForm.setPage(1);
		}
		if ("addProject".equals(pForm.getTask())) {
			return mapping.findForward("AddProject");
		}
		if ("saveProject".equals(pForm.getTask())) {
			pMan.addProject(pForm.getAddProject());
		}
		if ("cancel".equals(pForm.getTask())) {

		}

		if ("edit".equals(pForm.getTask())) {
			pForm.setpBean(pMan.getProjectById(pForm.getParamProjectCode()));
			pForm.setListPhase(pMan.getPhase());
			return mapping.findForward("EditProject");
		}
		if ("updateProject".equals(pForm.getTask())) {
			pMan.updateProject(pForm.getpBean());
			pForm.setListProject(pMan.searchProject(params));
		}
		if ("member".equals(pForm.getTask())) {
			pForm.setListProject(pMan.getAllMember(pForm.getParamProjectCode()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if ("addMember".equals(pForm.getTask())) {
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("AddMember");
		}
		if ("saveMember".equals(pForm.getTask())) {

			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			pMan.addProjectMember(pForm.getAddSProject());

			pForm.setListProject(pMan.getAllMember(pForm.getParamProjectCode()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if ("back".equals(pForm.getTask())) {
			pForm.setListProject(pMan.getAllMember(pForm.getParamProjectCode()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if ("editMember".equals(pForm.getTask())) {
			params = new HashMap();
			params.put("paramProjectCode", pForm.getParamProjectCode());
			params.put("paramAssigneeUserDomain",
					pForm.getParamAssigneeUserDomain());
			pForm.setAddSProject(pMan.getProjectMemberById(params));
			return mapping.findForward("EditMember");
		}
		if ("updateMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			pMan.updateMember(pForm.getAddSProject());

			pForm.setListProject(pMan.getAllMember(pForm.getParamProjectCode()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if("deleteMember".equals(pForm.getTask()))
		{
			pForm.getAddSProject().setAssigneeUserDomain(pForm.getParamAssigneeUserDomain());
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			pMan.deleteMember(pForm.getAddSProject());
			
			pForm.setListProject(pMan.getAllMember(pForm.getParamProjectCode()));
			ProjectBean pBean = new ProjectBean();
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("ViewMember");
		}
		if("deleteProject".equals(pForm.getTask()))
		{
			pMan.deleteProject(pForm.getParamProjectCode());
		}

		params.put("start", (pForm.getPage() - 1) * 10 + 1);
		params.put("end", (pForm.getPage() * 10));
		params.put("category", pForm.getSearchCategory());
		params.put("keyword", pForm.getSearchKeyword());

		pForm.setListProject(pMan.searchProject(params));
		pForm.setCountRecord(pMan.countProject(params));

		if (pForm.getCountRecord() % 10 == 0) {
			pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
		} else {
			pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListProject");
	}
}
