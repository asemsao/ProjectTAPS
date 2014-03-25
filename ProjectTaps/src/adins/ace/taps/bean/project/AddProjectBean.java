package adins.ace.taps.bean.project;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AddProjectBean implements Serializable 
{
	private String projectCode;
	private String projectName;
	private String client;
	private String phaseId;
	private String organizationCode;
	private String organizationName;
	private String startDate;
	private String endDate;
	private String flag;
	private String createdBy;
	private String createdDate;
	private String userdomain;
	
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
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPhaseId() {
		return phaseId;
	}
	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getUserdomain() {
		return userdomain;
	}
	public void setUserdomain(String userdomain) {
		this.userdomain = userdomain;
	}
	
}
