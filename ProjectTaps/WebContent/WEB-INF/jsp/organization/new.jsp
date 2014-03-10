<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

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
							<td><div class="input-control text ">
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
								<div class="input-control text ">
									<input type="text" placeholder="Head of Organization"
										readonly="readonly" />
									<button class="btn-search" id="employee"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Parent Organization</td>
							<td>:</td>
							<td>
								<div class="input-control text ">
									<input type="text" placeholder="Parent Organization"
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
	<jsp:include page="/frame/footer.jsp" />
	<div id="popup_employee" class="hide"><jsp:include
			page="/lookup/_employee.jsp" /></div>
	<div id="popup_organization" class="hide"><jsp:include
			page="/lookup/_organization.jsp" /></div>
</body>

</html>