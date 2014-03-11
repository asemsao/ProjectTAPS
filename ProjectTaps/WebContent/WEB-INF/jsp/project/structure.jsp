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
	function button(task) 
	{
		document.projectForm.task.value = task;
		document.projectForm.submit();
	}
</script>
<title>Member Structure</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/project" method="post" styleClass="projectForm">
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th colspan=6><h3>Members Structure</h3></th>
						</tr>
						<tr>
							<th colspan=1>Business Unit</th>
							<th colspan=5><bean:write property="organizationName" /></th>
						</tr>
						<tr>
							<th colspan=1>Project</th>
							<th colspan=5><bean:write property="projectName" /></th>
						</tr>
						<tr>
							<th class="text-center">Role</th>
							<th class="text-center">Assignee</th>
							<th class="text-center">Direct Report</th>
							<th class="text-center">Edit</th>
							<th class="text-center">Delete</th>
						</tr>
					</thead>
					<tbody>
						<logic:notEmpty name="projectForm" property="listProject">
						<logic:iterate id="project" name="projectForm" property="listProject">
							<tr>
								<td><bean:write name="project" property="projectRole" /></td>
								<td><bean:write name="project" property="assignee" /></td>
								<td><bean:write name="project" property="directReport" /></td>
								<td class="text-center"><a href="add.jsp"
									data-hint="Edit Member" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
								<td class="text-center"><a href="#"
									data-hint="Delete Member" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
							</tr>
						</logic:iterate>
						</logic:notEmpty>
						<logic:empty name="projectForm" property="listProject">
							<tr>
								<td class="text-center" colspan="7">No Member</td>
							</tr>
						</logic:empty>
						<tr>
							<td colspan=5 class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a><i class="icon-first-2"></i></a></li>
										<li class="prev"><a><i class="icon-previous"></i></a></li>
										<li><a>1</a></li>
										<li><a>2</a></li>
										<li class="active"><a>3</a></li>
										<li class="spaces"><a>...</a></li>
										<li class="disabled"><a>4</a></li>
										<li><a>500</a></li>
										<li class="next"><a><i class="icon-next"></i></a></li>
										<li class="last"><a><i class="icon-last-2"></i></a></li>
									</ul>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan=5 class="text-right">
								<button id="add-btn" onclick="javascript:button('addMember')" class="success">Add</button>
								<button id="back-btn" onclick="javascript:button('cancel')">Back</button>
							</td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
