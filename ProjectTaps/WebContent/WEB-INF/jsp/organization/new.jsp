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
		document.organizationForm.task.value = task;
		document.organizationForm.submit();
	}

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
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Add New Business Unit</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/organization" method="post">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3"><h3>Add New Business Unit</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Business Unit Code</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text property="orgBean.organizationCode"
											name="organizationForm"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>Business Unit Name</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="orgBean.organizationName"
											name="organizationForm"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Business Unit Level</td>
								<td>:</td>
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
							</tr>
							<tr>
								<td>Head Name</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.headDomain"
											name="organizationForm" styleId="employee-domain" />
										<input type="text" placeholder="Head of Business Unit"
											id="employee-name" readonly="readonly" />
										<button class="btn-search" type="button" id="employee"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td><label id="parent" style="visibility: visible">Parent
										Business Unit </label></td>
								<td><label id=":" style="visibility: visible">:</label></td>
								<td>
									<div class="input-control text">
										<html:hidden property="orgBean.parentCode"
											name="organizationForm" styleId="parent-organization-code" />
										<input type="text" placeholder="Parent Business Unit"
											readonly="readonly" id="parent-organization-name" />
										<button class="btn-search" type="button" id="organization"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right"><html:button
										property="save" onclick="javascript:flyToPage('Save');"
										styleClass="button success">Save</html:button> <html:button
										property="cancel" onclick="javascript:flyToPage('Cancel');"
										styleClass="button info">Cancel</html:button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="organizationForm" />
		<input type="hidden" id="headBu" value="headBu" />
	</html:form>
	<div id="lookUpEmployee" class="hide"></div>
	<div id="lookUpOrganization" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>