package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DashboardManager {
	public SqlMapClient ibatisSQLMap = null;

	public DashboardManager() {
		this.ibatisSQLMap = IbatisHelper.getSqlMapInstance();
	}

	public List<DashboardBean> searchTopTen(Map params) {
		System.out.println(params);
		List<DashboardBean> list = new ArrayList<DashboardBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.searchTopTen", params);
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
		System.out.println(list);
		return list;
	}

	public List<DashboardBean> searchTopTenOrganization(Map params) {
		System.out.println(params);
		List<DashboardBean> list = new ArrayList<DashboardBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList(
					"dashboard.searchTopTenOrganization", params);
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
		System.out.println(list);
		return list;
	}

	public DashboardBean getPhotoEmployees(String employeeDomain) {
		DashboardBean photo = null;
		try {
			ibatisSQLMap.startTransaction();
			photo = (DashboardBean) ibatisSQLMap.queryForObject(
					"dashboard.getPhotoEmployees", employeeDomain);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSQLMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return photo;
	}

	public Integer searchTotalClaim(String userDomain) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.claimDashboard", userDomain);
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
		return total;
	}

	public Integer searchTotalRFA(String userDomain) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.approvalDashboard", userDomain);
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
		return total;
	}

	public Integer searchTotalRFASelf(String userDomain) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.approvalSelfDashboard", userDomain);
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
		return total;
	}

	public Integer searchTotalCorrection(String userDomain) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.correctionDashboard", userDomain);
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
		return total;
	}

	public Integer searchTotalCorrectionSelf(String userDomain) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.correctionSelfDashboard", userDomain);
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
		return total;
	}

	public List<ClaimAssignmentBean> searchListClaim(Map param) {
		List<ClaimAssignmentBean> list = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.listClaim", param);
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

	public Integer countListClaim(Map param) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.countListClaim", param);
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
		return total;
	}

	public List<ClaimAssignmentBean> searchListApproval(Map param) {
		List<ClaimAssignmentBean> list = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.listApproval", param);
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

	public Integer countListApproval(Map param) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.countListApproval", param);
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
		return total;
	}

	public List<ClaimAssignmentBean> searchListApprovalSelf(Map param) {
		List<ClaimAssignmentBean> list = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.listApprovalSelf",
					param);
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

	public Integer countListApprovalSelf(Map param) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.countListApprovalSelf", param);
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
		return total;
	}

	public List<ClaimAssignmentBean> searchListCorrection(Map param) {
		List<ClaimAssignmentBean> list = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.listCorrection", param);
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

	public Integer countListCorrection(Map param) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.countListCorrection", param);
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
		return total;
	}

	public List<ClaimAssignmentBean> searchListCorrectionSelf(Map param) {
		List<ClaimAssignmentBean> list = new ArrayList<ClaimAssignmentBean>();
		try {
			ibatisSQLMap.startTransaction();
			list = ibatisSQLMap.queryForList("dashboard.listCorrectionSelf",
					param);
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

	public Integer countListCorrectionSelf(Map param) {
		Integer total = 0;
		try {
			ibatisSQLMap.startTransaction();
			total = (Integer) ibatisSQLMap.queryForObject(
					"dashboard.countListCorrectionSelf", param);
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
		return total;
	}

	public DashboardBean searchRecordAssignment(String taskCode) {
		DashboardBean bean = new DashboardBean();
		try {
			ibatisSQLMap.startTransaction();
			bean = (DashboardBean) ibatisSQLMap.queryForObject(
					"dashboard.searchRecordAssignment", taskCode);
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
}
