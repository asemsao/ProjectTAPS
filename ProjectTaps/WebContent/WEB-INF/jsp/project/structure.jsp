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
	function flyToPage(task, paramAssigneeUserDomain) {
		document.projectForm.task.value = task;
		document.projectForm.paramAssigneeUserDomain.value = paramAssigneeUserDomain;
		document.projectForm.submit();
	}
	function button(task) {
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
	function deleteConfirm(task, assigneeUserDomain, directReportUserDomain) {
		var con = confirm("This record will be deleted, are you sure?");
		if (con) {
			document.projectForm.directReportUserDomain.value = directReportUserDomain;
			flyToPage(task, assigneeUserDomain);
		}
	}
	$(document).ready(function() {
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
	});
</script>
<title>Project Member</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/project" method="post" styleClass="projectForm">
					<html:hidden property="task" name="projectForm" />
					<html:hidden property="paramProjectCode" name="projectForm" />
					<html:hidden property="paramAssigneeUserDomain" name="projectForm" />
					<html:hidden property="mode" name="projectForm" />
					<html:hidden property="page" name="projectForm" />
					<html:hidden property="maxpage" name="projectForm" />
					<html:hidden property="directReportUserDomain" name="projectForm" />
					<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="projectForm" />">
					<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="projectForm" />">
					
					<table class="table">
						<tr>
							<th colspan=2><h3>Project Member</h3></th>
						</tr>
						<tr>
							<th class="field-form">Business Unit</th>
							<td><strong><bean:write
										property="organizationName" /></strong></td>
						</tr>
						<tr>
							<th class="field-form">Project Name</th>
							<td><strong><bean:write property="projectName" /></strong></td>
						</tr>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Role</th>
								<th class="text-center">Assignee</th>
								<th class="text-center">Direct Report</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="projectForm"
								property="listStructureProject">
								<logic:iterate id="project" name="projectForm" property="listStructureProject">
									<tr>
										<td><bean:write name="project" property="projectRole" /></td>
										<td><bean:write name="project" property="assignee" /></td>
										<td><bean:write name="project" property="directReport" /></td>
										<td class="text-center">
											<a href="javascript:flyToPage('editMember','<bean:write name="project" property="assigneeUserDomain" />')" data-hint="Edit Member" data-hint-position="bottom">
												<img alt="" src="<%=request.getContextPath()%>/images/EDIT.png">
											</a>
										</td>
										<td class="text-center">
											<a href="javascript:deleteConfirm('deleteMember','<bean:write name="project" property="assigneeUserDomain" />','<bean:write name="project" property="directReportUserDomain" />')" data-hint="Delete Member" data-hint-position="bottom">
												<img alt="" src="<%=request.getContextPath()%>/images/DELETE.png">
											</a>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="projectForm" property="listStructureProject">
								<tr>
									<td class="text-center" colspan="7">No Member</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>

					<table class="table">
						<tr>
							<td class="text-center">
								<div class="pagination">
									<ul>
										<li class="first">
											<a id="first" href="javascript:button('first');">
												<i class="icon-first-2"></i>
											</a>
										</li>
										<li class="prev">
											<a id="prev" href="javascript:button('prev');">
												<i class="icon-previous"></i>
											</a>
										</li>
										<li class="disabled">
											<a>
												Page <bean:write name="projectForm" property="page" /> of <bean:write name="projectForm" property="maxpage" />
											</a>
										</li>
										<li class="next">
											<a id="next" href="javascript:button('next');">
												<i class="icon-next"></i>
											</a>
										</li>
										<li class="last">
											<a id="last" href="javascript:button('last');">
												<i class="icon-last-2"></i>
											</a>
										</li>
										<li class="disabled">
											<a>
												Total Record <bean:write name="projectForm" property="countRecord" />
											</a>
										</li>
									</ul>
								</div>
							</td>
							<td class="text-right field-form">
								<button id="add-btn" onclick="javascript:button('addMember')" class="success">Add</button>
								<button id="back-btn" onclick="javascript:button('cancel')" class="button info">Back</button>
							</td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
