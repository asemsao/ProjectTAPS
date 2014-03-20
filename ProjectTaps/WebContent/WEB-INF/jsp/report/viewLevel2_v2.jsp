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

<jsp:include page="../../../js/import.jsp" />
<script src="<%=request.getContextPath()%>/js/highchart/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/data.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/exporting.js"></script>
<script src="<%=request.getContextPath()%>/js/highchart/jspdf.min.js"></script>

<script type="text/javascript">
	function button(task) {
		document.reportForm.task.value = task;
		document.reportForm.submit();
	}
	function button(task,param,param2) {
		document.reportForm.task.value = task;
		document.reportForm.param.value = param;
		document.reportForm.param2.value = param2;
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
		$('#graph')
				.highcharts(
						{
							data : {
								table : document.getElementById('datatable')
							},
							chart : {
					            type: 'column',
					            marginTop: 50,
					            marginBottom:100,
					            spacingLeft: 30,
					            spacingRIght: 30
							},        
					        lang: {
					            noData: "NO DATA FOUND"
					        },
					        noData: {
					            style: {    
					                fontWeight: 'bold',     
					                fontSize: '15px',
					                color: '#303030'        
					            }
					        },
							title : {
								floating: false,
								text : 'Statistic Of Business Unit',
								margin : 30
							},
							yAxis : {
								allowDecimals : false,
								title : {
									text : 'Manhours',
									margin: 30
								}
							},
							xAxis : {
								allowDecimals : false,
								title : {
									text : 'Employee Name',
									margin: 30
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
							legend: {
					            layout: 'vertical',
					            backgroundColor: '#FFFFFF',
					            align: 'right',
					            verticalAlign: 'middle',
					            floating: false
					        },
							// tooltip : {
							// formatter : function() {
							// return '<b>' + this.series.name + '</b><br/>'
							// + this.point.y + ' '
							// + this.point.name.toLowerCase();
							// }
							// },
							credits : {
								enabled : false
							},
						});
	});
</script>
<title>Report</title>
</head>
<body class="metro">
	<jsp:include page="../../../frame/header.jsp" />



	<html:form action="/report" method="POST">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<div id="graph"
						style="min-width: 310px; height: 400px; margin: 0 auto"></div>
					<div class="hide">
						<table id="datatable" class="table striped bordered hovered">
							<thead>
								<tr>
									<th></th>
									<th>Self Assignment BU</th>
									<th>Assignment BU</th>
									<th>Self Assignment Project</th>
									<th>Assignment Project</th>
								</tr>
							</thead>
							<tbody>
								<logic:notEmpty name="reportForm" property="listReports">
								<logic:iterate id="report" name="reportForm"
									property="listReports">
									<tr>
										<th><bean:write name="report" property="employeeName" /></th>
										<td><bean:write name="report" property="totalSelfAssignmentBU" /></td>
										<td><bean:write name="report" property="totalAssignmentBU" /></td>
										<td><bean:write name="report" property="totalSelfAssignmentProject" /></td>
										<td><bean:write name="report" property="totalAssignmentProject" /></td>
									</tr>									
								</logic:iterate>
							</logic:notEmpty>
							</tbody>
						</table>
					</div>
					<button type="button" onclick="javascript:button('printReportDept')">generate Report</button>
					<div id="print">
						<table id="datatableshow" class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=7 class="text-center"><h3><bean:write property="param3"/></h3></th>
							</tr>
							<tr>
								<th colspan=2 class="text-left"><h5>Report Year : <bean:write property="reportYear"/> </h5></th>
								<th colspan=2 class="text-left"><h5>
								<logic:notEmpty name="reportForm" property="reportPeriode">
									Semester : <bean:write property="reportPeriode"/> </h5>
								</logic:notEmpty>
								<logic:notEmpty name="reportForm" property="reportMonth">
									Month :<bean:write property="reportMonth"/> </h5>
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
								<th class="text-center" colspan="2">BUSINESS UNIT</th>
								<th class="text-center" colspan="2">PROJECT</th>
							</tr>
							<tr>
								<th class="text-center">SELF ASSIGNMENT</th>
								<th class="text-center">ASSIGNMENT</th>
								<th class="text-center">SELF ASSIGNMENT</th>
								<th class="text-center">ASSIGNMENT</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="reportForm" property="listReports">
								<logic:iterate id="report" name="reportForm"
									property="listReports">
									<tr class="text-center">
										<td class="text-left"><bean:write name="report" property="employeeName" /></td>
										<td><bean:write name="report" property="totalSelfAssignmentBU" /></td>
										<td><bean:write name="report" property="totalAssignmentBU" /></td>
										<td><bean:write name="report" property="totalSelfAssignmentProject" /></td>
										<td><bean:write name="report" property="totalAssignmentProject" /></td>
									</tr>									
								</logic:iterate>
							</logic:notEmpty>
<!-- 							<tr> -->
<!-- 								<td colspan=6 class="text-center"> -->
<!-- 									<div class="pagination"> -->
<!-- 										<ul> -->
<!-- 											<li class="first"><a><i class="icon-first-2"></i></a></li> -->
<!-- 											<li class="prev"><a><i class="icon-previous"></i></a></li> -->
<!-- 											<li><a>1</a></li> -->
<!-- 											<li><a>2</a></li> -->
<!-- 											<li class="active"><a>3</a></li> -->
<!-- 											<li class="spaces"><a>...</a></li> -->
<!-- 											<li class="disabled"><a>4</a></li> -->
<!-- 											<li><a>500</a></li> -->
<!-- 											<li class="next"><a><i class="icon-next"></i></a></li> -->
<!-- 											<li class="last"><a><i class="icon-last-2"></i></a></li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</td> -->
<!-- 							</tr> -->
								<tr>
									<td colspan="5" class="text-right">
										<button id="back-btn" onclick="javascript:button('back')">Home</button>										
									<logic:equal name="reportForm" property="param2" value="2">
										<button id="back-btn" onclick="javascript:button('view','<bean:write name="reportForm" property="param4" />','1','<bean:write name="reportForm" property="param5" />')">Back</button>
									</logic:equal>						
									</td>
								</tr>
						</tbody>

					</table>
					</div>
					
				</div>
			</div>
		</div>
		<html:hidden property="task" name="reportForm" />
		<html:hidden property="param" name="reportForm" />
		<html:hidden property="param2" name="reportForm" />
		<html:hidden property="param3" name="reportForm" />
		<html:hidden property="param4" name="reportForm" />
		<html:hidden property="reportYear" name="reportForm" />
		<html:hidden property="reportPeriode" name="reportForm" />
		<html:hidden property="reportMonth" name="reportForm" />
	</html:form>
	<jsp:include page="../../../frame/footer.jsp" />

</body>

</html>