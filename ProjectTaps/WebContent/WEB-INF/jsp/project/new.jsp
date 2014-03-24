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
<script>
	function button(task) {
		if (task == "back") {
			document.projectForm.task.value = "";
			document.projectForm.submit();
			return;
		} else if (task == "saveProject") {
			document.projectForm.task.value = task;
			addProjectValidation();
		}
	}

	$(document)
			.ready(
					function() {
						$("#projectCode").attr("placeholder", "Project Code");
						$("#projectName").attr("placeholder", "Project Name");
						$("#client").attr("placeholder", "Client");
						$("#startDate").attr("placeholder", "Start Date");
						$("#endDate").attr("placeholder", "Finish Date");
						$("#parent-organization-name").attr("placeholder", "Business Unit");
						$("#lookUpOrganization")
								.load(
										"/ProjectTaps/ajax.do?mode=organizations&task=organizations");
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Add Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/project" method="post" styleClass="projectForm">
		<html:hidden property="task" styleId="task" name="projectForm" />
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3">
									<h3>Add Project</h3>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Project Code</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text ">
										<html:text property="addProject.projectCode"
											name="projectForm" styleId="projectCode"></html:text>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Project Name</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text ">
										<html:text property="addProject.projectName"
											name="projectForm" styleId="projectName"></html:text>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Client</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:text property="addProject.client" name="projectForm"
											styleId="client"></html:text>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Phase</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control select">
										<html:select property="addProject.phaseId" name="projectForm">
											<option value="REQ">Requirement</option>
											<option value="DEV">Development</option>
											<option value="UAT">UAT</option>
											<option value="LIV">Live</option>
											<option value="CLD">Closed</option>
										</html:select>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Business Unit</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="addProject.organizationCode"
											name="projectForm" styleId="organization-code" />
										<html:text property="addProject.organizationName" readonly="true"
											name="projectForm" styleId="parent-organization-name" />
										<button type="button" class="btn-search" id="organization"></button>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Start Date</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text" id="datepicker">
										<html:text property="addProject.startDate" name="projectForm"
											styleId="startDate" readonly="true" styleClass="datepicker-start"></html:text>
										<button type="button" class="btn-date"></button>											
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Estimate Finish Date</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text " id="datepicker">
										<html:text property="addProject.endDate" name="projectForm"
											styleId="endDate" readonly="true" styleClass="datepicker-end"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button id="save-btn" onclick="button('saveProject')"
										class="success">Save</button>
									<button id="cancel-btn" onclick="button('back')" class="button info">Cancel</button>
								</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</html:form>
	<div id="lookUpOrganization" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
