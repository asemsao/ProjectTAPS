<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

<title>Business Unit Member</title>
</head>

<body class="metro">
<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan="2">Business Unit Member</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Business Unit</td>
								<td colspan="2">CDD</td>
							</tr>
							<tr>
								<td>Business Unit Head</td>
								<td colspan="2">Toto Hugo</td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="auto-complete">
										<div class="control-group">
											<select id="select-search" required
												class="demo-default size3">
												<option value="">All</option>
												<option value="employeeCode">Employee Code</option>
												<option value="employeeName">Employee Name</option>
											</select>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="input-control text size11">
										<input type="text"
											placeholder="Keyword of Member in Organization" />
										<button class="btn-search"></button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Employee NIK</th>
								<th class="text-center">Employee Code</th>
								<th class="text-center">Employee Name</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2013-123</td>
								<td>RIS</td>
								<td>Farisa</td>
							</tr>
							<tr>
								<td>2013-124</td>
								<td>YUS</td>
								<td>Yusac</td>
							</tr>
							<tr>
								<td>2013-125</td>
								<td>LUK</td>
								<td>Lukas</td>
							</tr>
							<tr>
								<td colspan=3 class="text-center">
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
								<td colspan=3 class="text-right"><button id="back-btn"
										onclick="">Back</button></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>