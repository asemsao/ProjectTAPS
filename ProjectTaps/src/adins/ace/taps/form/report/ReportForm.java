package adins.ace.taps.form.report;


import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.report.ReportBean;
import adins.ace.taps.bean.report.ReportStarBean;


/**
 * @author ketut.gwj
 *
 */
@SuppressWarnings("serial")
public class ReportForm extends ActionForm{
	private String task;
	private String userDomain;
	private String organizationCode;
	private String organizationLevel;
	private String organizationName;
	private String parentCode;
	private String parentName;
	private String search;
	private String value;
	private String buPrint;
	private String periode;
	private String reportYear;
	private String reportPeriode;
	private String reportMonth;
	private ReportBean rBean = new ReportBean();
	private ReportStarBean rsBean = new ReportStarBean();
	private List<ReportBean> listReports;
	private Integer countRecord;
	private Integer maxpage;
	private Integer page;
	
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getOrganizationLevel() {
		return organizationLevel;
	}
	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	public String getBuPrint() {
		return buPrint;
	}
	public void setBuPrint(String buPrint) {
		this.buPrint = buPrint;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getReportYear() {
		return reportYear;
	}
	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}
	public String getReportPeriode() {
		return reportPeriode;
	}
	public void setReportPeriode(String reportPeriode) {
		this.reportPeriode = reportPeriode;
	}
	public String getReportMonth() {
		return reportMonth;
	}
	public void setReportMonth(String reportMonth) {
		this.reportMonth = reportMonth;
	}
	public ReportBean getrBean() {
		return rBean;
	}
	public void setrBean(ReportBean rBean) {
		this.rBean = rBean;
	}
	public List<ReportBean> getListReports() {
		return listReports;
	}
	public void setListReports(List<ReportBean> listReports) {
		this.listReports = listReports;
	}
	public Integer getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}
	public Integer getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public ReportStarBean getRsBean() {
		return rsBean;
	}
	public void setRsBean(ReportStarBean rsBean) {
		this.rsBean = rsBean;
	}
}
