package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.report.ReportBean;
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
	
	public List getReportLevel1(Map h){
		List reportList = null;
		try {
			ibatisSqlMap.startTransaction();
			reportList = ibatisSqlMap.queryForList("report.getReportLevel1", h);			
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
	
	public List getReportLevel2(Map h){
		List reportList = null;
		try {
			ibatisSqlMap.startTransaction();
			reportList = ibatisSqlMap.queryForList("report.getReportLevel2", h);			
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
	
	public List getReportDetails(Map h){
		List reportList = null;
		try {
			ibatisSqlMap.startTransaction();
			reportList = ibatisSqlMap.queryForList("report.getReportDetails", h);			
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
	
	public ReportBean getHeadOrganization(Map h){
		ReportBean rBean = new ReportBean();
		try {
			ibatisSqlMap.startTransaction();
			rBean = (ReportBean) ibatisSqlMap.queryForObject("report.getHeadOrganization", h);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rBean;		
	}
}
