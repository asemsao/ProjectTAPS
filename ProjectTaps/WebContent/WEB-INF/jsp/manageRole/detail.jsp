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
	<html:form action="/employeeRole" method="post">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3">Detail Employee Role</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Employee Name</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text property="erBean.employeeName"
											name="employeeRoleForm"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>Role BOM</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusBOM"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role HBU</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusHBU"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role HDE</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusHDE"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role SPV</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusSPV"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role ADM</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusADM"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role EMP</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="erBean.statusEMP"
											name="employeeRoleForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right"><html:button
										property="cancel" onclick="javascript:flyToPage('Back');"
										styleClass="button info">Back</html:button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="employeeRoleForm" />

	</html:form>
	<div id="lookUpEmployee" class="hide"></div>
	<div id="lookUpOrganization" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
