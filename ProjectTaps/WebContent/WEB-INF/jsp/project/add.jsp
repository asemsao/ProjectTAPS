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
			document.projectForm.task.value = task;
			document.projectForm.submit();
			return;
		} else if (task == "saveMember") {
			document.projectForm.task.value = task;
			addProjectMember();
		}
	}
	$(document).ready(function() {
		$("#role").attr("placeholder", "Role in Project");
		$("#employee-name").attr("placeholder", "Assign to");
		$("#employee-name-2").attr("placeholder", "Report to");
		$("#lookUpEmployee").load("/ProjectTaps/ajax.do?mode=employees&task=employees");
		$("#lookUpEmployee2").load("/ProjectTaps/ajax.do?mode=employees2&task=employees2");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Add Project Member</title>
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
								<th colspan="3"><h3>Add Project Member<br/><br/>"<bean:write property="projectName" />"</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Role</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:text property="addSProject.projectRole" name="projectForm" styleId="role">
										</html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Assignee</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="addSProject.assigneeUserDomain" name="projectForm" styleId="employee-domain"></html:hidden>
										<html:text property="addSProject.assigneeName" name="projectForm" styleId="employee-name" readonly="true"></html:text>
										<button type="button" class="btn-search" id="employee"></button>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Direct Report</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="addSProject.directreportUserDomain" name="projectForm" styleId="employee-domain-2"></html:hidden>
										<html:text property="addSProject.directreportName" name="projectForm" styleId="employee-name-2" readonly="true"></html:text>
										<button type="button" class="btn-search" id="employee2"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button id="save-btn" onclick="button('saveMember')" class="button success">Save</button>
									<button id="cancel-btn-2" onclick="button('back')" class="button info">Cancel</button>
								</td>
							</tr>
							<html:hidden property="task" name="projectForm" />
							<html:hidden property="paramProjectCode" name="projectForm" />

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</html:form>
	<div id="lookUpEmployee" class="hide"></div>
	<div id="lookUpEmployee2" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
