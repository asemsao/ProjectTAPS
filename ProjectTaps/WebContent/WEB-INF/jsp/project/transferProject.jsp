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

<title>Transfer Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/transferProject" method="post" styleClass="transferProjectForm" styleId="tpForm">
					<html:hidden property="task" name="transferProjectForm" styleId="task" />
					<html:hidden property="pagingDirection" name="transferProjectForm" styleId="pagingDirection" />
					<html:hidden property="pageP" name="transferProjectForm" styleId="pageP" />
					<html:hidden property="maxPageP" name="transferProjectForm" styleId="maxPageP" />
					<html:hidden property="pageO" name="transferProjectForm" styleId="pageO" />
					<html:hidden property="maxPageO" name="transferProjectForm" styleId="maxPageO" />
					<html:hidden property="orgBefore" name="transferProjectForm" styleId="orgBefore" />
					<html:hidden property="message" name="transferProjectForm" styleId="message" />
					<html:hidden property="color" name="transferProjectForm" styleId="color" />
					
					<fieldset>
					<legend>CHOOSE PROJECT</legend>

					<table class="table">
							<tr>
								<th width="25%">
									<div class="input-control select">
										<html:select property="projectCategory" name="transferProjectForm" styleId="projectCategory">
											<html:option value="all">All</html:option>
											<html:option value="projectCode">Project Code</html:option>
											<html:option value="projectName">Project Name</html:option>
											<html:option value="client">Client</html:option>
											<html:option value="phase">Phase</html:option>
											<html:option value="organization">Business Unit</html:option>
										</html:select>
									</div>
								</th>
								<th>
									<div class="input-control text">
										<html:text property="projectKeyword" name="transferProjectForm" styleId="projectKeyword"></html:text>
										<button  id="search-btn-project" type="button" class="btn-search"></button>
									</div>
								</th>
							</tr>
							</table>
							<table id="table-list-project" class="table striped bordered hovered">
						<thead>
							<tr>
								<th></th>
								<th class="text-center">Project Code</th>
								<th class="text-center">Project Name</th>
								<th class="text-center">Client</th>
								<th class="text-center">Business Unit</th>
								<th class="text-center">Phase</th>
								<th class="text-center">Start Date</th>
								<th class="text-center">Estimate Finish Date</th>
								<th class="text-center">Running (day)</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="transferProjectForm" property="listProject">
								<logic:iterate id="transferProject" name="transferProjectForm"
									property="listProject">
									<tr>
										<td>
											<div class="input-control radio default-style">
											<label>
											<input type="radio" name="project_choose" value="<bean:write name="transferProject"
												property="projectCode" />" />
											<span class="check"></span>
											</label>
											</div>
										</td>
										<td class="text-center"><bean:write name="transferProject"
												property="projectCode" /></td>
										<td><bean:write name="transferProject" property="projectName" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="client" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="organizationCode" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="phase" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="startDate" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="endDate" /></td>
										<td class="text-center"><bean:write name="transferProject"
												property="runningDay" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="transferProjectForm" property="listProject">
								<tr>
									<td class="text-center" colspan="9">Project Not Available</td>
								</tr>
						</logic:empty>
						</tbody>
					</table>
						<table class="table">
							<tr>
								<td>
									<div class="pagination">
										<ul>
											<li class="first"><a id="first"
												onclick="button('firstP');"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prev"
												onclick="button('prevP');"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <span id="currentPageP"><bean:write
														name="transferProjectForm" property="pageP" /></span> of <span id="lastPageP"><bean:write
														name="transferProjectForm" property="maxPageP" /></span></a></li>
											<li class="next"><a id="next"
												onclick="button('nextP');"><i class="icon-next"></i></a></li>
											<li class="last"><a id="last"
												onclick="button('lastP');"><i
													class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <span id="totalRecordP"><bean:write
														name="transferProjectForm" property="countRecordP" /></span></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</table>
					</fieldset>
					
					<fieldset>
					<legend>CHOOSE BUSINESS UNIT</legend>
					<table id="table-ajax-project" class="table">
					</table>
					<table class="table">
							<tr>
								<th width="25%">
									<div class="input-control select">
										<html:select property="orgCategory" name="transferProjectForm" styleId="orgCategory">
											<html:option value="all">All</html:option>
											<html:option value="organizationCode">Business Unit Code</html:option>
											<html:option value="organizationName">Business Unit Name</html:option>
											<html:option value="headName">Head Name</html:option>
										</html:select>
									</div>
								</th>
								<th>
									<div class="input-control text">
										<html:text property="orgKeyword" name="transferProjectForm"
											styleId="orgKeyword"></html:text>
										<button id="search-btn-org" type="button" class="btn-search"></button>
									</div>
								</th>
							</tr>
							</table>
							<table id="table-list-org" class="table striped bordered hovered">
						<thead>
							<tr>
								<th></th>
								<th class="text-center" colspan="3" width="12%">Business Unit Code</th>
								<th class="text-center">Business Unit Name</th>
								<th class="text-center">Head Name</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="transferProjectForm"
								property="listOrganization">
								<logic:iterate id="organization" name="transferProjectForm"
									property="listOrganization">
									<tr>
										<td class="text-center" width="5%">
										<div class="input-control radio default-style">
											<label>
											<input type="radio" name="org_choose" value="<bean:write name='organization'
												property='organizationCode' />@<bean:write name='organization'
												property='organizationName' />" />
											<span class="check"></span>
											</label>
											</div>
										</td>
										<td width="4%"><logic:equal value="0" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>
										<td width="4%"><logic:equal value="1" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>
										<td width="4%"><logic:equal value="2" name="organization"
												property="organizationLevel">
												<bean:write name="organization" property="organizationCode" />
											</logic:equal></td>

										<td><bean:write name="organization"
												property="organizationName" /></td>
										<td><bean:write name="organization" property="headName" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="transferProjectForm" property="listOrganization">
								<tr>
									<td class="text-center" colspan="6">Organization Not Available</td>
								</tr>
						</logic:empty>
							</tbody>
					</table>
					<table class="table">
							<tr>
								<td>
									<div class="pagination">
										<ul>
											<li class="first"><a id="first"
												onclick="button('firstO');"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prev"
												onclick="button('prevO');"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <span id="currentPageO"><bean:write
														name="transferProjectForm" property="pageO" /></span> of <span id="lastPageO"><bean:write
														name="transferProjectForm" property="maxPageO" /></span></a></li>
											<li class="next"><a id="next"
												onclick="button('nextO');"><i class="icon-next"></i></a></li>
											<li class="last"><a id="last"
												onclick="button('lastO');"><i
													class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <span id="totalRecordO"><bean:write
														name="transferProjectForm" property="countRecordO" /></span></a></li>
										</ul>
									</div>
								</td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
					<legend>CHOOSE MEMBER</legend>
					<table id="table-ajax-project2" class="table"></table>
					<table id="table-ajax-structure" class="table striped bordered hovered">
				</table>
					</fieldset>
					<fieldset>
					<legend>CHOOSE TRANSFER DATE</legend>
					<table id="table-ajax-project3" class="table"></table>
					<div class="date-wizard">
					<div class="notice marker-on-bottom bg-amber">
					<div class="fg-white">
					<i class="icon-warning"></i>&nbsp;This date will affect Report for both Business Unit (before and after)
					</div>
					</div>
					<br />
					
					<div class="input-control text">
					<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date = new java.util.Date();
					String dateString = df.format(date);
					%>
										<html:text property="transferDate"
											name="transferProjectForm" styleClass="datepicker-all" styleId="transferDate" value="<%=dateString %>">
											</html:text>
										<button type="button" class="btn-date"></button>
										</div>
					
					</div>
					</fieldset>
					<fieldset>
					<legend>SUMMARY</legend>
					<table id="table-ajax-summary" class="table"></table>
					</fieldset>
					<input id="submit-btn" type="button" class="submit-wizard" value="Finish" />
				</html:form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
