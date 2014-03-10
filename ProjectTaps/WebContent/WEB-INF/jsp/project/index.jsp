<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

<title>Project</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th colspan=11 class="text-center"><h3>Project</h3></th>
						</tr>
						<tr>
							<th class="text-center" colspan=2>
								<div class="input-control select">
									<select>
										<option value="">All</option>
										<option value="projectCode">Project Code</option>
										<option value="projectName">Project Name</option>
										<option value="client">Client</option>
										<option value="phase">Phase</option>
										<option value="organization">Organization</option>
									</select>
								</div>
							</th>
							<th class="text-center" colspan=9>
								<div class="input-control text">
									<input type="text" placeholder="Keyword of Projects" />
									<button class="btn-search"></button>
								</div>
							</th>
						</tr>
						<tr>
							<th class="text-center">Project Code</th>
							<th class="text-center">Project Name</th>
							<th class="text-center">Client</th>
							<th class="text-center">Organization</th>
							<th class="text-center">Phase</th>
							<th class="text-center">Start Date</th>
							<th class="text-center">Est Finish Date</th>
							<th class="text-center">Running (day)</th>
							<th class="text-center">Structure</th>
							<th class="text-center">Edit</th>
							<th class="text-center">Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>TAPS</td>
							<td>Timesheet and Performance Sheet</td>
							<td>AdIns</td>
							<td>CDD</td>
							<td>Development</td>
							<td>01/11/2013</td>
							<td>31/12/2013</td>
							<td>20</td>
							<td class="text-center"><a href="structure.jsp"
								data-hint="Member Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/MEMBER.png"></a></td>
							<td class="text-center"><a href="new.jsp"
								data-hint="Edit Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
							<td class="text-center"><a href="javascript:confDel()"
								data-hint="Delete Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
						</tr>
						<tr>
							<td>POPA</td>
							<td>Pos Pay</td>
							<td>Pos Indonesia</td>
							<td>CDD</td>
							<td>Development</td>
							<td>01/11/2013</td>
							<td>30/12/2013</td>
							<td>20</td>
							<td class="text-center"><a href="structure.jsp"
								data-hint="Member Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/MEMBER.png"></a></td>
							<td class="text-center"><a href="new.jsp"
								data-hint="Edit Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
							<td class="text-center"><a href="javascript:confDel()"
								data-hint="Delete Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
						</tr>
						<tr>
							<td colspan=9 class="text-center">
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

							<td colspan=2 class="text-right"><a href="new.jsp"
								data-hint="Add Project" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/ADD_PROJECT.png"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
