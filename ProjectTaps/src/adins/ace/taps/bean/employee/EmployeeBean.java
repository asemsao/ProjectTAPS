package adins.ace.taps.bean.employee;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String employeeCode;
	private String employeeDomain;
	private String employeeNik;
	private String employeeName;
	private String employeeAddress;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public String getEmployeeNik() {
		return employeeNik;
	}
	public void setEmployeeNik(String employeeNik) {
		this.employeeNik = employeeNik;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
}
