package adins.ace.taps.form.organization;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.organization.OrganizationBean;

@SuppressWarnings("serial")
public class OrganizationForm extends ActionForm {
	private String organizationCode;
	private String task;
	private String searchCategory;
	private String searchKeyword;
	private String sessionUserDomain;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private OrganizationBean orgBean = new OrganizationBean();
	private List<OrganizationBean> listOrganizations;
	private String message;
	private List<EmployeeBean> listEmployees;
	private Integer pageEmployee;
	private Integer maxpageEmployee;
	private Integer countRecordEmployee;

	public OrganizationBean getOrgBean() {
		return orgBean;
	}

	public void setOrgBean(OrganizationBean orgBean) {
		this.orgBean = orgBean;
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

	public String getTask() {
		return task;
	}

	public String getSessionUserDomain() {
		return sessionUserDomain;
	}

	public void setSessionUserDomain(String sessionUserDomain) {
		this.sessionUserDomain = sessionUserDomain;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<OrganizationBean> getListOrganizations() {
		return listOrganizations;
	}

	public void setListOrganizations(List<OrganizationBean> listOrganizations) {
		this.listOrganizations = listOrganizations;
	}

	public Integer getCountRecord() {
		return countRecord;
	}

	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<EmployeeBean> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<EmployeeBean> listEmployees) {
		this.listEmployees = listEmployees;
	}

	public Integer getPageEmployee() {
		return pageEmployee;
	}

	public void setPageEmployee(Integer pageEmployee) {
		this.pageEmployee = pageEmployee;
	}

	public Integer getMaxpageEmployee() {
		return maxpageEmployee;
	}

	public void setMaxpageEmployee(Integer maxpageEmployee) {
		this.maxpageEmployee = maxpageEmployee;
	}

	public Integer getCountRecordEmployee() {
		return countRecordEmployee;
	}

	public void setCountRecordEmployee(Integer countRecordEmployee) {
		this.countRecordEmployee = countRecordEmployee;
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
}
