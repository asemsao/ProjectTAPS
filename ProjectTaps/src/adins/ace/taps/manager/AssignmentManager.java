package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AssignmentManager {
	public SqlMapClient ibatisSQLMap = null;

	public AssignmentManager() {
		this.ibatisSQLMap = IbatisHelper.getSqlMapInstance();
	}

	// EmployeeReportSupervisor
	public List getListAssignmentSupervisor(Integer page) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.employeeReportSupervisor", rowCount);
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

	public List searchAssignmentSupervisor(Integer page, String search, String value, String startDate, String endDate) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);
		rowCount.put("search", search);
		rowCount.put("value", value);
		rowCount.put("startDate", startDate);
		rowCount.put("endDate", endDate);
		
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.employeeReportSupervisor", rowCount);
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

	// EmployeeReport
	public List getListAssignmentEmployee(Integer page) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.employeeReportEmployee", rowCount);
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

	public List searchAssignmentEmployee(Integer page, String search, String value, String startDate, String endDate) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);
		rowCount.put("search", search);
		rowCount.put("value", value);
		rowCount.put("startDate", startDate);
		rowCount.put("endDate", endDate);
		
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.employeeReportEmployee", rowCount);
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

	//Assignment
	public List getListAssignment(Integer page) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.listAssignment", rowCount);
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

	public List searchAssignment(Integer page, String search, String value, String startDate, String endDate) {
		List list = new ArrayList();
		Map rowCount = new HashMap();

		Integer rowEnd = page * 10;
		Integer rowStart = rowEnd - 9;
		rowCount.put("rowStart", rowStart);
		rowCount.put("rowEnd", rowEnd);
		rowCount.put("search", search);
		rowCount.put("value", value);
		rowCount.put("startDate", startDate);
		rowCount.put("endDate", endDate);
		
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.listAssignment", rowCount);
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
		
	public boolean addAssignment(NewAssignmentBean bean) {
		boolean success = true;

		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to add assignment");
			success = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean addSelfAssignment(NewAssignmentBean bean) {
		boolean success = true;

		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addSelfAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to add self assignment");
			success = false;
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return success;
	}
}
