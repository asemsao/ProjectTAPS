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
		ProjectBean pBean = new ProjectBean();
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
			//go to new.jsp
			return mapping.findForward("AddProject");
		}
		if ("saveProject".equals(pForm.getTask())) {
			if(pMan.addProject(pForm.getAddProject()))
			{
				pForm.setMessage("Insert Successfully");
			
				//insert table history_projects
				Map param = new HashMap();
				param.put("projectCode", pForm.getAddProject().getProjectCode());
				param.put("orgAfter",pForm.getAddProject().getOrganizationCode());
				pMan.insertHistory(param);
			}
			else
				pForm.setMessage("Insert Failed");
			
		}
		if ("cancel".equals(pForm.getTask())) {
			pForm.setMode("");
		}

		if ("edit".equals(pForm.getTask())) {
			//go to editproject.jsp
			pForm.setpBean(pMan.getProjectById(pForm.getParamProjectCode()));
			pForm.setListPhase(pMan.getPhase());
			return mapping.findForward("EditProject");
		}
		if ("updateProject".equals(pForm.getTask())) {
			pMan.updateProject(pForm.getpBean());
			pForm.setListProject(pMan.searchProject(params));
		}
		
		if ("deleteProject".equals(pForm.getTask())) {
			if(pMan.deleteProject(pForm.getParamProjectCode()))
			{
				pForm.setMessage("Deleted Successfully");
			}
			else
				pForm.setMessage("Delete Failed");
		}

		params.put("start", (pForm.getPage() - 1) * 10 + 1);
		params.put("end", (pForm.getPage() * 10));
		params.put("category", pForm.getSearchCategory());
		params.put("keyword", pForm.getSearchKeyword());
		
		if ("member".equals(pForm.getTask())) {
			//go to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
			
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
		
	
		if ("addMember".equals(pForm.getTask())) {
			//go to add.jsp
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("AddMember");
		}
			
		if ("saveMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			if(pMan.addProjectMember(pForm.getAddSProject()))
			{
				if(pMan.isExist(pForm.getAddSProject().getDirectreportUserDomain()) == false)
				{
					pMan.insertRole(pForm.getAddSProject().getDirectreportUserDomain());
				}
				pForm.setMessage("Added Successfully");
			}
			else
				pForm.setMessage("Add Failed");
			
			//Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
			
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
		
		if ("editMember".equals(pForm.getTask())) {
			//go to editmember.jsp
			params = new HashMap();
			params.put("paramProjectCode", pForm.getParamProjectCode());
			params.put("paramAssigneeUserDomain",pForm.getParamAssigneeUserDomain());
			pForm.setAddSProject(pMan.getProjectMemberById(params));
			pForm.setDirectReportBefore(pForm.getAddSProject().getDirectreportUserDomain());
			return mapping.findForward("EditMember");
		}
		
		if ("updateMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			pMan.updateMember(pForm.getAddSProject());
			
			//Edit direct report yang lama
			if(pMan.checkRole(pForm.getDirectReportBefore()) == 0)
			{
				pMan.deleteRole(pForm.getDirectReportBefore());
			}
			
			//Add Direct Report yang baru
			if(pMan.isExist(pForm.getAddSProject().getDirectreportUserDomain()) == false){
				pMan.insertRole(pForm.getAddSProject().getDirectreportUserDomain());
			}
			
			
			//Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
	
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
		
		if ("back".equals(pForm.getTask())) {
			//Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
			
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
	
		if ("deleteMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setAssigneeUserDomain(pForm.getParamAssigneeUserDomain());
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			if(pMan.deleteMember(pForm.getAddSProject()))
			{
				//update table employee_role
				if(pMan.checkRole(pForm.getDirectReportUserDomain()) == 0)
				{
					pMan.deleteRole(pForm.getDirectReportUserDomain());
				}
				
				//update table assignments
				Map param = new HashMap();
				param.put("assignee", pForm.getParamAssigneeUserDomain());
				param.put("projectCode", pForm.getParamProjectCode());
				param.put("directreport", pForm.getDirectReportUserDomain());
				pMan.updateAssStatus(param);
				
				pForm.setMessage("Record Has been Deleted");
			}
			else
				pForm.setMessage("Record can't be deleted");
			
			//Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
			
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
		
		if("structure".equals(pForm.getMode()))
		{
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));
			
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());
			
			pForm.setCountRecord(pMan.countAllMember(params));
			if(pForm.getCountRecord() == 0){
				pForm.setMaxpage(1);
			}
			else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0){
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}
			
		pForm.setListProject(pMan.searchProject(params));
		pForm.setCountRecord(pMan.countProject(params));

		if(pForm.getCountRecord() == 0){
			pForm.setMaxpage(1);
		}
		else if (pForm.getCountRecord() % 10 == 0) {
			pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
		} else if (pForm.getCountRecord() % 10 > 0){
			pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListProject");
	}
}
