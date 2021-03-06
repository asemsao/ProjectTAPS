package adins.ace.taps.form.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.project.AddProjectBean;
import adins.ace.taps.bean.project.AddStructureProjectBean;
import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.bean.project.StructureProjectBean;

public class ProjectForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String paramProjectCode;
	private String paramAssigneeUserDomain;
	private String searchKeyword;
	private String searchCategory;
	private String organizationName;
	private String projectName;
	private String projectCode;
	private List<ProjectBean> listProject;
	private List<StructureProjectBean> listStructureProject;
	private List listPhase;
	private ProjectBean pBean = new ProjectBean();
	private AddProjectBean addProject = new AddProjectBean();
	private AddStructureProjectBean addSProject = new AddStructureProjectBean();
	private Integer page;
	private Integer maxpage;
	private String mode;
	private String message;
	private String color;
	private String directReportUserDomain;
	private String directReportBefore;
	
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

	private Integer countRecord;

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

	public List<ProjectBean> getListProject() {
		return listProject;
	}

	public void setListProject(List<ProjectBean> listProject) {
		this.listProject = listProject;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getParamAssigneeUserDomain() {
		return paramAssigneeUserDomain;
	}

	public void setParamAssigneeUserDomain(String paramAssigneeUserDomain) {
		this.paramAssigneeUserDomain = paramAssigneeUserDomain;
	}

	public AddProjectBean getAddProject() {
		return addProject;
	}

	public void setAddProject(AddProjectBean addProject) {
		this.addProject = addProject;
	}

	public ProjectBean getpBean() {
		return pBean;
	}

	public void setpBean(ProjectBean pBean) {
		this.pBean = pBean;
	}

	public List getListPhase() {
		return listPhase;
	}

	public void setListPhase(List listPhase) {
		this.listPhase = listPhase;
	}

	public AddStructureProjectBean getAddSProject() {
		return addSProject;
	}

	public void setAddSProject(AddStructureProjectBean addSProject) {
		this.addSProject = addSProject;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<StructureProjectBean> getListStructureProject() {
		return listStructureProject;
	}

	public void setListStructureProject(List<StructureProjectBean> listStructureProject) {
		this.listStructureProject = listStructureProject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDirectReportUserDomain() {
		return directReportUserDomain;
	}

	public void setDirectReportUserDomain(String directReportUserDomain) {
		this.directReportUserDomain = directReportUserDomain;
	}

	public String getDirectReportBefore() {
		return directReportBefore;
	}

	public void setDirectReportBefore(String directReportBefore) {
		this.directReportBefore = directReportBefore;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
