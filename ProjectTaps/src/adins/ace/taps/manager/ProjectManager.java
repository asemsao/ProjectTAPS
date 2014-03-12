package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.project.AddProjectBean;
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
}
