package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.EmployeeReportBean;
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
		Map parameterAssignment = new HashMap();

		Integer end = page * 10;
		Integer start = end - 9;
		parameterAssignment.put("start", start);
		parameterAssignment.put("end", end);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.employeeReportSupervisor", parameterAssignment);
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

	public List searchAssignmentSupervisor(Integer page, String category,
			String keyword, String startDate, String endDate) {
		List list = new ArrayList();
		Map parameterAssignment = new HashMap();

		Integer end = page * 10;
		Integer start = end - 9;
		parameterAssignment.put("start", start);
		parameterAssignment.put("end", end);
		parameterAssignment.put("category", category);
		parameterAssignment.put("keyword", keyword);
		parameterAssignment.put("startDate", startDate);
		parameterAssignment.put("endDate", endDate);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.employeeReportSupervisor", parameterAssignment);
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
	public Integer countEmployeeReportEmployee(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countEmployeeReportEmployee", params);
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
		return count;
	}

	public List<EmployeeReportBean> searchAssignmentEmployee(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.employeeReportEmployee", params);
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
		System.out.println(params);
		return list;
	}

	// Assignment
	public List getListAssignment(Integer page) {
		List list = new ArrayList();
		Map parameterAssignment = new HashMap();

		Integer end = page * 10;
		Integer start = end - 9;
		parameterAssignment.put("start", start);
		parameterAssignment.put("end", end);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.listAssignment",
					parameterAssignment);
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

	public List searchAssignment(Integer page, String category, String keyword,
			String startDate, String endDate) {
		List list = new ArrayList();
		Map parameterAssignment = new HashMap();

		Integer end = page * 10;
		Integer start = end - 9;
		parameterAssignment.put("start", start);
		parameterAssignment.put("end", end);
		parameterAssignment.put("category", category);
		parameterAssignment.put("keyword", keyword);
		parameterAssignment.put("startDate", startDate);
		parameterAssignment.put("endDate", endDate);

		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.listAssignment",
					parameterAssignment);
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

	public String searchOrganizationCode(String userDomain) {
		String organizationCode = "";

		try {
			ibatisSQLMap.startTransaction();
			organizationCode = (String) ibatisSQLMap.queryForObject(
					"assignment.searchOrganizationCode", userDomain);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed search organization");
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return organizationCode;
	}

	public NewAssignmentBean searchHeadOrganizationCode(String userDomain) {
		NewAssignmentBean organization = new NewAssignmentBean();

		try {
			ibatisSQLMap.startTransaction();
			organization = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchHeadOrganizationCode", userDomain);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed search organization");
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return organization;
	}

	public String getMaxTaskCode(String paramTaskCode) {
		String generateTaskCode = "";

		try {
			ibatisSQLMap.startTransaction();
			generateTaskCode = (String) ibatisSQLMap.queryForObject(
					"assignment.getMaxTaskCode", paramTaskCode);
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
		if (generateTaskCode == null) {
			generateTaskCode = "00001";
		}
		return generateTaskCode;
	}

	public NewAssignmentBean searchRecordAssignment(String taskCode) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
		System.out.println(taskCode);
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordAssignment", taskCode);
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
		System.out.println(assignmentBean.getTaskCode());
		return assignmentBean;
	}

	public ClaimAssignmentBean searchRecordClaimAssignment(String taskCode) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		System.out.println(taskCode);
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordClaimAssignment", taskCode);
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
		return assignmentBean;
	}

	public List searchListDetailClaim(String taskCode) {
		List listDetailClaim = new ArrayList();

		try {
			ibatisSQLMap.startTransaction();
			listDetailClaim = ibatisSQLMap.queryForList(
					"assignment.searchDetailClaim", taskCode);
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
		return listDetailClaim;
	}
}
