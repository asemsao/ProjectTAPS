<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<script type="text/javascript">
	function button(task) {
		document.employeeForm.task.value = task;
		document.employeeForm.submit();
	}
	
	$(document).ready(function() {
		$("#searchKeyword").attr("placeholder", "Keyword of Employee");
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="/js/import.jsp" />

<title>Employee</title>

</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/employee" method="post" styleClass="employeeForm">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=7 class="text-center"><h3>Employee List</h3></th>
							</tr>
							<tr>
								<th class="text-center">
									<div class="input-control select">
										<html:select property="searchCategory" name="employeeForm">
											<html:option value="All">All</html:option>
											<html:option value="employeeDomain">Employee Domain</html:option>
											<html:option value="employeeCode">Employee Code</html:option>
											<html:option value="employeeName">Employee Name</html:option>
											<html:option value="employeeAddress">Employee Address</html:option>
										</html:select>
									</div>
								</th>
								<th class="text-center" colspan=6>
									<div class="input-control text">
										<html:text property="searchKeyword" name="employeeForm"
											styleId="searchKeyword"></html:text>
										<button class="btn-search"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="text-center">Code</th>
								<th class="text-center">Domain</th>
								<th class="text-center">NIK</th>
								<th class="text-center">Name</th>
								<th class="text-center">Address</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="employeeForm" property="listEmployees">
								<logic:iterate id="employee" name="employeeForm"
									property="listEmployees">
									<tr>
										<td><bean:write name="employee" property="employeeCode" /></td>
										<td><bean:write name="employee" property="employeeDomain" /></td>
										<td><bean:write name="employee" property="employeeNik" /></td>
										<td><bean:write name="employee" property="employeeName" /></td>
										<td><bean:write name="employee"
												property="employeeAddress" /></td>
										<td class="text-center"><a
											href="javascript:button('edit','<bean:write name="employee" property="employeeDomain"/>');"
											data-hint="Edit Employee" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
										<td class="text-center"><a href="javascript:confDel()"
											data-hint="Delete Employee" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="employeeForm" property="listEmployees">
								<tr>
									<td class="text-center" colspan="7">Employee Not Found</td>
								</tr>
							</logic:empty>
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
								<td class="text-center"><a href="javascript:button('new');"
									data-hint="Add Employee" data-hint-position="bottom"><img
										alt=""
										src="<%=request.getContextPath()%>/images/ADD_EMPLOYEE.png"></a></td>
							</tr>
						</tbody>

					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="employeeForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />

</body>

</html>
