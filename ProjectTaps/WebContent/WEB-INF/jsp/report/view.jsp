<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
function button(task) {
	document.reportForm.task.value = task;
	document.reportForm.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="../../../js/import.jsp" />

<title>Report</title>

</head>

<body class="metro">
	<jsp:include page="../../../frame/header.jsp" />
	<html:form action="/report" method="POST">	
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
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
							<logic:iterate id="report" name="reportForm" property="listReports">
								<tr>
									<td><bean:write name="report" property="reportId"/></td>
									<td><bean:write name="report" property="firstName"/></td>
									<td><bean:write name="report" property="lastName"/></td>
									<td class="text-center"><a href="javascript:button('edit');"
										data-hint="Edit Report" data-hint-position="bottom"><img
											alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
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
