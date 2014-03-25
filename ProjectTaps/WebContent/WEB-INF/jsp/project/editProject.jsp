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
			if (task == "cancel") 
			{
				document.projectForm.task.value = task;
				document.projectForm.submit();
			} 
			else if (task == "updateProject") 
			{
				if($('#phase').val()=="CLD")
				{
					$("#save-button").attr("type", "button");
					$("#lookUpUpdateProject").load(
							"/ProjectTaps/ajax.do?mode=updateProject&task=updateProject&projectCode="
									+ $('#projectCode').val());
					setTimeout(function() {
						$.Dialog({
							overlay : true,
							shadow : true,
							flat : true,
							icon : '<img src="images/LOGO_TITLE.png">',
							title : 'Flat window',
							content : $("#lookUpUpdateProject").html(),
							padding : 10,
							title : 'Assignment'
						});
					}, 500);
				}
				else
				{
					$("#save-button").removeAttr("type");
					document.projectForm.task.value = task;
					editProjectValidation();
				}
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
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>

<title>Edit Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/project" method="post" styleClass="projectForm" styleId= "updateProForm">
		<html:hidden property="task" styleId="task" name="projectForm" />
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="3">
									<h3>Edit Project</h3>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="field-form">Project Code</td>
								<td class="field-separator">:</td>
								<td><div class="input-control text ">
										<html:text property="pBean.projectCode" name="projectForm"
											styleId="projectCode"></html:text>
									</div></td>
							</tr>
							<tr>
								<td class="field-form">Project Name</td>
								<td class="field-separator">:</td>
								<td><div class="input-control text ">
										<html:text property="pBean.projectName" name="projectForm"
											styleId="projectName"></html:text>
									</div></td>
							</tr>
							<tr>
								<td class="field-form">Client</td>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:text property="pBean.client" name="projectForm"
											styleId="client"></html:text>
									</div></td>
							</tr>
							<tr>
								<td class="field-form">Phase</td>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control select">
										<html:select property="pBean.phase" name="projectForm" styleId = "phase">
											<html:optionsCollection name="projectForm"
												property="listPhase" label="phaseName" value="phase" />
										</html:select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="field-form">Business Unit</td>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="pBean.organizationCode"
											name="projectForm" styleId="organization-code"></html:hidden>
										<html:text property="pBean.organizationName"
											name="projectForm" styleId="businessUnit" readonly="true"></html:text>
									</div>

								</td>
							</tr>
							<tr>
								<td class="field-form">Start Date</td>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text" id="datepicker-begin">
										<html:text property="pBean.startDate" name="projectForm" 
										styleId="startDate" readonly="true" styleClass="datepicker-start"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td class="field-form">Estimate Finish Date</td>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text " id="datepicker-end">
										<html:text property="pBean.endDate" name="projectForm"
										styleId="endDate" readonly="true" styleClass="datepicker-end"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button id="save-button"
										onclick="button('updateProject')" class="success">Save</button>
									<button id="cancel-btn" onclick="button('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</html:form>
	<div id="lookUpUpdateProject" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
