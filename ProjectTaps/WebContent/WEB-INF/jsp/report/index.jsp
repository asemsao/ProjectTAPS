<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!doctype html>
<html>
<head>
<jsp:include page="/js/import.jsp" />
<script type="text/javascript">
	function report(task) {
		if (task == "cancel") {
			document.reportForm.task.value = "";
			document.reportForm.submit();
			return;
		} else {
			document.reportForm.task.value = task;
			reportValidation();
		}
	}
	
	function report(task,organizationCode) {
		if (task == "cancel") {
			document.reportForm.task.value = "";
			document.reportForm.submit();
			return;
		} else {
			document.reportForm.buPrint.value = organizationCode;
			document.reportForm.task.value = task;
			reportValidation();
		}
	}

	$(document).ready(function() {
						$("#reportYear").attr("placeholder", "Year");
					});
</script>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Taps</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/report" method="POST" styleClass="reportForm">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
							<tr>
								<th colspan=3 class="text-center"><h3>Generate Report</h3></th>
							</tr>
							<tr>
								<th class="field-form">Year</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:text name="reportForm" property="reportYear" styleClass="datepicker-year"
											styleId="reportYear"></html:text>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Period</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <html:radio name="reportForm"
												styleId="defaultCheck" styleClass="reportFormCheck"
												property="periode" value="6 Months"></html:radio> <span
											class="check"></span> Semester
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <html:radio name="reportForm"
												styleClass="reportFormCheck" property="periode"
												value="1 Months"></html:radio> <span class="check"></span>
											Monthly
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Choose</th>
								<td class="field-separator">:</td>
								<td colspan="1">

									<div id="6month">
										<div class="input-control select">
											<html:select property="reportPeriode" styleId="reportPeriode"
												name="reportForm">
												<html:option value="">Semester</html:option>
												<html:option value="I">First</html:option>
												<html:option value="II">Second</html:option>
											</html:select>
										</div>
									</div>

									<div id="1month">
										<div class="input-control select">
											<html:select property="reportMonth" styleId="reportMonth"
												name="reportForm">
												<html:option value="">Month</html:option>
												<html:option value="01">January</html:option>
												<html:option value="02">February</html:option>
												<html:option value="03">March</html:option>
												<html:option value="04">April</html:option>
												<html:option value="05">May</html:option>
												<html:option value="06">June</html:option>
												<html:option value="07">July</html:option>
												<html:option value="08">August</html:option>
												<html:option value="09">September</html:option>
												<html:option value="10">October</html:option>
												<html:option value="11">November</html:option>
												<html:option value="12">December</html:option>
											</html:select>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<% if (session.getAttribute("organizationLevel").equals("0")) {
												%>
												<button class="primary"
									onclick="javascript:report('printReportBOM','<%=session.getAttribute("organizationCode")%>')">Generate
									Report Management</button>
												<% } %>
		<%-- 							<logic:equal name="reportForm" property="organizationLevel" value="0"> --%>
		<!-- 								<button id="back-btn" onclick="javascript:button('back')">Home</button> -->
		<%-- 							</logic:equal> --%>
									<% if (session.getAttribute("organizationLevel").equals("1")) {
												%>
												<button class="primary" onclick="javascript:report('printReportBU','<%=session.getAttribute("organizationCode")%>')">Generate
									Report Business Unit</button>
												<% } %>
												<% if (session.getAttribute("organizationLevel").equals("2")) {
												%>
												<button class="primary" onclick="javascript:report('printReportDept','<%=session.getAttribute("organizationCode")%>')">Generate
									Report Department</button>
												<% } %>
									<button onclick="report('view');" class="info">View Report</button>
								</td>
							</tr>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="reportForm" />
		<html:hidden property="buPrint" name="reportForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
