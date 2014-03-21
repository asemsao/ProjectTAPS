<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="CrystalReportHelper.jsp"%>
<body>
	<%!private final String REPORT_NAME = "ReportForHBU.rpt";%>
	<%
		try {
	    ReportClientDocument report = getClientDocument(REPORT_NAME);
	      try {
	 	 int i = 0;
	 	String bu = "";
	 	String periode = "";
	 	String periodeReport = "";
	 	String year = "";
	 	if (request.getSession().getAttribute("buPrint") != null) {
	 		bu = request.getSession().getAttribute("buPrint").toString();
	 	}
	 	if (request.getSession().getAttribute("periodePrint") != null) {
	 		periode = request.getSession().getAttribute("periodePrint").toString();
	 	}
	 	if (request.getSession().getAttribute("periodeReportPrint") != null) {
	 		periodeReport = request.getSession().getAttribute("periodeReportPrint").toString();
	 	}
	 	if (request.getSession().getAttribute("yearPrint") != null) {
	 		year = request.getSession().getAttribute("yearPrint").toString();
	 	}
	 	setDocParameter(i++,periode, report);
	 	setDocParameter(i++,bu, report);
	 	setDocParameter(i++,periodeReport, report);
	 	setDocParameter(i++,year, report);
	 	
		
		viewReport(report, request, response, session);

	        //viewReport(report, request, response, session);
	      } finally {
	        report.close();
	        report.dispose();
	      }


	} catch(Exception ex) {
	    out.println("Unexpected error, cannot print report!");
	    ex.printStackTrace();
	}
	%>
</body>
</html>