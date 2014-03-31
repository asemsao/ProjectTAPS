<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX DELETE BUSINESS UNIT</title>
</head>
<body>
	<html:form action="/ajax" method="post">
		<html:hidden property="organizationCode" styleId="organizationCode-delete" name="ajaxForm" />
		<html:hidden property="task" styleId="task-organization-delete" name="ajaxForm" />
		<html:hidden property="task" styleId="taskMember" name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-organization-delete" name="ajaxForm" />
		<html:hidden property="page" styleId="page-organization-delete" name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-organization-delete" name="ajaxForm" />

		<logic:notEqual name="ajaxForm" property="checkDeleteOrganization" value="0">
			<!-- TABEL ORG PROJECT -->
			<table class="table striped bordered hovered">
					<tr>
						<th colspan="3"><strong>Business Unit <bean:write name="ajaxForm" property="organizationCode" /> 
							Can't be deleted because has
						</strong></th>
					</tr>
					<logic:notEqual name="ajaxForm" property="countMemberOrganization" value="0">
						<tr>
							<td colspan="3"><strong><bean:write name="ajaxForm" property="countMemberOrganization" /> 
								members in Business Unit 
							</strong></td>
						</tr>
					</logic:notEqual>
					<logic:notEqual name="ajaxForm" property="countChildOrganization" value="0">
						<tr>
							<td colspan="3"><strong><bean:write name="ajaxForm" property="countChildOrganization" /> 
								Child BU in Business Unit 
							</strong></td>
						</tr>
					</logic:notEqual>
			</table>

			<div id="table-ajax-organization-delete">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<td colspan="3"><strong>Project</strong></td>
						</tr>
						<tr>
							<th class="text-center">Project Code</th>
							<th class="text-center">Project Name</th>
						</tr>
					</thead>
					<tbody>
						<logic:notEmpty name="ajaxForm" property="organizationProject">
							<logic:iterate id="project" name="ajaxForm" property="organizationProject">
								<tr>
									<td class="text-center"><bean:write name="project" property="projectCode" /></td>
									<td class="text-center"><bean:write name="project" property="projectName" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<logic:empty name="ajaxForm" property="organizationProject">
							<tr>
								<td class="text-center" colspan=6>No Project</td>
							</tr>
						</logic:empty>
					</tbody>					
				</table>
			</div>

			<!-- PAGGING -->

			<table class="table">
				<tr>
					<th colspan=3 class="text-center">
						<div class="pagination">
							<ul>
								<li class="first"><a onclick="javascript:pagingOrganizationDelete('first');">
									<i class="icon-first-2"></i></a></li>
								<li class="prev"><a onclick="javascript:pagingOrganizationDelete('prev');">
									<i class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span id="current-page-organization-delete">
									<bean:write name="ajaxForm" property="page" /></span> of <span id="max-page-organization-delete">
									<bean:write name="ajaxForm" property="maxpage" /></span></a></li>
								<li class="next"><a onclick="javascript:pagingOrganizationDelete('next');">
									<i class="icon-next"></i></a></li>
								<li class="last"><a onclick="javascript:pagingOrganizationDelete('last');">
									<i class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span id="total-record-organization-delete">
									<bean:write name="ajaxForm" property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
				</tr>
				<tr>
					<th class="text-center" colspan="3">
						<button type="button" class='button info' onclick="javascript:chooseOrganizationDelete('cancel')">Cancel</button>
					</th>
				</tr>
			</table>
		</logic:notEqual>
		<logic:equal name="ajaxForm" property="checkDeleteOrganization" value="0">
			<table class="table striped bordered hovered">
				<tr>
					<th><strong>Are you sure to DELETE business unit 
						<bean:write name="ajaxForm" property="organizationCode" /> ?
					</strong></th>
				</tr>
				<tr>
					<th class="text-center">
						<button type="button" class='button danger' onclick="javascript:chooseOrganizationDelete('delete')">Delete</button>
						<button type="button" class='button info' onclick="javascript:chooseOrganizationDelete('cancel')">Cancel</button>
					</th>
				</tr>
			</table>
		</logic:equal>
	</html:form>
</body>
</html>