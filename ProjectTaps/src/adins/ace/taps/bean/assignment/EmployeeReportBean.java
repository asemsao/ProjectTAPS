package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeReportBean implements Serializable{
	private String assignmentDate;
	private String assignmentCode;
	private String assignmentCategory;
	private String fullName;
	private String assignmentDueDate;
	private String createdDate;
	private String currentStatus;
	public String getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(String assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public String getAssignmentCode() {
		return assignmentCode;
	}
	public void setAssignmentCode(String assignmentCode) {
		this.assignmentCode = assignmentCode;
	}
	public String getAssignmentCategory() {
		return assignmentCategory;
	}
	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAssignmentDueDate() {
		return assignmentDueDate;
	}
	public void setAssignmentDueDate(String assignmentDueDate) {
		this.assignmentDueDate = assignmentDueDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
}
