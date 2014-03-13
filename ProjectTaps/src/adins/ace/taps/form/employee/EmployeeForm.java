package adins.ace.taps.form.employee;


import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;


@SuppressWarnings("serial")
public class EmployeeForm extends ActionForm{
	private String employeeDomain;
	private String task;
	private String searchKeyword;
	private String searchCategory;
	private FormFile profilePicture;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private List<EmployeeBean> listEmployees;
	private List<NewEmployeeBean> editEmployees;
	private NewEmployeeBean newEmployee = new NewEmployeeBean();
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
	public NewEmployeeBean getNewEmployee() {
		return newEmployee;
	}
	public void setNewEmployee(NewEmployeeBean newEmployee) {
		this.newEmployee = newEmployee;
	}
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
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public List<NewEmployeeBean> getEditEmployees() {
		return editEmployees;
	}
	public void setEditEmployees(List<NewEmployeeBean> editEmployees) {
		this.editEmployees = editEmployees;
	}
	public FormFile getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(FormFile profilePicture) {
		this.profilePicture = profilePicture;
	}
}
