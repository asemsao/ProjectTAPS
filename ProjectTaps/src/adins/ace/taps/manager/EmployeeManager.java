package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;



public class EmployeeManager {
	public SqlMapClient ibatisSqlMap = null;

	public EmployeeManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	
	public List getAllEmployees(){
		List empList = null;
		try {
			ibatisSqlMap.startTransaction();
			empList = ibatisSqlMap.queryForList("employee.getAllEmployees", null);			
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
}
