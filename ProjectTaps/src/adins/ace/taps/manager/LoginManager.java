package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import adins.ace.taps.bean.module.MenuBean;
import adins.ace.taps.bean.module.OrganizationLevelBean;
import adins.ace.taps.bean.module.RoleBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class LoginManager {
	public SqlMapClient ibatisSqlMap = null;

	public LoginManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	
	public List<OrganizationLevelBean> GetOrganizationLevel(String userDomain) {
		List<OrganizationLevelBean> organizationLevel = null;
		try {
			ibatisSqlMap.startTransaction();
			organizationLevel = ibatisSqlMap.queryForList("login.getOrganizationLevel", userDomain);
			System.out.println("org : "+organizationLevel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return organizationLevel;
	}

	public List<RoleBean> roleList(String userDomain) {
		List<RoleBean> roleList = null;
		try {
			ibatisSqlMap.startTransaction();
			roleList = ibatisSqlMap.queryForList("login.getRoles", userDomain);
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

	public List<MenuBean> getListMenu(String roleId) {
		List<MenuBean> menuList = null;
		try {
			ibatisSqlMap.startTransaction();
			menuList = ibatisSqlMap.queryForList("login.getMenu", roleId);
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

	public String getFullName(String userDomain) {
		String fullname = null;
		try {
			ibatisSqlMap.startTransaction();
			fullname = (String) ibatisSqlMap.queryForObject(
					"login.getFullName", userDomain);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return fullname;
	}

	public boolean tryLogin(Map params) {
		boolean pass = false;
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject("login.tryLogin",
					params);
			ibatisSqlMap.commitTransaction();
			if (count > 0) {
				pass = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return pass;
	}
	
	public boolean userIsActive(Map params) {
		boolean active = false;
		Integer count = null;
		try {
			ibatisSqlMap.startTransaction();
			count = (Integer) ibatisSqlMap.queryForObject("login.userIsActive",
					params);
			ibatisSqlMap.commitTransaction();
			if (count > 0) {
				active = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return active;
	}
}
