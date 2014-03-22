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
	function flyToPage(task) {
		if (task == "cancel") {
			document.organizationForm.task.value = "";
			document.organizationForm.submit();
			return;
		} else if (task == "saveEdit") {
			document.organizationForm.task.value = task;
			newBUValidation();
		}
	};

	function changeopt() {
		search = document.getElementById("level");
		temp = search.options[search.selectedIndex].value;
		if (temp != 0) {
			document.getElementById("parent").style.visibility = "visible";
			document.getElementById(":").style.visibility = "visible";
			document.getElementById("parent-organization-name").style.visibility = "visible";
			document.getElementById("organization").style.visibility = "visible";
		} else {
			document.getElementById("parent").style.visibility = "hidden";
			document.getElementById(":").style.visibility = "hidden";
			document.getElementById("parent-organization-name").style.visibility = "hidden";
			document.getElementById("organization").style.visibility = "hidden";
		}
	};
	$(document)
			.ready(
					function() {
						var level = $("#level").val();
						$("#lookUpEmployee")
								.load(
										"/ProjectTaps/ajax.do?mode=employees&task=employees&headBu=headBu");
						$("#lookUpOrganization").load(
								"/ProjectTaps/ajax.do?mode=parentOrganizations&task=parentOrganizations&level="
										+ level);

						if ($("#level").val() == "0") {
							$("#parent-organization").hide();
						}
						$('#level').bind(
								"change",
								function() {
									$("#parent-organization-code").val('');
									$("#parent-organization-name").val('');
									$("#lookUpOrganization").html('');
									$("#lookUpOrganization").load(
											"/ProjectTaps/ajax.do?mode=parentOrganizations&task=parentOrganizations&level="
													+ $(this).val());
								});

						$("#organizationCode").attr("placeholder",
								"Business Unit Code");
						$("#organizationName").attr("placeholder",
								"Business Unit Name");
						$("#employee-name").attr("placeholder",
								"Head of Business Unit");
						$("#parent-organization-name").attr("placeholder",
								"Parent Business Unit");
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Edit Business Unit</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/organization" method="post"
		styleClass="organizationForm">
		<html:hidden property="task" name="organizationForm" />
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3"><h3>Edit Business Unit</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Business Unit Code</td>
								<td>:</td>
								<td><div class="input-control text size3">
										<html:text property="orgBean.organizationCode"
											name="organizationForm" styleId="organizationCode"
											readonly="true"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>Business Unit Name</td>
								<td>:</td>
								<td>
									<div class="input-control text size3">
										<html:text property="orgBean.organizationName"
											name="organizationForm" styleId="organizationName"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Business Unit Level</td>
								<td>:</td>
								<logic:equal value="0" property="countChild"
									name="organizationForm">
									<td>
										<div class="input-control select">
											<html:select property="orgBean.organizationLevel"
												name="organizationForm" styleId="level"
												onchange="javascript:changeopt();">
												<html:option value="2">Level 2</html:option>
												<html:option value="1">Level 1</html:option>
												<html:option value="0">Level 0</html:option>
											</html:select>
										</div>
									</td>
								</logic:equal>

								<logic:notEqual value="0" property="countChild"
									name="organizationForm">
									<td>
										<div class="input-control select">
											<html:select property="orgBean.organizationLevel"
												name="organizationForm" styleId="level" disabled="true">
												<html:option value="2">Level 2</html:option>
												<html:option value="1">Level 1</html:option>
												<html:option value="0">Level 0</html:option>
											</html:select>
										</div>
									</td>
								</logic:notEqual>
							</tr>
							<tr>
								<td>Head Name</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.headDomain"
											name="organizationForm" styleId="employee-domain" />
										<html:text property="orgBean.headName" name="organizationForm"
											styleId="employee-name" readonly="true"></html:text>
										<button class="btn-search" type="button" id="employee"></button>
									</div>
								</td>
							</tr>

							<tr id="parent-organization">
								<td><label id="parent" style="visibility: visible">Parent
										Business Unit </label></td>
								<td><label id=":" style="visibility: visible">:</label></td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.parentCode"
											name="organizationForm" styleId="parent-organization-code" />
										<html:text property="orgBean.parentName"
											name="organizationForm" styleId="parent-organization-name"
											readonly="true"></html:text>
										<button class="btn-search" type="button" id="organization"></button>
									</div>
								</td>
							</tr>

							<tr>
								<td colspan="3" class="text-right">
									<button onclick="flyToPage('saveEdit')" class="button success">Save</button>
									<button onclick="flyToPage('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<input type="hidden" id="headBu" value="headBu" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
	<div id="lookUpEmployee" class="hide"></div>
	<div id="lookUpOrganization" class="hide"></div>
</body>

</html>