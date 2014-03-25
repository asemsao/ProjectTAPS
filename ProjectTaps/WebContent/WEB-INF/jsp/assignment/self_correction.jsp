<%@page import="adins.ace.taps.form.assignment.SelfAssignmentForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />
<script type="text/javascript">/* 
	function flyToPage(task) {
		document.selfAssignmentForm.task.value = task;
		document.getElementById("activity-type").value = getRadioValue("activity_type");
		document.selfAssignmentForm.submit();
	} */
	function flyToPage(task) {
		if (task == "cancel") {
			document.selfAssignmentForm.task.value = task;
			document.selfAssignmentForm.submit();
			return;
		} else if (task == "RFA") {
			document.selfAssignmentForm.task.value = task;
			document.getElementById("activity-type").value = getRadioValue("activity_type");
			newCorrectionAssignmentValidation();
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
		var task_code = $("#task-code").val();
		var activity_type = $("#activity-type").val();
		if (activity_type == "ADHOC"){
			$(".adhoc").show();
		}
		$("#lookUpEmployee").load("/ProjectTaps/ajax.do?mode=employees&task=employees");
		$("input[name=activity_type][value=" + activity_type + "]").attr('checked', 'checked');
		$("#historyComment").load("/ProjectTaps/ajax.do?mode=comments&task=comments&taskCode=" + task_code);
		$("#employee-name").attr("placeholder", "Employee");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Self Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/selfAssignment" method="POST"  styleId="selfAssignment">
					<html:hidden property="selfAssignBean.taskCode" name="selfAssignmentForm" styleId="task-code" />
					<html:hidden property="selfAssignBean.activityType" name="selfAssignmentForm" styleId="activity-type" />
					<html:hidden property="selfAssignBean.reportTo" name="selfAssignmentForm" />
					<html:hidden property="task" name="selfAssignmentForm" />
					<input type="hidden" name="tmpDescription" value="<bean:write property="selfAssignBean.description" name="selfAssignmentForm" />" />
					<input type="hidden" name="tmpManHours" value="<bean:write property="selfAssignBean.manHours" name="selfAssignmentForm" />" />
					<input type="hidden" name="tmpActivityType" value="<bean:write property="selfAssignBean.activityType" name="selfAssignmentForm" />" />
					<input type="hidden" name="tmpAdhocDomain" value="<bean:write property="selfAssignBean.adhocUserDomain" name="selfAssignmentForm" />" />
					<table class="table">
						<thead>
							<tr>
								<td colspan=5 class="text-center text-bold"><h3>
										<%
											if ("RFA".equals(session.getAttribute("status"))) {
										%>
										Request For Approval Self Assignment
										<%
											} else if ("APPROVED".equals(session.getAttribute("status"))) {
										%>
										Approved Self Assignment
										<%
											} else if ("CORRECTION".equals(session.getAttribute("status"))) {
										%>
										Correction Self Assignment
										<%
											} else if ("REJECTED".equals(session.getAttribute("status"))) {
										%>
										Rejected Self Assignment
										<%
											} else {
										%>
										View Self Assignment
										<%
											}
										%>
									</h3></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Assignment Date</th>
								<td class="field-separator">:</td>
								<td colspan=3><bean:write property="selfAssignBean.assignmentDate" name="selfAssignmentForm"></bean:write></td>

							</tr>
							<tr>
								<th class="field-form">Assignment Type</th>
								<td class="field-separator">:</td>
								<td colspan=3><bean:write property="selfAssignBean.assignmentType" name="selfAssignmentForm"></bean:write></td>
							</tr>
							<%
								if (session.getAttribute("type").equals("PROJECT")) {
							%>
							<tr>
								<th class="field-form">Assign By</th>
								<td class="field-separator">:</td>
								<td><bean:write property="selfAssignBean.projectName" name="selfAssignmentForm"></bean:write></td>
								<td class="field-extra-text"><b>Report to </b> : </td>
								<td class="field-text"><bean:write property="selfAssignBean.reportToFullName" name="selfAssignmentForm"></bean:write></td>
							</tr>
							<%
								} else {
							%>
							<tr>
								<th class="field-form">Assign By</th>
								<td class="field-separator">:</td>
								<td><bean:write property="selfAssignBean.organizationName" name="selfAssignmentForm" /></td>
								<td class="field-extra-text"><b>Report to </b> : </td>
								<td class="field-text"><bean:write property="selfAssignBean.headUserName" name="selfAssignmentForm" /></td>
							</tr>
							<%
								}
							%>
							<tr>
								<th class="field-form">Activity Type</th>
								<td class="field-separator">:</td>
								<%
									if ("CORRECTION".equals(session.getAttribute("status"))) {
								%>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type" value="Routine" /> <span class="check"></span>
											Routine
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type" value="Initiative" /> <span class="check"></span> 
											Initiative
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type" value="ADHOC" /> <span class="check"></span> 
											AdHoc
										</label>
									</div>
								</td>
								<td class="adhoc field-extra-text"><b>To :</b></td>
								<td>
									<div class="adhoc input-control text field-text">
										<html:hidden property="selfAssignBean.adhocUserDomain" name="selfAssignmentForm" styleId="employee-domain" />
										<html:text property="selfAssignBean.adhocFullName" readonly="true" name="selfAssignmentForm" styleId="employee-name" />
										<button type="button" class="btn-search" id="employee"></button>
									</div>
								</td>
								<%
									} else {
								%>
									<td><bean:write property="selfAssignBean.activityType" name="selfAssignmentForm" /></td>
									<td class="adhoc field-extra-text"><b>AdHoc to </b> : </td>
									<td class="adhoc field-text"><bean:write property="selfAssignBean.adhocFullName" name="selfAssignmentForm" /></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th class="field-form">Reff Task Code</th>
								<td class="field-separator">:</td>
								<td colspan=3><bean:write property="selfAssignBean.reffTaskCode" name="selfAssignmentForm" /></td>
							</tr>
							<%
								if ("RFA".equals(session.getAttribute("status"))
											|| "APPROVED".equals(session.getAttribute("status"))
											|| "REJECTED".equals(session.getAttribute("status"))) {
							%>
							<tr>
								<th class="field-form">ManHours</th>
								<td class="field-separator">:</td>
								<td colspan=3><div class="input-control select">
										<html:select property="selfAssignBean.manHours" name="selfAssignmentForm" disabled="true">
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
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Description</th>
								<td class="field-separator">:</td>
								<td colspan=3><html:textarea property="selfAssignBean.description" name="selfAssignmentForm" readonly="true"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%
								} else {
							%>
							<tr>
								<th class="field-form">ManHours</th>
								<td class="field-separator">:</td>
								<td colspan=3><div class="input-control select">
										<html:select property="selfAssignBean.manHours" name="selfAssignmentForm">
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
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Description</th>
								<td class="field-separator">:</td>
								<td colspan=3><html:textarea property="selfAssignBean.description"
										name="selfAssignmentForm" styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%
								}
							%>
							<%
								if ("CORRECTION".equals(session.getAttribute("status"))) {
							%>
							<tr>
								<th class="field-form">Comment</th>
								<td class="field-separator">:</td>
								<td colspan=3><html:textarea property="selfAssignBean.comment" name="selfAssignmentForm"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%
								}
							%>
							<%
								if ("CORRECTION".equals(session.getAttribute("status"))) {
							%>
							<tr>
								<td colspan=5 class="text-right">
									<button onclick="javascript:flyToPage('RFA')" class="button success">RFA</button> 
									<button onclick="javascript:flyToPage('cancel');" class="button info">Cancel</button></td>
							</tr>
							<%
								} else if ("RFA".equals(session.getAttribute("status"))
											|| "APPROVED".equals(session.getAttribute("status"))
											|| "REJECTED".equals(session.getAttribute("status"))) {
							%>
							<tr>
								<td colspan=5 class="text-right">
									<button onclick="javascript:flyToPage('cancel');" class="button info">Close</button></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</html:form>
				<div id="historyComment"></div>
				<div id="lookUpEmployee" class="hide"></div>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
