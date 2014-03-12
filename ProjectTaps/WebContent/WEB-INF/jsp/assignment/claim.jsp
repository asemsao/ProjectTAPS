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
							<td>Assignment Date</td>
							<td>:</td>
							<td colspan=2><bean:write property="claimBean.assignmentDate" name="claimAssignmentForm" /></td>
						</tr>
						<tr>
							<td>Assignment Due Date</td>
							<td>:</td>
							<td colspan=2><bean:write property="claimBean.assignmentDueDate" name="claimAssignmentForm" /></td>
						</tr>
						<tr>
							<td>Assignment Type</td>
							<td>:</td>
							<td colspan=2><bean:write property="claimBean.assignmentType" name="claimAssignmentForm" /></td>
						</tr>
						<tr>
							<td>Assign To</td>
							<td>:</td>
							<td><bean:write property="claimBean.assignTo" name="claimAssignmentForm" /></td>
							<td><b>Assignment From </b> : <bean:write property="claimBean." name="claimAssignmentForm" /></td>
						</tr>
						<tr>
							<td>Reff Assignment</td>
							<td>:</td>
							<td colspan=2><bean:write property="claimBean.reffTaskCode" name="claimAssignmentForm" /></td>
						</tr>
						<tr>
							<td>Description</td>
							<td>:</td>
							<td colspan=2><bean:write property="claimBean.description" name="claimAssignmentForm" />
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
											<td><html:textarea property="" name="claimAssignmentForm" rows="2" styleClass="input-control textarea"></html:textarea>
											</td>
											<td class="text-center">
												<div class="input-control select">
													<html:select name="claimAssignmentForm" property="">
														<html:option value="">00:00</html:option>
														<html:option value="00:30">00:30</html:option>
														<html:option value="01:00">01:00</html:option>
														<html:option value="01:30">01:30</html:option>
														<html:option value="02:00">02:00</html:option>
														<html:option value="02:30">02:30</html:option>
														<html:option value="03:00">03:00</html:option>
														<html:option value="03:30">03:30</html:option>
														<html:option value="04:00">04:00</html:option>
														<html:option value="04:30">04:30</html:option>
														<html:option value="05:00">05:00</html:option>
														<html:option value="05:30">05:30</html:option>
														<html:option value="06:00">06:00</html:option>
														<html:option value="06:30">06:30</html:option>
														<html:option value="07:00">07:00</html:option>
														<html:option value="07:30">07:30</html:option>
														<html:option value="08:00">08:00</html:option>
														<html:option value="08:30">08:30</html:option>
														<html:option value="09:00">09:00</html:option>
														<html:option value="09:30">09:30</html:option>
														<html:option value="10:00">10:00</html:option>
														<html:option value="10:30">10:30</html:option>
														<html:option value="11:00">11:00</html:option>
														<html:option value="11:30">11:30</html:option>
														<html:option value="12:00">12:00</html:option>
														<html:option value="12:30">12:30</html:option>
														<html:option value="13:00">13:00</html:option>
														<html:option value="13:30">13:30</html:option>
														<html:option value="14:00">14:00</html:option>
														<html:option value="14:30">14:30</html:option>
														<html:option value="15:00">15:00</html:option>
														<html:option value="15:30">15:30</html:option>
														<html:option value="16:00">16:00</html:option>
														<html:option value="16:30">16:30</html:option>
														<html:option value="17:00">17:00</html:option>
														<html:option value="17:30">17:30</html:option>
														<html:option value="18:00">18:00</html:option>
														<html:option value="18:30">18:30</html:option>
														<html:option value="19:00">19:00</html:option>
														<html:option value="19:30">19:30</html:option>
														<html:option value="20:00">20:00</html:option>
														<html:option value="20:30">20:30</html:option>
														<html:option value="21:00">21:00</html:option>
														<html:option value="21:30">21:30</html:option>
														<html:option value="22:00">22:00</html:option>
														<html:option value="22:30">22:30</html:option>
														<html:option value="23:00">23:00</html:option>
														<html:option value="23:30">23:30</html:option>
														<html:option value="24:00">24:00</html:option>
													</html:select>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan=2 class="text-right">Total</td>
											<td class="text-center"><bean:write property=""	name="claimAssignmentForm" /></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>Comment</td>
							<td>:</td>
							<td colspan=2><html:textarea property="" name="claimAssignmentForm" rows="3"
									styleClass="input-control textarea"></html:textarea></td>
						</tr>
						<tr>
							<td colspan=4 class="text-right">
								<html:button property="claim-btn" styleClass="button success">Claim</html:button>
								<html:button property="claimclose-btn" styleClass="button success">RFA</html:button>
								<html:button property="cancel-btn" styleClass="button info">Cancel</html:button>
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
							<td class="text-center"><bean:write property=""	name="claimAssignmentForm" /></td>
							<td class="text-center"><bean:write property=""	name="claimAssignmentForm" /></td>
							<td class="text-center"><bean:write property=""	name="claimAssignmentForm" /></td>
							<td class="text-center"><bean:write property=""	name="claimAssignmentForm" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
