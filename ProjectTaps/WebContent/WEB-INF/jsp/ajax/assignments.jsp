<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AJAX ASSIGNMENT</title>
</head>

<body class="metro">
	<html:form action="/ajax" method="post">
		<html:hidden property="task" styleId="task-assignment" name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-assignment" name="ajaxForm" />
		<html:hidden property="page" styleId="page-assignment" name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-assignment"
			name="ajaxForm" />
		<html:hidden property="assignmentCategory"
			styleId="assignmentCategory-assignment" name="ajaxForm" />
		<html:hidden property="assignmentType"
			styleId="assignmentType-assignment" name="ajaxForm" />
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=7 class="text-center">Assignment List</th>
				</tr>
				<tr>
					<th class="text-center" colspan=2>
						<div class="input-control select">
							<html:select property="searchCategory" name="ajaxForm"
								styleClass="search-category-assignment">
								<html:option value="All">All</html:option>
								<html:option value="taskCode">Assignment Code</html:option>
								<html:option value="taskType">Assignment Category</html:option>
								<html:option value="employee">Employee Name</html:option>
							</html:select>
						</div>
					</th>
					<th class="text-center" colspan=5>
						<div class="input-control text">
							<html:text property="searchKeyword" name="ajaxForm"
								styleClass="search-keyword-assignment"
								onkeydown="if (event.keyCode == 13){ javascript:pagingAssignment('search'); return false;}"></html:text>
							<button type="button" class="btn-search"
								onclick="javascript:pagingAssignment('search');"></button>
						</div>
					</th>
				</tr>
			</thead>
		</table>
		<div id="table-ajax-assignment">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Choose</th>
						<th class="text-center">Date</th>
						<th class="text-center">Code</th>
						<th class="text-center">Type</th>
						<th class="text-center">Employee</th>
						<th class="text-center">Deadline</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listEmployeeReport">
						<logic:iterate id="assignment" name="ajaxForm"
							property="listEmployeeReport">
							<tr>
								<td class="text-center"><input type='radio'
									name='assignment_choose'
									value='<bean:write name="assignment"
										property="assignmentCode" />' />
								</td>

								<td class="text-center"><bean:write name="assignment"
										property="assignmentDate" /></td>
								<td class="text-center"><bean:write name="assignment"
										property="assignmentCode" /></td>
								<td class="text-center"><bean:write name="assignment"
										property="assignmentCategory" /></td>
								<td><bean:write name="assignment" property="fullName" /></td>
								<td class="text-center"><bean:write name="assignment"
										property="assignmentDueDate" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listEmployeeReport">
						<tr>
							<td class="text-center" colspan=6>Data not found</td>
						</tr>
					</logic:empty>
				</tbody>
			</table>
		</div>
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=3 class="text-center">
						<div class="pagination">
							<ul>
								<li class="first"><a
									onclick="javascript:pagingAssignment('first');"><i
										class="icon-first-2"></i></a></li>
								<li class="prev"><a
									onclick="javascript:pagingAssignment('prev');"><i
										class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span
										id="current-page-assignment"><bean:write
												name="ajaxForm" property="page" /></span> of <span
										id="max-page-assignment"><bean:write name="ajaxForm"
												property="maxpage" /></span></a></li>
								<li class="next"><a
									onclick="javascript:pagingAssignment('next');"><i
										class="icon-next"></i></a></li>
								<li class="last"><a
									onclick="javascript:pagingAssignment('last');"><i
										class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span
										id="total-record-assignment"><bean:write
												name="ajaxForm" property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
					<th class="text-center"><button type="button"
							class='button success' onclick="javascript:chooseAssignment()">Add</button></th>
				</tr>
			</thead>
		</table>
	</html:form>
</body>

</html>