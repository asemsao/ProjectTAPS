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
		if (task == "cancel") {
			document.dashboardForm.task.value = task;
			document.dashboardForm.submit();
			return;
		} else {
			document.dashboardForm.task.value = task;
			commentDashboardValidation();
		}
	}

	$(document).ready(function() {
		var task_code = $("#task-code").val();
		setTimeout(function() {
			$("#historyComment").load("/ProjectTaps/ajax.do?mode=comments&task=comments&taskCode=" + task_code);
		}, 100);
		
		$(".manHourUpdate").change(function() {
			var totalMh = 0.0;
			$(".manHourUpdate").each(function() {
				totalMh += parseFloat($(this).val());
			});

			$("#total-mh").html(calculateTotalMh(totalMh + ""));

			var detailId = $(this).prev().val();
			var manHour = $(this).val();
			var data = "task=updateDetailClaim&detailId=" + detailId + "&manHour=" + manHour;
			$.ajax({
				url : "/ProjectTaps/claimAssignment.do",
				type : "POST",
				data : data,
				context : this,
				error : function() {
					console.log("problem was here!");
				},
				success : function(data) {
					console.log("success");
				}
			});
		});
	});
</script>

<title>Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/dashboard" method="POST" styleId="dashboardComment">
					<html:hidden property="claimBean.status" name="dashboardForm" styleId="status" />
					<html:hidden property="claimBean.taskCode" name="dashboardForm" styleId="task-code" />
					<html:hidden property="task" name="dashboardForm" />
					<html:hidden property="claimBean.reportTo" name="dashboardForm" />
					<table class="table">
						<tr>
							<td colspan=4 class="text-center text-bold">
								<h3>Correction Assignment</h3>
							</td>
						</tr>
						<tr>
							<th class="field-form">Assignment Date</th>
							<td class="field-separator">:</td>
							<td colspan=2><bean:write property="claimBean.assignmentDate" name="dashboardForm" /></td>
						</tr>
						<tr>
							<th class="field-form">Assignment Due Date</th>
							<td class="field-separator">:</td>
							<td colspan=2><bean:write property="claimBean.assignmentDueDate" name="dashboardForm" /></td>
						</tr>
						<tr>
							<th class="field-form">Assignment Type</th>
							<td class="field-separator">:</td>
							<td colspan=2>
								<logic:equal property="claimBean.assignmentType" name="dashboardForm" value="BU">Business Unit - 
									<bean:write property="claimBean.organizationName" name="dashboardForm" />
								</logic:equal> 
								<logic:equal property="claimBean.assignmentType" name="dashboardForm" value="PROJECT"> Project - 
									<bean:write property="claimBean.projectName" name="dashboardForm" />
								</logic:equal></td>
						</tr>
						<tr>
							<th class="field-form">Assign To</th>
							<td class="field-separator">:</td>
							<td><bean:write property="claimBean.fullName" name="dashboardForm" /></td>
							<td><b>Assignment From </b> : <bean:write property="claimBean.createdByName" name="dashboardForm" /></td>
						</tr>
						<tr>
							<th class="field-form">Reff Assignment</th>
							<td class="field-separator">:</td>
							<td colspan=2><bean:write property="claimBean.reffTaskCode" name="dashboardForm" /></td>
						</tr>
						<tr>
							<th class="field-form">Description</th>
							<td class="field-separator">:</td>
							<td colspan=2><bean:write property="claimBean.description" name="dashboardForm" /></td>
						</tr>
						<tr>
							<th class="field-form">Detail Claim</th>
							<td class="field-separator">:</td>
							<td colspan=2>
								<logic:notEmpty property="listDetailClaim" name="dashboardForm">
									<table class="table striped bordered hovered">
										<thead>
											<tr>
												<th>Claim Date</th>
												<th>Description</th>
												<th>ManHours</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<logic:iterate id="assignment" property="listDetailClaim" name="dashboardForm">
													<tr>
														<td class="text-center"><bean:write property="claimDate" name="assignment" /></td>
														<td><html:textarea property="detailDescription" name="assignment" rows="2" styleClass="input-control textarea" readonly="true"></html:textarea></td>
														<td class="text-center">
															<div class="input-control select">
																<html:hidden property="detailId" name="assignment" />
																<html:select property="manHours" name="assignment" styleClass="manHourUpdate">
																	<html:option value="">00:00</html:option>
																	<html:option value="0.5">00:30</html:option>
																	<html:option value="1.0">01:00</html:option>
																	<html:option value="1.5">01:30</html:option>
																	<html:option value="2.0">02:00</html:option>
																	<html:option value="2.5">02:30</html:option>
																	<html:option value="3.0">03:00</html:option>
																	<html:option value="3.5">03:30</html:option>
																	<html:option value="4.0">04:00</html:option>
																	<html:option value="4.5">04:30</html:option>
																	<html:option value="5.0">05:00</html:option>
																	<html:option value="5.5">05:30</html:option>
																	<html:option value="6.0">06:00</html:option>
																	<html:option value="6.5">06:30</html:option>
																	<html:option value="7.0">07:00</html:option>
																	<html:option value="7.5">07:30</html:option>
																	<html:option value="8.0">08:00</html:option>
																	<html:option value="8.5">08:30</html:option>
																	<html:option value="9.0">09:00</html:option>
																	<html:option value="9.5">09:30</html:option>
																	<html:option value="10.0">10:00</html:option>
																	<html:option value="10.5">10:30</html:option>
																	<html:option value="11.0">11:00</html:option>
																	<html:option value="11.5">11:30</html:option>
																	<html:option value="12.0">12:00</html:option>
																	<html:option value="12.5">12:30</html:option>
																	<html:option value="13.0">13:00</html:option>
																	<html:option value="13.5">13:30</html:option>
																	<html:option value="14.0">14:00</html:option>
																	<html:option value="14.5">14:30</html:option>
																	<html:option value="15.0">15:00</html:option>
																	<html:option value="15.5">15:30</html:option>
																	<html:option value="16.0">16:00</html:option>
																	<html:option value="16.5">16:30</html:option>
																	<html:option value="17.0">17:00</html:option>
																	<html:option value="17.5">17:30</html:option>
																	<html:option value="18.0">18:00</html:option>
																	<html:option value="18.5">18:30</html:option>
																	<html:option value="19.0">19:00</html:option>
																	<html:option value="19.5">19:30</html:option>
																	<html:option value="20.0">20:00</html:option>
																	<html:option value="20.5">20:30</html:option>
																	<html:option value="21.0">21:00</html:option>
																	<html:option value="21.5">21:30</html:option>
																	<html:option value="22.0">22:00</html:option>
																	<html:option value="22.5">22:30</html:option>
																	<html:option value="23.0">23:00</html:option>
																	<html:option value="23.5">23:30</html:option>
																	<html:option value="24.0">24:00</html:option>
																</html:select>
															</div>
														</td>
													</tr>
												</logic:iterate>
											<tr>
												<th colspan=2 class="text-right">Total</th>
												<td class="text-center">
													<span id="total-mh">
														<bean:write property="totalManHours" name="dashboardForm" />
													</span>
												</td>
											</tr>
										</tbody>
									</table>
								</logic:notEmpty>
							</td>
						</tr>
						<tr>
							<th class="field-form">Comment</th>
							<td class="field-separator">:</td>
							<td colspan=2>
								<html:textarea property="claimBean.comment" name="dashboardForm" rows="3" styleId="comment" styleClass="input-control textarea"></html:textarea>
							</td>
						</tr>
						<tr>
							<td colspan=4 class="text-right">
							<logic:equal value="REOPEN" property="claimBean.status" name="dashboardForm">
								<button onclick="javascript:flyToPage('re-rfa');" class="button success">RFA</button>
							</logic:equal>
							<logic:equal value="CORRECTION" property="claimBean.status" name="dashboardForm">
								<button onclick="javascript:flyToPage('rfa');" class="button success">RFA</button> 
							</logic:equal>
							<button onclick="javascript:flyToPage('cancel');" class="button info">Cancel</button>
						</tr>
					</table>
				</html:form>
				<div id="historyComment"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
