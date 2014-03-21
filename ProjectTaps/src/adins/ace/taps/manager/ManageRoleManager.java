package adins.ace.taps.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	public boolean deleteRoleMenu(Map h) {
		boolean flag = false;
		try {
			ibatisSqlMap.startTransaction();
			ibatisSqlMap.delete("manageRole.deleteRoleMenu",
					h);
			ibatisSqlMap.commitTransaction();
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
	
//	public List<MenuBean> searchListRoleMenu(Map h) {
//		List<MenuBean> menuList = null;
//		try {
//			ibatisSqlMap.startTransaction();
//			menuList = ibatisSqlMap.queryForList("manageRole.searchListRoleMenu",
//					h);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ibatisSqlMap.endTransaction();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return menuList;
//	}
	
//	public RoleBean detailEmployeeRole(Map params) {
//		RoleBean erBean = null;
//		try {
//			ibatisSqlMap.startTransaction();
//			erBean = (RoleBean) ibatisSqlMap.queryForObject("employeeRole.detailEmployeeRole",
//					params);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ibatisSqlMap.endTransaction();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return erBean;
//	}
}