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
		$("#lookUpEmployee2").load("/ProjectTaps/ajax.do?mode=employees2&task=employees2");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Edit Project Member</title>
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
								<th colspan="3"><h3>Edit Project Member</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignee</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="addSProject.assigneeUserDomain" name="projectForm" styleId="employee-domain"></html:hidden>
										<html:text property="addSProject.assigneeName" styleId="employee-name" readonly="true"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<td>Role</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:text property="addSProject.projectRole" name="projectForm"></html:text>
									</div>
								</td>
							</tr>	
							<tr>
								<td>Direct Report</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="addSProject.directreportUserDomain" name="projectForm" styleId="employee-domain-2"></html:hidden>
										<html:text property="addSProject.directreportName" styleId="employee-name-2" readonly="readonly"></html:text>
										<button type="button" class="btn-search" id="employee2"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button id="save-btn" onclick="javascript:button('updateMember')" class="button success">Save</button>
									<button id="cancel-btn-2" onclick="javascript:button('back')">Cancel</button>
								</td>
							</tr>
							<html:hidden property="task" name="projectForm" />
							<html:hidden property="paramProjectCode" name="projectForm" />
							<html:hidden property="directReportBefore" name = "projectForm" />
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
	<div id="lookUpEmployee2" class="hide"></div>
</body>

</html>
