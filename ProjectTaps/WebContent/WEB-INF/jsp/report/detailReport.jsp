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
	function print(task,organizationCode) {
		document.reportForm.task.value = task;
		document.reportForm.buPrint.value = organizationCode;
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
					text : 'Employee Productivity',
					margin : 30
				},
				yAxis : {
					allowDecimals : false,
					title : {
						text : 'Assignments / Manhours',
						margin : 30
					}
				},
				xAxis : {
					allowDecimals : false,
					title : {
						text : 'Month',
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
<title>Detail Report</title>
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
								<th>Productivity</th>
							</tr>	
						
							<logic:notEmpty name="reportForm" property="rBean">
								<logic:equal value="I" name="reportForm" property="reportPeriode">
									<tr>
										<th>January</th>
										<td><bean:write name="reportForm" property="rBean.productivity01" /></td>
									<tr>
									<tr>
										<th>February</th>
										<td><bean:write name="reportForm" property="rBean.productivity02" /></td>
									<tr>
									<tr>
										<th>March</th>
										<td><bean:write name="reportForm" property="rBean.productivity03" /></td>
									<tr>
									<tr>
										<th>April</th>
										<td><bean:write name="reportForm" property="rBean.productivity04" /></td>
									<tr>
									<tr>
										<th>May</th>
										<td><bean:write name="reportForm" property="rBean.productivity05" /></td>
									<tr>
									<tr>
										<th>June</th>
										<td><bean:write name="reportForm" property="rBean.productivity06" /></td>
									<tr>
								</logic:equal>
								<logic:equal value="II" name="reportForm" property="reportPeriode">
									<tr>
										<th>July</th>
										<td><bean:write name="reportForm" property="rBean.productivity07" /></td>
									<tr>
									<tr>
										<th>August</th>
										<td><bean:write name="reportForm" property="rBean.productivity08" /></td>
									<tr>
									<tr>
										<th>September</th>
										<td><bean:write name="reportForm" property="rBean.productivity09" /></td>
									<tr>
									<tr>
										<th>October</th>
										<td><bean:write name="reportForm" property="rBean.productivity10" /></td>
									<tr>
									<tr>
										<th>November</th>
										<td><bean:write name="reportForm" property="rBean.productivity11" /></td>
									<tr>
									<tr>
										<th>December</th>
										<td><bean:write name="reportForm" property="rBean.productivity12" /></td>
									<tr>
								</logic:equal>
							</logic:notEmpty>	
						</table>
					</div>
					
				</html:form>
			</div>	
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
