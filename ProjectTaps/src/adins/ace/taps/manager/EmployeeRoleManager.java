package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employeeRole.EmployeeRoleBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EmployeeRoleManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeRoleManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List<EmployeeRoleBean> searchEmployeeRole() {
		List<EmployeeRoleBean> empRoleList = null;
		try {
			ibatisSqlMap.startTransaction();
			empRoleList = ibatisSqlMap.queryForList("employeeRole.searchEmployees",
					null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empRoleList;
	}
	
	public EmployeeRoleBean detailEmployeeRole(Map params) {
		EmployeeRoleBean erBean = null;
		try {
			ibatisSqlMap.startTransaction();
			erBean = (EmployeeRoleBean) ibatisSqlMap.queryForObject("employeeRole.detailEmployeeRole",
					params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return erBean;
	}
}