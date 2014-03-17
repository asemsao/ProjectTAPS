package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DashboardManager {
	public SqlMapClient ibatisSQLMap = null;

	public DashboardManager() {
		this.ibatisSQLMap = IbatisHelper.getSqlMapInstance();
	}
	
	public List<DashboardBean> searchTopTen (){
		List<DashboardBean> list = new ArrayList<DashboardBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.searchTopTen", list);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<DashboardBean> searchTopTenOrganization(String organizationCode){
		List<DashboardBean> list = new ArrayList<DashboardBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.searchTopTenOrganization", organizationCode);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}
