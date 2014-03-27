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
		document.projectForm.task.value = task;
		document.projectForm.paramProjectCode.value = paramProjectCode;
		document.projectForm.submit();
	}
	function button(task) {
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
	function deleteConfirm(task, paramProjectCode) {
		var con = confirm("This project record will be deleted, are you sure?");
		if (con) {
			flyToPage(task, paramProjectCode);
		}
	}
	$(document).ready(function() {
		$("#searchKeyword").attr("placeholder", "Keyword of Project");
		if ($("#messageCRUD").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#messageCRUD").val()
				});
			}, 1000);
		}
		$(".delete-link").click(function() {
			$("#projectCode").val($(this).attr('alt').trim());
			$("#proForm").val($(this).attr('alt').trim());
		});
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>

<title>Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/project" method="post" styleClass="projectForm"
					styleId="proForm">
					<html:hidden property="task" name="projectForm" styleId="task" />
					<html:hidden property="page" name="projectForm" />
					<html:hidden property="maxpage" name="projectForm" />
					<html:hidden property="paramProjectCode" name="projectForm"
						styleId="projectCode" />
					<input type="hidden" id="messageCRUD"
						value="<bean:write  property="message" name="projectForm" />">
					<input type="hidden" id="messagecolor"
						value="<bean:write  property="color" name="projectForm" />">

					<table class="table">
							<tr>
								<td colspan=2 class="text-center">
									<h3>Project</h3>
								</td>
							</tr>
							<tr>
								<td class="text-center field-form">
									<div class="input-control select">
										<html:select property="searchCategory" name="projectForm">
											<html:option value="all">All</html:option>
											<html:option value="projectCode">Project Code</html:option>
											<html:option value="projectName">Project Name</html:option>
											<html:option value="client">Client</html:option>
											<html:option value="phase">Phase</html:option>
											<html:option value="organization">Business Unit</html:option>
										</html:select>
									</div>

								</td>
								<td class="text-center">
									<div class="input-control text">
										<html:text property="searchKeyword" name="projectForm"
											styleId="searchKeyword"
											onkeydown="if (event.keyCode == 13){ javascript:button('search'); return false;}"></html:text>
										<button class="btn-search" type="button"
											onclick="javascript:button('search');"></button>
									</div>

								</td>
							</tr>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Project Code</th>
								<th class="text-center">Project Name</th>
								<th class="text-center">Client</th>
								<th class="text-center">Business Unit</th>
								<th class="text-center">Phase</th>
								<th class="text-center">Start Date</th>
								<th class="text-center">Finish Date</th>
								<th class="text-center">Running (day)</th>
								<th class="text-center">Structure</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="projectForm" property="listProject">
								<logic:iterate id="project" name="projectForm"
									property="listProject">
									<tr>
										<td class="text-center"><bean:write name="project"
												property="projectCode" /></td>
										<td><bean:write name="project" property="projectName" /></td>
										<td class="text-center"><bean:write name="project"
												property="client" /></td>
										<td class="text-center"><bean:write name="project"
												property="organizationCode" /></td>
										<td class="text-center"><bean:write name="project"
												property="phase" /></td>
										<td class="text-center"><bean:write name="project"
												property="startDate" /></td>
										<td class="text-center"><bean:write name="project"
												property="endDate" /></td>
										<td class="text-center"><bean:write name="project"
												property="runningDay" /></td>
										<td class="text-center"><a
											href="javascript:flyToPage('member','<bean:write name="project" property="projectCode" />');"
											data-hint="Project Member" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/MEMBER.png"></a></td>
										<td class="text-center"><a
											href="javascript:flyToPage('edit','<bean:write name="project" property="projectCode" />');"
											data-hint="Edit Project" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
										<td class="text-center"><a href="#"
											class="delete-link deleteProject" data-hint="Delete Project"
											data-hint-position="bottom"
											alt="<bean:write name="project"
												property="projectCode" />">
												<img alt=""
												src="<%=request.getContextPath()%>/images/DELETE.png">
										</a></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="projectForm" property="listProject">
								<tr>
									<td class="text-center" colspan="11">Project Not Available</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>

					<table class="table">
						<tr>
							<td class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a id="first"
											onclick="button('first');"><i class="icon-first-2"></i></a></li>
										<li class="prev"><a id="prev" onclick="button('prev');"><i
												class="icon-previous"></i></a></li>
										<li class="disabled"><a>Page <bean:write
													name="projectForm" property="page" /> of <bean:write
													name="projectForm" property="maxpage" /></a></li>
										<li class="next"><a id="next" onclick="button('next');"><i
												class="icon-next"></i></a></li>
										<li class="last"><a id="last" onclick="button('last');"><i
												class="icon-last-2"></i></a></li>
										<li class="disabled"><a>Total Record <bean:write
													name="projectForm" property="countRecord" /></a></li>
									</ul>
								</div>
							</td>
							<td class="text-right field-form"><a
								href="javascript:button('addProject');" data-hint="Add Project"
								data-hint-position="bottom"><img alt=""
									src="<%=request.getContextPath()%>/images/ADD_PROJECT.png"></a></td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<div id="lookUpDeleteProject" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
