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

	public void submitInsert(OrganizationBean eBean) throws SQLException,
			IOException {
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("organization.insertOrganization", eBean);
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
