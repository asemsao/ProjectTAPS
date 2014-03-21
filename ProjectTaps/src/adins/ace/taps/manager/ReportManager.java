package adins.ace.taps.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.project.AddProjectBean;
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
	
	public Savepoint insertSavePoint() {
		boolean flag = false;
		Savepoint savepoint2 = null;
		try {
			ibatisSqlMap.getDataSource().getConnection().setAutoCommit(false);
			savepoint2 = ibatisSqlMap.getDataSource().getConnection().setSavepoint("SavePoint2");
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("report.tes", null);
			ibatisSqlMap.insert("report.tes2", null);
			//ibatisSqlMap.insert("report.tes3", null);
			
			//ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (SQLException e) {
//			try {
//				ibatisSqlMap.getDataSource().getConnection().rollback(savepoint2);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return savepoint2;
	}
	
	public boolean insertSavePoint2(Savepoint savepoint2) {
		boolean flag = false;
		try {
			ibatisSqlMap.getDataSource().getConnection().setAutoCommit(false);
			//savepoint2 = ibatisSqlMap.getDataSource().getConnection().setSavepoint("SavePoint2");
			ibatisSqlMap.startTransaction();
			//ibatisSqlMap.insert("report.tes", null);
			//ibatisSqlMap.insert("report.tes2", null);
			ibatisSqlMap.insert("report.tes3", null);
			ibatisSqlMap.getDataSource().getConnection().commit();
			flag = true;
		} catch (SQLException e) {
			try {
				ibatisSqlMap.getDataSource().getConnection().rollback(savepoint2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List getReportLevel2(Map h){
		List reportList = null;
		//Savepoint savepoint1 = null;
		try {
			//ibatisSqlMap.getDataSource().getConnection().setAutoCommit(false);
			//savepoint1 = ibatisSqlMap.getDataSource().getConnection().setSavepoint("SavePoint1");			
			ibatisSqlMap.startTransaction();
			reportList = ibatisSqlMap.queryForList("report.getReportLevel2_v2", h);
			//ibatisSqlMap.commitTransaction();
		} catch (Exception e) {
//			try {
//				ibatisSqlMap.getCurrentConnection().rollback(savepoint1);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
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
