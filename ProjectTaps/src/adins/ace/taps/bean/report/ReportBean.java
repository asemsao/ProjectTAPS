package adins.ace.taps.bean.report;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReportBean implements Serializable {

	private String organizationCode;
	private String organizationName;
	private String organizationLevel;
	private String organizationParent;
	private String organizationParentName;
	private String firstName;
	private String lastName;
	private String employeeName;
	private Double manhour;
	private Integer totalRoutine; //total manhour activity routine
	private Integer totalInitiative; //total manhour activity initiative
	private Integer totalAdhoc; //total manhour activity adhoc
	
	//bawah belum kepake
	private String reportId;
	private String projectCode;
	private String assignmentDate;
	private String assignmentDueDate;
	private String assignmentApprovedDate;
	private String activityType;
	private String description;
	private String adhocName;
	private String adhocDomain;
	private String reportToName;
	private String reportToDomain;
	private String assignByName;
	private String assignByDomain;
	private String assignToName;
	private String assignToDomain;
	private Integer star;
	private String assignmentType;
	private String assignmentCategory;
	
	private String periodeReport;
	private String createdBy;
	private String createdDate;
	private String updateBy;
	private String updateDate;
	
	
	public String getOrganizationParentName() {
		return organizationParentName;
	}

	public void setOrganizationParentName(String organizationParentName) {
		this.organizationParentName = organizationParentName;
	}

	public String getOrganizationParent() {
		return organizationParent;
	}

	public void setOrganizationParent(String organizationParent) {
		this.organizationParent = organizationParent;
	}

	public Integer getTotalRoutine() {
		return totalRoutine;
	}

	public void setTotalRoutine(Integer totalRoutine) {
		this.totalRoutine = totalRoutine;
	}

	public Integer getTotalInitiative() {
		return totalInitiative;
	}

	public void setTotalInitiative(Integer totalInitiative) {
		this.totalInitiative = totalInitiative;
	}

	public Integer getTotalAdhoc() {
		return totalAdhoc;
	}

	public void setTotalAdhoc(Integer totalAdhoc) {
		this.totalAdhoc = totalAdhoc;
	}

	public String getOrganizationLevel() {
		return organizationLevel;
	}

	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
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

	public String getAssignmentApprovedDate() {
		return assignmentApprovedDate;
	}

	public void setAssignmentApprovedDate(String assignmentApprovedDate) {
		this.assignmentApprovedDate = assignmentApprovedDate;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdhocName() {
		return adhocName;
	}

	public void setAdhocName(String adhocName) {
		this.adhocName = adhocName;
	}

	public String getAdhocDomain() {
		return adhocDomain;
	}

	public void setAdhocDomain(String adhocDomain) {
		this.adhocDomain = adhocDomain;
	}

	public String getReportToName() {
		return reportToName;
	}

	public void setReportToName(String reportToName) {
		this.reportToName = reportToName;
	}

	public String getReportToDomain() {
		return reportToDomain;
	}

	public void setReportToDomain(String reportToDomain) {
		this.reportToDomain = reportToDomain;
	}

	public String getAssignByName() {
		return assignByName;
	}

	public void setAssignByName(String assignByName) {
		this.assignByName = assignByName;
	}

	public String getAssignByDomain() {
		return assignByDomain;
	}

	public void setAssignByDomain(String assignByDomain) {
		this.assignByDomain = assignByDomain;
	}

	public String getAssignToName() {
		return assignToName;
	}

	public void setAssignToName(String assignToName) {
		this.assignToName = assignToName;
	}

	public String getAssignToDomain() {
		return assignToDomain;
	}

	public void setAssignToDomain(String assignToDomain) {
		this.assignToDomain = assignToDomain;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
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

	public Double getManhour() {
		return manhour;
	}

	public void setManhour(Double manhour) {
		this.manhour = manhour;
	}

	public String getPeriodeReport() {
		return periodeReport;
	}

	public void setPeriodeReport(String periodeReport) {
		this.periodeReport = periodeReport;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
