package adins.ace.taps.form.employee;


import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.employee.EmployeeBean;


@SuppressWarnings("serial")
public class EmployeeForm extends ActionForm{
	private String task;
	private String searchKeyword;
	private String searchCategory;
	private List<EmployeeBean> listEmployees;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
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
	public List<EmployeeBean> getListEmployees() {
		return listEmployees;
	}
	public void setListEmployees(List<EmployeeBean> listEmployees) {
		this.listEmployees = listEmployees;
	}
}
