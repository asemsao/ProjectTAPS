package adins.ace.taps.bean.manageRole;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String employeeDomain;
	private String employeeName;
	private String isAdmin;
	
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
