package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NewClaimAssignmentBean implements Serializable {
	private String assignmentDate;
	private String assignmentDueDate;
	private String assignmentType;
	private String assignTo;
	private String createdBy;
	private String createdDate;
	private String reffTaskCode;
	private String taskCode;
	private String manhour;
	private String description;
	private String detailId;
	
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
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getManhour() {
		return manhour;
	}
	public void setManhour(String manhour) {
		this.manhour = manhour;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	
}
