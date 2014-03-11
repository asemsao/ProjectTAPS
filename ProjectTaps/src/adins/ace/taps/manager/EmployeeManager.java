package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EmployeeManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public boolean insertNewEmployee(NewEmployeeBean newEmployee) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.queryForObject("employee.addEmployee", newEmployee);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
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

	public List<EmployeeBean> searchEmployees(Map params) {
		List<EmployeeBean> empList = null;
		try {
			ibatisSqlMap.startTransaction();
			System.out.println("row dave");
			empList = ibatisSqlMap.queryForList("employee.searchEmployees",
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
		return empList;
	}

	public NewEmployeeBean getEditEmployees(Map params) {
		NewEmployeeBean empEdit = null;
		try {
			ibatisSqlMap.startTransaction();
			empEdit = (NewEmployeeBean) ibatisSqlMap.queryForObject(
					"employee.getEditEmployees", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empEdit;
	}

	public Integer countEmployees(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"employee.countEmployees", params);
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
}
