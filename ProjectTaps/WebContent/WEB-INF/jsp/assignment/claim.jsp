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
<script type="text/javascript">
	function flyToPage(task) {
		document.claimAssignmentForm.task.value = task;
		document.claimAssignmentForm.submit();
	}
</script>

<title>Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/claimAssignment" method="POST">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<td colspan=4 class="text-center text-bold"><h3>View
										Assignment</h3></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td colspan=2><bean:write
										property="claimBean.assignmentDate" name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Assignment Due Date</td>
								<td>:</td>
								<td colspan=2><bean:write
										property="claimBean.assignmentDueDate"
										name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td colspan=2><logic:equal
										property="claimBean.assignmentType" name="claimAssignmentForm"
										value="BU">Business Unit - 
									<bean:write property="claimBean.organizationName"
											name="claimAssignmentForm" />
									</logic:equal> <logic:equal property="claimBean.assignmentType"
										name="claimAssignmentForm" value="PROJECT"> Project - 
									<bean:write property="claimBean.projectName"
											name="claimAssignmentForm" />
									</logic:equal></td>
							</tr>
							<tr>
								<td>Assign To</td>
								<td>:</td>
								<td><bean:write property="claimBean.fullName"
										name="claimAssignmentForm" /></td>
								<td><b>Assignment From </b> : <bean:write
										property="claimBean.createdByName" name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Reff Assignment</td>
								<td>:</td>
								<td colspan=2><bean:write property="claimBean.reffTaskCode"
										name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td colspan=2><bean:write property="claimBean.description"
										name="claimAssignmentForm" /></td>
							</tr>
							<tr>
								<td>Detail Claim</td>
								<td>:</td>
								<td colspan=2><logic:notEmpty property="listDetailClaim"
										name="claimAssignmentForm">
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
													<logic:iterate id="assignment" property="listDetailClaim"
														name="claimAssignmentForm">
														<tr>
															<td class="text-center"><bean:write
																	property="claimDate" name="assignment" /></td>
															<td><html:textarea property="detailDescription"
																	name="assignment" rows="2"
																	styleClass="input-control textarea"></html:textarea></td>
															<td class="text-center">
																<div class="input-control select">
																	<html:select property="manHours" name="assignment">
																		<html:option value="">00:00</html:option>
																		<html:option value="0.5">00:30</html:option>
																		<html:option value="1">01:00</html:option>
																		<html:option value="1.5">01:30</html:option>
																		<html:option value="2">02:00</html:option>
																		<html:option value="2.5">02:30</html:option>
																		<html:option value="3">03:00</html:option>
																		<html:option value="3.5">03:30</html:option>
																		<html:option value="4">04:00</html:option>
																		<html:option value="4.5">04:30</html:option>
																		<html:option value="5">05:00</html:option>
																		<html:option value="5.5">05:30</html:option>
																		<html:option value="6">06:00</html:option>
																		<html:option value="6.5">06:30</html:option>
																		<html:option value="7">07:00</html:option>
																		<html:option value="7.5">07:30</html:option>
																		<html:option value="8">08:00</html:option>
																		<html:option value="8.3">08:30</html:option>
																		<html:option value="9">09:00</html:option>
																		<html:option value="9.5">09:30</html:option>
																		<html:option value="10">10:00</html:option>
																		<html:option value="10.5">10:30</html:option>
																		<html:option value="11">11:00</html:option>
																		<html:option value="11.5">11:30</html:option>
																		<html:option value="12">12:00</html:option>
																		<html:option value="12:30">12:30</html:option>
																		<html:option value="13">13:00</html:option>
																		<html:option value="13.5">13:30</html:option>
																		<html:option value="14">14:00</html:option>
																		<html:option value="14.5">14:30</html:option>
																		<html:option value="15">15:00</html:option>
																		<html:option value="15.5">15:30</html:option>
																		<html:option value="16">16:00</html:option>
																		<html:option value="16.5">16:30</html:option>
																		<html:option value="17">17:00</html:option>
																		<html:option value="17.5">17:30</html:option>
																		<html:option value="18">18:00</html:option>
																		<html:option value="18.5">18:30</html:option>
																		<html:option value="19">19:00</html:option>
																		<html:option value="19.5">19:30</html:option>
																		<html:option value="20">20:00</html:option>
																		<html:option value="20.5">20:30</html:option>
																		<html:option value="21">21:00</html:option>
																		<html:option value="21.5">21:30</html:option>
																		<html:option value="22">22:00</html:option>
																		<html:option value="22.5">22:30</html:option>
																		<html:option value="23">23:00</html:option>
																		<html:option value="23.5">23:30</html:option>
																		<html:option value="24">24:00</html:option>
																	</html:select>
																</div>
															</td>
														</tr>

													</logic:iterate>
												<tr>
													<td colspan=2 class="text-right">Total</td>
													<td class="text-center">
														<%-- 													<bean:write property="totalManhours" name="assignment" /> --%>
													</td>
												</tr>
											</tbody>
										</table>
									</logic:notEmpty></td>
							</tr>
							<tr>
								<td>Comment</td>
								<td>:</td>
								<td colspan=2><html:textarea property="claimBean.comment"
										name="claimAssignmentForm" rows="3"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<tr>
								<td colspan=4 class="text-right"><html:button
										property="claim-btn" onclick="javascript:flyToPage('claim');"
										styleClass="button success">Claim</html:button> <html:button
										property="claimclose-btn"
										onclick="javascript:flyToPage('RFA');"
										styleClass="button success">RFA</html:button> <html:button
										property="cancel-btn"
										onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Cancel</html:button></td>
							</tr>
						</tbody>
					</table>

					<logic:notEmpty property="historyComment"
						name="claimAssignmentForm">
						<table class="table striped bordered hovered">
							<thead>
								<tr>
									<th colspan=4 class="text-center text-bold">History
										Comment</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center text-bold">Date</td>
									<td class="text-center text-bold">Comment</td>
									<td class="text-center text-bold">From</td>
									<td class="text-center text-bold">To</td>
									<td class="text-center text-bold">Status</td>
								</tr>
								<logic:iterate id="assignment" property="historyComment"
									name="claimAssignmentForm">
									<tr>
										<td class="text-center"><bean:write
												property="commentDate" name="assignment" /></td>
										<td><bean:write property="assignmentComment"
												name="assignment" /></td>
										<td class="text-center"><bean:write
												property="commentFrom" name="assignment" /></td>
										<td class="text-center"><bean:write property="commentTo"
												name="assignment" /></td>
										<td class="text-center"><bean:write property="status"
												name="assignment" /></td>
								</logic:iterate>
							</tbody>
						</table>
					</logic:notEmpty>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="claimAssignmentForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
