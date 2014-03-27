<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX ACTIVE DIRECTORY</title>
</head>
<body>
	<html:form action="/ajax" method="post">
		<html:hidden property="task" styleId="task-ActiveDirectory"
			name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-ActiveDirectory"
			name="ajaxForm" />
		<html:hidden property="page" styleId="page-ActiveDirectory"
			name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-ActiveDirectory"
			name="ajaxForm" />
		<table class="table">
				<tr>
					<th colspan=5 class="text-center">Employee List</th>
				</tr>
				<tr>
					<th class="text-center" colspan=2>
						<div class="input-control select">
							<html:select property="searchCategory" name="ajaxForm"
								styleClass="search-category-ActiveDirectory">
								<html:option value="">All</html:option>
								<html:option value="employeeDomain">Employee Domain</html:option>
								<html:option value="employeeName">Employee Name</html:option>
							</html:select>
						</div>
					</th>
					<th class="text-center" colspan=3>
						<div class="input-control text">
							<html:text property="searchKeyword" name="ajaxForm"
								styleClass="search-keyword-ActiveDirectory"
								onkeydown="if (event.keyCode == 13){ javascript:pagingActiveDirectory('search'); return false;}"></html:text>
							<button type="button" class="btn-search"
								onclick="javascript:pagingActiveDirectory('search');"></button>
						</div>
					</th>
				</tr>
		</table>
		<div id="table-ajax-ActiveDirectory">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Choose</th>
						<th class="text-center">Domain</th>
						<th class="text-center">Name</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listAD">
						<logic:iterate id="employee" name="ajaxForm"
							property="listAD">
							<tr>
								<td class="text-center"><input type='radio'
									name='ad_choose'
									value='<bean:write name="employee"
										property="userDomain" />' />
								</td>
								<td class="text-center"><bean:write name="employee"
										property="userDomain" /></td>
								<td><bean:write name="employee" property="fullName" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listAD">
						<tr>
							<td class="text-center" colspan=5>Data not found</td>
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
								<li class="first"><a
									onclick="javascript:pagingActiveDirectory('first');"><i
										class="icon-first-2"></i></a></li>
								<li class="prev"><a
									onclick="javascript:pagingActiveDirectory('prev');"><i
										class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span
										id="current-page-ActiveDirectory"><bean:write name="ajaxForm"
												property="page" /></span> of <span id="max-page-ActiveDirectory"><bean:write
												name="ajaxForm" property="maxpage" /></span></a></li>
								<li class="next"><a
									onclick="javascript:pagingActiveDirectory('next');"><i
										class="icon-next"></i></a></li>
								<li class="last"><a
									onclick="javascript:pagingActiveDirectory('last');"><i
										class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span
										id="total-record-ActiveDirectory"><bean:write name="ajaxForm"
												property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
					<th class="text-center"><button type="button"
							class='button success' onclick="javascript:chooseActiveDirectory()">Add</button></th>
				</tr>
		</table>
	</html:form>
</body>
</html>