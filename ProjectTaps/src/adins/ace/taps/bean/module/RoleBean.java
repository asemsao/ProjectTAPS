package adins.ace.taps.bean.module;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoleBean implements Serializable{
	private String roleId;
	private String roleName;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
