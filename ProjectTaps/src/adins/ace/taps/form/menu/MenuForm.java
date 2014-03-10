package adins.ace.taps.form.menu;


import java.util.List;

import org.apache.struts.action.ActionForm;


@SuppressWarnings("serial")
public class MenuForm extends ActionForm{
	private String task;	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
}
