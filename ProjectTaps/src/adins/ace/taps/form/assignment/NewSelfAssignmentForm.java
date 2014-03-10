package adins.ace.taps.form.assignment;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.NewSelfAssignmentBean;

@SuppressWarnings("serial")
public class NewSelfAssignmentForm extends ActionForm {
	private NewSelfAssignmentBean selfAssignBean = new NewSelfAssignmentBean();
	private String newTask;

	public NewSelfAssignmentBean getSelfAssignBean() {
		return selfAssignBean;
	}

	public void setSelfAssignBean(NewSelfAssignmentBean selfAssignBean) {
		this.selfAssignBean = selfAssignBean;
	}

	public String getNewTask() {
		return newTask;
	}

	public void setNewTask(String newTask) {
		this.newTask = newTask;
	}

}
