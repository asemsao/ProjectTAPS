package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.specialAppraisal.SpecialAppraisalBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class OrganizationManager {
	public SqlMapClient ibatisSqlMap = null;

	public OrganizationManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
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
		System.out.println(params.get("organization_code"));
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

	public boolean submitInsert(OrganizationBean eBean) throws SQLException,
			IOException {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("organization.insertOrganization", eBean);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public void insertRole(OrganizationBean eBean) throws SQLException,
			IOException {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("organization.insertRole", eBean);
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
	
	public void deleteRole(String headDomain) {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("organization.deleteRole", headDomain);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean deleteOrganization(String organization_code) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("organization.deleteOrganization",
					organization_code);
			ibatisSqlMap.commitTransaction();
			flag = true;

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
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("organization.editOrganization", orgBean);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

}
