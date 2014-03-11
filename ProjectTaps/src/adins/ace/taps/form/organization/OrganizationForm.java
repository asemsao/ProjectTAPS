package adins.ace.taps.form.organization;

import java.util.List;

import org.apache.struts.action.ActionForm;

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
	private String message;

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

	private List<OrganizationBean> listOrganizations;

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

}
