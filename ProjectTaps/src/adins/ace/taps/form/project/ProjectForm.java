package adins.ace.taps.form.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.bean.project.AddProjectBean;
import adins.ace.taps.bean.project.AddStructureProjectBean;
import adins.ace.taps.bean.project.ProjectBean;

public class ProjectForm extends ActionForm
{
	private String task;
	private String param;
	private String param2;
	private String value;
	private String search;
	private String organizationName;
	private String projectName;
	private String projectCode;
	private List listProject;
	private List listPhase;
	private ProjectBean pBean = new ProjectBean();
	private AddProjectBean addProject = new AddProjectBean();
	private AddStructureProjectBean addSProject = new AddStructureProjectBean();
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public List getListProject() {
		return listProject;
	}
	public void setListProject(List listProject) {
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
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
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
	
	
	
}
