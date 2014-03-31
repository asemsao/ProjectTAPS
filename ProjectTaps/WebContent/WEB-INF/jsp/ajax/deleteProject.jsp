<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX DELETE PROJECT</title>
</head>
<body>
	<html:form action="/ajax" method="post">
		<html:hidden property="projectCode" styleId="projectCode-project-delete" name="ajaxForm" />
		<html:hidden property="task" styleId="task-project-delete" name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-project-delete" name="ajaxForm" />
		<html:hidden property="page" styleId="page-project-delete" name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-project-delete" name="ajaxForm" />
		<html:hidden property="assignmentCategory" styleId="assignmentCategory-project-delete" name="ajaxForm" />
		<html:hidden property="assignmentType" styleId="assignmentType-project-delete" name="ajaxForm" />
		<html:hidden property="paramProjectCode" name="ajaxForm" styleId="projectCode-project-delete"/>
		
		<table class="table striped bordered hovered">
			<tr>
				<th colspan=7 class="text-center">Pending Assignment List</th>
			</tr>
			<tr>
				<th class="text-center" colspan=2>
					<div class="input-control select">
						<html:select property="searchCategory" name="ajaxForm" styleClass="search-category-project-delete">
							<html:option value="All">All</html:option>
							<html:option value="taskCode">Assignment Code</html:option>
							<html:option value="taskType">Assignment Category</html:option>
							<html:option value="employee">Employee Name</html:option>
						</html:select>
					</div>
				</th>
				<th class="text-center" colspan=5>
					<div class="input-control text">
						<html:text property="searchKeyword" name="ajaxForm" styleClass="search-keyword-project-delete"
							onkeydown="if (event.keyCode == 13){ javascript:pagingProjectDelete('search'); return false;}"></html:text>
						<button type="button" class="btn-search" onclick="javascript:pagingProjectDelete('search');"></button>
					</div>
				</th>
			</tr>
		</table>
		<div id="table-ajax-project-delete">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Date</th>
						<th class="text-center">Code</th>
						<th class="text-center">Type</th>
						<th class="text-center">Report To</th>
						<th class="text-center">Deadline</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listEmployeeReport">
						<logic:iterate id="assignment" name="ajaxForm" property="listEmployeeReport">
							<tr>
								<td class="text-center"><bean:write name="assignment" property="assignmentDate" /></td>
								<td class="text-center"><bean:write name="assignment" property="assignmentCode" /></td>
								<td class="text-center"><bean:write name="assignment" property="assignmentCategory" /></td>
								<td><bean:write name="assignment" property="fullName" /></td>
								<td class="text-center"><bean:write name="assignment" property="assignmentDueDate" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listEmployeeReport">
						<tr>
							<td class="text-center" colspan=6>No Pending Assignment</td>
						</tr>
					</logic:empty>
				</tbody>
			</table>
		</div>
		<table class="table">
			<tr>
				<th colspan=3 class="text-center">
					<div class="pagination">
						<ul>
							<li class="first"><a onclick="javascript:pagingProjectDelete('first');">
								<i class="icon-first-2"></i></a></li>
							<li class="prev"><a onclick="javascript:pagingProjectDelete('prev');">
								<i class="icon-previous"></i></a></li>
							<li class="disabled"><a>Page <span id="current-page-project-delete">
								<bean:write name="ajaxForm" property="page" /></span> of <span id="max-page-project-delete">
								<bean:write name="ajaxForm" property="maxpage" /></span></a></li>
							<li class="next"><a onclick="javascript:pagingProjectDelete('next');">
								<i class="icon-next"></i></a></li>
							<li class="last"><a onclick="javascript:pagingProjectDelete('last');">
								<i class="icon-last-2"></i></a></li>
							<li class="disabled"><a>Total Record <span id="total-record-project-delete">
								<bean:write name="ajaxForm" property="countRecord" /></span></a></li>
						</ul>
					</div>
				</th>
				<th class="text-center">
					<button type="button" class='button danger' onclick="javascript:chooseProjectDelete('delete')">Delete</button>
					<button type="button" class='button info' onclick="javascript:chooseProjectDelete('cancel')">Cancel</button>
				</th>
			</tr>
		</table>
	</html:form>
</body>
</html>