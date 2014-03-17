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
<title>Taps</title>
<script type="text/javascript">
	$(document).ready(function() {
		setInterval(function() {
			$("#ar").val($("#ar").val() + "=");
		}, 1000);
	});

	function flyToPage(task) {
		document.dashboardForm.task.value = task;
		document.dashboardForm.submit();
	}
</script>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/dashboard" method="post">
					<html:hidden property="task" name="dashboardForm" />
					<h2 class="fg-steel">Things To Do</h2>
					<div class="input-control text">
						<input name="id" value="" id="ar">
					</div>
					<div class="span9 center-taps">
						<div id="auto-refresh">
							<a href="#" onclick="javascript:flyToPage('approval');"
								data-hint="Approval Assignment" data-hint-position="left"
								class="tile bg-cyan"> <span class="tile-content icon">
									<img alt="" src="images/APPROVAL_ASSIGNMENT.png">
							</span> <span class="brand"> <span class="badge bg-gray"><bean:write
											property="totalRFA" name="dashboardForm" /></span>
							</span>
							</a> <a href="#" onclick="javascript:flyToPage('approvalSelf');"
								data-hint="Approval Self Assignment" data-hint-position="left"
								class="tile bg-cyan"> <span class="tile-content icon">
									<img alt="" src="images/APPROVAL_NEW_ASSIGNMENT.png">
							</span> <span class="brand"> <span class="badge bg-gray"><bean:write
											property="totalRFAself" name="dashboardForm" /></span>
							</span>
							</a> <a href="#" onclick="javascript:flyToPage('claim');"
								id="_edit_this" data-hint="Claim Assignment"
								data-hint-position="left" class="tile bg-cyan"> <span
								class="tile-content icon"> <img alt=""
									src="images/CLAIM_ASSIGNMENT.png">
							</span> <span class="brand"> <span class="badge bg-red"><bean:write
											property="totalClaim" name="dashboardForm" /></span>
							</span>
							</a> <a href="#" onclick="javascript:flyToPage('correction');"
								data-hint="Correction Assignment" data-hint-position="left"
								class="tile bg-cyan"> <span class="tile-content icon">
									<img alt="" src="images/CORRECTION_ASSIGNMENT.png">
							</span> <span class="brand"> <span class="badge bg-gray"><bean:write
											property="totalCorrection" name="dashboardForm" /></span>
							</span>
							</a> <a href="#" onclick="javascript:flyToPage('correctionSelf');"
								data-hint="Correction Self Assignment" data-hint-position="left"
								class="tile bg-cyan"> <span class="tile-content icon">
									<img alt="" src="images/CORRECTION_NEW_ASSIGNMENT.png">
							</span> <span class="brand"> <span class="badge bg-gray"><bean:write
											property="totalCorrectionSelf" name="dashboardForm" /></span>
							</span>
							</a>
						</div>
					</div>
				</html:form>
			</div>

			<div class="row row-taps shadow-taps">
				<div class="span-ranking-taps">
					<h2 class="fg-steel">Top Ten Business Unit</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th colspan=2>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTenOrganization"
								name="dashboardForm">
								<logic:iterate id="employee" property="listTopTenOrganization"
									name="dashboardForm">
									<tr>
										<td class="text-center"><img src="images/test-ava.jpg"
											style="width: 30px; height: 45px;"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTenOrganization"
								name="dashboardForm">
								<tr>
									<td colspan="2">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
				</div>

				<div class="span-ranking-taps">
					<h2 class="fg-steel">Top Ten All</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTen" name="dashboardForm">
								<logic:iterate id="employee" property="listTopTen"
									name="dashboardForm">
									<tr>
										<td class="text-center"><img src="images/test-ava.jpg"
											style="width: 30px; height: 45px;"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTen" name="dashboardForm">
								<tr>
									<td colspan="2">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
