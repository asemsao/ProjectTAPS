package adins.ace.taps.bean.project;

import java.io.Serializable;

public class StructureProjectBean implements Serializable
{
	private String organizationName;
	private String projectCode;
	private String projectName;
	private String projectRole;
	private String assignee;
	private String directReport;
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getDirectReport() {
		return directReport;
	}
	public void setDirectReport(String directReport) {
		this.directReport = directReport;
	}
	
	
}
