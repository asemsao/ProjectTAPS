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
<title>New Special Appraisal</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/specialAppraisal" method="post">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center">Special Appraisal</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="size3">Appraisal Date</td>
								<td>:</td>
								<td><div class="input-control text " id="datepicker-begin">
										<html:text property="appraisalBean.createdDate"
											name="specialAppraisalForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td class="size3">Appraisal To</td>
								<td>:</td>
								<td><div class="input-control text size3">
								<input type="text" placeholder="Employee" readonly="readonly" />
										<button class="btn-search" id="employee"></button>
									</div></td>
							</tr>
							<tr>
								<td class="size3">Appraisal Description</td>
								<td>:</td>
								<td><html:textarea styleClass="input-control textarea"
										property="appraisalBean.description"
										name="specialAppraisalForm" /></td>
							</tr>
							<tr>
								<td class="size3">Appraisal Star edit</td>
								<td>:</td>
								<td>
									<div class="rating fg-yellow" id="rating">
										<ul>
											<li></li>
											<li></li>
											<li></li>
											<li></li>
											<li></li>
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
								<td colspan="3" class="text-right"><html:button
										property="save" onclick="javascript:flyToPage('Appraisal');"
										styleClass="button success">Appraisal</html:button> <html:button
										property="save" onclick="javascript:flyToPage('Cancel');"
										styleClass="button success">Cancel</html:button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="specialAppraisalForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
	<div id="popup_employee" class="hide"><jsp:include
			page="/lookup/_employee.jsp" /></div>
	<%-- 	<div id="popup_appraisal" class="hide"><jsp:include --%>
	<%-- 			page="/lookup/_appraisal.jsp" /></div> --%>
</body>

</html>