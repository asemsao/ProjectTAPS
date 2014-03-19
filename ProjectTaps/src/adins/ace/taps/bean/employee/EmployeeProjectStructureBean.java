package adins.ace.taps.bean.employee;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeProjectStructureBean implements Serializable {
	private String projectCode;
	private String projectRole;
	private String directReport;
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	public String getDirectReport() {
		return directReport;
	}
	public void setDirectReport(String directReport) {
		this.directReport = directReport;
	}
}
