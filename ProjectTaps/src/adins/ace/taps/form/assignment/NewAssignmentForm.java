package adins.ace.taps.form.assignment;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.NewAssignmentBean;

@SuppressWarnings("serial")
public class NewAssignmentForm extends ActionForm{
	private NewAssignmentBean assignmentBean = new NewAssignmentBean();
	private String task;
	
	public NewAssignmentBean getAssignmentBean() {
		return assignmentBean;
	}
	public void setAssignmentBean(NewAssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
}