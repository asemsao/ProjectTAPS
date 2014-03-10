package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;



public class EmployeeManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	public boolean insertNewEmployee(NewEmployeeBean newEmployee){
		boolean flag=false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.queryForObject("employee.addEmployee", newEmployee);
			ibatisSqlMap.commitTransaction();
			flag=true;
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
	
	public List getAllEmployees(Map params){
		List empList = null;
		try {
			ibatisSqlMap.startTransaction();
			empList = ibatisSqlMap.queryForList("employee.getAllEmployees", params);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empList;		
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
