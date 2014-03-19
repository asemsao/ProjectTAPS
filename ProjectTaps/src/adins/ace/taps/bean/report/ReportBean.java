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
	private Integer totalRoutine; //total manhour activity routine
	private Integer totalInitiative; //total manhour activity initiative
	private Integer totalAdhocBU; //total manhour activity adhoc BU
	private Integer totalAdhocProject; //total manhour activity adhoc Project
	
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
	public Integer getTotalAdhocBU() {
		return totalAdhocBU;
	}
	public void setTotalAdhocBU(Integer totalAdhocBU) {
		this.totalAdhocBU = totalAdhocBU;
	}
	public Integer getTotalAdhocProject() {
		return totalAdhocProject;
	}
	public void setTotalAdhocProject(Integer totalAdhocProject) {
		this.totalAdhocProject = totalAdhocProject;
	}
	
	
}
