package adins.ace.taps.bean.assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NewAssignmentBean implements Serializable {
	private String taskCode = "";
	private String assignmentDate = "";
	private String assignmentDueDate = "";
	private String assignmentTime = "";
	private String assignmentType = "";
	private String assignmentCategory = "";
	private String organizationCode = "";
	private String organizationName = "";
	private String headUserDomain = "";
	private String headUserName = "";
	private String projectCode = "";
	private String projectName = "";
	private String activityType = "";
	private Double manHours;
	private String claimDate = "";
	private String description = "";
	private String reffTaskCode = "";
	private String adhocUserDomain = "";
	private String assignTo = "";
	private String reportTo = "";
	private String flag = "";
	private String currentStatus = "";
	private String createdBy = "";
	private String createdDate = "";
	private String updatedBy = "";
	private String updatedDate = "";
	private String assignToFullName = "";
	private String reportToFullName = "";
	private String adhocFullName = "";
	private String detailId = "";
	private String comment;
	private String assignmentComment;
	private String commentDate;
	private String commentFrom;
	private String commentTo;
	private Integer appraisalStar;
	private Integer starBefore;
	private String updateableStar;
	private Integer organizationLevel;
	
	public Integer getOrganizationLevel() {
		return organizationLevel;
	}
	public void setOrganizationLevel(Integer organizationLevel) {
		this.organizationLevel = organizationLevel;
	}
	public String getAssignmentTime() {
		return assignmentTime;
	}
	public void setAssignmentTime(String assignmentTime) {
		this.assignmentTime = assignmentTime;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
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
	public String getHeadUserDomain() {
		return headUserDomain;
	}
	public void setHeadUserDomain(String headUserDomain) {
		this.headUserDomain = headUserDomain;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
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
	public Double getManHours() {
		return manHours;
	}
	public void setManHours(Double manHours) {
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
	public String getUpdateableStar() {
		return updateableStar;
	}
	public void setUpdateableStar(String updateableStar) {
		this.updateableStar = updateableStar;
	}
	
}
