package adins.ace.taps.bean.project;

import java.io.Serializable;

public class ProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String projectCode;
	private String projectName;
	private String client;
	private String organizationCode;
	private String organizationName;
	private String phase;
	private String phaseName;
	private String startDate;
	private String endDate;
	private String projectShortName;
	private int runningDay;
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

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
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

	public int getRunningDay() {
		return runningDay;
	}

	public void setRunningDay(int runningDay) {
		this.runningDay = runningDay;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public String getProjectShortName() {
		return projectShortName;
	}

	public void setProjectShortName(String projectShortName) {
		this.projectShortName = projectShortName;
	}

	public String getUserdomain() {
		return userdomain;
	}

	public void setUserdomain(String userdomain) {
		this.userdomain = userdomain;
	}

}
