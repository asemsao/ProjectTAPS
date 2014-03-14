package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
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

	// **********************************************************************************************//

	public NewAssignmentBean searchRecordAssignment(String taskCode) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
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

	public NewAssignmentBean searchRecordSelfAssignment(String taskCode) {
		NewAssignmentBean assignmentBean = new NewAssignmentBean();
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
		System.out.println(assignmentBean.getTaskCode());
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

	public boolean editAssignment(NewAssignmentBean bean) {
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
		boolean success = false;
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

	public boolean editDetailClaimAssignment(ClaimAssignmentBean bean) {
		boolean success = false;
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
		boolean success = false;
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

	public boolean addHistoryComment(ClaimAssignmentBean bean) {
		boolean success = false;
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

	public boolean updateStatus(Map paramStatus) {
		boolean success = false;
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
}
