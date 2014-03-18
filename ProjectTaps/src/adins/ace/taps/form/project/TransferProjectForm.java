package adins.ace.taps.form.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;

public class TransferProjectForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String paramProjectCode;
	private String searchKeyword;
	private String searchCategory;
	private String projectName;
	private String projectCode;
	private String orgCode;
	private String orgName;
	private String assigneeUserDomain;
	private String directReportUserDomain;
	private List<ProjectBean> listProject;
	private List<OrganizationBean> listOrganization;
	private List<StructureProjectBean> listMember;
	private ProjectBean pBean = new ProjectBean();
	private Integer pageProject;
	private Integer maxPageProject;
	private Integer countRecordProject;
	private Integer pageOrganization;
	private Integer maxOrganization;
	private Integer countRecordOrganization;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getParamProjectCode() {
		return paramProjectCode;
	}
	public void setParamProjectCode(String paramProjectCode) {
		this.paramProjectCode = paramProjectCode;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchCategory() {
		return searchCategory;
	}
	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAssigneeUserDomain() {
		return assigneeUserDomain;
	}
	public void setAssigneeUserDomain(String assigneeUserDomain) {
		this.assigneeUserDomain = assigneeUserDomain;
	}
	public String getDirectReportUserDomain() {
		return directReportUserDomain;
	}
	public void setDirectReportUserDomain(String directReportUserDomain) {
		this.directReportUserDomain = directReportUserDomain;
	}
	public List<ProjectBean> getListProject() {
		return listProject;
	}
	public void setListProject(List<ProjectBean> listProject) {
		this.listProject = listProject;
	}
	public List<OrganizationBean> getListOrganization() {
		return listOrganization;
	}
	public void setListOrganization(List<OrganizationBean> listOrganization) {
		this.listOrganization = listOrganization;
	}
	public List<StructureProjectBean> getListMember() {
		return listMember;
	}
	public void setListMember(List<StructureProjectBean> listMember) {
		this.listMember = listMember;
	}
	public ProjectBean getpBean() {
		return pBean;
	}
	public void setpBean(ProjectBean pBean) {
		this.pBean = pBean;
	}
	public Integer getPageProject() {
		return pageProject;
	}
	public void setPageProject(Integer pageProject) {
		this.pageProject = pageProject;
	}
	public Integer getMaxPageProject() {
		return maxPageProject;
	}
	public void setMaxPageProject(Integer maxPageProject) {
		this.maxPageProject = maxPageProject;
	}
	public Integer getCountRecordProject() {
		return countRecordProject;
	}
	public void setCountRecordProject(Integer countRecordProject) {
		this.countRecordProject = countRecordProject;
	}
	public Integer getPageOrganization() {
		return pageOrganization;
	}
	public void setPageOrganization(Integer pageOrganization) {
		this.pageOrganization = pageOrganization;
	}
	public Integer getMaxOrganization() {
		return maxOrganization;
	}
	public void setMaxOrganization(Integer maxOrganization) {
		this.maxOrganization = maxOrganization;
	}
	public Integer getCountRecordOrganization() {
		return countRecordOrganization;
	}
	public void setCountRecordOrganization(Integer countRecordOrganization) {
		this.countRecordOrganization = countRecordOrganization;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
