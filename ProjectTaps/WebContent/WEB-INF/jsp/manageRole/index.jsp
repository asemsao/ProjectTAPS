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
		$(".wizard").click(function() {
			$("#task").val("wizard");
			$("#CRUDForm").submit();
		});
		$(".listMember").click(function() {
			$("#task").val("listMember");
			$("#param").val($(this).attr('alt').trim());
			$("#CRUDForm").submit();
		});
		$("#firstER").click(function() {
			$("#mode").val("firstER");
			$("#CRUDForm").submit();
		});
		$("#prevER").click(function() {
			$("#mode").val("prevER");
			$("#CRUDForm").submit();
		});
		$("#nextER").click(function() {
			$("#mode").val("nextER");
			$("#CRUDForm").submit();
		});
		$("#lastER").click(function() {
			$("#mode").val("lastER");
			$("#CRUDForm").submit();
		});
		$("#searchER").click(function() {
			$("#mode").val("searchER");
			$("#CRUDForm").submit();
		});
		$("#searchKeywordER").attr("placeholder", "Keyword of Employee");
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
<title>Employee Role</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
				<html:form action="/manageRole" method="post" styleClass="manageRoleForm" styleId="CRUDForm">
					<html:hidden property="task" styleId="task" name="manageRoleForm" />
					<html:hidden property="mode" styleId="mode" name="manageRoleForm" />
					<html:hidden property="param" styleId="param" name="manageRoleForm" />
					<html:hidden property="message" styleId="messageCRUD" name="manageRoleForm" />
					<html:hidden property="messagecolor" styleId="messagecolor" name="manageRoleForm" />
					<html:hidden property="pageER" name="manageRoleForm" />
					<html:hidden property="maxpageER" name="manageRoleForm" />
					
					<br />
					<h3 class="text-center">Roles</h3>
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Role ID</th>
								<th class="text-center">Role Name</th>
								<th class="text-center">Total</th>
								<th class="text-center">List Employee</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="manageRoleForm" property="listRole">
								<logic:iterate id="manageRole" name="manageRoleForm" property="listRole">
									<tr>
										<td class="text-center"><bean:write name="manageRole" property="roleId" /></td>
										<td class="text-center"><bean:write name="manageRole" property="roleName" /></td>
										<td class="text-center"><bean:write name="manageRole" property="roleCount" /></td>
										<td class="text-center">
											<a class="listMember" alt="<bean:write name="manageRole" property="roleId" />" data-hint="List Member <bean:write name="manageRole" property="roleName" />" data-hint-position="bottom"> 
												<img alt="" src="<%=request.getContextPath()%>/images/MEMBER.png">
											</a>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="manageRoleForm" property="listRole">
								<tr>
									<td class="text-center" colspan="4">Role Not Available</td>
								</tr>
							</logic:empty>
							<tr>
								<th colspan=4 class="text-right">
									<input type="button" class="wizard primary" value="Manage Role Menu" data-hint="This feature help you add menu for each role." />
								</th>
							</tr>
						</tbody>
					</table>
					
					<br />
					<h3 class="text-center">Employee's Role</h3>
					<table class="table">
					<tr>
						<th class="text-center field-form">
							<div class="input-control select">
								<html:select property="searchCategoryER" name="manageRoleForm">
									<html:option value="All">All</html:option>
									<html:option value="employeeDomain">Employee Domain</html:option>
									<html:option value="employeeName">Employee Name</html:option>
								</html:select>
							</div>
						</th>
						<th class="text-center">
							<div class="input-control text">
								<html:text property="searchKeywordER" name="manageRoleForm"
									styleId="searchKeywordER"></html:text>
								<button id="searchER" class="btn-search"></button>
							</div>
						</th>
					</tr>
				</table>
				
				<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center"></th>
								<th class="text-center">Employee</th>
								<th class="text-center">Supervisor</th>
								<th class="text-center">Head BU</th>
								<th class="text-center">Administrator</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="manageRoleForm" property="listEmployeeRole">
								<logic:iterate id="employeeRole" name="manageRoleForm" property="listEmployeeRole">
									<tr>
										<td><bean:write name="employeeRole" property="employeeName" /> ( <bean:write name="employeeRole" property="employeeUserDomain" /> )</td>
										<logic:equal name="employeeRole" property="isEmployee" value="1">
										<td class="text-center"><i class="icon-checkmark fg-green"></i></td>
										</logic:equal>
										<logic:notEqual name="employeeRole" property="isEmployee" value="1">
										<td class="text-center"><i class="icon-minus-2 fg-red"></i></td>
										</logic:notEqual>
										
										<logic:equal name="employeeRole" property="isSupervisor" value="1">
										<td class="text-center"><i class="icon-checkmark fg-green"></i></td>
										</logic:equal>
										<logic:notEqual name="employeeRole" property="isSupervisor" value="1">
										<td class="text-center"><i class="icon-minus-2 fg-red"></i></td>
										</logic:notEqual>
										
										<logic:equal name="employeeRole" property="isHeadBU" value="1">
										<td class="text-center"><i class="icon-checkmark fg-green"></i></td>
										</logic:equal>
										<logic:notEqual name="employeeRole" property="isHeadBU" value="1">
										<td class="text-center"><i class="icon-minus-2 fg-red"></i></td>
										</logic:notEqual>
										
										<logic:equal name="employeeRole" property="isAdministrator" value="1">
										<td class="text-center"><i class="icon-checkmark fg-green"></i></td>
										</logic:equal>
										<logic:notEqual name="employeeRole" property="isAdministrator" value="1">
										<td class="text-center"><i class="icon-minus-2 fg-red"></i></td>
										</logic:notEqual>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="manageRoleForm" property="listEmployeeRole">
								<tr>
									<td class="text-center" colspan="5">Employee Not Available</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
					
				<table class="table">
							<tr>
								<td>
									<div class="pagination">
										<ul>
											<li class="first"><a id="firstER">
												<i class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prevER">
												<i class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write name="manageRoleForm" property="pageER" />
												of <bean:write name="manageRoleForm" property="maxpageER" /></a></li>
											<li class="next"><a id="nextER">
												<i class="icon-next"></i></a></li>
											<li class="last"><a id="lastER">
												<i class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record 
												<bean:write name="manageRoleForm" property="countRecordER" /></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</table>
					</html:form>
				</div>
			</div>
		</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
