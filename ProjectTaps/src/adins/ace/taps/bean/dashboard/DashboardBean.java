package adins.ace.taps.bean.dashboard;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DashboardBean implements Serializable {
	private String userName;
	private String employeeName;
	private String totalStar;
	private byte[] profilePicture;
	private String userDomain;
	private String taskCode;
	private String assignmentDate;
	private String assignmentDueDate;
	private String assignmentType;
	private String assignTo;
	private String assignToFullName;
	private String reportTo;
	private String reportToFullName;
	private String reffTaskCode;
	private String description;
	private String claimDate;
	private String manHours;
	private String detailDescription;

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(String totalStar) {
		this.totalStar = totalStar;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
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

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getAssignToFullName() {
		return assignToFullName;
	}

	public void setAssignToFullName(String assignToFullName) {
		this.assignToFullName = assignToFullName;
	}

	public String getReportToFullName() {
		return reportToFullName;
	}

	public void setReportToFullName(String reportToFullName) {
		this.reportToFullName = reportToFullName;
	}

	public String getReffTaskCode() {
		return reffTaskCode;
	}

	public void setReffTaskCode(String reffTaskCode) {
		this.reffTaskCode = reffTaskCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getManHours() {
		return manHours;
	}

	public void setManHours(String manHours) {
		this.manHours = manHours;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

}
