<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<html:form action="/ajax" method="post">
			task <html:text property="task" styleId="task" name="ajaxForm" />
			page <html:text property="page" styleId="task" name="ajaxForm" />
	<div id="table-ajax-employee">
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
				<logic:notEmpty name="ajaxForm" property="listEmployees">
					<logic:iterate id="employee" name="ajaxForm"
						property="listEmployees">
						<tr>
							<td class="text-center"><input type='radio'
								name='employee_choose'
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
				<logic:empty name="ajaxForm" property="listEmployees">
					<tr>
						<td class="text-center" colspan=5>Data not found</td>
					</tr>
				</logic:empty>
			</tbody>
		</table>
	</div>
</html:form>