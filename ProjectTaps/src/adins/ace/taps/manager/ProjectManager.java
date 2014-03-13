package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.project.AddProjectBean;
import adins.ace.taps.bean.project.AddStructureProjectBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProjectManager {
	public SqlMapClient ibatisSqlMap = null;

	public ProjectManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List<ProjectBean> searchProject(Map params) {
		List<ProjectBean> projectList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectList = ibatisSqlMap.queryForList("project.searchProject",params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return projectList;
	}

	public ProjectBean getProjectById(String prjtCode) {
		ProjectBean pBean = new ProjectBean();
		try {
			ibatisSqlMap.startTransaction();
			pBean = (ProjectBean) ibatisSqlMap.queryForObject(
					"project.getProjectById", prjtCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pBean;
	}

	public List getAllMember(String prjtCode) {
		List projectMemberList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectMemberList = ibatisSqlMap.queryForList(
					"project.getAllProjectMember", prjtCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return projectMemberList;
	}

	public void addProject(AddProjectBean apBean) {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("project.addProject", apBean);
			ibatisSqlMap.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List getPhase()
	{
		List list = null;
		try 
		{
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("project.getPhase", null);
			ibatisSqlMap.commitTransaction();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try 
			{
				ibatisSqlMap.endTransaction();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void updateProject(ProjectBean bean)
	{	
		try
		{
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("project.updateProject", bean);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				ibatisSqlMap.endTransaction();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addProjectMember(AddStructureProjectBean bean) {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("project.addProjectMember", bean);
			ibatisSqlMap.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public AddStructureProjectBean getProjectMemberById(Map params) {
		AddStructureProjectBean bean = new AddStructureProjectBean();
		try {
			ibatisSqlMap.startTransaction();
			bean = (AddStructureProjectBean) ibatisSqlMap.queryForObject("project.getProjectMemberById", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
}
