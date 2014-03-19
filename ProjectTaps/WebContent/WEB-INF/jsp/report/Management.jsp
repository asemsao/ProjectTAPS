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
	<%!private final String REPORT_NAME = "ReportForManagement.rpt";%>
	<%
		try {
	    ReportClientDocument report = getClientDocument(REPORT_NAME);
	      try {
	 	 int i = 0;
	 	setDocParameter(i++,"Januari - Juni", report);
	 	setDocParameter(i++,"MAN", report);
	 	setDocParameter(i++,"01/04/2014", report);
	 	setDocParameter(i++,"'01','02','03'", report);
	 	setDocParameter(i++,"01/01/2014", report);
	 	setDocParameter(i++,"2014", report);
		
		
		viewReport(report, request, response, session);
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