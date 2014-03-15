package adins.ace.taps.bean.employeeRole;

import java.io.Serializable;

public class EmployeeRoleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userDomain;
	private String employeeName;
	private String statusBOM;
	private String statusHBU;
	private String statusHDE;
	private String statusSPV;
	private String statusADM;
	private String statusEMP;
	
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getStatusBOM() {
		return statusBOM;
	}
	public void setStatusBOM(String statusBOM) {
		this.statusBOM = statusBOM;
	}
	public String getStatusHBU() {
		return statusHBU;
	}
	public void setStatusHBU(String statusHBU) {
		this.statusHBU = statusHBU;
	}
	public String getStatusHDE() {
		return statusHDE;
	}
	public void setStatusHDE(String statusHDE) {
		this.statusHDE = statusHDE;
	}
	public String getStatusSPV() {
		return statusSPV;
	}
	public void setStatusSPV(String statusSPV) {
		this.statusSPV = statusSPV;
	}
	public String getStatusADM() {
		return statusADM;
	}
	public void setStatusADM(String statusADM) {
		this.statusADM = statusADM;
	}
	public String getStatusEMP() {
		return statusEMP;
	}
	public void setStatusEMP(String statusEMP) {
		this.statusEMP = statusEMP;
	}
	
	
}
