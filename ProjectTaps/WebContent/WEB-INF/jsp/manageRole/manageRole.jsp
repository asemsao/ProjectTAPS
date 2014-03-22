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
<jsp:include page="/js/import.jsp" />

<title>Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/manageRole" method="post"
					styleClass="manageRoleForm" styleId="mrForm">
					<%-- 					<html:hidden property="task" name="manageRoleForm" styleId="task" /> --%>
					<%-- 					<html:hidden property="pagingDirection" name="manageRoleForm" styleId="pagingDirection" /> --%>
					<%-- 					<html:hidden property="pageP" name="manageRoleForm" styleId="pageP" /> --%>
					<%-- 					<html:hidden property="maxPageP" name="manageRoleForm" styleId="maxPageP" /> --%>
					<%-- 					<html:hidden property="maxPageO" name="manageRoleForm" styleId="maxPageO" /> --%>
					<%-- 					<html:hidden property="orgBefore" name="manageRoleForm" styleId="orgBefore" /> --%>

					<fieldset>
						<legend>CHOOSE ROLE</legend>

						<!-- 					<table class="table"> -->
						<!-- 							<tr> -->
						<!-- 								<th width="25%"> -->
						<!-- 									<div class="input-control select"> -->
						<%-- 										<html:select property="projectCategory" name="manageRoleForm" styleId="projectCategory"> --%>
						<%-- 											<html:option value="all">All</html:option> --%>
						<%-- 										</html:select> --%>
						<!-- 									</div> -->
						<!-- 								</th> -->
						<!-- 								<th> -->
						<!-- 									<div class="input-control text"> -->
						<%-- 										<html:text property="projectKeyword" name="manageRoleForm" styleId="projectKeyword"></html:text> --%>
						<!-- 										<button  id="search-btn-project" type="button" class="btn-search"></button> -->
						<!-- 									</div> -->
						<!-- 								</th> -->
						<!-- 							</tr> -->
						<!-- 							</table> -->

						<table class="table striped bordered hovered">
							<thead>
								<tr>
									<th></th>
									<th class="text-center">Role ID</th>
									<th class="text-center">Role Name</th>
								</tr>
							</thead>
							<tbody>
								<logic:notEmpty name="manageRoleForm" property="listRole">
									<logic:iterate id="manageRole" name="manageRoleForm"
										property="listRole">
										<tr>
											<td>
												<div class="input-control radio default-style">
													<label> <input type="radio" name="role_choose"
														value="<bean:write name="manageRole"
												property="roleId" />@<bean:write name="manageRole"
												property="roleName" />" />
														<span class="check"></span>
													</label>
												</div>
											</td>
											<td class="text-center"><bean:write name="manageRole"
													property="roleId" /></td>
											<td><bean:write name="manageRole" property="roleName" /></td>
										</tr>
									</logic:iterate>
								</logic:notEmpty>
								<logic:empty name="manageRoleForm" property="listRole">
									<tr>
										<td class="text-center" colspan="3">Role Not Available</td>
									</tr>
								</logic:empty>
							</tbody>
						</table>
					</fieldset>

					<fieldset>
						<legend>CHOOSE MENU</legend>
						<div id="table-ajax-list-menu"></div>
<!-- 						<table id="table-ajax-list-menu" class="table striped bordered hovered"></table> -->
						
					</fieldset>
					
					<fieldset>
						<legend>SUMMARY</legend>
						<div id="table-ajax-summary-menu-role"></div>
<!-- 						<table id="table-ajax-summary-menu-role" class="table"></table> -->
					</fieldset>
					<input id="submit-btn-menu-role" type="button" class="submit-wizard"
						value="Finish" />
				</html:form>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
