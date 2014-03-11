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

<title>Edit Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/project" method="post" styleClass="projectForm">
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table">
					<thead>
						<tr>
							<th colspan="3">
								<h3>Edit Project</h3>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Project Code</td>
							<td>:</td>
							<td><div class="input-control text ">
									<input type="text" placeholder="Project Code" />
								</div></td>
						</tr>
						<tr>
							<td>Project Name</td>
							<td>:</td>
							<td><div class="input-control text ">
									<input type="text" placeholder="Project Name" />
								</div></td>
						</tr>
						<tr>
							<td>Client</td>
							<td>:</td>
							<td><div class="input-control text">
									<input type="text" placeholder="Client" />
								</div></td>
						</tr>
						<tr>
							<td>Phase</td>
							<td>:</td>
							<td>
								<div class="input-control select">
									<select>
										<option value="">Phase</option>
										<option value="requirement">Requirement</option>
										<option value="development">Development</option>
										<option value="UAT">UAT</option>
										<option value="live">Live</option>
										<option value="close">Closed</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>Business Unit</td>
							<td>:</td>
							<td>
								<div class="input-control text">
									<input type="text" placeholder="Business Unit"
										readonly="readonly" />
									<button class="btn-search" id="organization"></button>
								</div>

							</td>
						</tr>
						<tr>
							<td>Start Date</td>
							<td>:</td>
							<td>
								<div class="input-control text" id="datepicker-begin">
									<input type="text">
									<button class="btn-date"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Estimate Finish Date</td>
							<td>:</td>
							<td>
								<div class="input-control text " id="datepicker-end">
									<input type="text">
									<button class="btn-date"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" class="text-right">
								<button id="save-btn" onclick="" class="success">Save</button>
								<button id="cancel-btn" onclick="javascript:button('cancel');">Cancel</button>
							</td>
							
							<html:hidden property="task" styleId="task" name="projectForm" />
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
	<div id="popup_organization" class="hide"><jsp:include
			page="/lookup/_organization.jsp" /></div>	
</body>
</html>
