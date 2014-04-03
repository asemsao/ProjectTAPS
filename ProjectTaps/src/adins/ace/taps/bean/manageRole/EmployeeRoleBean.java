package adins.ace.taps.bean.manageRole;

import java.io.Serializable;

public class EmployeeRoleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String employeeUserDomain;
	private String employeeName;
	private String isEmployee;
	private String isSupervisor;
	private String isHeadBU;
	private String isAdministrator;
	
	public String getEmployeeUserDomain() {
		return employeeUserDomain;
	}
	public void setEmployeeUserDomain(String employeeUserDomain) {
		this.employeeUserDomain = employeeUserDomain;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getIsEmployee() {
		return isEmployee;
	}
	public void setIsEmployee(String isEmployee) {
		this.isEmployee = isEmployee;
	}
	public String getIsSupervisor() {
		return isSupervisor;
	}
	public void setIsSupervisor(String isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
	public String getIsHeadBU() {
		return isHeadBU;
	}
	public void setIsHeadBU(String isHeadBU) {
		this.isHeadBU = isHeadBU;
	}
	public String getIsAdministrator() {
		return isAdministrator;
	}
	public void setIsAdministrator(String isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	
}
