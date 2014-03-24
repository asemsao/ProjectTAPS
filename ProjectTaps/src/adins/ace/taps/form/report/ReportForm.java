package adins.ace.taps.form.report;


import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.report.ReportBean;


@SuppressWarnings("serial")
public class ReportForm extends ActionForm{
	private String task;
	private String param;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String search;
	private String value;
	private String buPrint;
	private String periode;
	private String reportYear;
	private String reportPeriode;
	private String reportMonth;
	ReportBean rBean = new ReportBean();
	private List listReports;
	
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

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	} 

	public ReportBean getrBean() {
		return rBean;
	}

	public void setrBean(ReportBean rBean) {
		this.rBean = rBean;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public List getListReports() {
		return listReports;
	}

	public void setListReports(List listReports) {
		this.listReports = listReports;
	}

	public String getTask() {
		return task;
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

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getBuPrint() {
		return buPrint;
	}

	public void setBuPrint(String buPrint) {
		this.buPrint = buPrint;
	}
}
