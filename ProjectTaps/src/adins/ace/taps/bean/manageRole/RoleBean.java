package adins.ace.taps.bean.manageRole;

import java.io.Serializable;

public class RoleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private Integer roleCount;
	
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
	public Integer getRoleCount() {
		return roleCount;
	}
	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}
	
}
