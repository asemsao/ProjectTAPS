<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="/js/import.jsp" />
<script src="<%=request.getContextPath()%>/js/highchart/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/data.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/exporting.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/jspdf.min.js"></script>

<script type="text/javascript">
	function button(task) {
		document.reportForm.task.value = task;
		document.reportForm.submit();
	}
	function button(task, organizationCode, organizationLevel, organizationName) {
		document.reportForm.task.value = task;
		document.reportForm.organizationCode.value = organizationCode;
		document.reportForm.organizationLevel.value = organizationLevel;
		document.reportForm.organizationName.value = organizationName;
		document.reportForm.submit();
	}
	$(function() {
		var specialElementHandlers = {
			'#editor' : function(element, renderer) {
				return true;
			}
		};
		$('#cmd').click(function() {
			var doc = new jsPDF();
			doc.fromHTML($('#print').html(), 10, 10, {
				'width' : 1024,
				'height' : 640,
				'elementHandlers' : specialElementHandlers
			});
			doc.save('Report.pdf');
		});
		$('#graph').highcharts(
			{
				data : {
					table : document.getElementById('datatable')
				},
				chart : {
					type : 'column',
					marginTop : 50,
					marginBottom : 100,
					spacingLeft : 30,
					spacingRIght : 30
				},
				lang : {
					noData : "NO DATA FOUND"
				},
				noData : {
					style : {
						fontWeight : 'bold',
						fontSize : '15px',
						color : '#303030'
					}
				},
				title : {
					floating : false,
					text : 'Statistic Of Business Unit',
					margin : 30
				},
				yAxis : {
					allowDecimals : false,
					title : {
						text : 'Manhours',
						margin : 30
					}
				},
				xAxis : {
					allowDecimals : false,
					title : {
						text : 'Employee Name',
						margin : 30
					}
				},
				tooltip : {
					headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
					pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}</td><td>:</td>'
							+ '<td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
					footerFormat : '</table>',
					shared : true,
					useHTML : true
				},
				legend : {
					layout : 'vertical',
					backgroundColor : '#FFFFFF',
					align : 'right',
					verticalAlign : 'middle',
					floating : false
				},
				credits : {
					enabled : false
			},
		});
	});
</script>
<title>Report</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />


	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/report" method="POST">
					<html:hidden property="task" name="reportForm" />
					<html:hidden property="organizationCode" name="reportForm" />
					<html:hidden property="organizationLevel" name="reportForm" />
					<html:hidden property="organizationName" name="reportForm" />
					<html:hidden property="parentCode" name="reportForm" />
					<html:hidden property="periode" name="reportForm" />
					<html:hidden property="reportYear" name="reportForm" />
					<html:hidden property="reportPeriode" name="reportForm" />
					<html:hidden property="reportMonth" name="reportForm" />
					<div id="graph"></div>
					<div class="hide">
						<table id="datatable" class="table striped bordered hovered">
							<tr>
								<th></th>
								<th>Self Assignment</th>
								<th>Assignment</th>
								<th>BU</th>
								<th>Project</th>
							</tr>
							<logic:notEmpty name="reportForm" property="listReports">
								<logic:iterate id="report" name="reportForm" property="listReports">
									<tr>
										<th><bean:write name="report" property="employeeName" /></th>
										<td><bean:write name="report" property="totalSelfAssignment" /></td>
										<td><bean:write name="report" property="totalAssignment" /></td>
										<td><bean:write name="report" property="totalBU" /></td>
										<td><bean:write name="report" property="totalProject" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</table>
					</div>
	
					<div id="print">
						<table id="datatableshow" class="table striped bordered hovered">
							<tr>
								<th colspan=7 class="text-center">
									<h3>
										<bean:write property="organizationName" />
									</h3>
								</th>
							</tr>
							<tr>
								<th colspan=2 class="text-left">
									<h5>
										Report Year : <bean:write property="reportYear" />
									</h5>
								</th>
								<th colspan=2 class="text-left">
									<logic:notEmpty name="reportForm" property="reportPeriode">
										Semester : <h5><bean:write property="reportPeriode" /></h5>
									</logic:notEmpty>
									<logic:notEmpty name="reportForm" property="reportMonth">
										Month : <h5><bean:write property="reportMonth" /></h5>
									</logic:notEmpty>
								</th>
							</tr>
							<tr>
								<th class="text-center">
									<div class="input-control select">
										<select>
											<option value="">All</option>
										</select>
									</div>
								</th>
								<th class="text-center" colspan=6>
									<div class="input-control text">
										<input type="text" placeholder="Keyword of Report" />
										<button class="btn-search"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="text-center" rowspan="2">EMPLOYEE NAME</th>
								<th class="text-center" colspan="2">ASSIGNMENT CATEGORY</th>
								<th class="text-center" colspan="2">ASSIGNMENT TYPE</th>
							</tr>
							<tr>
								<th class="text-center">SELF ASSIGNMENT</th>
								<th class="text-center">ASSIGNMENT</th>
								<th class="text-center">BU</th>
								<th class="text-center">PROJECT</th>
							</tr>
							<logic:notEmpty name="reportForm" property="listReports">
								<logic:iterate id="report" name="reportForm"
									property="listReports">
									<tr class="text-center">
										<td class="text-left"><bean:write name="report"
												property="employeeName" /></td>
										<td><bean:write name="report"
												property="totalSelfAssignment" /></td>
										<td><bean:write name="report" property="totalAssignment" /></td>
										<td><bean:write name="report" property="totalBU" /></td>
										<td><bean:write name="report" property="totalProject" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<tr>
								<td colspan="5" class="text-right">
									<button type="button" onclick="javascript:button('printReportDept')">
										Generate Report
									</button>
									<button id="back-btn" onclick="javascript:button('back')">Home</button>
									<%
										if (!session.getAttribute("organizationLevel").equals("2")) {
									%>
											<button id="back-btn" onclick="javascript:button('view','<bean:write name="reportForm" property="parentCode" />','1','<bean:write name="reportForm" property="parentName" />')">Back</button>
									<%
										}
									%>
								</td>
							</tr>
						</table>
					</div>
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
