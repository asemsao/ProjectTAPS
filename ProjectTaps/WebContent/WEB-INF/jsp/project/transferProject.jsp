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
<script>
	function flyToPage(task, paramProjectCode) {
		document.transferProjectForm.task.value = task;
		document.transferProjectForm.paramProjectCode.value = paramProjectCode;
		document.transferProjectForm.submit();
	}
	function button(task) {
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
	$(document).ready(function() {
		$("#myForm").formToWizard({ submitButton: 'submit-btn' })
		$("#munculkan").hide();
	});
</script>

<title>Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/transferProject" method="post" styleClass="transferProjectForm" styleId="myForm">
					<html:hidden property="task" name="transferProjectForm" />
					<html:hidden property="pageProject" name="transferProjectForm" />
					<html:hidden property="maxPageProject" name="transferProjectForm" />
					<html:hidden property="paramProjectCode" name="transferProjectForm" />
					
					<fieldset>
					<legend>CHOOSE PROJECT</legend>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center" colspan=2>
									<div class="input-control select">
										<html:select property="searchCategory" name="transferProjectForm">
											<html:option value="all">All</html:option>
											<html:option value="projectCode">Project Code</html:option>
											<html:option value="projectName">Project Name</html:option>
											<html:option value="client">Client</html:option>
											<html:option value="phase">Phase</html:option>
											<html:option value="organization">Organization</html:option>
										</html:select>
									</div>
								</th>
								<th class="text-center" colspan=9>
									<div class="input-control text">
										<html:text property="searchKeyword" name="transferProjectForm"
											onkeydown="if (event.keyCode == 13){ javascript:button('search'); return false;}"></html:text>
										<button class="btn-search" type="button"
											onclick="javascript:button('search');"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th></th>
								<th class="text-center">Project Code</th>
								<th class="text-center">Project Name</th>
								<th class="text-center">Client</th>
								<th class="text-center">Organization</th>
								<th class="text-center">Phase</th>
								<th class="text-center">Start Date</th>
								<th class="text-center">Finish Date</th>
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
											<input type="radio" name="project_choose" />
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
									<td class="text-center" colspan="11">Project Not Available</td>
								</tr>
						</logic:empty>
						</tbody>
					</table>
					</fieldset>
					
					<fieldset>
					<legend>CHOOSE BUSINESS UNIT</legend>
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center" colspan=1>
									<div class="input-control select">
										<html:select property="searchCategory" name="transferProjectForm">
											<html:option value="all">All</html:option>
											<html:option value="organizationCode">Organization Code</html:option>
											<html:option value="organizationName">Organization Name</html:option>
											<html:option value="headName">Head Name</html:option>
										</html:select>
									</div>
								</th>
								<th class="text-center" colspan=5>
									<div class="input-control text">
										<html:text property="searchKeyword" name="transferProjectForm"
											styleId="searchKeyword"></html:text>
										<button id="search" class="btn-search"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th></th>
								<th class="text-center">Organization Code</th>
								<th class="text-center">Organization Name</th>
								<th class="text-center">Head Name</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="transferProjectForm"
								property="listOrganization">
								<logic:iterate id="organization" name="transferProjectForm"
									property="listOrganization">
									<tr>
										<td>
											<div class="input-control radio default-style">
											<label>
											<input type="radio" name="project_choose" />
											<span class="check"></span>
											</label>
											</div>
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
					</fieldset>
					<fieldset>
					<legend>CHOOSE MEMBER</legend>
<!-- 					<table class="table striped bordered hovered"> -->
<!-- 						<tr> -->
<!-- 							<td colspan=1>Project Name</th> -->
<%-- 							<td colspan=4><strong><bean:write property="projectName" /></strong></td> --%>
<!-- 						</tr> -->
<!-- 						</table> -->
<!-- 						<table> -->
<!-- 						<thead> -->
<!-- 						<tr> -->
<!-- 							<th></th> -->
<!-- 							<th class="text-center">Role</th> -->
<!-- 							<th class="text-center">Assignee</th> -->
<!-- 							<th class="text-center">Direct Report</th> -->
<!-- 						</tr> -->
<!-- 					</thead> -->
<!-- 					<tbody> -->
<%-- 						<logic:notEmpty name="projectForm" property="listProject"> --%>
<%-- 						<logic:iterate id="project" name="projectForm" property="listProject"> --%>
<!-- 							<tr> -->
<%-- 								<td><bean:write name="project" property="projectRole" /></td> --%>
<%-- 								<td><bean:write name="project" property="assignee" /></td> --%>
<%-- 								<td><bean:write name="project" property="directReport" /></td> --%>
<%-- 								<td class="text-center"><a href="javascript:flyToPage('editMember','<bean:write name="project" property="assigneeUserDomain" />')" --%>
<!-- 									data-hint="Edit Member" data-hint-position="bottom"><img -->
<%-- 										alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td> --%>
<%-- 								<td class="text-center"><a href="javascript:flyToPage('deleteMember','<bean:write name="project" property="assigneeUserDomain" />')" --%>
<!-- 									data-hint="Delete Member" data-hint-position="bottom"><img -->
<%-- 										alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td> --%>
<!-- 							</tr> -->
<%-- 						</logic:iterate> --%>
<%-- 						</logic:notEmpty> --%>
<%-- 						<logic:empty name="projectForm" property="listProject"> --%>
<!-- 							<tr> -->
<!-- 								<td class="text-center" colspan="7">No Member</td> -->
<!-- 							</tr> -->
<%-- 						</logic:empty> --%>
<!-- 						<tr> -->
<!-- 							<td colspan=5 class="text-center"> -->
<!-- 								<div class="pagination"> -->
<!-- 									<ul> -->
<!-- 										<li class="first"><a><i class="icon-first-2"></i></a></li> -->
<!-- 										<li class="prev"><a><i class="icon-previous"></i></a></li> -->
<!-- 										<li><a>1</a></li> -->
<!-- 										<li><a>2</a></li> -->
<!-- 										<li class="active"><a>3</a></li> -->
<!-- 										<li class="spaces"><a>...</a></li> -->
<!-- 										<li class="disabled"><a>4</a></li> -->
<!-- 										<li><a>500</a></li> -->
<!-- 										<li class="next"><a><i class="icon-next"></i></a></li> -->
<!-- 										<li class="last"><a><i class="icon-last-2"></i></a></li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td colspan=5 class="text-right"> -->
<!-- 								<button id="add-btn" onclick="javascript:button('addMember')" class="success">Add</button> -->
<!-- 								<button id="back-btn" onclick="javascript:button('cancel')">Back</button> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 					</tbody> -->
<!-- 				</table> -->
					</fieldset>
					<input id="submit-btn" type="button" value="Submit Form" />
				</html:form>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
