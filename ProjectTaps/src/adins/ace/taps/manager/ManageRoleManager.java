package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.manageRole.EmployeeBean;
import adins.ace.taps.bean.manageRole.MenuBean;
import adins.ace.taps.bean.manageRole.RoleBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ManageRoleManager {
	public SqlMapClient ibatisSqlMap = null;

	public ManageRoleManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}

	public List<RoleBean> searchListRole() {
		List<RoleBean> roleList = null;
		try {
			ibatisSqlMap.startTransaction();
			roleList = ibatisSqlMap.queryForList("manageRole.searchListRole",
					null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return roleList;
	}
	
	public List<MenuBean> searchListMenu(String roleId) {
		List<MenuBean> menuList = null;
		try {
			ibatisSqlMap.startTransaction();
			menuList = ibatisSqlMap.queryForList("manageRole.searchListMenu",
					roleId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return menuList;
	}
	
	public List<EmployeeBean> searchListMember(Map h) {
		List<EmployeeBean> memberList = null;
		try {
			ibatisSqlMap.startTransaction();
			memberList = ibatisSqlMap.queryForList("manageRole.searchListMember",
					h);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return memberList;
	}
	
	public Integer countMember(Map params) {
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject(
					"manageRole.countMember", params);
			ibatisSqlMap.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	
	public String getRoleName(String roleId) {
		String roleName = "";
		try {
			ibatisSqlMap.startTransaction();
			roleName = (String) ibatisSqlMap.queryForObject("manageRole.getRoleName",
					roleId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return roleName;
	}
	
	public String getEmpName(String userDomain) {
		String empName = "";
		try {
			ibatisSqlMap.startTransaction();
			empName = (String) ibatisSqlMap.queryForObject("manageRole.getEmpName",
					userDomain);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empName;
	}
	
	public boolean deleteRoleMenu(Map h) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.delete("manageRole.deleteRoleMenu",
					h);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean deleteRoleAdmin(String userDomain) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.delete("manageRole.deleteRoleAdmin",
					userDomain);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
		
	public boolean insertRoleMenu(Map h) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("manageRole.insertRoleMenu",
					h);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean insertRoleAdmin(String userDomain) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.insert("manageRole.insertRoleAdmin",
					userDomain);
			ibatisSqlMap.commitTransaction();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
}