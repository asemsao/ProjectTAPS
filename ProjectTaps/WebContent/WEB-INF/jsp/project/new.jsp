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
	function button(task) 
	{
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
	
	$(document).ready(function() {
		$("#projectCode").attr("placeholder", "Project Code");
		$("#projectName").attr("placeholder", "Project Name");
		$("#client").attr("placeholder", "Client");
		$("#lookUpOrganization").load("/ProjectTaps/ajax.do?mode=organizations&task=organizations");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Add Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/project" method="post" styleClass="projectForm">
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
							<td>Project Code</td>
							<td>:</td>
							<td><div class="input-control text ">
									<html:text property="addProject.projectCode"
											name="projectForm" styleId="projectCode"></html:text>
								</div></td>
						</tr>
						<tr>
							<td>Project Name</td>
							<td>:</td>
							<td><div class="input-control text ">
									<html:text property="addProject.projectName"
											name="projectForm" styleId="projectName"></html:text>
								</div></td>
						</tr>
						<tr>
							<td>Client</td>
							<td>:</td>
							<td><div class="input-control text">
									<html:text property="addProject.client"
											name="projectForm" styleId="client"></html:text>
								</div></td>
						</tr>
						<tr>
							<td>Phase</td>
							<td>:</td>
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
							<td>Business Unit</td>
							<td>:</td>
							<td>
								<div class="input-control text">
									<html:hidden property="addProject.organizationCode"
											name="projectForm" styleId="organization-code" ></html:hidden>
										<input type="text" placeholder="Business Unit"
											readonly="readonly" id="parent-organization-name" />
										<button type="button" class="btn-search" id="organization"></button>
									</div>
							</td>
						</tr>
						<tr>
							<td>Start Date</td>
							<td>:</td>
							<td>
								<div class="input-control text" id="datepicker-begin">
									<html:text property="addProject.startDate"
											name="projectForm"></html:text>
									<button type="button" class="btn-date"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Estimate Finish Date</td>
							<td>:</td>
							<td>
								<div class="input-control text " id="datepicker-end">
									<html:text property="addProject.endDate"
											name="projectForm"></html:text>
									<button type="button" class="btn-date"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" class="text-right">
								<button id="save-btn" onclick="javascript:button('saveProject');" class="success">Save</button>
								<button id="cancel-btn" onclick="javascript:button('cancel');">Cancel</button>
							</td>
						</tr>
						
						<html:hidden property="task" styleId="task" name="projectForm" />
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
