package adins.ace.taps.form.project;

import org.apache.struts.action.ActionForm;

public class ProjectForm extends ActionForm
{
	private String task;
	private String value;
	private String search;
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
	
	
}
