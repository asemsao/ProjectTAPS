<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />
<script>
	function flyToPage(task) {
		document.specialAppraisalForm.task.value = task;
		document.specialAppraisalForm.submit();
	}
	function flyToPage2(task, param) {
		document.specialAppraisalForm.task.value = task;
		document.specialAppraisalForm.param.value = param;
		document.specialAppraisalForm.submit();
	}
	$(document).ready(function() {
		$("#startDate").attr("placeholder", "Start Date");
		$("#endDate").attr("placeholder", "End Date");
		$("#searchKeyword").attr("placeholder", "Keyword of Employee");
		if ($("#message").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#message").val()
				});
			}, 1000);
		}
		
	});
</script>

<title>Appraisal</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/specialAppraisal" method="post" styleClass="specialAppraisalForm">
					<html:hidden property="task" name="specialAppraisalForm" />
					<html:hidden property="param" name="specialAppraisalForm" />
					<html:hidden property="maxpage" name="specialAppraisalForm" />
					<html:hidden property="page" name="specialAppraisalForm" />
					
					<table class="table">
							<tr>
								<th colspan=2 class="text-center">
									<h3>Special	Appraisal</h3>
								</th>
							</tr>
							<tr>
								<th class="field-form">Appraisal Date From</th>
								<th>
									<div class="input-control text" id="datepicker-begin">
										<html:text property="startDate" name="specialAppraisalForm"
											styleId="startDate" styleClass="datepicker-start"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="field-form">Appraisal Date To</th>
								<th>
									<div class="input-control text" id="datepicker-begin">
										<html:text property="endDate" name="specialAppraisalForm"
											styleId="endDate" styleClass="datepicker-end"></html:text>
										<button type="button" class="btn-date"></button>
									</div>
								</th>

							</tr>
							<tr>
								<th class="field-form">Employee Name</th>
								<th>
									<div class="input-control text">
										<html:text property="searchKeyword"
											name="specialAppraisalForm" styleId="searchKeyword"></html:text>
										<button class="btn-search"
											onclick="javascript:flyToPage('search');"></button>
									</div>
								</th>
							</tr>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Appraisal Date</th>
								<th class="text-center">Employee Name</th>
								<th class="text-center">Appraisal Star</th>
								<th class="text-center">View</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="specialAppraisalForm"
								property="listSpecialAppraisal">
								<logic:iterate id="specialAppraisal" name="specialAppraisalForm"
									property="listSpecialAppraisal">
									<tr>
										<td class="text-center"><bean:write
												name="specialAppraisal" property="createdDate" /></td>
										<td class="text-center"><bean:write
												name="specialAppraisal" property="employeeName" /></td>
										<td class="text-center"><bean:define id="temp"
												name="specialAppraisal" property="appraisalStar"
												type="Integer" /> 
											<%
											 	Integer sc = temp;
								 				if (sc > 0) {
								 					for (int i = 0; i < sc; i++) {
											%>
														<img src="<%=request.getContextPath()%>/images/star/star_ijo_kecil_catu.png" />
											<%
													}
												} else if (sc < 0) {
													for (int i = 0; i < Math.abs(sc); i++) {
											%> 
														<img src="<%=request.getContextPath()%>/images/star/star_meyah_kecil_catu.png" />
											<%
													}
												} else {
											%> 
														<img src="<%=request.getContextPath()%>/images/star/star_tengah_kecil_catu.png" />
											<%
												}
											%>
										</td>
										<td class="text-center"><a
											href="javascript:flyToPage2('View','<bean:write name="specialAppraisal" property="starId" />');"
											data-hint="View Special Appraisal"
											data-hint-position="bottom"><img alt=""
												src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="specialAppraisalForm"
								property="listSpecialAppraisal">
								<tr>
									<td class="text-center" colspan="7">
										Special Appraisal Not Found
									</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
					
					<table class="table">
						<tr>
							<td class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a
											href="javascript:flyToPage('first');"><i
												class="icon-first-2"></i></a></li>
										<li class="prev"><a href="javascript:flyToPage('prev');"><i
												class="icon-previous"></i></a></li>
										<li class="disabled"><a>Page <bean:write
													name="specialAppraisalForm" property="page" /> of <bean:write
													name="specialAppraisalForm" property="maxpage" /></a></li>
										<li class="next"><a href="javascript:flyToPage('next');"><i
												class="icon-next"></i></a></li>
										<li class="last"><a href="javascript:flyToPage('last');"><i
												class="icon-last-2"></i></a></li>
										<li class="disabled"><a>Total Record <bean:write
													name="specialAppraisalForm" property="countRecord" /></a></li>
									</ul>
								</div>
							</td>
							<td class="text-center field-form"><a
								href="javascript:flyToPage('New');"
								data-hint="New Special Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/ADD_STAR.png"></a></td>
						</tr>
					</table>
					
					<input type="hidden" id="messagecolor"
						value="<bean:write  property="color" name="specialAppraisalForm" />">
					<input type="hidden" id="message"
						value="<bean:write  property="message" name="specialAppraisalForm" />">
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>