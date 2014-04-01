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
		if ($("#message").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#message").val()
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
					<html:hidden property="param" styleId="param" name="manageRoleForm" />
					<html:hidden property="message" styleId="message" name="manageRoleForm" />
					<html:hidden property="messagecolor" styleId="messagecolor" name="manageRoleForm" />
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>Role List</h3></th>
							</tr>
							<tr>
								<th class="text-center">Role ID</th>
								<th class="text-center">Role Name</th>
								<th class="text-center">List Employee</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="manageRoleForm" property="listRole">
								<logic:iterate id="manageRole" name="manageRoleForm" property="listRole">
									<tr>
										<td class="text-center"><bean:write name="manageRole" property="roleId" /></td>
										<td class="text-center"><bean:write name="manageRole" property="roleName" /></td>
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
									<td class="text-center" colspan="3">Role Not Available</td>
								</tr>
							</logic:empty>
							<tr>
								<th colspan=3 class="text-right">
									<input type="button" class="wizard primary" value="Manage Role Menu" data-hint="This feature help you add menu for each role." />
								</th>
							</tr>
						</tbody>
					</table>
					</html:form>
				</div>
			</div>
		</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
