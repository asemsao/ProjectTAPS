package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ViewSelfAssignment implements Serializable{
	private String assignmentDate;
	private String assignmentType;
	private String reportTo;
	private String createdBy;
	private String reffTaskCode;
	private String activityType;
	private String taskCode;
	private String description;
	private String manhour;
	private String commentDate;
	private String commentDetail;
	private String commentFrom;
	private String commentTo;
	private String status;
	public String getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(String assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public String getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	public String getReportTo() {
		return reportTo;
	}
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getReffTaskCode() {
		return reffTaskCode;
	}
	public void setReffTaskCode(String reffTaskCode) {
		this.reffTaskCode = reffTaskCode;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManhour() {
		return manhour;
	}
	public void setManhour(String manhour) {
		this.manhour = manhour;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	public String getCommentFrom() {
		return commentFrom;
	}
	public void setCommentFrom(String commentFrom) {
		this.commentFrom = commentFrom;
	}
	public String getCommentTo() {
		return commentTo;
	}
	public void setCommentTo(String commentTo) {
		this.commentTo = commentTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
