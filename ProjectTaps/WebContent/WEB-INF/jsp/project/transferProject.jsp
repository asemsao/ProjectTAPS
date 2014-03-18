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
	function flyToPage(task, paramProjectCode) {
		document.transferProjectForm.task.value = task;
		document.transferProjectForm.paramProjectCode.value = paramProjectCode;
		document.transferProjectForm.submit();
	}
	function button(task) {
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
	
	
</script>

<title>Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/transferProject" method="post" styleClass="transferProjectForm" styleId="myForm">
					<html:hidden property="task" name="transferProjectForm" />
					<html:hidden property="pageProject" name="transferProjectForm" />
					<html:hidden property="maxPageProject" name="transferProjectForm" />
					<html:hidden property="paramProjectCode" name="transferProjectForm" />
					
					<fieldset>
					<legend>CHOOSE PROJECT</legend>

					<table class="table">
							<tr>
								<th width="25%">
									<div class="input-control select">
										<html:select property="searchCategory" name="transferProjectForm">
											<html:option value="all">All</html:option>
											<html:option value="projectCode">Project Code</html:option>
											<html:option value="projectName">Project Name</html:option>
											<html:option value="client">Client</html:option>
											<html:option value="phase">Phase</html:option>
											<html:option value="organization">Business Unit</html:option>
										</html:select>
									</div>
								</th>
								<th>
									<div class="input-control text">
										<html:text property="searchKeyword" name="transferProjectForm"
											onkeydown="if (event.keyCode == 13){ javascript:button('search'); return false;}"></html:text>
										<button class="btn-search" type="button"
											onclick="javascript:button('search');"></button>
									</div>
								</th>
							</tr>
							</table>
							<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th></th>
								<th class="text-center">Project Code</th>
								<th class="text-center">Project Name</th>
								<th class="text-center">Client</th>
								<th class="text-center">Business Unit</th>
								<th class="text-center">Phase</th>
								<th class="text-center">Start Date</th>
								<th class="text-center">Finish Date</th>
								<th class="text-center">Running (day)</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="transferProjectForm" property="listProject">
								<logic:iterate id="transferProject" name="transferProjectForm"
									property="listProject">
									<tr>
										<td>
											<div class="input-control radio default-style">
											<label>
											<input type="radio" name="project_choose" value="<bean:write name="transferProject"
												property="projectCode" />" />
											<span class="check"></span>
											</label>
											</div>
										</td>
										<td class="text-center"><bean:write name="transferProject"
												property="projectCode" /></td>
										<td><bean:write name="transferProject" property="projectName" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="client" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="organizationCode" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="phase" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="startDate" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="endDate" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="runningDay" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="transferProjectForm" property="listProject">
								<tr>
									<td class="text-center" colspan="9">Project Not Available</td>
								</tr>
						</logic:empty>
						</tbody>
					</table>
					</fieldset>
					
					<fieldset>
					<legend>CHOOSE BUSINESS UNIT</legend>
					<table id="table-ajax-project" class="table">
					</table>
					<table class="table">
							<tr>
								<th width="25%">
									<div class="input-control select">
										<html:select property="searchCategory" name="transferProjectForm">
											<html:option value="all">All</html:option>
											<html:option value="organizationCode">Business Unit Code</html:option>
											<html:option value="organizationName">Business Unit Name</html:option>
											<html:option value="headName">Head Name</html:option>
										</html:select>
									</div>
								</th>
								<th>
									<div class="input-control text">
										<html:text property="searchKeyword" name="transferProjectForm"
											styleId="searchKeyword"></html:text>
										<button id="search" class="btn-search"></button>
									</div>
								</th>
							</tr>
							</table>
							<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th></th>
								<th class="text-center" colspan="3" width="12%">Business Unit Code</th>
								<th class="text-center">Business Unit Name</th>
								<th class="text-center">Head Name</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="transferProjectForm"
								property="listOrganization">
								<logic:iterate id="organization" name="transferProjectForm"
									property="listOrganization">
									<tr>
										<td class="text-center" width="5%">
										<div class="input-control radio default-style">
											<label>
											<input type="radio" name="org_choose" value="<bean:write name='organization'
												property='organizationCode' />@<bean:write name='organization'
												property='organizationName' />" />
											<span class="check"></span>
											</label>
											</div>
										</td>
										<td width="4%"><logic:equal value="0" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>
										<td width="4%"><logic:equal value="1" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>
										<td width="4%"><logic:equal value="2" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>

										<td><bean:write name="organization"
												property="organizationName" /></td>
										<td><bean:write name="organization" property="headName" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="transferProjectForm" property="listOrganization">
								<tr>
									<td class="text-center" colspan="6">Organization Not Available</td>
								</tr>
						</logic:empty>
							</tbody>
					</table>
					</fieldset>
					<fieldset>
					<legend>CHOOSE MEMBER</legend>
					<table id="table-ajax-project2" class="table"></table>
					<table id="table-ajax-structure" class="table striped bordered hovered">
				</table>
					</fieldset>
					<fieldset>
					<legend>SUMMARY</legend>
					<table id="table-ajax-summary" class="table"></table>
					</fieldset>
					<input id="submit-btn" type="button" class="submit-wizard" value="Finish" />
				</html:form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
