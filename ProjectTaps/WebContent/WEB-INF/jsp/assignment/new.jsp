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
		document.newAssignmentForm.newTask.value = task;
		document.newAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
		document.newAssignmentForm.submit();
	}

	function getRadioValue(theRadioGroup) {
		var elements = document.getElementsByName(theRadioGroup);
		for ( var i = 0, l = elements.length; i < l; i++) {
			if (elements[i].checked) {
				return elements[i].value;
			}
		}
	}

	function checkRadioButtonValue() {

	}

	$(document).ready(
			function() {
				$("#lookUpEmployee").load(
						"/ProjectTaps/ajax.do?mode=employees&task=employees");
				$("#employee-name").val($("#employee-fullName").val());
			});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body class="metro" onload="javascript:checkRadioButtonValue();">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/newAssignment" method="POST">
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
											name="newAssignmentForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Due Date</td>
								<td>:</td>
								<td><div class="input-control text" id="datepicker-end">
										<html:text property="assignmentBean.assignmentDueDate"
											name="newAssignmentForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td><div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											checked="checked" value="BU" /> <span class="check"></span>
											Business Unit
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											value="PROJECT" /> <span class="check"></span> Project
										</label>
									</div> <%-- 									<html:radio property="assignmentBean.assignmentType" --%>
									<%-- 										name="newAssignmentForm" value="businessUnit">Business Unit</html:radio> --%>
									<%-- 									<html:radio property="assignmentBean.assignmentType" --%>
									<%-- 										name="newAssignmentForm" value="project">Project</html:radio> --%>
								</td>
							</tr>
							<tr>
								<td>Assign To</td>
								<td>:</td>
								<td><div class="pr" class="in-bl">
										<div class="input-control text">
											<html:text property="assignmentBean.projectCode"
												name="newAssignmentForm" readonly="readonly"></html:text>
											<button type="button" class="btn-search" id="project"></button>
										</div>
									</div> <br />
									<div class="input-control text">
										<html:hidden property="assignmentBean.assignTo"
											name="newAssignmentForm" styleId="employee-domain" />
										<html:hidden property="assignmentBean.assignToFullName"
											name="newAssignmentForm" styleId="employee-fullName" />
										<input type="text" placeholder="Employee" id="employee-name"
											readonly="readonly" />
										<button type="button" class="btn-search" id="employee"></button>
									</div></td>
							</tr>
							<tr>
								<td>Reff Task Code</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text property="assignmentBean.reffTaskCode"
											name="newAssignmentForm" readonly="readonly"></html:text>
										<button type="button" class="btn-search" id="task"></button>
									</div></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td><html:textarea property="assignmentBean.description"
										name="newAssignmentForm" styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right"><html:button
										property="save" onclick="javascript:flyToPage('save');"
										styleClass="button success">Save</html:button> <html:button
										property="assign" onclick="javascript:flyToPage('assign');"
										styleClass="button success">Assign</html:button> <html:button
										property="cancel" onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Cancel</html:button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="newTask" name="newAssignmentForm" />
		<html:hidden property="assignmentType" name="newAssignmentForm"
			styleId="assignment-type" />
	</html:form>

	<div id="lookUpEmployee" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" /></body>
</body>
</html>