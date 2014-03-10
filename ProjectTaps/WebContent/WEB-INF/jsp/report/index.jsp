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
	alert(task);
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
								<td>Period</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="period_type"
											value="6 Months"  checked="checked" /> <span class="check"></span> 6 Months
										</label>
									</div>
									<div class="input-control radio margin10">

										<label> <input type="radio" name="period_type"
											value="1 Month" /> <span class="check"></span> 1 Month
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td>Choose</td>
								<td>:</td>
								<td>
									<div id="6month" class="auto-complete">
										<div class="control-group">
											<select id="select-semester" required
												class="demo-default size2">
												<option value="">Semester</option>
												<option value="first semester">First Semester</option>
												<option value="last semester">Last Semester</option>
											</select>
										</div>
									</div>

									<div id="1month" class="auto-complete">	
										<div class="control-group">
											<select id="select-month" required class="demo-default size2">
												<option value="">Month</option>
												<option value="january">January</option>
												<option value="february">February</option>
												<option value="march">March</option>
												<option value="april">April</option>
												<option value="may">May</option>
												<option value="june">June</option>
												<option value="july">July</option>
												<option value="august">August</option>
												<option value="september">September</option>
												<option value="october">October</option>
												<option value="november">November</option>
												<option value="december">December</option>
											</select>
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