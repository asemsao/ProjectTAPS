<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/js/import.jsp" />

<title>New Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table">
					<thead>
						<tr>
							<th colspan=3 class="text-center"><h3>New Assignment</h3></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Assignment Date</td>
							<td>:</td>
							<td><div class="input-control text " id="datepicker-begin">
									<input type="text">
									<button class="btn-date"></button>
								</div></td>
						</tr>
						<tr>
							<td>Assignment Due Date</td>
							<td>:</td>
							<td><div class="input-control text" id="datepicker-end">
									<input type="text">
									<button class="btn-date"></button>
								</div></td>
						</tr>
						<tr>
							<td>Assignment Type</td>
							<td>:</td>
							<td>
								<div class="input-control radio margin10">
									<label> <input type="radio" name="assignment_type"
										checked="checked" value="Bussiness Unit" /> <span
										class="check"></span> Business Unit
									</label>
								</div>
								<div class="input-control radio margin10">
									<label> <input type="radio" name="assignment_type"
										value="Project" /> <span class="check"></span> Project
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>Assign To</td>
							<td>:</td>
							<td><div class="pr" class="in-bl">
									<div class="input-control text">
										<input type="text" placeholder="Project" readonly="readonly" />
										<button class="btn-search" id="project"></button>
									</div>
								</div> <br />
								<div class="input-control text">
									<input type="text" placeholder="Employee" readonly="readonly" />
									<button class="btn-search" id="employee"></button>
								</div></td>
						</tr>
						<tr>
							<td>Reff Task Code</td>
							<td>:</td>
							<td><div class="input-control text">
									<input type="text" placeholder="Reff Task Code"
										readonly="readonly" />
									<button class="btn-search" id="task"></button>
								</div></td>
						</tr>
						<tr>
							<td>Description</td>
							<td>:</td>
							<td><textarea rows="3" class="input-control textarea"></textarea></td>
						</tr>
						<tr>
							<td colspan=3 class="text-right"><button id="save-btn"
									class="button success">Save</button>
								<button id="assign-btn" class="button success">Assign</button>
								<button id="cancel-btn" class="button info">Cancel</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" /></body>
<div id="popup_employee" class="hide"><jsp:include
		page="/lookup/_employee.jsp" /></div>
<div id="popup_project" class="hide">
	<jsp:include page="/lookup/_project.jsp" /></div>
<div id="popup_task" class="hide">
	<jsp:include page="/lookup/_task.jsp" /></div>
</body>
</html>