package adins.ace.taps.ajax;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.employee.EmployeeBean;

public class AjaxForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String searchCategory;
	private String searchKeyword;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private List<EmployeeBean> listEmployees;

	// private List<OrganizationBean> listOrganizations;
	// private Integer pageEmployee;
	// private Integer maxpageEmployee;
	// private Integer countRecordEmployee;

	public String getTask() {
		return task;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
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

	public List<EmployeeBean> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<EmployeeBean> listEmployees) {
		this.listEmployees = listEmployees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
