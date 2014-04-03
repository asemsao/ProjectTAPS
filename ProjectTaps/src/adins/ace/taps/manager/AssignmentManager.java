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
	
	public void startTransaction(){
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.getDataSource().getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void commitTransaction(){
		try {
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
	}
	
	public void rollback(){
		try {
			ibatisSQLMap.getDataSource().getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// *********************************EmployeeReportSupervisor*************************************//
	public Integer countEmployeeReportSupervisor(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject("assignment.countEmployeeReportSupervisor", params);
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

	public Integer countPendingAssignmentList(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countPendingAssignmentList", params);
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

	public List<EmployeeReportBean> pendingAssignmentList(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.pendingAssignmentList", params);
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
			ibatisSQLMap.insert("assignment.addSelfAssignment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
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

	public NewAssignmentBean searchUpperHeadOrganization(String userDomain) {
		NewAssignmentBean organization = new NewAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			organization = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchUpperHeadOrganization", userDomain);
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

	public NewAssignmentBean searchRecordSelfAssignment(Map params) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordSelfAssignment", params);
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

	public NewAssignmentBean searchRecordSelfAssignmentDraft(String taskCode) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordSelfAssignmentDraft", taskCode);
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

	public ClaimAssignmentBean searchRecordClaimAssignment(Map params) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchRecordClaimAssignment", params);
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

	public String getClaimDate(String taskCode) {
		String claimDate = "";
		List<ClaimAssignmentBean> listDetailClaim = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			listDetailClaim = ibatisSQLMap.queryForList(
					"assignment.getClaimDate", taskCode);
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
		for (int i = 0; i < listDetailClaim.size(); i++) {
			claimDate += listDetailClaim.get(i).getClaimDate() + "|";
		}
		return claimDate;
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
			ibatisSQLMap.update("assignment.editSelfAssignment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean editDetailClaim(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.update("assignment.editClaimSelfAssignment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
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

	public boolean editActivityType(NewAssignmentBean selfAssignBean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.updateActivityType", selfAssignBean);
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

	public boolean editAdhocUserDomain(NewAssignmentBean selfAssignBean) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.updateAdhocUserDomain", selfAssignBean);
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
			ibatisSQLMap.insert("assignment.addDetailClaim", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean addDetailClaimAssignment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.addDetailClaimAssignment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean addHistoryComment(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.addHistoryComment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean addHistorySelfComment(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.addHistorySelfComment", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean updateStatus(Map paramStatus) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.updateStatusAssignment",
					paramStatus);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	public boolean addAssignmentStar(ClaimAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.addAssignmentStar", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} 
		return success;
	}

	public boolean addSelfAssignmentStar(NewAssignmentBean bean) {
		boolean success = true;
		try {
			ibatisSQLMap.insert("assignment.addSelfAssignmentStar", bean);
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
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

	public Integer countLookUpAssignmentEmployee(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countlookUpAssignmentEmployee", params);
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

	public List<EmployeeReportBean> lookUpAssignmentEmployee(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.lookUpAssignmentEmployee", params);
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

	public Integer countLookUpAssignmentSupervisor(Map params) {
		Integer count = null;
		try {
			ibatisSQLMap.startTransaction();
			count = (Integer) ibatisSQLMap.queryForObject(
					"assignment.countLookUpAssignmentSupervisor", params);
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

	public List<EmployeeReportBean> lookUpAssignmentSupervisor(Map params) {
		List<EmployeeReportBean> list = new ArrayList<EmployeeReportBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"assignment.lookUpAssignmentSupervisor", params);
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
	public boolean deleteAssignment(Map paramDelete) {
		boolean success = true;
		try {
			ibatisSQLMap.startTransaction();
			ibatisSQLMap.update("assignment.deleteClaim", paramDelete);
			ibatisSQLMap.update("assignment.deleteAssignment", paramDelete);
			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			success = false;
			try {
				ibatisSQLMap.getDataSource().getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

	/****** email employee assignment *******/
	public ClaimAssignmentBean emailToSupervisorAssignment(Map params) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
//			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.emailToSupervisorAssignment", params);
//			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return assignmentBean;
	}

	public ClaimAssignmentBean emailToEmployeeAssignment(Map params) {
		ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
		try {
//			ibatisSQLMap.startTransaction();
			assignmentBean = (ClaimAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.emailToEmployeeAssignment", params);
//			ibatisSQLMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				ibatisSQLMap.endTransaction();
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

	public NewAssignmentBean searchDirectReportProject(Map params) {
		NewAssignmentBean bean = new NewAssignmentBean();
		try {
			ibatisSQLMap.startTransaction();
			bean = (NewAssignmentBean) ibatisSQLMap.queryForObject(
					"assignment.searchDirectReportProject", params);
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
		return bean;
	}

	public String checkClaimDate(Map params) {
		String status = null;
		try {
			ibatisSQLMap.startTransaction();
			status = (String) ibatisSQLMap.queryForObject(
					"assignment.checkClaimDate", params);
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
		return status;
	}
}
