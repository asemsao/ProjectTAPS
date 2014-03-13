package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NewAssignmentBean implements Serializable {
	private String taskCode = "";
	private String assignmentDate = "";
	private String assignmentDueDate = "";
	private String assignmentType = "";
	private String assignmentCategory = "";
	private String organizationCode = "";
	private String organizationName = "";
	private String headUserName = "";
	private String projectCode = "";
	private String activityType = "";
	private String manHours = "";
	private String description = "";
	private String reffTaskCode = "";
	private String adhocUserDomain = "";
	private String assignTo = "";
	private String reportTo = "";
	private String flag = "";
	private String currentStatus = "";
	private String createBy = "";
	private String createDate = "";
	private String updatedBy = "";
	private String updatedDate = "";
	private String assignToFullName = "";

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getAssignToFullName() {
		return assignToFullName;
	}

	public void setAssignToFullName(String assignToFullName) {
		this.assignToFullName = assignToFullName;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(String assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public String getAssignmentDueDate() {
		return assignmentDueDate;
	}

	public void setAssignmentDueDate(String assignmentDueDate) {
		this.assignmentDueDate = assignmentDueDate;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getAssignmentCategory() {
		return assignmentCategory;
	}

	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getHeadUserName() {
		return headUserName;
	}

	public void setHeadUserName(String headUserName) {
		this.headUserName = headUserName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getManHours() {
		return manHours;
	}

	public void setManHours(String manHours) {
		this.manHours = manHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReffTaskCode() {
		return reffTaskCode;
	}

	public void setReffTaskCode(String reffTaskCode) {
		this.reffTaskCode = reffTaskCode;
	}

	public String getAdhocUserDomain() {
		return adhocUserDomain;
	}

	public void setAdhocUserDomain(String adhocUserDomain) {
		this.adhocUserDomain = adhocUserDomain;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
