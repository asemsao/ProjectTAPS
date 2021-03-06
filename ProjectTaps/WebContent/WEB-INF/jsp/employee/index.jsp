<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.struts.Globals"%> 
<%@page import="org.apache.struts.taglib.html.Constants"%> 
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#new").click(function() {
			$("#task").val("new");
			$("#CRUDForm").submit();
		});
		$(".editEmployee").click(function() {
			$("#task").val("edit");
			$("#employeeDomain").val($(this).attr('alt').trim());
			$("#CRUDForm").submit();
		});
		$("#first").click(function() {
			$("#task").val("first");
			$("#CRUDForm").submit();
		});
		$("#prev").click(function() {
			$("#task").val("prev");
			$("#CRUDForm").submit();
		});
		$("#next").click(function() {
			$("#task").val("next");
			$("#CRUDForm").submit();
		});
		$("#last").click(function() {
			$("#task").val("last");
			$("#CRUDForm").submit();
		});
		$("#search").click(function() {
			$("#task").val("search");
			$("#CRUDForm").submit();
		});
		$(".delete-link").click(function() {
			$("#employeeDomain").val($(this).attr('alt').trim());
			$("#CRUDForm").val($(this).attr('alt').trim());
		});
		$("#searchKeyword").attr("placeholder", "Keyword of Employee");
		if ($("#messageCRUD").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#messageCRUD").val()
				});
			}, 1000);
		}
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Employee</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
			<html:form action="/employee" method="post" styleClass="employeeForm" styleId="CRUDForm">
				<html:hidden property="task" styleId="task" name="employeeForm" />
				<html:hidden property="page" name="employeeForm" />
				<html:hidden property="maxpage" name="employeeForm" />
				<html:hidden property="employeeDomain" styleId="employeeDomain" name="employeeForm" />
				<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="employeeForm" />">
				<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="employeeForm" />">
				<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" >
				<table class="table">
					<tr>
						<th colspan=2 class="text-center"><h3>Employee List</h3></th>
					</tr>
					<tr>
						<th class="text-center field-form">
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
						<th class="text-center">
							<div class="input-control text">
								<html:text property="searchKeyword" name="employeeForm"
									styleId="searchKeyword"></html:text>
								<button id="search" class="btn-search"></button>
							</div>
						</th>
					</tr>
				</table>

				<table class="table striped bordered hovered">
					<thead>
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
									<td class="text-center"><bean:write name="employee"
											property="employeeCode" /></td>
									<td class="text-center"><bean:write name="employee"
											property="employeeDomain" /></td>
									<td class="text-center"><bean:write name="employee"
											property="employeeNik" /></td>
									<td><bean:write name="employee" property="employeeName" /></td>
									<td><bean:write name="employee"
											property="employeeAddress" /></td>
									<td class="text-center"><a class='editEmployee'
										alt="<bean:write name="employee" property="employeeDomain" />"
										data-hint="Edit Employee" data-hint-position="bottom"><img
											alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
									<td class="text-center"><a href="#"
										class="delete-link deleteEmployee"
										data-hint="Delete Employee" data-hint-position="bottom"
										alt="<bean:write name="employee"
											property="employeeDomain" />"><img
											alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a>
									</td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<logic:empty name="employeeForm" property="listEmployees">
							<tr>
								<td class="text-center" colspan="7">Employee Not Found</td>
							</tr>
						</logic:empty>
					</tbody>
				</table>

				<table class="table">
					<tr>
						<td class="text-center">
							<div class="pagination">
								<ul>
									<li class="first"><a id="first"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a id="prev"><i
											class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <bean:write
												name="employeeForm" property="page" /> of <bean:write
												name="employeeForm" property="maxpage" /></a></li>
									<li class="next"><a id="next"><i class="icon-next"></i></a></li>
									<li class="last"><a><i id="last" class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <bean:write
												name="employeeForm" property="countRecord" /></a></li>
								</ul>
							</div>
						</td>
						<td class="text-center field-form"><a id="new" data-hint="Add Employee"
							data-hint-position="bottom"><img alt=""
								src="<%=request.getContextPath()%>/images/ADD_EMPLOYEE.png"></a></td>
					</tr>
				</table>
				</html:form>
			</div>
		</div>
	</div>
	<div id="lookUpDeleteEmployee" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
