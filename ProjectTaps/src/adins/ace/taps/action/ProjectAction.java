package adins.ace.taps.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.project.AddStructureProjectBean;
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
		HttpSession session = request.getSession(true);
		String userDomain = (String) session.getAttribute("username");
		pForm.getAddProject().setUserdomain((String)session.getAttribute("username"));
		pForm.getpBean().setUserdomain((String)session.getAttribute("username"));
		pForm.getAddSProject().setUserdomain((String)session.getAttribute("username"));
	
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
			// go to new.jsp
			return mapping.findForward("AddProject");
		}
		if ("saveProject".equals(pForm.getTask())) {
			boolean add = false;
			boolean history = false;
			pMan.startTransaction();
			
			//insert to table projects
			add = pMan.addProject(pForm.getAddProject());
			
			// insert table history_projects
			Map param = new HashMap();
			param.put("projectCode", pForm.getAddProject().getProjectCode());
			param.put("orgAfter", pForm.getAddProject()
					.getOrganizationCode());
			param.put("userdomain", userDomain);
			history = pMan.insertHistory(param);
			
			
			if (add && history) 
			{	
				pMan.commitTransaction();
				pForm.setMessage("Inserted Successfully");
				pForm.setColor("green");
			} 
			else
			{
				pMan.rollback();
				pForm.setMessage("Insert Project Failed");
				pForm.setColor("red");
			}
		}
		if ("cancel".equals(pForm.getTask())) {
			pForm.setMode("");
		}

		if ("edit".equals(pForm.getTask())) {
			// go to editproject.jsp
			pForm.setpBean(pMan.getProjectById(pForm.getParamProjectCode()));
			pForm.setListPhase(pMan.getPhase());
			return mapping.findForward("EditProject");
		}
		if ("updateProject".equals(pForm.getTask())) {
			//klo project sudah closed semua role di dalam di hapus
			if("CLD".equals(pForm.getpBean().getPhase()))
			{
				pMan.startTransaction();
				boolean deleteProjectStruct = false;
				boolean updateProject = false;
				
				//delete all member role
				boolean errorDirectReport = false;
				Map map = new HashMap();
				List<AddStructureProjectBean> list = null;
				List<Boolean> listStatus = new ArrayList<Boolean>();
				
				map = pMan.checkDirectReportUserDomain(pForm.getpBean().getProjectCode());
				list = (List<AddStructureProjectBean>)map.get("list");
				errorDirectReport = (Boolean)map.get("error");
				
				//delete employee from project_structures table
				deleteProjectStruct = pMan.deleteProjectStructuresTable(pForm.getpBean().getProjectCode());
				
				for (int i=0;i<list.size();i++) 
				{
					AddStructureProjectBean bean = new AddStructureProjectBean();
					bean = list.get(i);

					Map map1 = new HashMap();
					map1 = pMan.notHeadBU(bean.getDirectreportUserDomain());

					boolean noMoreSPV = false;
					boolean errorNoMoreSPV = false;
					boolean errorNotHead = false;
					boolean notHead = false;
					boolean deleteRole = false;
					
					notHead = (Boolean)map1.get("notHead");
					errorNotHead = (Boolean)map1.get("error");
					
					if(!errorNotHead)
					{
						if(notHead)
						{
							Map map2 = new HashMap();
							map2 = pMan.checkRole(bean.getDirectreportUserDomain());
							noMoreSPV = (Boolean)map2.get("noMoreSPV");
							errorNoMoreSPV = (Boolean)map2.get("error");
							
							if(!errorNoMoreSPV)
							{
								if(noMoreSPV)
								{
									deleteRole = pMan.deleteRole(bean.getDirectreportUserDomain());
								}
								else
								{
									deleteRole = true;
									noMoreSPV = true;
								}
							}
						}
						else
						{
							notHead = true;
							deleteRole = true;
							noMoreSPV = true;
						}
					}
					
					//set listStatus menjadi true or false
					if(noMoreSPV && deleteRole && !errorNoMoreSPV && !errorNotHead && notHead)
					{
						listStatus.add(i, true);
					}
					else
					{
						listStatus.add(i, false);
					}
				}
				
				//nge recap semua status yang di dalam ListStatus
				boolean recapStatus = true;
				for(int i = 0;i < listStatus.size();i++)
				{
					recapStatus = recapStatus && listStatus.get(i);
				}
				
				//update Project
				updateProject = pMan.updateProject(pForm.getpBean());
				
				
				if(recapStatus && updateProject && deleteProjectStruct && !errorDirectReport)
				{
					pMan.commitTransaction();
					pForm.setMessage("Updated Successfully");
					pForm.setColor("green");
				}
				else
				{
					pMan.rollback();
					pForm.setMessage("Update Project Failed");
					pForm.setColor("red");
				}
				
				//back to index.jsp
				pForm.setListProject(pMan.searchProject(params));

			}
			else //update project selain closed
			{
				boolean updateProject = false;
				pMan.startTransaction();
				updateProject = pMan.updateProject(pForm.getpBean());
				
				if(updateProject)
				{
					pMan.commitTransaction();
					pForm.setMessage("Updated Successfully");
					pForm.setColor("green");
				}
				else
				{
					pMan.rollback();
					pForm.setMessage("Update Project Failed");
					pForm.setColor("red");
				}
				
				//back to index.jsp
				pForm.setListProject(pMan.searchProject(params));
			}
		}

		if ("deleteProject".equals(pForm.getTask())) {
			pMan.startTransaction();
			boolean deleteProject = false;
			boolean deleteProjectStruct = false;
			
			//delete Project
			deleteProject = pMan.deleteProject(pForm.getParamProjectCode());
			
			//delete all member role
			boolean errorDirectReport = false;
			Map map = new HashMap();
			List<AddStructureProjectBean> list = null;
			List<Boolean> listStatus = new ArrayList<Boolean>();
			
			map = pMan.checkDirectReportUserDomain(pForm.getParamProjectCode());
			list = (List<AddStructureProjectBean>)map.get("list");
			errorDirectReport = (Boolean)map.get("error");
			
			//delete employee from project_structures table
			deleteProjectStruct = pMan.deleteProjectStructuresTable(pForm.getParamProjectCode());
			
			for (int i=0;i<list.size();i++) 
			{
				AddStructureProjectBean bean = new AddStructureProjectBean();
				bean = list.get(i);

				Map map1 = new HashMap();
				map1 = pMan.notHeadBU(bean.getDirectreportUserDomain());

				boolean noMoreSPV = false;
				boolean errorNoMoreSPV = false;
				boolean errorNotHead = false;
				boolean notHead = false;
				boolean deleteRole = false;
				
				notHead = (Boolean)map1.get("notHead");
				errorNotHead = (Boolean)map1.get("error");
				
				if(!errorNotHead)
				{
					if(notHead)
					{
						Map map2 = new HashMap();
						map2 = pMan.checkRole(bean.getDirectreportUserDomain());
						noMoreSPV = (Boolean)map2.get("noMoreSPV");
						errorNoMoreSPV = (Boolean)map2.get("error");
						
						if(!errorNoMoreSPV)
						{
							if(noMoreSPV)
							{
								deleteRole = pMan.deleteRole(bean.getDirectreportUserDomain());
							}
							else
							{
								deleteRole = true;
								noMoreSPV = true;
							}
						}
					}
					else
					{
						notHead = true;
						deleteRole = true;
						noMoreSPV = true;
					}
				}
				
				//set listStatus menjadi true or false
				if(noMoreSPV && deleteRole && !errorNoMoreSPV && !errorNotHead && notHead)
				{
					listStatus.add(i, true);
				}
				else
				{
					listStatus.add(i, false);
				}
			}
			
			//nge recap semua status yang di dalam ListStatus
			boolean recapStatus = true;
			for(int i = 0;i < listStatus.size();i++)
			{
				recapStatus = recapStatus && listStatus.get(i);
			}
	
			// update table assignments
			boolean updateAssignment = false;
			Map mapUpdate = new HashMap();
			map.put("projectCode", pForm.getParamProjectCode());
			map.put("userDomain", userDomain);
			updateAssignment = pMan.updateAllAssStatus(mapUpdate);
			
			if(updateAssignment && deleteProjectStruct && recapStatus && !errorDirectReport && deleteProject)
			{
				pMan.commitTransaction();
				pForm.setMessage("Deleted Successfully");
				pForm.setColor("green");
			}
			else
			{
				pMan.rollback();
				pForm.setMessage("Delete Project Failed");
				pForm.setColor("red");
			}
			
		}

		params.put("start", (pForm.getPage() - 1) * 10 + 1);
		params.put("end", (pForm.getPage() * 10));
		params.put("category", pForm.getSearchCategory());
		params.put("keyword", pForm.getSearchKeyword());

		if ("member".equals(pForm.getTask())) {
			// go to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		if ("addMember".equals(pForm.getTask())) {
			// go to add.jsp
			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setProjectName(pBean.getProjectName());
			return mapping.findForward("AddMember");
		}

		if ("saveMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			boolean add = false;
			boolean isNotExist = false;
			boolean role = false;
			boolean error = false;
			Map map = new HashMap();
			
			pMan.startTransaction();
			add = pMan.addProjectMember(pForm.getAddSProject());
			map = pMan.isNotExist(pForm.getAddSProject().getDirectreportUserDomain());
			isNotExist = (Boolean)map.get("notExist");
			error = (Boolean)map.get("error");
			if(!error)
			{
				if(isNotExist)
				{
					role = pMan.insertRole(pForm.getAddSProject().getDirectreportUserDomain());
				}
				else
				{
					role = true;
					isNotExist = true;
				}
			}
			
			if(add && isNotExist && role && !error)
			{
				pMan.commitTransaction();
				pForm.setMessage("Added Employee Successfully");
				pForm.setColor("green");
			}
			else
			{
				pMan.rollback();
				pForm.setMessage("Add Employee on Project Failed");
				pForm.setColor("red");
			}

			// Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		if ("editMember".equals(pForm.getTask())) {
			// go to editmember.jsp
			params = new HashMap();
			params.put("paramProjectCode", pForm.getParamProjectCode());
			params.put("paramAssigneeUserDomain",
					pForm.getParamAssigneeUserDomain());
			pForm.setAddSProject(pMan.getProjectMemberById(params));
			pForm.setDirectReportBefore(pForm.getAddSProject()
					.getDirectreportUserDomain());
			return mapping.findForward("EditMember");
		}

		if ("updateMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			
			boolean update = false;
			boolean notHead = false;
			boolean errorNotHead = false;
			boolean noMoreSPV = false;
			boolean errorNoMoreSPV = false;
			pMan.startTransaction();
			boolean deleteRole = false;
			update = pMan.updateMember(pForm.getAddSProject());
			
			// Check apakah dia(supervisor yg lama) head BU atau bukan(kalau bukan akan di delete supervisor role nya)
			Map map1 = new HashMap();
			map1 = pMan.notHeadBU(pForm.getDirectReportBefore());
			notHead = (Boolean)map1.get("notHead");
			errorNotHead = (Boolean)map1.get("error");
			
			if(!errorNotHead)
			{
				if(notHead)
				{
					Map map2 = new HashMap();
					map2 = pMan.checkRole(pForm.getDirectReportBefore());
					noMoreSPV = (Boolean)map2.get("noMoreSPV");
					errorNoMoreSPV = (Boolean)map2.get("error");
					
					if(!errorNoMoreSPV)
					{
						if(noMoreSPV)
						{
							deleteRole = pMan.deleteRole(pForm.getDirectReportBefore());
						}
						else
						{
							deleteRole = true;
							noMoreSPV = true;
						}
					} 
				}
				else
				{
					deleteRole = true;
					noMoreSPV = true;
					notHead = true;
				}
			} 
			
			//add supervisor role ke direct report yang baru
			Map map3 = new HashMap();
			boolean isNotExist = false;
			boolean errorNotExist = false;
			boolean role = false;
			map3 = pMan.isNotExist(pForm.getAddSProject().getDirectreportUserDomain());
			isNotExist = (Boolean)map3.get("notExist");
			errorNotExist = (Boolean)map3.get("error");
			if(!errorNotExist)
			{
				if(isNotExist)
				{
					role = pMan.insertRole(pForm.getAddSProject().getDirectreportUserDomain());
				}
				else
				{
					role = true;
					isNotExist = true;
				}
			}

			// update table assignment --> ganti directreport ke orang yang baru
			Map param = new HashMap();
			boolean change = false;
			param.put("reportTo", pForm.getAddSProject()
					.getDirectreportUserDomain());
			param.put("assignTo", pForm.getAddSProject()
					.getAssigneeUserDomain());
			param.put("projectCode", pForm.getParamProjectCode());
			param.put("reportToBefore", pForm.getDirectReportBefore());
			param.put("userDomain", userDomain);
			change = pMan.changeNewSupervisor(param);

			if(update && deleteRole && noMoreSPV && notHead && role && isNotExist && change && !errorNotHead && !errorNotExist)
			{
				pMan.commitTransaction();
				pForm.setMessage("Edit Successfully");
				pForm.setColor("green");
			}
			else
			{
				pMan.rollback();
				pForm.setMessage("Edit Failed");
				pForm.setColor("red");
			}
			
			// Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		if ("back".equals(pForm.getTask())) {
			// Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		if ("deleteMember".equals(pForm.getTask())) {
			pForm.getAddSProject().setAssigneeUserDomain(pForm.getParamAssigneeUserDomain());
			pForm.getAddSProject().setProjectCode(pForm.getParamProjectCode());
			
			//delete member
			boolean deleteMember = false;
			pMan.startTransaction();
			deleteMember = pMan.deleteMember(pForm.getAddSProject());
				
			// Check apakah dia head BU atau bukan(kalau bukan akan di delete supervisor role nya)
			Map map1 = new HashMap();
			boolean notHead = false;
			boolean errorNotHead = false;
			boolean noMoreSPV = false;
			boolean errorNoMoreSPV = false;
			boolean deleteRole = false;
			map1 = pMan.notHeadBU(pForm.getDirectReportUserDomain());
			notHead = (Boolean)map1.get("notHead");
			errorNotHead = (Boolean)map1.get("error");
			
			if(!errorNotHead)
			{
				if(notHead)
				{
					Map map2 = new HashMap();
					map2 = pMan.checkRole(pForm.getDirectReportUserDomain());
					noMoreSPV = (Boolean)map2.get("noMoreSPV");
					errorNoMoreSPV = (Boolean)map2.get("error");
					System.out.println(noMoreSPV + " " +  pForm.getDirectReportUserDomain());
					if(!errorNoMoreSPV)
					{
						if(noMoreSPV)
						{
							deleteRole = pMan.deleteRole(pForm.getDirectReportUserDomain());
						}
						else
						{
							deleteRole = true;
							noMoreSPV = true;
						}
					}
				}
				else
				{
					notHead = true;
					deleteRole = true;
					noMoreSPV = true;
				}
			} 

				// update table assignments
				Map param = new HashMap();
				boolean updateAssStatus = false;
				param.put("assignee", pForm.getParamAssigneeUserDomain());
				param.put("projectCode", pForm.getParamProjectCode());
				param.put("directreport", pForm.getDirectReportUserDomain());
				param.put("userDomain", userDomain);
				updateAssStatus = pMan.updateAssStatus(param);
				
				if(deleteMember && deleteRole && noMoreSPV && notHead && updateAssStatus && !errorNoMoreSPV && !errorNotHead)
				{
					pMan.commitTransaction();
					pForm.setMessage("Employee has been Deleted from This Project");
					pForm.setColor("green");
				} 
				else
				{
					pMan.rollback();
					pForm.setMessage("Employee can't be deleted from This Project");
					pForm.setColor("red");
				}

			// Back to structure.jsp
			pForm.setPage(1);
			pForm.setMode("structure");
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		if ("structure".equals(pForm.getMode())) {
			params.put("projectCode", pForm.getParamProjectCode());
			pForm.setListStructureProject(pMan.getAllMember(params));

			pBean = pMan.getProjectById(pForm.getParamProjectCode());
			pForm.setOrganizationName(pBean.getOrganizationName());
			pForm.setProjectName(pBean.getProjectName());

			pForm.setCountRecord(pMan.countAllMember(params));
			if (pForm.getCountRecord() == 0) {
				pForm.setMaxpage(1);
			} else if (pForm.getCountRecord() % 10 == 0) {
				pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
			} else if (pForm.getCountRecord() % 10 > 0) {
				pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("ViewMember");
		}

		pForm.setListProject(pMan.searchProject(params));
		pForm.setCountRecord(pMan.countProject(params));

		if (pForm.getCountRecord() % 10 == 0) {
			pForm.setMaxpage((int) Math.ceil(pForm.getCountRecord() / 10));
		} else if (pForm.getCountRecord() % 10 > 0) {
			pForm.setMaxpage(((int) Math.ceil(pForm.getCountRecord() / 10)) + 1);
		}
		if (pForm.getMaxpage() == 0) {
			pForm.setMaxpage(1);
		}

		return mapping.findForward("ListProject");
	}
}
