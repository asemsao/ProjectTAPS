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
		document.claimAssignmentForm.newTask.value = task;
		document.claimAssignmentForm.submit();
	}

	$(document)
			.ready(
					function() {
						if ($("#assignmentType").val() == 'PROJECT') {
							$("#bu").hide();
							$(".pr").show();
						} else {
							$(".pr").hide();
							$("#bu").show();
						}

						var project_code = $("#project-code").val();
						var organization_code = $("#organization-code-view")
								.val();
						$("#lookUpEmployeeOnOrganization")
								.load(
										"/ProjectTaps/ajax.do?mode=employeesOnOrganization&task=employeesOnOrganization&organizationCode="
												+ organization_code);
						$("#lookUpEmployeeOnProject")
								.load(
										"/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode="
												+ project_code);
						$("#lookUpProject")
								.load(
										"/ProjectTaps/ajax.do?mode=projects&task=projects");
						$("#employee-name").val($("#employee-fullName").val());

						$("#timepicker").timeselector();

						$('#project-name')
								.bind(
										"change",
										function() {
											var project_code = $(
													"#project-code").val();
											$("#lookUpEmployeeOnProject").html(
													'');
											$("#lookUpEmployeeOnProject")
													.load(
															"/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode="
																	+ project_code);
											$("#employee-name").val("");
											$("#employee-fullName").val("");
											$("#employee-domain").val("");
										});
						$("#lookUpAssignment")
								.load(
										"/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=bu");
						$("input[name='assignment_type']")
								.change(
										function() {
											if ($(this).val() == "PROJECT") {
												$("#lookUpAssignment")
														.load(
																"/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=project");
											} else {
												$("#lookUpAssignment")
														.load(
																"/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=bu");
											}
										});
						$("#assignmentDate").attr("placeholder",
								"Assignment Date");
						$("#assignmentDueDate").attr("placeholder",
								"Assignment Due Date");
						$("#timepicker").attr("placeholder", "Assignment Time");
						$("#project-name").attr("placeholder", "Project");
						$("#employee-name").attr("placeholder", "Employee");
						$("#assignment-code").attr("placeholder",
								"Reff Task Code");
						$("#description").attr("placeholder", "Description");
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body class="metro" onload="javascript:checkRadioButtonValue();">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/newAssignment" method="POST"
		styleId="newAssignment">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>New Assignment</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td><div class="input-control text " id="datepicker-begin">
										<html:text property="assignmentBean.assignmentDate"
											name="claimAssignmentForm" styleId="assignmentDate"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Due Date</td>
								<td>:</td>
								<td><div class="input-control text" id="datepicker-end">
										<html:text property="assignmentBean.assignmentDueDate"
											name="claimAssignmentForm" styleId="assignmentDueDate"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Time</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text property="assignmentBean.assignmentTime"
											name="claimAssignmentForm" styleId="timepicker"
											readonly="readonly"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td><bean:write property="assignmentBean.assignmentType"
										name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Assign To</td>
								<td>:</td>
								<td><div class="pr" class="in-bl">
										<div class="input-control text">
											<html:hidden property="assignmentBean.projectCode"
												name="claimAssignmentForm" styleId="project-code" />
											<html:text property="assignmentBean.projectName"
												readonly="true" name="claimAssignmentForm"
												styleId="project-name" />
											<button type="button" class="btn-search" id=""></button>
										</div>
									</div> <br />
									<div class="pr" class="in-bl">
										<div class="input-control text">
											<html:hidden property="assignmentBean.assignTo"
												name="claimAssignmentForm" styleId="employee-domain" />
											<html:hidden property="assignmentBean.assignToFullName"
												name="claimAssignmentForm" styleId="employee-fullName" />
											<input type="text" placeholder="Employee" id="employee-name" />
											<div class="pr" class="in-bl">
												<button type="button" class="btn-search"
													id="employeeOnProject"></button>
											</div>
										</div>
									</div>
									<div id="bu" class="input-control text">
										<html:hidden property="assignmentBean.assignTo"
											name="claimAssignmentForm" styleId="employee-domain" />
										<html:text property="assignmentBean.assignToFullName"
											readonly="true" name="claimAssignmentForm"
											styleId="employee-name" />
										<div class="pr" class="in-bl">
											<button type="button" class="btn-search"
												id="employeeOnProject"></button>
										</div>
										<div id="bu" class="in-bl">
											<button type="button" class="btn-search"
												id="employeeOnOrganization"></button>
										</div>
									</div></td>
							</tr>
							<tr>
								<td>Reff Task Code</td>
								<td>:</td>

								<td><div class="input-control text">
										<html:text property="assignmentBean.reffTaskCode"
											name="claimAssignmentForm" styleId="assignment-code"
											readonly="true"></html:text>
										<button type="button" class="btn-search" id="assigment"></button>
									</div></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td><html:textarea property="assignmentBean.description"
										name="claimAssignmentForm" styleClass="input-control textarea"
										styleId="description"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right">
									<button onclick="flyToPage('save')" class="button success">Save</button>
									<button onclick="flyToPage('assign')" class="button success">Assign</button>
									<button onclick="flyToPage('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- ini nanti ambil session -->
		<input type="hidden" id="organization-code-view" value="CDD" />
		<html:hidden property="newTask" name="claimAssignmentForm" />
		<html:hidden property="assignmentType" name="claimAssignmentForm" />
		<html:hidden property="assignmentBean.assignmentType"
			name="claimAssignmentForm" styleId="assignmentType" />
	</html:form>


	<div id="lookUpProject" class="hide"></div>
	<div id="lookUpEmployeeOnOrganization" class="hide"></div>
	<div id="lookUpEmployeeOnProject" class="hide"></div>
	<div id="lookUpAssignment" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" /></body>
</body>
</html>
