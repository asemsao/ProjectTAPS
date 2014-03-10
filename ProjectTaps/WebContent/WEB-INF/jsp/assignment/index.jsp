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

<title>Assignment</title>

<script type="text/javascript">
	function flyToPage(task) {
		document.employeeReportForm.task.value = task;
		document.employeeReportForm.submit();
	}
</script>

</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th colspan=7 class="text-center"><h3>Employee Report</h3></th>
						</tr>
						<tr>
							<th colspan=2 class="text-center">Assignment Deadline From</th>
							<th colspan=5>
								<div class="input-control text" id="datepicker-begin">
									<html:text property="startDate" name="employeeReportForm"></html:text>
									<button class="btn-date"></button>
								</div>
							</th>
						</tr>
						<tr>
							<th colspan=2 class="text-center">Assignment Deadline To</th>
							<th colspan=5>
								<div class="input-control text" id="datepicker-end">
									<html:text property="endDate" name="employeeReportForm"></html:text>
									<button class="btn-date"></button>
								</div>
							</th>
						</tr>
						<tr>
							<th colspan=2 class="text-center">
								<div class="input-control select">
									<html:select property="search" name="employeeReportForm">
										<html:option value="">All</html:option>
										<html:option value="taskCode">Assignment Code</html:option>
										<html:option value="taskType">Assignment Type</html:option>
										<html:option value="employee">Employee Name</html:option>
									</html:select>
								</div>
							</th>
							<th colspan=5 class="text-center">
								<div class="input-control text">
									<html:text property="value" name="employeeReportForm"></html:text>
									<html:button property="btnSearch"
										onclick="javascript:flyToPage('search');"></html:button>
									<%-- 									<html:text property="value" name="employeeReportForm" --%>
									<%-- 										placeholder="Keyword of Assignment"></html:text> --%>
									<%-- 									<html:button property="btnSearch" class="btn-search" --%>
									<%-- 										onclick="javascript:flyToPage('search');" ></html:button> --%>
								</div>
							</th>
						</tr>
						<tr>
							<th class="text-center">Assignment Date</th>
							<th class="text-center">Assignment Code</th>
							<th class="text-center">Assignment Type</th>
							<th class="text-center">Employee Name</th>
							<th class="text-center">Deadline</th>
							<th class="text-center">Data Created</th>
							<th class="text-center">Status</th>
						</tr>
					</thead>
					<tbody>
						<logic:notEmpty property="listAssignment"
							name="employeeReportForm">
							<logic:iterate id="assignment" name="employeeReportForm"
								property="listAssignment">
								<tr>
									<td><bean:write property="assignmentDate"
											name="assignment" /></td>
									<td><bean:write property="assignmentCode"
											name="assignment" /></td>
									<td><bean:write property="assignmentCategory"
											name="assignment" /></td>
									<td><bean:write property="fullName" name="assignment" /></td>
									<td><bean:write property="assignmentDueDate"
											name="assignment" /></td>
									<td><bean:write property="createdDate" name="assignment" /></td>
									<td><bean:write property="currentStatus" name="assignment" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<logic:empty property="listAssignment" name="employeeReportForm">
							<tr>
								<td colspan="7">Data Not Found</td>
							</tr>
						</logic:empty>
						<tr>
							<td colspan=5 class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a><i class="icon-first-2"></i></a></li>
										<li class="prev"><a><i class="icon-previous"></i></a></li>
										<li><a>1</a></li>
										<li><a>2</a></li>
										<li class="active"><a>3</a></li>
										<li class="spaces"><a>...</a></li>
										<li class="disabled"><a>4</a></li>
										<li><a>500</a></li>
										<li class="next"><a><i class="icon-next"></i></a></li>
										<li class="last"><a><i class="icon-last-2"></i></a></li>
									</ul>
								</div>
							</td>
							<td colspan=2 class="text-right"><a href="new_s.jsp"
								data-hint="New Self Assignment" data-hint-position="bottom"><img
									alt=""
									src="<%=request.getContextPath()%>/images/ADD_ASSIGNMENTT.png"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
