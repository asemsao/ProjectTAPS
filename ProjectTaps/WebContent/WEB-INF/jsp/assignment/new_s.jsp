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
<script type="text/javascript">
	function flyToPage(task) {
		if (task == "cancel") {
			document.selfAssignmentForm.newTask.value = "";
			document.selfAssignmentForm.submit();
			return;
		} else if (task == "save") {
			document.selfAssignmentForm.newTask.value = task;
			document.selfAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
			document.selfAssignmentForm.activityType.value = getRadioValue("activity_type");
			newSelfAssignmentValidation();
		} else if (task == "RFA") {
			document.selfAssignmentForm.newTask.value = task;
			document.selfAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
			document.selfAssignmentForm.activityType.value = getRadioValue("activity_type");
			newSelfAssignmentValidation();
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

	function setReportTo() {
		var project_code = $("#project-code").val();
		var data = "newTask=retreiveReportTo&projectCode=" + project_code;
		$.ajax({
			url : "/ProjectTaps/newSelfAssignment.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				if (json == null) {
					$("#employee-domain").val("");
					$("#employee-name").val("");
				} else {
					$("#employee-domain").val(json.reportTo);
					$("#employee-name").val(json.reportToFullName);
				}

			}
		});
	}
	$(document)
			.ready(
					function() {
						var project_code = $("#project-code").val();
						var organization_code = $("#organization-code-view")
								.val();
						var userDomain = $("#userDomain").val();

						$("#employee-name").val($("#employee-fullName").val());
						$("#employee-name-2").val(
								$("#employee-fullName-2").val());
						$("#lookUpEmployeeOnProject")
								.load(
										"/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode="
												+ project_code);
						$("#lookUpProject").load(
								"/ProjectTaps/ajax.do?mode=projects&task=projects&userDomain="
										+ userDomain);
						$("#lookUpEmployee2")
								.load(
										"/ProjectTaps/ajax.do?mode=employees2&task=employees2");
						$("#lookUpAssignment")
								.load(
										"/ProjectTaps/ajax.do?mode=newSelfAssignments&task=assignments&assignmentCategory=self%20assignment&assignmentType=bu");
						$('#project-name')
								.bind(
										"change",
										function() {
											setReportTo();
											var project_code = $(
													"#project-code").val();
											$("#lookUpEmployeeOnProject").html(
													'');
											$("#lookUpEmployeeOnProject")
													.load(
															"/ProjectTaps/ajax.do?mode=employeesOnProject&task=employeesOnProject&projectCode="
																	+ project_code);

										});
						$("input[name='assignment_type']")
								.change(
										function() {
											if ($(this).val() == "PROJECT") {
												$("#lookUpAssignment")
														.load(
																"/ProjectTaps/ajax.do?mode=newSelfAssignments&task=assignments&assignmentCategory=self%20assignment&assignmentType=project");
											} else {
												$("#lookUpAssignment")
														.load(
																"/ProjectTaps/ajax.do?mode=newSelfAssignments&task=assignments&assignmentCategory=self%20assignment&assignmentType=bu");
											}
										});

						$("#assignmentDate").attr("placeholder",
								"Assignment Date");
						$("#project-name").attr("placeholder", "Project");
						$("#employee-name").attr("placeholder", "Employee");
						$("#employee-name-2").attr("placeholder", "Employee");
						$("#assignment-code").attr("placeholder",
								"Reff Task Code");
						$("#description").attr("placeholder", "Description");
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>New Self Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/newSelfAssignment" method="POST"
		styleId="newSelfAssignment">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>New Self
										Assignment</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td><div class="input-control text" id="datepicker">
										<html:text property="selfAssignBean.assignmentDate"
											name="selfAssignmentForm" styleId="assignmentDate"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											checked="checked" value="BU" /> <span class="check"></span>
											Business Unit
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											value="PROJECT" /> <span class="check"></span> Project
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td>Assign By</td>
								<td>:</td>
								<td><div id="bu">
										<bean:write property="selfAssignBean.organizationName"
											name="selfAssignmentForm" />
										&nbsp;&nbsp; <b>Report to </b> :
										<bean:write property="selfAssignBean.headUserName"
											name="selfAssignmentForm" />
									</div>
									<div class="pr">
										<div class="input-control text">
											<html:hidden property="selfAssignBean.projectCode"
												name="selfAssignmentForm" styleId="project-code"></html:hidden>
											<html:text property="selfAssignBean.projectName"
												readonly="true" name="selfAssignmentForm"
												styleId="project-name"></html:text>
											<button type="button" class="btn-search" id="project"></button>
										</div>
									</div></td>
							</tr>
							<tr class="pr">
								<td>Report To</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="selfAssignBean.reportTo"
											name="selfAssignmentForm" styleId="employee-domain" />
										<html:text property="selfAssignBean.reportToFullName"
											readonly="true" name="selfAssignmentForm"
											styleId="employee-name" />
										<button type="button" class="btn-search"
											id="employeeOnProject"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td>Activity Type</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											checked="checked" value="Routine" /> <span class="check"></span>
											Routine
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											value="Initiative" /> <span class="check"></span> Initiative
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											value="ADHOC" /> <span class="check"></span> AdHoc
										</label>
									</div>
								</td>
							</tr>
							<tr class="adhoc">
								<td>Ad Hoc To</td>
								<td>:</td>
								<td>
									<div class="input-control text">
										<html:hidden property="selfAssignBean.adhocUserDomain"
											name="selfAssignmentForm" styleId="employee-domain-2" />
										<html:text property="selfAssignBean.adhocFullName"
											readonly="true" name="selfAssignmentForm"
											styleId="employee-name-2" />
										<button type="button" class="btn-search" id="employee2"></button>
									</div>
								</td>
							</tr>
							<tr>
								<td>Reff Task Code</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text property="selfAssignBean.reffTaskCode"
											readonly="true" name="selfAssignmentForm"
											styleId="assignment-code"></html:text>
										<button type="button" class="btn-search" id="assigment"></button>
									</div></td>
							</tr>
							<tr>
								<td>ManHours</td>
								<td>:</td>
								<td>
									<div class="input-control select">
										<html:select property="selfAssignBean.manHours"
											name="selfAssignmentForm">
											<html:option value="">00:00</html:option>
											<html:option value="0.5">00:30</html:option>
											<html:option value="1.0">01:00</html:option>
											<html:option value="1.5">01:30</html:option>
											<html:option value="2.0">02:00</html:option>
											<html:option value="2.5">02:30</html:option>
											<html:option value="3.0">03:00</html:option>
											<html:option value="3.5">03:30</html:option>
											<html:option value="4.0">04:00</html:option>
											<html:option value="4.5">04:30</html:option>
											<html:option value="5.0">05:00</html:option>
											<html:option value="5.5">05:30</html:option>
											<html:option value="6.0">06:00</html:option>
											<html:option value="6.5">06:30</html:option>
											<html:option value="7.0">07:00</html:option>
											<html:option value="7.5">07:30</html:option>
											<html:option value="8.0">08:00</html:option>
											<html:option value="8.5">08:30</html:option>
											<html:option value="9.0">09:00</html:option>
											<html:option value="9.5">09:30</html:option>
											<html:option value="10.0">10:00</html:option>
											<html:option value="10.5">10:30</html:option>
											<html:option value="11.0">11:00</html:option>
											<html:option value="11.5">11:30</html:option>
											<html:option value="12.0">12:00</html:option>
											<html:option value="12.5">12:30</html:option>
											<html:option value="13.0">13:00</html:option>
											<html:option value="13.5">13:30</html:option>
											<html:option value="14.0">14:00</html:option>
											<html:option value="14.5">14:30</html:option>
											<html:option value="15.0">15:00</html:option>
											<html:option value="15.5">15:30</html:option>
											<html:option value="16.0">16:00</html:option>
											<html:option value="16.5">16:30</html:option>
											<html:option value="17.0">17:00</html:option>
											<html:option value="17.5">17:30</html:option>
											<html:option value="18.0">18:00</html:option>
											<html:option value="18.5">18:30</html:option>
											<html:option value="19.0">19:00</html:option>
											<html:option value="19.5">19:30</html:option>
											<html:option value="20.0">20:00</html:option>
											<html:option value="20.5">20:30</html:option>
											<html:option value="21.0">21:00</html:option>
											<html:option value="21.5">21:30</html:option>
											<html:option value="22.0">22:00</html:option>
											<html:option value="22.5">22:30</html:option>
											<html:option value="23.0">23:00</html:option>
											<html:option value="23.5">23:30</html:option>
											<html:option value="24.0">24:00</html:option>
										</html:select>
									</div>
								</td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td><html:textarea property="selfAssignBean.description"
										name="selfAssignmentForm" styleClass="input-control textarea"
										styleId="description"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right">
									<button onclick="flyToPage('save')" class="button success">Save</button>
									<button onclick="flyToPage('RFA')" class="button success">RFA</button>
									<button onclick="flyToPage('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="newTask" name="selfAssignmentForm" />
		<html:hidden property="assignmentType" name="selfAssignmentForm" />
		<html:hidden property="activityType" name="selfAssignmentForm" />
		<html:hidden property="selfAssignBean.detailId"
			name="selfAssignmentForm" />
		<html:hidden property="selfAssignBean.headUserDomain"
			name="selfAssignmentForm" />

		<!-- ini nanti ambil session -->
		<input type="hidden" id="organization-code-view" value="CDD" />
		<input type="hidden" id="userDomain" value="DOMAIN205" />
	</html:form>

	<div id="lookUpProject" class="hide"></div>
	<div id="lookUpEmployeeOnProject" class="hide"></div>
	<div id="lookUpEmployee2" class="hide"></div>
	<div id="lookUpAssignment" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
