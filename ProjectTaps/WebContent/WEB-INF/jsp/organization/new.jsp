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
<script
	src="<%=request.getContextPath()%>/js/lookup/organizationLookup.js"></script>


<title>Add Organization</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table">
					<thead>
						<tr>
							<th colspan="3">Add Organization</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Organization Code</td>
							<td>:</td>
							<td><div class="input-control text size3">
									<input type="text" placeholder="Organization Code" />
								</div></td>
						</tr>
						<tr>
							<td>Organization Name</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Organization Name" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Head Name</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Ini di Hide"
										readonly="readonly" id="employee_id" /> <input type="text"
										placeholder="Head of Organization" readonly="readonly"
										id="employee_name" />
									<button class="btn-search" id="employee"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Parent Organization</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Nampung ID nanti di hidden"
										readonly="readonly" id="parent_organization_id" /> <input
										type="text" placeholder="Parent Organization"
										readonly="readonly" id="parent_organization" />
									<button class="btn-search" id="organization"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" class="text-right">
								<button id="save-btn" onclick="" class="success">Save</button>
								<button id="cancel-btn" onclick="">Cancel</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="lookUpOrganization" class="hide">
		<html:form action="/organization" method="post">
			<html:hidden property="task" styleId="task-organization"
				name="organizationForm" />
			<html:hidden styleId="page-organization" property="page"
				name="organizationForm" />
			<html:hidden styleId="maxpage-organization" property="maxpage"
				name="organizationForm" />

			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=4 class="text-center">Organization</th>
					</tr>
					<tr>
						<th class="text-center" colspan=1>
							<div class="input-control select">
								<html:select property="searchCategory" name="organizationForm"
									styleId="search-organization">
									<html:option value="">All</html:option>
									<html:option value="organizationCode">Organization Code</html:option>
									<html:option value="organizationName">Organization Name</html:option>
									<html:option value="headName">Head Name</html:option>
								</html:select>
							</div>
						</th>
						<th class="text-center" colspan=3>
							<div class="input-control text">
								<html:text property="searchKeyword" name="organizationForm"
									styleId="value-organization" value="devririza"></html:text>
								<button type="button" class="btn-search"
									onclick="javascript:pagingOrganization('search-lookup-organization');"></button>
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
						<logic:notEmpty name="organizationForm"
							property="listOrganizations">
							<logic:iterate id="organization" name="organizationForm"
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
										onclick="javascript:pagingOrganization('first-lookup-organization');"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a
										onclick="javascript:pagingOrganization('prev-lookup-organization');"><i
											class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <span
											id="current-page-organization"><bean:write
													name="organizationForm" property="page" /></span> of <span
											id="max-page-organization"> <bean:write
													name="organizationForm" property="maxpage" /></span></a></li>
									<li class="next"><a
										onclick="javascript:pagingOrganization('next-lookup-organization');"><i
											class="icon-next"></i></a></li>
									<li class="last"><a
										onclick="javascript:pagingOrganization('last-lookup-organization');"><i
											class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <span
											id="total-record-organization"><bean:write
													name="organizationForm" property="countRecord" /></span></a></li>
								</ul>
							</div>
						</th>
						<th class="text-center"><button type="button"
								class='button success'
								onclick="javascript:chooseBussinessUnit()">Add</button></th>
					</tr>
				</thead>
			</table>
		</html:form>
	</div>

	<div id="lookUpEmployee" class="hide">
		<html:form action="/organization" method="post">
			<html:hidden property="task" styleId="task-employee"
				name="organizationForm" />
			<html:hidden styleId="page-employee" property="pageEmployee"
				name="organizationForm" />
			<html:hidden styleId="maxpage-employee" property="maxpageEmployee"
				name="organizationForm" />

			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=5 class="text-center">Employee List</th>
					</tr>
					<tr>
						<th class="text-center" colspan=2>
							<div class="input-control select">
								<html:select property="searchCategory" name="organizationForm"
									styleClass="search-category-employee">
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
								<html:text property="searchKeyword" name="organizationForm"
									styleClass="search-keyword-employee"
									onkeydown="if (event.keyCode == 13){ javascript:pagingEmployee('search-lookup-employee'); return false;}"></html:text>
								<button type="button" class="btn-search"
									onclick="javascript:pagingEmployee('search-lookup-employee');"></button>
							</div>
						</th>
					</tr>
				</thead>
			</table>
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
						<logic:notEmpty name="organizationForm" property="listEmployees">
							<logic:iterate id="employee" name="organizationForm"
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
										onclick="javascript:pagingEmployee('first-lookup-employee');"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a
										onclick="javascript:pagingEmployee('prev-lookup-employee');"><i
											class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <span
											id="current-page-employee"><bean:write
													name="organizationForm" property="pageEmployee" /></span> of <span
											id="max-page-employee"><bean:write
													name="organizationForm" property="maxpageEmployee" /></span></a></li>
									<li class="next"><a
										onclick="javascript:pagingEmployee('next-lookup-employee');"><i
											class="icon-next"></i></a></li>
									<li class="last"><a
										onclick="javascript:pagingEmployee('last-lookup-employee');"><i
											class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <span
											id="total-record-employee"><bean:write
													name="organizationForm" property="countRecordEmployee" /></span></a></li>
								</ul>
							</div>
						</th>
						<th class="text-center"><button type="button"
								class='button success' onclick="javascript:chooseEmployee()">Add</button></th>
					</tr>
				</thead>
			</table>
		</html:form>
	</div>



	<jsp:include page="/frame/footer.jsp" />
	<!-- 	<div id="popup_employee" class="hide"> -->
	<%-- 		<jsp:include page="/lookup/_employee.jsp" /></div> --%>
	<!-- 	<div id="popup_organization" class="hide"> -->
	<%-- 		<jsp:include page="/lookup/_organization.jsp" /></div> --%>
</body>

</html>