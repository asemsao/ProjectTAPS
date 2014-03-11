package adins.ace.taps.form.organization;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.employee.EmployeeBean;
import adins.ace.taps.bean.organization.OrganizationBean;

@SuppressWarnings("serial")
public class OrganizationForm extends ActionForm {
	private String organizationCode;
	private String task;
	private String search;
	private String value;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
}
