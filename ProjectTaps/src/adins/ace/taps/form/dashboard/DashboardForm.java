package adins.ace.taps.form.dashboard;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.dashboard.DashboardBean;

@SuppressWarnings("serial")
public class DashboardForm extends ActionForm{
	DashboardBean dBean = new DashboardBean();
	private String task;
	private String employeeDomain;
	private List<DashboardBean> listTopTen;
	private List<DashboardBean> listTopTenOrganization;
	
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

	public List<DashboardBean> getListTopTen() {
		return listTopTen;
	}

	public void setListTopTen(List<DashboardBean> listTopTen) {
		this.listTopTen = listTopTen;
	}

	public List<DashboardBean> getListTopTenOrganization() {
		return listTopTenOrganization;
	}

	public void setListTopTenOrganization(List<DashboardBean> listTopTenOrganization) {
		this.listTopTenOrganization = listTopTenOrganization;
	}

	public String getEmployeeDomain() {
		return employeeDomain;
	}

	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}

}
