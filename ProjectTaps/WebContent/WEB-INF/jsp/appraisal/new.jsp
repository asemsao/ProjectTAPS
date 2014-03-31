<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.struts.Globals"%> 
<%@page import="org.apache.struts.taglib.html.Constants"%> 
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
	function flyToPage(task) {
		if (task == "cancel") {
			document.specialAppraisalForm.task.value = "";
			document.specialAppraisalForm.submit();
			return;
		} else if (task == "Appraisal") {
			document.specialAppraisalForm.task.value = task;
			specialAppraisalValidation();
		}
	}

	$(document).ready( function() {
		if ($("#messageCRUD").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#messageCRUD").val()
				});
			}, 1000);
		}
		setTimeout(	function() {
			$("#lookUpEmployee").load("/ProjectTaps/ajax.do?mode=employees&task=employees");
		}, 500);
		$("#description").attr("maxlength", "1000");
		$("#createdDate").attr("placeholder", "Date");
		$("#employee-name").attr("placeholder", "Employee Name");
		$("#description").attr("placeholder", "Description");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>New Special Appraisal</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/specialAppraisal" method="post" styleId="specialAppraisal">
					<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" > 
					<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="specialAppraisalForm" />">
					<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="specialAppraisalForm" />">
					<html:hidden property="task" name="specialAppraisalForm" />
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center">Special Appraisal</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Appraisal Date</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text " id="datepicker-begin">
										<html:text property="appraisalBean.createdDate" styleId="createdDate" name="specialAppraisalForm" styleClass="datepicker-back"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal To</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:hidden property="appraisalBean.userDomain" name="specialAppraisalForm" styleId="employee-domain" /> <html:text property="appraisalBean.employeeName"
											readonly="true" name="specialAppraisalForm" styleId="employee-name"></html:text>
										<button class="btn-search" type="button" id="employee"></button>
									</div></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal Description</th>
								<td class="field-separator">:</td>
								<td><html:textarea styleClass="input-control textarea" styleId="description" property="appraisalBean.description" name="specialAppraisalForm" /></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal Star edit</th>
								<td class="field-separator">:</td>
								<td>
									<div class="star-hider">
										<div class="rating-kiri" style="float: left;">
											<select id="rating-kiri" name="rating">
												<option value="-5">-5</option>
												<option value="-4">-4</option>
												<option value="-3">-3</option>
												<option value="-2">-2</option>
												<option value="-1">-1</option>
											</select>
										</div>

										<div class="rating-tengah" style="float: left;">
											<select id="rating-tengah" name="rating">
												<option value="0">0</option>
											</select>
										</div>

										<div class="rating-kanan" style="float: left;">
											<select id="rating-kanan" name="rating">
												<option value="1">+1</option>
												<option value="2">+2</option>
												<option value="3">+3</option>
												<option value="4">+4</option>
												<option value="5">+5</option>
											</select>
										</div>
										<p class="star"></p>
										<html:hidden property="appraisalBean.appraisalStar" styleId="star" />
										<button type="button" id="edit-star-btn" class="default">Edit</button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button onclick="flyToPage('Appraisal')" class="button success">Appraisal</button>
									<button onclick="flyToPage('cancel')" class="button info">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<div id="lookUpEmployee" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
