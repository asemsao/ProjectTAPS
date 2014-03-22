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
		$("#timepicker").timeselector();
		$("#assignmentDate").attr("placeholder", "Assignment Date");
		$("#timepicker").attr("placeholder", "Assignment Time");
		$("#description").attr("placeholder", "Description");
	});
</script>

<title>Claim Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/dashboard" method="post">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<td colspan=4 class="text-center text-bold"><h3>Claim
										Assignment</h3></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td colspan=2><bean:write
										property="claimBean.assignmentDate" name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Assignment Due Date</td>
								<td>:</td>
								<td colspan=2><bean:write
										property="claimBean.assignmentDueDate" name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td colspan=2><bean:write
										property="claimBean.assignmentType" name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Assign To</td>
								<td>:</td>
								<td><bean:write property="claimBean.assignToFullName"
										name="dashboardForm" /></td>
								<td><b>Assignment From </b> : <bean:write
										property="claimBean.reportToFullName" name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Reff Assignment</td>
								<td>:</td>
								<td colspan=2><bean:write property="claimBean.reffTaskCode"
										name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td colspan=2><bean:write property="claimBean.description"
										name="dashboardForm" /></td>
							</tr>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td colspan=2><div class="input-control text"
										id="datepicker">
										<html:text property="claimBean.claimDate" name="dashboardForm"
											styleId="assignmentDate" styleClass="datepicker-back" />
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Time</td>
								<td>:</td>
								<td colspan=2><div class="input-control text">
										<html:text property="claimBean.claimTime"
											name="dashboardForm" styleId="timepicker" readonly="readonly"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>ManHours</td>
								<td>:</td>
								<td colspan=2>
									<div class="input-control select">
										<html:select name="dashboardForm"
											property="claimBean.manHours">
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
								<td colspan=2><html:textarea
										property="claimBean.detailDescription" name="dashboardForm"
										rows="3" styleId="description" styleClass="input-control textarea">
									</html:textarea></td>
							</tr>
							<tr>
								<td colspan=4 class="text-right">
									<button onclick="javascript:flyToPage('claim');"
										class="button success">Claim</button>
									<button onclick="javascript:flyToPage('rfa');"
										class="button success">RFA</button>
									<button onclick="javascript:flyToPage('cancel');"
										class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="dashboardForm" />
		<html:hidden property="claimBean.taskCode" name="dashboardForm" />
		<html:hidden property="claimBean.assignTo" name="dashboardForm" />
		<html:hidden property="claimBean.reportTo" name="dashboardForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
