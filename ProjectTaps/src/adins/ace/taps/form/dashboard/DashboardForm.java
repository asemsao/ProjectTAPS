package adins.ace.taps.form.dashboard;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.dashboard.DashboardBean;

@SuppressWarnings("serial")
public class DashboardForm extends ActionForm{
	DashboardBean dBean = new DashboardBean();
	private String task;
	
	public DashboardBean getdBean() {
		return dBean;
	}

	public void setdBean(DashboardBean dBean) {
		this.dBean = dBean;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
