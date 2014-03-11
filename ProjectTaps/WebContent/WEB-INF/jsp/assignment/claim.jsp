<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

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
							<td colspan=2><bean:write property="" name="" /></td>
						</tr>
						<tr>
							<td>Assignment Type</td>
							<td>:</td>
							<td colspan=2><bean:write property="" name="" /></td>
						</tr>
						<tr>
							<td>Assign To</td>
							<td>:</td>
							<td><bean:write property="" name="" /></td>
							<td><b>Assignment From </b> : <bean:write property="" name="" /></td>
						</tr>
						<tr>
							<td>Reff Assignment</td>
							<td>:</td>
							<td colspan=2><bean:write property="" name="" /></td>
						</tr>
						<tr>
							<td>Description</td>
							<td>:</td>
							<td colspan=2><bean:write property="" name="" />
							</td>
						</tr>
						<tr>
							<td>Detail Claim</td>
							<td>:</td>
							<td colspan=2>
								<table class="table striped bordered hovered">
									<thead>
										<tr>
											<th>Claim Date</th>
											<th>Description</th>
											<th>Manhour</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="text-center">2013-11-15</td>
											<td><textarea rows="2" class="input-control textarea"></textarea>
											</td>
											<td class="text-center">
												<div class="input-control select">
													<select>
														<option value="">00:00</option>
														<option value="00:30">00:30</option>
														<option value="01:00">01:00</option>
														<option value="01:30">01:30</option>
														<option value="02:00">02:00</option>
														<option value="02:30">02:30</option>
														<option value="03:00">03:00</option>
														<option value="03:30">03:30</option>
														<option value="04:00">04:00</option>
														<option value="04:30">04:30</option>
														<option value="05:00">05:00</option>
														<option value="05:30">05:30</option>
														<option value="06:00">06:00</option>
														<option value="06:30">06:30</option>
														<option value="07:00">07:00</option>
														<option value="07:30">07:30</option>
														<option value="08:00">08:00</option>
														<option value="08:30">08:30</option>
														<option value="09:00">09:00</option>
														<option value="09:30">09:30</option>
														<option value="10:00">10:00</option>
														<option value="10:30">10:30</option>
														<option value="11:00">11:00</option>
														<option value="11:30">11:30</option>
														<option value="12:00">12:00</option>
														<option value="12:30">12:30</option>
														<option value="13:00">13:00</option>
														<option value="13:30">13:30</option>
														<option value="14:00">14:00</option>
														<option value="14:30">14:30</option>
														<option value="15:00">15:00</option>
														<option value="15:30">15:30</option>
														<option value="16:00">16:00</option>
														<option value="16:30">16:30</option>
														<option value="17:00">17:00</option>
														<option value="17:30">17:30</option>
														<option value="18:00">18:00</option>
														<option value="18:30">18:30</option>
														<option value="19:00">19:00</option>
														<option value="19:30">19:30</option>
														<option value="20:00">20:00</option>
														<option value="20:30">20:30</option>
														<option value="21:00">21:00</option>
														<option value="21:30">21:30</option>
														<option value="22:00">22:00</option>
														<option value="22:30">22:30</option>
														<option value="23:00">23:00</option>
														<option value="23:30">23:30</option>
														<option value="24:00">24:00</option>
													</select>
												</div>
											</td>
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
							<td>Comment</td>
							<td>:</td>
							<td colspan=2><html:textarea property="" name=""></html:textarea></td>
						</tr>
						<tr>
							<td colspan=4 class="text-right">
								<button id="claim-btn" class="button success">Claim</button>
								<button id="claimclose-btn" class="button success">RFA</button>
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
