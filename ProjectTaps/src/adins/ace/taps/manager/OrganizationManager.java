package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class OrganizationManager {
	public SqlMapClient ibatisSqlMap = null;

	public OrganizationManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void rollback() {
		try {
			ibatisSqlMap.getDataSource().getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<OrganizationBean> searchOrganizations(Map params) {
		List<OrganizationBean> orgList = null;
		try {
			ibatisSqlMap.startTransaction();
			orgList = ibatisSqlMap.queryForList(
					"organization.searchOrganizations", params);
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

	public List<OrganizationBean> searchMemberOrganizations(Map params) {
		List<OrganizationBean> orgList = null;
		try {
			ibatisSqlMap.startTransaction();
			orgList = ibatisSqlMap.queryForList(
					"organization.searchMemberOrganizations", params);
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

	public String getOrganizationName(Map params) {
		String OrganizationName = "";
		try {
			ibatisSqlMap.startTransaction();
			OrganizationName = (String) ibatisSqlMap.queryForObject(
					"organization.selectOrganizationName", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return OrganizationName;
	}

	public List<OrganizationBean> listProject(Map params) {
		List<OrganizationBean> listProject = null;
		try {
			ibatisSqlMap.startTransaction();
			listProject = ibatisSqlMap.queryForList(
					"organization.selectProject", params);
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
		return listProject;
	}

	public List<OrganizationBean> listChild(Map params) {
		List<OrganizationBean> listProject = null;
		try {
			ibatisSqlMap.startTransaction();
			listProject = ibatisSqlMap.queryForList("organization.selectChild",
					params);
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
		return listProject;
	}

	public Integer countListProject(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countSelectProject", params);
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

	public Integer countListChild(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countSelectChild", params);
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

	public Integer countOrganizations(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countOrganizations", params);
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

	public List<OrganizationBean> searchParentOrganizations(Map params) {
		List<OrganizationBean> orgList = null;
		try {
			ibatisSqlMap.startTransaction();
			orgList = ibatisSqlMap.queryForList(
					"organization.searchParentOrganizations", params);
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

	public Integer countParentOrganizations(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countParentOrganizations", params);
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

	public Integer countChildOrganizations(String organization_code) {
		Integer countChild = null;
		try {
			ibatisSqlMap.startTransaction();
			countChild = (Integer) ibatisSqlMap.queryForObject(
					"organization.countChildOrganizations", organization_code);
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
		return countChild;
	}

	public Integer countMemberOrganizations(Map params) {
		Integer countMember = null;
		try {
			ibatisSqlMap.startTransaction();
			countMember = (Integer) ibatisSqlMap.queryForObject(
					"organization.countMemberOrganizations", params);
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
		return countMember;
	}

	public Integer countMember(Map params) {
		Integer countMember = null;
		try {
			ibatisSqlMap.startTransaction();
			countMember = (Integer) ibatisSqlMap.queryForObject(
					"organization.countMember", params);
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
		return countMember;
	}

	public Integer countProject(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countProject", params);
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

	public Integer countRoleSPV(String headDomain) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countRoleSPV", headDomain);
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
	
	public Integer countRoleSPVNoStart(String headDomain) {
		Integer count = null;
		try {
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countRoleSPV", headDomain);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}


	public Integer countDirectReportProject(String headDomain) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countDirectReport", headDomain);
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
	
	public Integer levelParent(String parentCode) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.levelParent", parentCode);
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
	
	public Integer maxLevel() {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.maxLevel", null);
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
	
	public Integer countDirectReportProjectNoStart(String headDomain) {
		Integer count = null;
		try {
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.countDirectReport", headDomain);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean submitInsert(OrganizationBean eBean) throws SQLException,
			IOException {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("organization.insertOrganization", eBean);
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean insertRoleSPV(OrganizationBean eBean) throws SQLException,
			IOException {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("organization.insertRoleSPV", eBean);
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean insertRole(OrganizationBean eBean) throws SQLException,
			IOException {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("organization.insertRole", eBean);
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteRole(String headDomain) {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("organization.deleteRole", headDomain);
			flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteRoleSPV(String headDomain) {
		boolean flag = false;
		try {
			ibatisSqlMap.insert("organization.deleteRoleSPV", headDomain);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteOrganization(String organization_code) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.deleteOrganization",
					organization_code);
			flag = true;

		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean checkChildOrganization(String organization_code) {
		boolean flag = false;
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.checkChildOrganization", organization_code);
			ibatisSqlMap.commitTransaction();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				flag = false;
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public int checkMemberOrganization(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"organization.checkMemberOrganization", params);
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

	public OrganizationBean getOrgCode(String organizationCode) {
		OrganizationBean orgBean = new OrganizationBean();
		try {
			ibatisSqlMap.startTransaction();
			orgBean = (OrganizationBean) ibatisSqlMap.queryForObject(
					"organization.getOrganizationCode", organizationCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return orgBean;
	}

	public boolean submitEdit(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.editOrganization", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}

	public boolean submitEditWithChild(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.editOrganizationWithChild",
					orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean updateLevelChild(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateLevelChild",
					orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	
	
	public boolean updateDeleteOrgCodeHBU(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateDeleteOrgCodeHBU", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean updateDeleteHBU(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateDeleteHBU", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	
	public boolean updateOrgCodeHBU(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateOrgCodeHBU", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}

	public boolean updateAssignment(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateAssignment", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}

	public boolean updateReportAssignment(OrganizationBean orgBean) {
		boolean flag = false;
		try {
			ibatisSqlMap.update("organization.updateReportAssignment", orgBean);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
