package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClaimAssignmentBean implements Serializable {
	private String assignmentDate;
	private String assignmentTime;
	private String assignmentDueDate;
	private String assignmentType;
	private String organizationName;
	private String organizationCode;
	private String projectCode;
	private String projectName;
	private String assignTo;
	private String fullName;
	private String createdByName;
	private String createdBy;
	private String createdDate;
	private String reffTaskCode;
	private String taskCode;
	private String description;
	private Integer detailId;
	private String claimDate;
	private String detailDescription;
	private Double manHours;
	private String updatedBy;
	private String updatedDate;
	private String comment;
	private String assignmentComment;
	private String commentDate;
	private String commentFrom;
	private String commentTo;
	private String status;
	private Integer appraisalStar;
	private Integer starBefore;
	private String assignmentCategory = "";
	private String headUserDomain = "";
	private String headUserName = "";
	private String activityType = "";
	private String adhocUserDomain = "";
	private String reportTo = "";
	private String flag = "";
	private String currentStatus = "";
	private String assignToFullName = "";
	private String reportToFullName = "";
	private String adhocFullName = "";
	private String senderName="";
	private String emailReceiver="";
	private String nameReceiver="";
	
	public String getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(String assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public String getAssignmentTime() {
		return assignmentTime;
	}
	public void setAssignmentTime(String assignmentTime) {
		this.assignmentTime = assignmentTime;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
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
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
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
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public Double getManHours() {
		return manHours;
	}
	public void setManHours(Double manHours) {
		this.manHours = manHours;
	}
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAssignmentComment() {
		return assignmentComment;
	}
	public void setAssignmentComment(String assignmentComment) {
		this.assignmentComment = assignmentComment;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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
	public Integer getAppraisalStar() {
		return appraisalStar;
	}
	public void setAppraisalStar(Integer appraisalStar) {
		this.appraisalStar = appraisalStar;
	}
	public Integer getStarBefore() {
		return starBefore;
	}
	public void setStarBefore(Integer starBefore) {
		this.starBefore = starBefore;
	}
	public String getAssignmentCategory() {
		return assignmentCategory;
	}
	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}
	public String getHeadUserDomain() {
		return headUserDomain;
	}
	public void setHeadUserDomain(String headUserDomain) {
		this.headUserDomain = headUserDomain;
	}
	public String getHeadUserName() {
		return headUserName;
	}
	public void setHeadUserName(String headUserName) {
		this.headUserName = headUserName;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getAdhocUserDomain() {
		return adhocUserDomain;
	}
	public void setAdhocUserDomain(String adhocUserDomain) {
		this.adhocUserDomain = adhocUserDomain;
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
	public String getAdhocFullName() {
		return adhocFullName;
	}
	public void setAdhocFullName(String adhocFullName) {
		this.adhocFullName = adhocFullName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getEmailReceiver() {
		return emailReceiver;
	}
	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}
	public String getNameReceiver() {
		return nameReceiver;
	}
	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}	
}
