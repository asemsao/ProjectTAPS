<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		$(".detailRole").click(function() {
			$("#task").val("detailRole");
			$("#param").val($(this).attr('alt').trim());
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
		$("#searchKeyword").attr("placeholder", "Keyword of Employee");
	});
</script>

<title>Employee Role</title>

</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/employeeRole" method="post" styleClass="employeeRoleForm"
		styleId="CRUDForm">
		<html:hidden property="task" styleId="task" name="employeeRoleForm" />
		<html:hidden property="page" name="employeeRoleForm" />
		<html:hidden property="maxpage" name="employeeRoleForm" />
		<html:hidden property="param" name="employeeRoleForm" styleId="param" />
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=8 class="text-center"><h3>Employee Role List</h3></th>
							</tr>
							<tr>
								<th class="text-center">
									<div class="input-control select">
										<html:select property="searchCategory" name="employeeRoleForm">
											<html:option value="All">All</html:option>
											<html:option value="employeeDomain">Employee Domain</html:option>
											<html:option value="employeeName">Employee Name</html:option>
										</html:select>
									</div>
								</th>
								<th class="text-center" colspan=7>
									<div class="input-control text">
										<html:text property="searchKeyword" name="employeeRoleForm"
											styleId="searchKeyword"></html:text>
										<button id="search" class="btn-search"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="text-center">Employee Name</th>
								<th class="text-center">BOM</th>
								<th class="text-center">HBU</th>
								<th class="text-center">HDE</th>
								<th class="text-center">SPV</th>
								<th class="text-center">ADM</th>
								<th class="text-center">EMP</th>
								<th class="text-center">Details</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="employeeRoleForm" property="listEmployeeRole">
								<logic:iterate id="employeeRole" name="employeeRoleForm"
									property="listEmployeeRole">
									<tr class="text-center">
										<td class="text-left"><bean:write name="employeeRole" property="employeeName" /></td>
										<td><bean:write name="employeeRole" property="statusBOM" /></td>
										<td><bean:write name="employeeRole" property="statusHBU" /></td>
										<td><bean:write name="employeeRole" property="statusHDE" /></td>
										<td><bean:write name="employeeRole" property="statusSPV" /></td>
										<td><bean:write name="employeeRole" property="statusADM" /></td>
										<td><bean:write name="employeeRole" property="statusEMP" /></td>										
										<td class="text-center"><a class='detailRole'
											alt="<bean:write name="employeeRole" property="userDomain" />"
											data-hint="Detail Role" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>										
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="employeeRoleForm" property="listEmployeeRole">
								<tr>
									<td class="text-center" colspan="7">Employee Not Found</td>
								</tr>
							</logic:empty>
							<tr>
								<td colspan=6 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a id="first"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prev"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write
														name="employeeRoleForm" property="page" /> of <bean:write
														name="employeeRoleForm" property="maxpage" /></a></li>
											<li class="next"><a id="next"><i class="icon-next"></i></a></li>
											<li class="last"><a><i id="last" class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <bean:write
														name="employeeRoleForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</html:form>
	<jsp:include page="/frame/footer.jsp" />

</body>

</html>
