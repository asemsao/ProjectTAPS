package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.manageRole.EmployeeBean;
import adins.ace.taps.bean.manageRole.EmployeeRoleBean;
import adins.ace.taps.bean.manageRole.MenuBean;
import adins.ace.taps.bean.manageRole.RoleBean;
import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class RestoreOrganizationManager {
	public SqlMapClient ibatisSqlMap = null;

	public RestoreOrganizationManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	
	public List<OrganizationBean> searchListOrganization() {
		List<OrganizationBean> list = null;
		try {
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("restoreOrganization.searchListOrganization", null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public Integer countRecord() {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject("restoreOrganization.countRecord", null);
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
	
	public List<OrganizationBean> searchListOrganization(Map params) {
		List<OrganizationBean> list = null;
		try {
			ibatisSqlMap.startTransaction();
			list = ibatisSqlMap.queryForList("restoreOrganization.searchListOrganization", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public Integer countRecord(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject("restoreOrganization.countRecord", params);
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
	
	public boolean restoreOrganization(String code) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.update("restoreOrganization.restoreOrg", code);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
}