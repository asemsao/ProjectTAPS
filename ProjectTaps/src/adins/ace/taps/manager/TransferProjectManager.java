package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class TransferProjectManager {
	public SqlMapClient ibatisSqlMap = null;

	public TransferProjectManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List<ProjectBean> searchProject(Map params) {
		List<ProjectBean> projectList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectList = ibatisSqlMap.queryForList("transferProject.searchProject",params);
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
	
	public List<OrganizationBean> searchOrganization(Map params) {
		List<OrganizationBean> orgList = null;
		try {
			ibatisSqlMap.startTransaction();
			orgList = ibatisSqlMap.queryForList("transferProject.searchOrganization", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return orgList;
	}
	
	public ProjectBean getProjectById(String prjtCode) {
		ProjectBean pBean = new ProjectBean();
		try {
			ibatisSqlMap.startTransaction();
			pBean = (ProjectBean) ibatisSqlMap.queryForObject(
					"transferProject.getProjectById", prjtCode);
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
	
	public List<StructureProjectBean> getAllMemberByProjectId(String prjtCode) {
		List<StructureProjectBean> projectMemberList = null;
		try {
			ibatisSqlMap.startTransaction();
			projectMemberList = ibatisSqlMap.queryForList("transferProject.getAllMemberByProjectId", prjtCode);
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
	
	public boolean updateTransfer(Map params) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("transferProject.updateTransferProject", params);
			if (params.get("listMember").toString().length() > 1) {
				ibatisSqlMap.update("transferProject.updateTransferMember", params);
			}
			ibatisSqlMap.insert("transferProject.insertHistoryProject", params);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
			}
		}
		return flag;
	}

	public Integer countProject(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"transferProject.countProject", params);
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
	
	public Integer countOrganization(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"transferProject.countOrganization", params);
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
	
	public Integer countAllMember(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"transferProject.countAllProjectMember", params);
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
	
	public byte[] getPhoto(String userDomain) {
		StructureProjectBean bean = null;
		try {
			ibatisSqlMap.startTransaction();
			bean = (StructureProjectBean) ibatisSqlMap.queryForObject(
					"transferProject.getPhoto", userDomain);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean.getPhoto();
	}
}
