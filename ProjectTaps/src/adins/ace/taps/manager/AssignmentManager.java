package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.EmployeeReportBean;
import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.bean.employee.NewSelfAssignmentBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AssignmentManager {
	public SqlMapClient ibatisSQLMap = null;

	public AssignmentManager() {
		this.ibatisSQLMap = IbatisHelper.getSqlMapInstance();
	}

	// *********************************EmployeeReportSupervisor*************************************//
	public Integer countEmployeeReportSupervisor(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countEmployeeReportSupervisor", params);
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

	public List<EmployeeReportBean> searchEmployeeReportSupervisor(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.employeeReportSupervisor", params);
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

	// **********************************************************************************************//

	// *************************************EmployeeReport*******************************************//
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

	public List<EmployeeReportBean> searchEmployeeReportEmployee(Map params) {
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
		return list;
	}
	// **********************************************************************************************//

	// **********************************AssignmentSupervisor***************************************//
	
	public Integer countEmployeeAssignmentList(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countEmployeeAssignmentList", params);
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
	
	public List<EmployeeReportBean> employeeAssignmentList(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.employeeAssignmentList", params);
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

	// **********************************************************************************************//

	// **********************************AssignmentSupervisor***************************************//
	public Integer countAssignmentSupervisor(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countAssignmentSupervisor", params);
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

	public List<EmployeeReportBean> searchAssignmentSupervisor(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.assignmentSupervisor",
					params);
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

	// **********************************************************************************************//

	// **********************************************************************************************//
	public boolean addAssignment(ClaimAssignmentBean bean) {
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

	public String searchHeadUserDomain(String userDomain) {
		String headUserDomain = "";
		try {
			ibatisSQLMap.startTransaction();
			headUserDomain = (String) ibatisSQLMap.queryForObject(
					"assignment.searchHeadUserDomain", userDomain);
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
		return headUserDomain;
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

	public String getMaxTaskCodeOrganization(String paramTaskCode) {
		String generateTaskCode = "";
		try {
			ibatisSQLMap.startTransaction();
			generateTaskCode = (String) ibatisSQLMap.queryForObject(
					"assignment.getMaxTaskCodeOrganization", paramTaskCode);
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
	
	public String getMaxTaskCodeProject(String paramTaskCode) {
		String generateTaskCode = "";
		try {
			ibatisSQLMap.startTransaction();
			generateTaskCode = (String) ibatisSQLMap.queryForObject(
					"assignment.getMaxTaskCodeProject", paramTaskCode);
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

	// **********************************************************************************************//

	public ClaimAssignmentBean searchRecordAssignment(String taskCode) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
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
		return assignmentBean;
	}

	public NewAssignmentBean searchRecordSelfAssignment(String taskCode) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
		System.out.println(assignmentBean.getTaskCode());
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordSelfAssignment", taskCode);
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

	public ClaimAssignmentBean searchRecordClaimAssignment(String taskCode) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
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

	public List<ClaimAssignmentBean> searchListDetailClaim(String taskCode) {
		List<ClaimAssignmentBean> listDetailClaim = new ArrayList<ClaimAssignmentBean>();
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

	public List<ClaimAssignmentBean> searchHistoryComment(Map params) {
		List<ClaimAssignmentBean> historyComment = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			historyComment = ibatisSQLMap.queryForList(
					"assignment.searchHistoryComment", params);
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
		return historyComment;
	}

	public Integer countHistoryComment(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countHistoryComment", params);
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

	public boolean editAssignment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.editAssignment", bean);
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

	public boolean editSelfAssignment(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.editSelfAssignment", bean);
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

	public boolean editDetailClaim(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.editClaimSelfAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to edit detail claim assignment");
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

	public boolean editManHourSelf(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.editManHourSelfAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to edit man hours self assignment");
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

	public boolean editDescriptionSelfAssignment(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.updateDescriptionSelfAssignment",
					bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out
					.println("Failed to edit description assignment on self assignment");
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

	public boolean editDetailClaimAssignment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.editDetailClaimAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to edit detail claim assignment");
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

	public boolean addDetailClaim(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addDetailClaim", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to add detail claim assignment");
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

	public boolean addDetailClaimAssignment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addDetailClaimAssignment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			System.out.println("Failed to add detail claim assignment");
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
	
	public boolean addHistoryComment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addHistoryComment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public boolean addHistorySelfComment(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addHistorySelfComment", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public boolean updateStatus(Map paramStatus) {
		System.out.println(paramStatus);
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.updateStatusAssignment",
					paramStatus);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public boolean addAssignmentStar(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addAssignmentStar", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public boolean addSelfAssignmentStar(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.insert("assignment.addSelfAssignmentStar", bean);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public Integer searchLastStar(String taskCode) {
		Integer lastStar = 0;

		try {
			ibatisSQLMap.startTransaction();
			lastStar = (Integer) ibatisSQLMap.queryForObject(
					"assignment.searchLastStar", taskCode);
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
		return lastStar;
	}

	public String getTotalManHours(String taskCode) {
		Double totalManHours = 0.0;
		String manHours = null;
		try {
			ibatisSQLMap.startTransaction();
			totalManHours = (Double) ibatisSQLMap.queryForObject(
					"assignment.totalManHours", taskCode);
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

		String[] parts = (String.valueOf(totalManHours)).split("\\.");
		if (parts[0].length() == 1) {
			manHours = "0" + parts[0];
		} else {
			manHours = parts[0];
		}

		if (parts[1].equals("5")) {
			manHours = manHours + ":30";
		} else {
			manHours = manHours + ":00";
		}
		return manHours;
	}

	public Integer countLookUpEmployee(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countLookUpEmployee", params);
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

	public List<EmployeeReportBean> lookUpEmployee(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("assignment.lookUpEmployee",
					params);
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

	// *********************************Delete
	// Assignment*************************************//
	public boolean deleteAssignment(String taskCode) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.deleteAssignment", taskCode);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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

	public boolean deleteClaim(String taskCode) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.deleteClaim", taskCode);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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
	
	/******email employee assignment*******/
	public ClaimAssignmentBean emailToSupervisorAssignment(Map params) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.emailToSupervisorAssignment", params);
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
	
	public ClaimAssignmentBean emailToEmployeeAssignment(Map params) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.emailToEmployeeAssignment", params);
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

	public boolean updateFlag(String taskCode) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.updateFlag", taskCode);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
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
