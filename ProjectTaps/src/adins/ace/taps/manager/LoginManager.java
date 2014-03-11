package adins.ace.taps.manager;

import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class LoginManager {
	public SqlMapClient ibatisSqlMap = null;
	public LoginManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	public List<String> roleList(Map params){
		List<String> roleList = null;
		try {
			ibatisSqlMap.startTransaction();
			roleList = ibatisSqlMap.queryForList("login.getRoles", params);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return roleList;
	}
}
