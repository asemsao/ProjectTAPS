<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

<title>Assignment</title>
</head>
<body class="metro">
<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<td colspan=4 class="text-center text-bold"><h3>View Assignment</h3></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Due Date</td>
								<td>:</td>
								<td colspan=2>15-11-2013</td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td colspan=2>Business Unit</td>
							</tr>
							<tr>
								<td>Assign By</td>
								<td>:</td>
								<td>TAPS </td>
								<td><b>Report to </b> : Toto hugo
								</td>
							</tr>
							<tr>
								<td>Reff Assignment</td>
								<td>:</td>
								<td colspan=2>PRJ131100002</td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td colspan=2>- Membuat tampilan Task<br />- Membuat Tampilan Home</td>
							</tr>
							<tr>
								<td>Detail Claim</td>
								<td>:</td>
								<td colspan=2>
									<table class="table striped bordered hovered">
										<thead>
											<tr>
												<th>Manhour</th>
												<th>Description</th>
												<th>Manhour</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-center">2013-11-15</td>
												<td><textarea rows="2" class="input-control textarea"></textarea>
												</td>
												<td class="text-center">02:00</td>
											</tr>
											<tr>
												<td colspan=2 class="text-right">Total</td>
												<td class="text-center">02.00</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>

							<tr>
								<td>Assignment Star</td>
								<td>:</td>
								<td colspan=2>
									<div class="rating" id="rating">
										<ul>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li></li>
											<li></li>
											<li></li>
											<li></li>
											<li></li>
										</ul>
										<span class="score-hint"></span>
									</div>
								</td>
							</tr>
							
							<tr>
								<td colspan=4 class="text-right">
									<button id="updatestar-btn" class="button success">Update Star</button>
									<button id="cancel-btn" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=4 class="text-center text-bold">History Comment</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center text-bold">Date</td>
								<td class="text-center text-bold">Comment</td>
								<td class="text-center text-bold">From</td>
								<td class="text-center text-bold">Status</td>
							</tr>
							<tr>
								<td class="text-center">2013-11-15</td>
								<td class="text-center">Ganti sesuatu</td>
								<td class="text-center">Ricky Suryo Utomo</td>
								<td class="text-center">Correction</td>
							</tr>
							<tr>
								<td class="text-center">2013-11-15</td>
								<td class="text-center">done bro</td>
								<td class="text-center">Hizkia Purba</td>
								<td class="text-center">Claim</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
