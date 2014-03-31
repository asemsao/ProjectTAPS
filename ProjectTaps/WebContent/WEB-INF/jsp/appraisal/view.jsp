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
<script type="text/javascript">
	function flyToPage(task) {
		document.specialAppraisalForm.task.value = task;
		document.specialAppraisalForm.submit();
	}
</script>
<title>View Special Appraisal</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/specialAppraisal" method="post">
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
								<td><bean:write name="specialAppraisalForm"
										property="appraisalBean.createdDate" /></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal To</th>
								<td class="field-separator">:</td>
								<td><bean:write name="specialAppraisalForm"
										property="appraisalBean.employeeName" /></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal Description</th>
								<td class="field-separator">:</td>
								<td><bean:write name="specialAppraisalForm"
										property="appraisalBean.description" /></td>
							</tr>
							<tr>
								<th class="field-form">Appraisal Star</th>
								<td class="field-separator">:</td>
								<td><bean:define id="temp" name="specialAppraisalForm"
										property="appraisalBean.appraisalStar" type="Integer" />
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
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<button	onclick="flyToPage('Back')" class="button success">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>

	<jsp:include page="/frame/footer.jsp" />
</body>

</html>