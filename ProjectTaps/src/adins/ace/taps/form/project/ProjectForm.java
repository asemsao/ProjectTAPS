package adins.ace.taps.form.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.project.ProjectBean;

public class ProjectForm extends ActionForm
{
	private String task;
	private String value;
	private String search;
	private List<ProjectBean> listProject;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
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
	public List<ProjectBean> getListProject() {
		return listProject;
	}
	public void setListProject(List<ProjectBean> listProject) {
		this.listProject = listProject;
	}
	
	
}
