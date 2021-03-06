<%@page import="adins.ace.taps.bean.module.RoleBean"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.struts.Globals"%> 
<%@page import="org.apache.struts.taglib.html.Constants"%> 
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
		if (task == "cancel") {
			document.claimAssignmentForm.newTask.value = task;
			document.claimAssignmentForm.submit();
			return;
		} else if (task == "save") {
			document.claimAssignmentForm.newTask.value = task;
			document.claimAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
			newAssignmentSaveValidation(getRadioValue("assignment_type"));
		} else if (task == "assign") {
			document.claimAssignmentForm.newTask.value = task;
			document.claimAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
			newAssignmentValidation();
		}
	}
	function getRadioValue(theRadioGroup) {
		var elements = document.getElementsByName(theRadioGroup);
		for ( var i = 0, l = elements.length; i < l; i++) {
			if (elements[i].checked) {
				return elements[i].value;
			}
		}
	}
	$(document).ready(function() {
		var project_code = $("#project-code").val();
		var organization_code = $("#organization-code-view").val();
		var userDomain = $("#userDomain").val();
		setTimeout(function() {
			$("#lookUpEmployeeOnOrganization").load("/ProjectTaps/ajax.do?mode=employeesOnOrganization&task=employeesOnOrganization&organizationCode="
					+ organization_code);
		}, 500);
		setTimeout(function() {
			$("#lookUpEmployeeOnProject").load("/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode="
					+ project_code);
		}, 500);
		setTimeout(function() {
			$("#lookUpProject").load("/ProjectTaps/ajax.do?mode=projects&task=projects&userDomain="+ userDomain);
		}, 500);
		
		$("#employee-name").val($("#employee-fullName").val());
		$('#project-name').bind("change",function() {
			var project_code = $("#project-code").val();
			$("#lookUpEmployeeOnProject").html('');
			$("#lookUpEmployeeOnProject").load("/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode=" + project_code);
			$("#employee-name").val("");
			$("#employee-fullName").val("");
			$("#employee-domain").val("");
		});

		if ($("input[name='assignment_type']").val() == "PROJECT") {
			$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=project");
		} else {
			$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=bu");
		}
	
		$("input[name='assignment_type']").change(function() {
			if ($(this).val() == "PROJECT") {
				$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=project");
			} else {
				$("#lookUpAssignment").load("/ProjectTaps/ajax.do?mode=newAssignments&task=assignments&assignmentCategory=assignment&assignmentType=bu");
			}
		});
		$("#assignmentDueDate").attr("placeholder", "Assignment Due Date");
		$("#project-name").attr("placeholder", "Project");
		$("#employee-name").attr("placeholder", "Employee");
		$("#assignment-code").attr("placeholder", "Reff Task Code");
		$("#description").attr("placeholder", "Description");
		$("#description").attr("maxlength", "1000");
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
					<input type="hidden" id="userDomain" value="<%=session.getAttribute("username") %>" />
					<input type="hidden" id="organization-code-view" value="<%=session.getAttribute("organizationCode") %>" />
					<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" > 
					<html:hidden property="newTask" name="claimAssignmentForm" />
					<html:hidden property="assignmentType" name="claimAssignmentForm" styleId="assignment-type" />
	
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
								<td><div class="input-control text" id="datepicker">
										<html:text property="assignmentBean.assignmentDueDate" name="claimAssignmentForm" styleId="assignmentDueDate" styleClass="datepicker-future"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Assignment Type</th>
								<td class="field-separator">:</td>
								<td>
									<%
										boolean headBU = false;
										List<RoleBean> roleList = (List) session.getAttribute("role");
										for (int i = 0; i < roleList.size(); i++) {
											if (roleList.get(i).getRoleId().equals("hbu")
													|| roleList.get(i).getRoleId().equals("hde")
													|| roleList.get(i).getRoleId().equals("bom")) {
									%>
												<div class="input-control radio margin10">
													<label>
														<input type="radio" name="assignment_type" checked="checked" value="BU" />
														<span class="check"></span>
														Business Unit
													</label>
												</div>
												<div class="input-control radio margin10">
													<label>
														<input type="radio" name="assignment_type" value="PROJECT" />
														<span class="check"></span>
														Project
													</label>
												</div> 
									<%
												headBU = true;
											}
										}
										if (!headBU) {
									%>
											<div class="input-control radio margin10">
												<label>
													<input type="radio" name="assignment_type" disabled="disabled" value="BU" />
													<span class="check"></span>
													Business Unit
												</label>
											</div>
											<div class="input-control radio margin10">
												<label>
													<input type="radio" name="assignment_type" checked="checked" value="PROJECT" />
													<span class="check"></span>
													Project
												</label>
											</div> 
									<%
										}
									%>
								</td>
							</tr>
							<tr>
								<th class="field-form">Assign To</th>
								<td class="field-separator">:</td>
								<td>
									<%
										if (headBU) {
									%>
											<div class="pr" class="in-bl">
												<div class="input-control text">
													<html:hidden property="assignmentBean.projectCode" name="claimAssignmentForm" styleId="project-code" />
													<html:text property="assignmentBean.projectName" readonly="true" name="claimAssignmentForm" styleId="project-name" />
													<button type="button" class="btn-search" id="project"></button>
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
									<%
									 	} else {
									 %>
											<div class="input-control text">
												<html:hidden property="assignmentBean.projectCode" name="claimAssignmentForm" styleId="project-code" />
												<html:text property="assignmentBean.projectName" readonly="true" name="claimAssignmentForm" styleId="project-name" />
												<button type="button" class="btn-search" id="project"></button>
											</div> <br /> <br />
											<div class="input-control text">
												<html:hidden property="assignmentBean.assignTo" name="claimAssignmentForm" styleId="employee-domain" />
												<html:text property="assignmentBean.assignToFullName" readonly="true" name="claimAssignmentForm" styleId="employee-name" />
												<div>
													<button type="button" class="btn-search" id="employeeOnProject"></button>
												</div>
											</div>
									<%
									 	}
									%>
								</td>
							</tr>
							<tr>
								<th class="field-form">Reff Task Code</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:text property="assignmentBean.reffTaskCode" name="claimAssignmentForm" styleId="assignment-code" readonly="true"></html:text>
										<button type="button" class="btn-search" id="assigment"></button>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Description</th>
								<td class="field-separator">:</td>
								<td><html:textarea property="assignmentBean.description" name="claimAssignmentForm" styleClass="input-control textarea" styleId="description"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right">
									<input type="button" onclick="flyToPage('save')" class="button success" value="Save" />
									<button onclick="flyToPage('assign')" class="button success">Assign</button>
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
