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
	private Double manhourBU;
	private Double manhourProject;
	private Double totalRoutine; //total manhour activity routine
	private Double totalInitiative; //total manhour activity initiative
	private Double totalAdhocBU; //total manhour activity adhoc BU
	private Double totalAdhocProject; //total manhour activity adhoc Project
	//report v1
	private Double totalSelfAssignment;
	private Double totalAssignment;
	private Double totalBU;
	private Double totalProject;
	//report v2
	private Double totalSelfAssignmentBU;
	private Double totalAssignmentBU;
	private Double totalAssignmentProject;
	private Double totalSelfAssignmentProject;
	//new report
	private Double productivity;
	private Double quality;
	
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
	public String getOrganizationLevel() {
		return organizationLevel;
	}
	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}
	public String getOrganizationParent() {
		return organizationParent;
	}
	public void setOrganizationParent(String organizationParent) {
		this.organizationParent = organizationParent;
	}
	public String getOrganizationParentName() {
		return organizationParentName;
	}
	public void setOrganizationParentName(String organizationParentName) {
		this.organizationParentName = organizationParentName;
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
	public Double getManhourBU() {
		return manhourBU;
	}
	public void setManhourBU(Double manhourBU) {
		this.manhourBU = manhourBU;
	}
	public Double getManhourProject() {
		return manhourProject;
	}
	public void setManhourProject(Double manhourProject) {
		this.manhourProject = manhourProject;
	}
	public Double getTotalRoutine() {
		return totalRoutine;
	}
	public void setTotalRoutine(Double totalRoutine) {
		this.totalRoutine = totalRoutine;
	}
	public Double getTotalInitiative() {
		return totalInitiative;
	}
	public void setTotalInitiative(Double totalInitiative) {
		this.totalInitiative = totalInitiative;
	}
	public Double getTotalAdhocBU() {
		return totalAdhocBU;
	}
	public void setTotalAdhocBU(Double totalAdhocBU) {
		this.totalAdhocBU = totalAdhocBU;
	}
	public Double getTotalAdhocProject() {
		return totalAdhocProject;
	}
	public void setTotalAdhocProject(Double totalAdhocProject) {
		this.totalAdhocProject = totalAdhocProject;
	}
	public Double getTotalSelfAssignment() {
		return totalSelfAssignment;
	}
	public void setTotalSelfAssignment(Double totalSelfAssignment) {
		this.totalSelfAssignment = totalSelfAssignment;
	}
	public Double getTotalAssignment() {
		return totalAssignment;
	}
	public void setTotalAssignment(Double totalAssignment) {
		this.totalAssignment = totalAssignment;
	}
	public Double getTotalBU() {
		return totalBU;
	}
	public void setTotalBU(Double totalBU) {
		this.totalBU = totalBU;
	}
	public Double getTotalProject() {
		return totalProject;
	}
	public void setTotalProject(Double totalProject) {
		this.totalProject = totalProject;
	}
	public Double getTotalSelfAssignmentBU() {
		return totalSelfAssignmentBU;
	}
	public void setTotalSelfAssignmentBU(Double totalSelfAssignmentBU) {
		this.totalSelfAssignmentBU = totalSelfAssignmentBU;
	}
	public Double getTotalAssignmentBU() {
		return totalAssignmentBU;
	}
	public void setTotalAssignmentBU(Double totalAssignmentBU) {
		this.totalAssignmentBU = totalAssignmentBU;
	}
	public Double getTotalAssignmentProject() {
		return totalAssignmentProject;
	}
	public void setTotalAssignmentProject(Double totalAssignmentProject) {
		this.totalAssignmentProject = totalAssignmentProject;
	}
	public Double getTotalSelfAssignmentProject() {
		return totalSelfAssignmentProject;
	}
	public void setTotalSelfAssignmentProject(Double totalSelfAssignmentProject) {
		this.totalSelfAssignmentProject = totalSelfAssignmentProject;
	}
	public Double getProductivity() {
		return productivity;
	}
	public void setProductivity(Double productivity) {
		this.productivity = productivity;
	}
	public Double getQuality() {
		return quality;
	}
	public void setQuality(Double quality) {
		this.quality = quality;
	}
	
}
