package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;



public class ReportManager {
	public SqlMapClient ibatisSqlMap = null;

	public ReportManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	
	public List getAllReports(){
		List reportList = null;
		try {
			ibatisSqlMap.startTransaction();
			reportList = ibatisSqlMap.queryForList("report.getAllReports", null);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return reportList;		
	}
}
