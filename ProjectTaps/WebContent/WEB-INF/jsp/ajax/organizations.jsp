<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX ORGANIZATIONS</title>
</head>
<body>
	<html:form action="/ajax" method="post">
		<html:hidden property="task" styleId="task-organization"
			name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-organization"
			name="ajaxForm" />
		<html:hidden property="page" styleId="page-organization"
			name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-organization"
			name="ajaxForm" />
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=5 class="text-center">Organization List</th>
				</tr>
				<tr>
					<th class="text-center" colspan=2>
						<div class="input-control select">
							<html:select property="searchCategory" name="ajaxForm"
								styleClass="search-category-organization">
								<html:option value="all">All</html:option>
								<html:option value="organizationCode">Organization Code</html:option>
								<html:option value="organizationName">Organization Name</html:option>
								<html:option value="headName">Head Name</html:option>
							</html:select>
						</div>
					</th>
					<th class="text-center" colspan=3>
						<div class="input-control text">
							<html:text property="searchKeyword" name="ajaxForm"
								styleClass="search-keyword-organization"
								onkeydown="if (event.keyCode == 13){ javascript:pagingOrganization('search'); return false;}"></html:text>
							<button type="button" class="btn-search"
								onclick="javascript:pagingOrganization('search');"></button>
						</div>
					</th>
				</tr>
			</thead>
		</table>
		<div id="table-ajax-organization">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Choose</th>
						<th class="text-center">Organization Code</th>
						<th class="text-center">Organization Name</th>
						<th class="text-center">Head Name</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listOrganizations">
						<logic:iterate id="organization" name="ajaxForm"
							property="listOrganizations">
							<tr>
								<td class="text-center"><input type='radio'
									name='organization_choose'
									value='<bean:write name="organization"
										property="organizationCode" />@<bean:write name="organization"
										property="organizationName" />' />
								</td>
								<td><bean:write name="organization"
										property="organizationCode" /></td>
								<td><bean:write name="organization"
										property="organizationName" /></td>
								<td><bean:write name="organization" property="headName" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listOrganizations">
						<tr>
							<td class="text-center" colspan=4>Data not found</td>
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
									onclick="javascript:pagingOrganization('first');"><i
										class="icon-first-2"></i></a></li>
								<li class="prev"><a
									onclick="javascript:pagingOrganization('prev');"><i
										class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span
										id="current-page-organization"><bean:write name="ajaxForm"
												property="page" /></span> of <span id="max-page-organization"><bean:write
												name="ajaxForm" property="maxpage" /></span></a></li>
								<li class="next"><a
									onclick="javascript:pagingOrganization('next');"><i
										class="icon-next"></i></a></li>
								<li class="last"><a
									onclick="javascript:pagingOrganization('last');"><i
										class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span
										id="total-record-organization"><bean:write name="ajaxForm"
												property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
					<th class="text-center"><button type="button"
							class='button success' onclick="javascript:chooseOrganization()">Add</button></th>
				</tr>
			</thead>
		</table>
	</html:form>
</body>
</html>