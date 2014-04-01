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
	function flyToPage(task) {
		if (task == "cancelEdit") {
			document.organizationForm.task.value = "";
			document.organizationForm.submit();
			return;
		} else if (task == "saveEdit") {
			document.organizationForm.task.value = task;
			newBUValidation();
		}
	};

	$(document).ready(function() {
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
		var level = $("#level").val();
		if (level == "0") {
			$(".parent-organization").hide();
		}
		setTimeout(function() {
			$("#lookUpEmployee").load("/ProjectTaps/ajax.do?mode=employees&task=employees&headBu=headBu");
		}, 500);
		setTimeout(function() {
			$("#lookUpOrganization").load("/ProjectTaps/ajax.do?mode=parentOrganizations&task=parentOrganizations&level="+ level);
		}, 500);

		$("#level").change(function() {
			$("#parent-organization-name").val("");
			$("#parent-organization-code").val("");
			if ($("#level").val() == "0") {
				$(".parent-organization").hide();
			} else {
				$("#lookUpOrganization").load("/ProjectTaps/ajax.do?mode=parentOrganizations&task=parentOrganizations&level=" + $(this).val());
				$(".parent-organization").show();
			}
		});

		$("#organizationCode").attr("placeholder", "Business Unit Code");
		$("#organizationName").attr("placeholder", "Business Unit Name");
		$("#employee-name").attr("placeholder", "Head of Business Unit");
		$("#parent-organization-name").attr("placeholder", "Parent Business Unit");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Edit Business Unit</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/organization" method="post" styleClass="organizationForm">
					<html:hidden property="task" name="organizationForm" />
					<html:hidden property="headDomainBefore" name="organizationForm" />
					<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" >
					<input type="hidden" id="headBu" value="headBu" />
					<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="organizationForm" />">
					<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="organizationForm" />">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3"><h3>Edit Business Unit</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Business Unit Code</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text size3">
										<html:text property="orgBean.organizationCode" name="organizationForm" styleId="organizationCode" readonly="true"></html:text>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Business Unit Name</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text size3">
										<html:text property="orgBean.organizationName" name="organizationForm" styleId="organizationName" maxlength="50"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Business Unit Level</th>
								<td class="field-separator">:</td>
								<logic:equal value="0" property="countChild" name="organizationForm">
									<td>
										<div class="input-control select">
											<html:select property="orgBean.organizationLevel" name="organizationForm" styleId="level">
												<html:option value="2">Level 2</html:option>
												<html:option value="1">Level 1</html:option>
												<html:option value="0">Level 0</html:option>
											</html:select>
										</div>
									</td>
								</logic:equal>

								<logic:notEqual value="0" property="countChild" name="organizationForm">
									<td>
										<div class="input-control select">
											<html:select property="orgBean.organizationLevel" name="organizationForm" styleId="level" disabled="true">
												<html:option value="2">Level 2</html:option>
												<html:option value="1">Level 1</html:option>
												<html:option value="0">Level 0</html:option>
											</html:select>
										</div>
									</td>
								</logic:notEqual>
							</tr>
							<tr>
								<th class="field-form">Head Name</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.headDomain" name="organizationForm" styleId="employee-domain" />
										<html:text property="orgBean.headName" name="organizationForm" styleId="employee-name" readonly="true"></html:text>
										<button class="btn-search" type="button" id="employee"></button>
									</div>
								</td>
							</tr>

							<tr class="parent-organization">
								<th class="field-form"><label id="parent">Parent Business Unit </label></th>
								<td class="field-separator"><label id=":">:</label></td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.parentCode" name="organizationForm" styleId="parent-organization-code" />
										<html:text property="orgBean.parentName" name="organizationForm" styleId="parent-organization-name" readonly="true"></html:text>
										<button class="btn-search" type="button" id="organization"></button>
									</div>
								</td>
							</tr>

							<tr>
								<td colspan="3" class="text-right">
									<button onclick="flyToPage('saveEdit')" class="button success">Save</button>
									<button onclick="flyToPage('cancelEdit')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
	<div id="lookUpEmployee" class="hide"></div>
	<div id="lookUpOrganization" class="hide"></div>
</body>
</html>