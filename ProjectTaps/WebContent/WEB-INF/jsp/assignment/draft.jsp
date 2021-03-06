<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/js/import.jsp" />
<title>New Assignment</title>
<script type="text/javascript">
	function flyToPage(task) {
		if (task == "assign") {
			document.claimAssignmentForm.newTask.value = task;
			newAssignmentValidation();
		} else if (task == "cancel") {
			document.claimAssignmentForm.newTask.value = task;
			document.claimAssignmentForm.submit();
			return;
		} else {
			document.claimAssignmentForm.newTask.value = task;
			document.claimAssignmentForm.submit();
		}
	}

	$(document).ready(function() {
		var project_code = $("#project-code").val();
		var organization_code = $("#organization-code-view").val();
		
		setTimeout(function() {
			$("#lookUpEmployeeOnOrganization").load("/ProjectTaps/ajax.do?mode=employeesOnOrganization&task=employeesOnOrganization&organizationCode=" + organization_code);
		}, 500);
		setTimeout(function() {
			$("#lookUpEmployeeOnProject").load("/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode=" + project_code);
		}, 500);
		setTimeout(function() {
			$("#lookUpProject").load("/ProjectTaps/ajax.do?mode=projects&task=projects");
		}, 500);
		
		if ($("#assignmentType").val() == "PROJECT") {
			$(".pr").show();
			$("#bu").hide();
			$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=project");
		} else {
			$(".pr").hide();
			$("#bu").show();
			$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=bu");
		}

		$("#assignmentDueDate").attr("placeholder", "Assignment Due Date");
		$("#project-name").attr("placeholder", "Project");
		$("#employee-name").attr("placeholder", "Employee");
		$("#assignment-code").attr("placeholder", "Reff Task Code");
		$("#description").attr("placeholder", "Description");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/newAssignment" method="POST" styleId="newAssignment">
					<input type="hidden" id="organization-code-view" value="<%=session.getAttribute("organizationCode") %>" />
					<html:hidden property="newTask" name="claimAssignmentForm" />
					<html:hidden property="assignmentType" name="claimAssignmentForm" />
					<html:hidden property="assignmentBean.assignmentType" name="claimAssignmentForm" styleId="assignmentType" />
					
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>New Assignment</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Assignment Due Date</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text" id="datepicker">
										<html:text property="assignmentBean.assignmentDueDate" name="claimAssignmentForm" styleId="assignmentDueDate" styleClass="datepicker-end"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Assignment Type</th>
								<td class="field-separator">:</td>
								<td><bean:write property="assignmentBean.assignmentType" name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<th class="field-form">Assign To</th>
								<td class="field-separator">:</td>
								<td>
									<div class="pr" class="in-bl">
										<div class="input-control text">
											<html:hidden property="assignmentBean.projectCode" name="claimAssignmentForm" styleId="project-code" />
											<html:text property="assignmentBean.projectName" readonly="true" name="claimAssignmentForm" styleId="project-name" />
											<button type="button" class="btn-search" id=""></button>
										</div>
									</div> <br />									
									<div class="input-control text">
										<html:hidden property="assignmentBean.assignTo" name="claimAssignmentForm" styleId="employee-domain" />
										<html:text property="assignmentBean.assignToFullName" readonly="true" name="claimAssignmentForm" styleId="employee-name" />
										<div class="pr" class="in-bl">
											<button type="button" class="btn-search" id="employeeOnProject"></button>
										</div>
										<div id="bu" class="in-bl">
											<button type="button" class="btn-search" id="employeeOnOrganization"></button>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Reff Task Code</th>
								<td class="field-separator">:</td>

								<td>
									<div class="input-control text">
										<html:text property="assignmentBean.reffTaskCode" name="claimAssignmentForm" styleId="assignment-code" readonly="true"></html:text>
										<button type="button" class="btn-search" id="assigment"></button>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Description</th>
								<td class="field-separator">:</td>
								<td><html:textarea property="assignmentBean.description" name="claimAssignmentForm" styleClass="input-control textarea" styleId="description"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right">
									<button onclick="flyToPage('save')" class="button success">Save</button>
									<button onclick="flyToPage('assign')" class="button success">Assign</button>
									<button onclick="flyToPage('delete')" class="button danger">Delete</button>
									<button onclick="flyToPage('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<div id="lookUpProject" class="hide"></div>
	<div id="lookUpEmployeeOnOrganization" class="hide"></div>
	<div id="lookUpEmployeeOnProject" class="hide"></div>
	<div id="lookUpAssignment" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" /></body>
</body>
</html>
