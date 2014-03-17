package adins.ace.taps.ajax;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.EmployeeReportBean;
import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.module.ActiveDirectoryBean;
import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.project.ProjectBean;

public class AjaxForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String searchCategory;
	private String searchKeyword;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private List<EmployeeBean> listEmployees;
	private List<EmployeeBean> listEmployees2;
	private List<EmployeeBean> listEmployeesOnOrganization;
	private List<EmployeeBean> listEmployeesOnProject;
	private List<OrganizationBean> listOrganizations;
	private List<OrganizationBean> listParentOrganizations;
	private List<EmployeeReportBean> listEmployeeReport;
	private List<ProjectBean> listProject;
	private List<ActiveDirectoryBean> listAD;
	private List<ClaimAssignmentBean> historyComment;
	private String mode;
	private String projectCode;
	private String organizationCode;
	private Integer level;
	private String taskCode;
	private String userDomain;
	private String assignmentCategory;
	private String assignmentType;

	
	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}

	public String getAssignmentCategory() {
		return assignmentCategory;
	}

	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	
	public String getTask() {
		return task;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}

	public Integer getCountRecord() {
		return countRecord;
	}

	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}

	public List<EmployeeBean> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<EmployeeBean> listEmployees) {
		this.listEmployees = listEmployees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<OrganizationBean> getListOrganizations() {
		return listOrganizations;
	}

	public void setListOrganizations(List<OrganizationBean> listOrganizations) {
		this.listOrganizations = listOrganizations;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<EmployeeReportBean> getListEmployeeReport() {
		return listEmployeeReport;
	}

	public void setListEmployeeReport(
			List<EmployeeReportBean> listEmployeeReport) {
		this.listEmployeeReport = listEmployeeReport;
	}

	public List<ProjectBean> getListProject() {
		return listProject;
	}

	public void setListProject(List<ProjectBean> listProject) {
		this.listProject = listProject;
	}

	public List<EmployeeBean> getListEmployees2() {
		return listEmployees2;
	}

	public void setListEmployees2(List<EmployeeBean> listEmployees2) {
		this.listEmployees2 = listEmployees2;
	}

	public List<ActiveDirectoryBean> getListAD() {
		return listAD;
	}

	public void setListAD(List<ActiveDirectoryBean> listAD) {
		this.listAD = listAD;
	}

	public List<EmployeeBean> getListEmployeesOnProject() {
		return listEmployeesOnProject;
	}

	public void setListEmployeesOnProject(
			List<EmployeeBean> listEmployeesOnProject) {
		this.listEmployeesOnProject = listEmployeesOnProject;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public List<EmployeeBean> getListEmployeesOnOrganization() {
		return listEmployeesOnOrganization;
	}

	public void setListEmployeesOnOrganization(
			List<EmployeeBean> listEmployeesOnOrganization) {
		this.listEmployeesOnOrganization = listEmployeesOnOrganization;
	}

	public List<OrganizationBean> getListParentOrganizations() {
		return listParentOrganizations;
	}

	public void setListParentOrganizations(
			List<OrganizationBean> listParentOrganizations) {
		this.listParentOrganizations = listParentOrganizations;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<ClaimAssignmentBean> getHistoryComment() {
		return historyComment;
	}

	public void setHistoryComment(List<ClaimAssignmentBean> historyComment) {
		this.historyComment = historyComment;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

}
