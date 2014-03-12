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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#lookUpEmployee")
								.load(
										"/ProjectTaps/ajax.do?mode=employees&task=employees");
						$("#lookUpOrganization")
								.load(
										"/ProjectTaps/ajax.do?mode=organizations&task=organizations");
					});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>

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
							<td><div class="input-control text">
									<input type="text" placeholder="Organization Code" />
								</div></td>
						</tr>
						<tr>
							<td>Organization Name</td>
							<td>:</td>
							<td>
								<div class="input-control text">
									<input type="text" placeholder="Organization Name" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Head Name</td>
							<td>:</td>
							<td>
								<div class="input-control text">
									<input type="hidden" id="employee-domain" /> <input
										type="text" placeholder="Head of Organization"
										readonly="readonly" id="employee-name" />
									<button class="btn-search" id="employee"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Parent Organization</td>
							<td>:</td>
							<td>
								<div class="input-control text">
									<input type="hidden" id="parent-organization-code" /> <input
										type="text" placeholder="Parent Organization"
										readonly="readonly" id="parent-organization-name" />
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

	<div id="lookUpOrganization"></div>
	<div id="lookUpEmployee" class="hide"></div>

	<jsp:include page="/frame/footer.jsp" />
</body>

</html>