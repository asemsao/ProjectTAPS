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
<script type="text/javascript">
	function flyToPage(task) {
		document.dashboardForm.task.value = task;
		document.dashboardForm.submit();
	}

	$(document).ready(function() {
		var task_code = $("#task-code").val();
		$("#historyComment").load("/ProjectTaps/ajax.do?mode=comments&task=comments&taskCode=" + task_code);
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
				<html:form action="/dashboard" method="POST">
					<html:hidden property="selfAssignBean.currentStatus" name="dashboardForm" styleId="status" />
					<html:hidden property="selfAssignBean.taskCode" name="dashboardForm" styleId="task-code" />
					<html:hidden property="task" name="dashboardForm" />
					<input type="hidden" name="tmpDescription" value="<bean:write property="selfAssignBean.description" name="dashboardForm" />" />
					<input type="hidden" name="tmpManHours" value="<bean:write property="selfAssignBean.manHours" name="dashboardForm" />" />
					<html:hidden property="selfAssignBean.assignTo" name="dashboardForm" />
					<html:hidden property="selfAssignBean.reportTo" name="dashboardForm" />
					<table class="table">
						<thead>
							<tr>
								<td colspan=4 class="text-center text-bold">
									<h3>Request For Approval Self Assignment</h3>
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Assignment Date</th>
								<td class="field-separator">:</td>
								<td colspan=2><bean:write property="selfAssignBean.assignmentDate" name="dashboardForm"></bean:write></td>

							</tr>
							<tr>
								<th class="field-form">Assignment Type</th>
								<td class="field-separator">:</td>
								<td colspan=2><bean:write property="selfAssignBean.assignmentType" name="dashboardForm"></bean:write></td>
							</tr>
							<%
								if (session.getAttribute("type").equals("PROJECT")) {
							%>
							<tr>
								<th class="field-form">Assign By</th>
								<td class="field-separator">:</td>
								<td><bean:write property="selfAssignBean.projectName" name="dashboardForm"></bean:write></td>
								<td><b>Report to </b> : <bean:write property="selfAssignBean.reportToFullName" name="dashboardForm"></bean:write></td>
							</tr>
							<%
								} else {
							%>
							<tr>
								<th class="field-form">Assign By</th>
								<td class="field-separator">:</td>
								<td><bean:write property="selfAssignBean.organizationName" name="dashboardForm" /></td>
								<td><b>Report to </b> : <bean:write property="selfAssignBean.headUserName" name="dashboardForm" />
								</td>
							</tr>
							<%
								}
							%>
							<tr>
								<th class="field-form">Activity Type</th>
								<td class="field-separator">:</td>
								<td><bean:write property="selfAssignBean.activityType" name="dashboardForm" /></td>
								<%
									if (session.getAttribute("adhoc").equals("ADHOC")) {
								%>
								<td><b>AdHoc to </b> : <bean:write property="selfAssignBean.adhocFullName" name="dashboardForm" />
								</td>
								<%
									}
								%>
							</tr>
							<tr>
								<th class="field-form">Reff Task Code</th>
								<td class="field-separator">:</td>
								<td colspan=2><bean:write property="selfAssignBean.reffTaskCode" name="dashboardForm" /></td>
							</tr>
							<tr>
								<th class="field-form">ManHours</th>
								<td class="field-separator">:</td>
								<td colspan=2><div class="input-control select">
										<html:select property="selfAssignBean.manHours" name="dashboardForm">
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
								<td colspan=2><html:textarea property="selfAssignBean.description" name="dashboardForm"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>

							<tr>
								<th class="field-form size3">Appraisal Star</th>
								<td class="field-separator">:</td>
								<td colspan=2>
									<div class="star-hider">
										<div class="rating-kiri" style="float: left;">
											<select id="rating-kiri" name="rating">
												<option value="-5">-5</option>
												<option value="-4">-4</option>
												<option value="-3">-3</option>
												<option value="-2">-2</option>
												<option value="-1">-1</option>
											</select>
										</div>

										<div class="rating-tengah" style="float: left;">
											<select id="rating-tengah" name="rating">
												<option value="0">0</option>
											</select>
										</div>

										<div class="rating-kanan" style="float: left;">
											<select id="rating-kanan" name="rating">
												<option value="1">+1</option>
												<option value="2">+2</option>
												<option value="3">+3</option>
												<option value="4">+4</option>
												<option value="5">+5</option>
											</select>
										</div>

										<p class="star"></p>
										<html:hidden property="selfAssignBean.appraisalStar" styleId="star" />
										<button type="button" id="edit-star-btn" class="default">Edit</button>

									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Comment</th>
								<td class="field-separator">:</td>
								<td colspan=2><html:textarea
										property="selfAssignBean.comment" name="dashboardForm"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=4 class="text-right">
									<button onclick="javascript:flyToPage('approvedSelf');" class="button success">Approve</button>
									<button onclick="javascript:flyToPage('correctionSelf');" class="button warning">Correction</button>
									<button onclick="javascript:flyToPage('rejectSelf');" class="button danger">Reject</button>
									<button onclick="javascript:flyToPage('cancel');" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
				<div id="historyComment"></div>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
