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
	private List<OrganizationBean> listMemberOrganizations;
	private String message;
	private String mode;
	private String headDomain;

	public String getHeadDomain() {
		return headDomain;
	}

	public void setHeadDomain(String headDomain) {
		this.headDomain = headDomain;
	}

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

	public List<OrganizationBean> getListMemberOrganizations() {
		return listMemberOrganizations;
	}

	public void setListMemberOrganizations(
			List<OrganizationBean> listMemberOrganizations) {
		this.listMemberOrganizations = listMemberOrganizations;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
