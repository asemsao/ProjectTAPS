package adins.ace.taps.form.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;

public class TransferProjectForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String pagingDirection;
	private String projectKeyword;
	private String projectCategory;
	private String orgKeyword;
	private String orgCategory;
	private String projectName;
	private String projectCode;
	private String orgBefore;
	private String orgCode;
	private String orgName;
	private String newEstDate;
	private String assigneeUserDomain;
	private String directReportUserDomain;
	private byte[] photo;
	private List<ProjectBean> listProject;
	private List<OrganizationBean> listOrganization;
	private List<StructureProjectBean> listMember;
	private ProjectBean pBean = new ProjectBean();
	private Integer pageP;
	private Integer maxPageP;
	private Integer countRecordP;
	private Integer pageO;
	private Integer maxPageO;
	private Integer countRecordO;
	private String message;
	private String color;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getPagingDirection() {
		return pagingDirection;
	}
	public void setPagingDirection(String pagingDirection) {
		this.pagingDirection = pagingDirection;
	}
	public String getProjectKeyword() {
		return projectKeyword;
	}
	public void setProjectKeyword(String projectKeyword) {
		this.projectKeyword = projectKeyword;
	}
	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	public String getOrgKeyword() {
		return orgKeyword;
	}
	public void setOrgKeyword(String orgKeyword) {
		this.orgKeyword = orgKeyword;
	}
	public String getOrgCategory() {
		return orgCategory;
	}
	public void setOrgCategory(String orgCategory) {
		this.orgCategory = orgCategory;
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
	public String getOrgBefore() {
		return orgBefore;
	}
	public void setOrgBefore(String orgBefore) {
		this.orgBefore = orgBefore;
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
	public String getNewEstDate() {
		return newEstDate;
	}
	public void setNewEstDate(String newEstDate) {
		this.newEstDate = newEstDate;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	public Integer getPageP() {
		return pageP;
	}
	public void setPageP(Integer pageP) {
		this.pageP = pageP;
	}
	public Integer getMaxPageP() {
		return maxPageP;
	}
	public void setMaxPageP(Integer maxPageP) {
		this.maxPageP = maxPageP;
	}
	public Integer getCountRecordP() {
		return countRecordP;
	}
	public void setCountRecordP(Integer countRecordP) {
		this.countRecordP = countRecordP;
	}
	public Integer getPageO() {
		return pageO;
	}
	public void setPageO(Integer pageO) {
		this.pageO = pageO;
	}
	public Integer getMaxPageO() {
		return maxPageO;
	}
	public void setMaxPageO(Integer maxPageO) {
		this.maxPageO = maxPageO;
	}
	public Integer getCountRecordO() {
		return countRecordO;
	}
	public void setCountRecordO(Integer countRecordO) {
		this.countRecordO = countRecordO;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
