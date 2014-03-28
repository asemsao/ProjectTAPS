package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.project.AddProjectBean;
import adins.ace.taps.bean.project.AddStructureProjectBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;
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

	public Integer countProject(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"project.countProject", params);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
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

	public List<StructureProjectBean> getAllMember(Map params) {
		List<StructureProjectBean> projectMemberList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectMemberList = ibatisSqlMap.queryForList(
					"project.getAllProjectMember", params);
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
	
	public Integer countAllMember(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"project.countAllProjectMember", params);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}

	public boolean addProject(AddProjectBean apBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("project.addProject", apBean);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List getPhase() {
		List list = null;
		try {
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("project.getPhase", null);
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
		return list;
	}

	public boolean updateProject(ProjectBean bean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("project.updateProject", bean);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}

	public boolean addProjectMember(AddStructureProjectBean bean) {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("project.addProjectMember", bean);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}

	public AddStructureProjectBean getProjectMemberById(Map params) {
		AddStructureProjectBean bean = new AddStructureProjectBean();
		try {
			ibatisSqlMap.startTransaction();
			bean = (AddStructureProjectBean) ibatisSqlMap.queryForObject(
					"project.getProjectMemberById", params);
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
	
	public boolean updateMember(AddStructureProjectBean bean)
	{	
		boolean flag = false;
		try
		{
			ibatisSqlMap.update("project.updateMember", bean);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return flag;
	}
	
	public boolean deleteMember(AddStructureProjectBean bean)
	{
		boolean flag = false;
		try
		{
//			ibatisSqlMap.startTransaction();
			ibatisSqlMap.delete("project.deleteMember", bean);
//			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally 
//		{
//			try 
//			{
//				ibatisSqlMap.endTransaction();
//			} 
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		return flag;
	}
	
	public boolean deleteProject(String projectCode)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.update("project.deleteProject", projectCode);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	public Map isNotExist(String name)
	{
		int count = 0;
		Map map = new HashMap();
		boolean notExist = false;
		boolean error = false;
		try
		{
			count = (Integer)ibatisSqlMap.queryForObject("project.isNotExist", name);
		} catch (SQLException e) {
			e.printStackTrace();
			error = true;
		} 
		
		if(count == 0)
			notExist = true;
		
		map.put("notExist", notExist);
		map.put("error", error);
		return map;
	}
	
	public boolean insertRole(String name)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.insert("project.insertRole", name);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return flag;
	}
	
	public Map checkRole(String name)
	{
		int count = 0;
		Map map = new HashMap();
		boolean noMoreSPV= false;
		boolean error = false;
		try
		{
			count = (Integer)ibatisSqlMap.queryForObject("project.checkRole", name);
		} catch (SQLException e) {
			e.printStackTrace();
			error = true;
		} 
	
		
		if(count == 0)
			noMoreSPV = true;
		
		map.put("noMoreSPV", noMoreSPV);
		map.put("error", error);
		return map;
	}
	
	public boolean deleteRole(String name)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.delete("project.deleteRole", name);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
		return flag;
	}
	
	public boolean updateAssStatus(Map param)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.update("project.updateAssStatus",param);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean insertHistory(Map param)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.insert("project.insertHistory",param);	
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean updateAllAssStatus(Map map)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.update("project.updateAllAssStatus",map);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean changeNewSupervisor(Map param)
	{
		boolean flag = false;
		try
		{
			ibatisSqlMap.update("project.changeNewSupervisor",param);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
		return flag;
	}
	
	public Map notHeadBU(String userDomain)
	{
		int count = 0;
		Map map = new HashMap();
		boolean notHead = false;
		boolean error = false;
		try
		{
			count = (Integer)ibatisSqlMap.queryForObject("project.notHeadBU", userDomain);
		} catch (SQLException e) {
			e.printStackTrace();
			error = true;
		} 
	
		if(count == 0)
			notHead = true;
		
		map.put("error", error);
		map.put("notHead", notHead);
		return map;
	}
	
	public Map checkDirectReportUserDomain(String code)
	{
		Map map = new HashMap();
		boolean error = false;
		List<AddStructureProjectBean> list = new ArrayList<AddStructureProjectBean>();
		try {
			list = ibatisSqlMap.queryForList("project.checkDirectReportUserDomain", code);
		} catch (SQLException e) {
			e.printStackTrace();
			error = true;
		}
		map.put("error", error);
		map.put("list", list);
		return map;
	}
	
	public boolean deleteProjectStructuresTable(String code)
	{
		boolean flag= false;
		try
		{
			ibatisSqlMap.delete("project.deleteProjectStructuresTable", code);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;
	}
	
	public void startTransaction() {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.getDataSource().getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commitTransaction() {
		try {
			ibatisSqlMap.commitTransaction();
			ibatisSqlMap.endTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback() {
		try {
			ibatisSqlMap.getDataSource().getConnection().rollback();
			ibatisSqlMap.endTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
