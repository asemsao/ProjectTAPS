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
	function report(task) {
		document.reportForm.task.value = task;
		document.reportForm.submit();
	}
	function print(task, organizationCode) {
		document.reportForm.buPrint.value = organizationCode;
		document.reportForm.task.value = task;
		document.reportForm.submit();
	}
	function report(task, organizationCode, organizationLevel, organizationName) {
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
				<html:hidden property="buPrint" name="reportForm" />
				<html:hidden property="periode" name="reportForm" />
				<html:hidden property="reportYear" name="reportForm" />
				<html:hidden property="reportPeriode" name="reportForm" />
				<html:hidden property="reportMonth" name="reportForm" />
				<div id="graph"></div>
				<div class="hide">
					<table id="datatable" class="table striped bordered hovered">
						<tr>
							<th></th>
							<th>Self Assignment BU</th>
							<th>Assignment BU</th>
							<th>Self Assignment Project</th>
							<th>Assignment Project</th>
						</tr>
						<logic:notEmpty name="reportForm" property="listReports">
							<logic:iterate id="report" name="reportForm"
								property="listReports">
								<tr>
									<th><bean:write name="report" property="employeeName" /></th>
									<td><bean:write name="report"
											property="totalSelfAssignmentBU" /></td>
									<td><bean:write name="report"
											property="totalAssignmentBU" /></td>
									<td><bean:write name="report"
											property="totalSelfAssignmentProject" /></td>
									<td><bean:write name="report"
											property="totalAssignmentProject" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
					</table>
				</div>
				<br /> <br />
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
								<h5>
									<logic:notEmpty name="reportForm" property="reportPeriode">
										Semester : <bean:write property="reportPeriode" />
									</logic:notEmpty> 
									<logic:notEmpty name="reportForm" property="reportMonth">
										Month : <bean:write property="reportMonth" />
									</logic:notEmpty>
								</h5>
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
							<th class="text-center" colspan="2">BUSINESS UNIT</th>
							<th class="text-center" colspan="2">PROJECT</th>
						</tr>
						<tr>
							<th class="text-center">SELF ASSIGNMENT</th>
							<th class="text-center">ASSIGNMENT</th>
							<th class="text-center">SELF ASSIGNMENT</th>
							<th class="text-center">ASSIGNMENT</th>
						</tr>
						<logic:notEmpty name="reportForm" property="listReports">
							<logic:iterate id="report" name="reportForm"
								property="listReports">
								<tr class="text-center">
									<td class="text-left"><bean:write name="report"
											property="employeeName" /></td>
									<td><bean:write name="report"
											property="totalSelfAssignmentBU" /></td>
									<td><bean:write name="report"
											property="totalAssignmentBU" /></td>
									<td><bean:write name="report"
											property="totalSelfAssignmentProject" /></td>
									<td><bean:write name="report"
											property="totalAssignmentProject" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<tr>
							<td colspan="5" class="text-right">
								<button class="primary" onclick="javascript:print('printReportDept','<bean:write name="reportForm" property="organizationCode" />')">
									Generate Departement Report
								</button>
								<button id="back-btn" class="info" onclick="javascript:report('back')">
									Home
								</button>
								<logic:notEqual name="reportForm" property="organizationLevel" value='<%=session.getAttribute("organizationLevel").toString()%>'>
									<logic:equal name="reportForm" property="organizationLevel" value="2">
										<button id="back-btn" class="info" onclick="javascript:report('view','<bean:write name="reportForm" property="parentCode" />','1','<bean:write name="reportForm" property="parentName" />')">
											Back
										</button>
									</logic:equal>
								</logic:notEqual>
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
