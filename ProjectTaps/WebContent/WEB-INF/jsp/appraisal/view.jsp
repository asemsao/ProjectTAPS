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
								<td>25/02/2014</td>
							</tr>
							<tr>
								<td class="size3">Appraisal To</td>
								<td>:</td>
								<td>Devri</td>
							</tr>
							<tr>
								<td class="size3">Appraisal Description</td>
								<td>:</td>
								<td>UI UI UI</td>
							</tr>
							<tr>
								<td class="size3">Appraisal Star</td>
								<td>:</td>
								<td>
									<div class="rating" id="rating">
										<ul>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
											<li class="rated"></li>
										</ul>
										<span class="score-hint"></span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right">
									<html:button
										property="back" onclick="javascript:flyToPage('Back');"
										styleClass="button success">Back</html:button>
								</td>
										
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="specialAppraisalForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>