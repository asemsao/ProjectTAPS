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
			reportList = ibatisSqlMap.queryForList("report.getReportLevel2_v2", h);			
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
	
	public String getStartDateProject(Map h){
		String startDate = "";
		try {
			ibatisSqlMap.startTransaction();
			startDate = (String) ibatisSqlMap.queryForObject("report.getStartDate", h);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return startDate;		
	}
	
	public String getEndDateProject(Map h){
		String endDate = "";
		try {
			ibatisSqlMap.startTransaction();
			endDate = (String) ibatisSqlMap.queryForObject("report.getEndDate", h);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return endDate;		
	}
	
	public int countHistoryProjects(Map h){
		int count = 0;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject("report.countHistoryProjects", h);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;		
	}
}
