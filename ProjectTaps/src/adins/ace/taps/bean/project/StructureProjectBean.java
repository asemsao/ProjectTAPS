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
	private String directReportUserDomain;
	private String assigneeUserDomain;
	private byte[] photo;
	private String headBU;
	private String userdomain;
	
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
	public String getAssigneeUserDomain() {
		return assigneeUserDomain;
	}
	public void setAssigneeUserDomain(String assigneeUserDomain) {
		this.assigneeUserDomain = assigneeUserDomain;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getDirectReportUserDomain() {
		return directReportUserDomain;
	}
	public void setDirectReportUserDomain(String directReportUserDomain) {
		this.directReportUserDomain = directReportUserDomain;
	}
	public String getHeadBU() {
		return headBU;
	}
	public void setHeadBU(String headBU) {
		this.headBU = headBU;
	}
	public String getUserdomain() {
		return userdomain;
	}
	public void setUserdomain(String userdomain) {
		this.userdomain = userdomain;
	}
	
}
