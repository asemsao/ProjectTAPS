package adins.ace.taps.manager;

import java.util.List;

import adins.ace.taps.bean.module.MenuBean;
import adins.ace.taps.bean.module.RoleBean;
import adins.ace.taps.ibatis.IbatisHelper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class LoginManager {
	public SqlMapClient ibatisSqlMap = null;
	public LoginManager() {
		this.ibatisSqlMap = IbatisHelper.getSqlMapInstance();
	}
	public List<RoleBean> roleList(String userDomain){
		List<RoleBean> roleList = null;
		try {
			ibatisSqlMap.startTransaction();
			roleList = ibatisSqlMap.queryForList("login.getRoles", userDomain);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
		} finally{
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
			fullname = (String) ibatisSqlMap.queryForObject("login.getFullName", userDomain);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				ibatisSqlMap.endTransaction();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return fullname;
	}
}
