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
		document.dashboardForm.task.value = task;
		document.dashboardForm.submit();
	}
	function flyToPage(task, taskCode, taskType, currentStatus) {
		document.dashboardForm.task.value = task;
		document.dashboardForm.taskCode.value = taskCode;
		document.dashboardForm.taskType.value = taskType;
		document.dashboardForm.currentStatus.value = currentStatus;
		document.dashboardForm.submit();
	}
</script>

</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/dashboard" method="post">
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
										<html:text property="startDate" name="dashboardForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th colspan=2 class="text-center">Assignment Deadline To</th>
								<th colspan=5>
									<div class="input-control text" id="datepicker-end">
										<html:text property="endDate" name="dashboardForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th colspan=2 class="text-center">
									<div class="input-control select">
										<html:select property="category" name="dashboardForm">
											<html:option value="All">All</html:option>
											<html:option value="taskCode">Assignment Code</html:option>
											<html:option value="taskType">Assignment Category</html:option>
											<html:option value="employee">Employee Name</html:option>
										</html:select>
									</div>
								</th>

								<th colspan=5 class="text-center">
									<div class="input-control text">
										<html:text property="keyword" name="dashboardForm"
											styleId="searchKeyword"></html:text>
										<button class="btn-search"
											onclick="javascript:flyToPage('search');"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="text-center">Assignment Date</th>
								<th class="text-center">Assignment Code</th>
								<th class="text-center">Assignment Category</th>
								<th class="text-center">Employee Name</th>
								<th class="text-center">Deadline</th>
								<th class="text-center">Data Created</th>
								<th class="text-center">Status</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listAssignment" name="dashboardForm">
								<logic:iterate id="assignment" name="dashboardForm"
									property="listAssignment">
									<logic:equal property="flag" name="assignment" value="INACTIVE">
										<tr>
											<td class="text-center text-bold text-italic"><bean:write
													property="assignmentDate" name="assignment" /></td>
											<td class="text-center text-bold text-italic"><bean:write property="taskCode"
													name="assignment" /></td>
											<td class="text-center text-bold text-italic"><bean:write
													property="assignmentCategory" name="assignment" /></td>
											<td class="text-bold text-italic"><bean:write property="fullName" name="assignment" /></td>
											<td class="text-center text-bold text-italic"><bean:write
													property="assignmentDueDate" name="assignment" /></td>
											<td class="text-center text-bold text-italic"><bean:write
													property="createdDate" name="assignment" /></td>
											<td class="text-center text-bold text-italic"><a
												href="javascript:flyToPage('view', '<bean:write property="taskCode"
												name="assignment" />', '<bean:write property="assignmentCategory"
												name="assignment" />','<bean:write
													property="currentStatus" name="assignment" />' );"><bean:write
														property="currentStatus" name="assignment" /></a></td>
										</tr>
									</logic:equal>
									<logic:equal property="flag" name="assignment" value="ACTIVE">
										<tr>
											<td class="text-center"><bean:write
													property="assignmentDate" name="assignment" /></td>
											<td class="text-center"><bean:write property="taskCode"
													name="assignment" /></td>
											<td class="text-center"><bean:write
													property="assignmentCategory" name="assignment" /></td>
											<td><bean:write property="fullName" name="assignment" /></td>
											<td class="text-center"><bean:write
													property="assignmentDueDate" name="assignment" /></td>
											<td class="text-center"><bean:write
													property="createdDate" name="assignment" /></td>
											<td class="text-center"><a
												href="javascript:flyToPage('view', '<bean:write property="taskCode"
												name="assignment" />', '<bean:write property="assignmentCategory"
												name="assignment" />','<bean:write
													property="currentStatus" name="assignment" />' );"><bean:write
														property="currentStatus" name="assignment" /></a></td>
										</tr>
									</logic:equal>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listAssignment" name="dashboardForm">
								<tr>
									<td colspan="7">Data Not Found</td>
								</tr>
							</logic:empty>
							<tr>
								<td colspan=7 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a
												href="javascript:flyToPage('first');"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a href="javascript:flyToPage('prev');"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write
														name="dashboardForm" property="page" /> of <bean:write
														name="dashboardForm" property="maxPage" /></a></li>
											<li class="next"><a href="javascript:flyToPage('next');"><i
													class="icon-next"></i></a></li>
											<li class="last"><a href="javascript:flyToPage('last');"><i
													id="last" class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <bean:write
														name="dashboardForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="dashboardForm" />
		<html:hidden property="taskCode" name="dashboardForm" />
		<html:hidden property="taskType" name="dashboardForm" />
		<html:hidden property="currentStatus" name="dashboardForm" />
		<html:hidden property="page" name="dashboardForm" />
		<html:hidden property="maxPage" name="dashboardForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
