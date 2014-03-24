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
<title>AJAX EMPLOYEES 2</title>
</head>

<body class="metro">
	<html:form action="/ajax" method="post">
		<html:hidden property="task" styleId="task-employee-2" name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-employee-2" name="ajaxForm" />
		<html:hidden property="page" styleId="page-employee-2" name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-employee-2"
			name="ajaxForm" />
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=5 class="text-center">Employee List</th>
				</tr>
				<tr>
					<th class="text-center" colspan=2>
						<div class="input-control select">
							<html:select property="searchCategory" name="ajaxForm"
								styleClass="search-category-employee-2">
								<html:option value="All">All</html:option>
								<html:option value="employeeDomain">Employee Domain</html:option>
								<html:option value="employeeCode">Employee Code</html:option>
								<html:option value="employeeName">Employee Name</html:option>
								<html:option value="employeeAddress">Employee Address</html:option>
							</html:select>
						</div>
					</th>
					<th class="text-center" colspan=3>
						<div class="input-control text">
							<html:text property="searchKeyword" name="ajaxForm"
								styleClass="search-keyword-employee-2"
								onkeydown="if (event.keyCode == 13){ javascript:pagingEmployee2('search'); return false;}"></html:text>
							<button type="button" class="btn-search"
								onclick="javascript:pagingEmployee2('search');"></button>
						</div>
					</th>
				</tr>
			</thead>
		</table>
		<div id="table-ajax-employee-2">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Choose</th>
						<th class="text-center">Domain</th>
						<th class="text-center">Code</th>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listEmployees2">
						<logic:iterate id="employee" name="ajaxForm"
							property="listEmployees2">
							<tr>
								<td class="text-center"><input type='radio'
									name='employee_choose2'
									value='<bean:write name="employee"
										property="employeeDomain" />@<bean:write name="employee"
										property="employeeName" />' />
								</td>
								<td class="text-center"><bean:write name="employee"
										property="employeeDomain" /></td>
								<td class="text-center"><bean:write name="employee"
										property="employeeCode" /></td>
								<td><bean:write name="employee" property="employeeName" /></td>
								<td><bean:write name="employee" property="employeeAddress" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listEmployees2">
						<tr>
							<td class="text-center" colspan=5>Data not found</td>
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
									onclick="javascript:pagingEmployee2('first');"><i
										class="icon-first-2"></i></a></li>
								<li class="prev"><a
									onclick="javascript:pagingEmployee2('prev');"><i
										class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span
										id="current-page-employee-2"><bean:write name="ajaxForm"
												property="page" /></span> of <span id="max-page-employee-2"><bean:write
												name="ajaxForm" property="maxpage" /></span></a></li>
								<li class="next"><a
									onclick="javascript:pagingEmployee2('next');"><i
										class="icon-next"></i></a></li>
								<li class="last"><a
									onclick="javascript:pagingEmployee2('last');"><i
										class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span
										id="total-record-employee-2"><bean:write name="ajaxForm"
												property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
					<th class="text-center"><button type="button"
							class='button success' onclick="javascript:chooseEmployee2()">Add</button></th>
				</tr>
			</thead>
		</table>
	</html:form>
</body>

</html>