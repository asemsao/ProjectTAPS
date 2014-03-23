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
		<html:hidden property="organizationCode"
			styleId="organizationCode-delete" name="ajaxForm" />
		<html:hidden property="task" styleId="task-organization-delete"
			name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-organization-delete"
			name="ajaxForm" />
		<html:hidden property="page" styleId="page-organization-delete"
			name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-organization-delete"
			name="ajaxForm" />


		<logic:notEqual name="ajaxForm" property="checkDeleteEmpoyee"
			value="0">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th><strong>Business Unit <bean:write
									name="ajaxForm" property="organizationCode" /> Can't be
								deleted because has
						</strong></th>
					</tr>
				</thead>

				<logic:notEmpty name="ajaxForm" property="ChildOrganization">
					<thead>
						<tr>
							<td><strong>Business Unit's Child</strong></td>
						</tr>
					</thead>
					<tbody>
						<logic:iterate id="organization" name="ajaxForm"
							property="childOrganization">
							<tr>
								<td>Business Unit Code</td>
								<td>:</td>
								<td><bean:write name="organization"
										property="organizationCode" /></td>
							</tr>
							<tr>
								<td>Business Unit Name</td>
								<td>:</td>
								<td><bean:write name="organization"
										property="organizationName" /></td>
							</tr>
						</logic:iterate>
					</tbody>
				</logic:notEmpty>
				<thead>
					<tr>
						<th class="text-center">
							<button type="button" class='button info'
								onclick="javascript:chooseOrganizationDelete('cancel')">Cancel</button>
						</th>
					</tr>
				</thead>
			</table>
		</logic:notEqual>

		<logic:equal name="ajaxForm" property="checkDeleteEmpoyee" value="0">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th><strong>Are you sure to DELETE business Unit <bean:write
									name="ajaxForm" property="organizationCode" /> ?
						</strong></th>
					</tr>
					<tr>
						<th class="text-center"><button type="button"
								class='button danger'
								onclick="javascript:chooseOrganizationDelete('delete')">Delete</button>
							<button type="button" class='button info'
								onclick="javascript:chooseOrganizationDelete('cancel')">Cancel</button>
						</th>
					</tr>
				</thead>
			</table>
		</logic:equal>
	</html:form>
</body>
</html>