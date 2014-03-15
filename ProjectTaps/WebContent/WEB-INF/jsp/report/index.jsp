<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!doctype html>
<html>
<head>
<script type="text/javascript">
function report(task) {
	document.reportForm.task.value = task;
	document.reportForm.submit();
}
</script>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="../../../js/import.jsp" />
<title>Taps</title>
</head>
<body class="metro">
<jsp:include page="../../../frame/header.jsp" />
	<html:form action="/report" method="POST" styleClass="reportForm">
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>Generate Report</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Year</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:text name="reportForm" property="reportYear"></html:text>
									</div></td>
							</tr>
							<tr>
								<td>Period</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> 
										<html:radio name="reportForm" styleId="defaultCheck" styleClass="reportFormCheck" property="periode" value="6 Months"></html:radio>
										<span class="check"></span> Semester
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <html:radio name="reportForm" styleClass="reportFormCheck" property="periode" value="1 Months"></html:radio>
										 <span class="check"></span> Monthly
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td>Choose</td>
								<td>:</td>
								<td colspan="1">
									
									<div id="6month">
										<div class="input-control select">
											<html:select property="reportPeriode"
												name="reportForm">
												<html:option value="">Semester</html:option>
												<html:option value="I">First</html:option>
												<html:option value="II">Second</html:option>
											</html:select>
										</div>
									</div>

									<div id="1month">
										<div class="input-control select">
												<html:select property="reportMonth"
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
									<button onclick="report('view');" class="success">Generate</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="reportForm" />
		</html:form>
	<jsp:include page="../../../frame/footer.jsp" />
</body>
</html>