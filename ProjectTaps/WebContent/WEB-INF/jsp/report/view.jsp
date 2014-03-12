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

<script type="text/javascript">
	function button(task) {
		document.reportForm.task.value = task;
		document.reportForm.submit();
	}
	$(function() {
		$('#graph')
				.highcharts(
						{
							data : {
								table : document.getElementById('datatable')
							},
							chart : {
								type : 'column'
							},
							title : {
								text : 'Statistic Of Employee'
							},
							yAxis : {
								allowDecimals : false,
								title : {
									text : 'Range'
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
									<th>Assignment</th>
									<th>Manhour</th>
									<th>Star</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>Kamashwanee</th>
									<td class="text-center">20</td>
									<td class="text-center">88</td>
									<td class="text-center">80</td>
								</tr>
								<tr>
									<th>Kowawa</th>
									<td class="text-center">18</td>
									<td class="text-center">80</td>
									<td class="text-center">74</td>
								</tr>
								<tr>
									<th>MeyTan</th>
									<td class="text-center">22</td>
									<td class="text-center">84</td>
									<td class="text-center">82</td>
								</tr>
								<tr>
									<th>Leon</th>
									<td class="text-center">16</td>
									<td class="text-center">72</td>
									<td class="text-center">68</td>
								</tr>
								<tr>
									<th>Venace</th>
									<td class="text-center">14</td>
									<td class="text-center">70</td>
									<td class="text-center">64</td>
								</tr>
								<tr>
									<th>Raisa</th>
									<td class="text-center">14</td>
									<td class="text-center">66</td>
									<td class="text-center">65</td>
								</tr>
								<tr>
									<th>Yousuck</th>
									<td class="text-center">12</td>
									<td class="text-center">64</td>
									<td class="text-center">60</td>
								</tr>
								<tr>
									<th>Asemsao</th>
									<td class="text-center">19</td>
									<td class="text-center">80</td>
									<td class="text-center">77</td>
								</tr>
							</tbody>
						</table>
					</div>
					<table id="datatableshow" class="table striped bordered hovered">
							<thead>
								<tr>
									<th></th>
									<th>Assignment</th>
									<th>Manhour</th>
									<th>Star</th>
									<th>Organization</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>Kamashwanee</th>
									<td class="text-center">20</td>
									<td class="text-center">88</td>
									<td class="text-center">80</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Kowawa</th>
									<td class="text-center">18</td>
									<td class="text-center">80</td>
									<td class="text-center">74</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>MeyTan</th>
									<td class="text-center">22</td>
									<td class="text-center">84</td>
									<td class="text-center">82</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Leon</th>
									<td class="text-center">16</td>
									<td class="text-center">72</td>
									<td class="text-center">68</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Venace</th>
									<td class="text-center">14</td>
									<td class="text-center">70</td>
									<td class="text-center">64</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Raisa</th>
									<td class="text-center">14</td>
									<td class="text-center">66</td>
									<td class="text-center">65</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Yousuck</th>
									<td class="text-center">12</td>
									<td class="text-center">64</td>
									<td class="text-center">60</td>
									<td class="text-center">ACE</td>
								</tr>
								<tr>
									<th>Asemsao</th>
									<td class="text-center">19</td>
									<td class="text-center">80</td>
									<td class="text-center">77</td>
									<td class="text-center">ACE</td>
								</tr>
							</tbody>
						</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=7 class="text-center"><h3>View Report List</h3></th>
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
								<th class="text-center">Report ID</th>
								<th class="text-center">First Name</th>
								<th class="text-center">Last Name</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="reportForm" property="listReports">
								<logic:iterate id="report" name="reportForm"
									property="listReports">
									<tr>
										<td><bean:write name="report" property="reportId" /></td>
										<td><bean:write name="report" property="firstName" /></td>
										<td><bean:write name="report" property="lastName" /></td>
										<td class="text-center"><a
											href="javascript:button('edit');" data-hint="Edit Report"
											data-hint-position="bottom"><img alt=""
												src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
										<td class="text-center"><a href="javascript:confDel()"
											data-hint="Delete Report" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<tr>
								<td colspan=6 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a><i class="icon-first-2"></i></a></li>
											<li class="prev"><a><i class="icon-previous"></i></a></li>
											<li><a>1</a></li>
											<li><a>2</a></li>
											<li class="active"><a>3</a></li>
											<li class="spaces"><a>...</a></li>
											<li class="disabled"><a>4</a></li>
											<li><a>500</a></li>
											<li class="next"><a><i class="icon-next"></i></a></li>
											<li class="last"><a><i class="icon-last-2"></i></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</tbody>

					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="reportForm" />
	</html:form>
	<jsp:include page="../../../frame/footer.jsp" />

</body>

</html>
