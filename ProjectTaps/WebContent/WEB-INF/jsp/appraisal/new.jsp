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
		if (task == "cancel") {
			document.specialAppraisalForm.task.value = "";
			document.specialAppraisalForm.submit();
			return;
		} else if (task == "appraisal") {
			document.specialAppraisalForm.task.value = task;
			specialAppraisalValidation();
		}
	}

	$(document).ready(
			function() {
				$("#lookUpEmployee").load(
						"/ProjectTaps/ajax.do?mode=employees&task=employees");
			});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>New Special Appraisal</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/specialAppraisal" method="post"
		styleId="specialAppraisal">
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
											styleId="createdDate" name="specialAppraisalForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td class="size3">Appraisal To</td>
								<td>:</td>
								<td><div class="input-control text">
										<html:hidden property="appraisalBean.userDomain"
											name="specialAppraisalForm" styleId="employee-domain" />
										<input type="text" placeholder="Employee" id="employee-name"
											readonly="readonly" />
										<button class="btn-search" type="button" id="employee"></button>
									</div></td>
							</tr>
							<tr>
								<td class="size3">Appraisal Description</td>
								<td>:</td>
								<td><html:textarea styleClass="input-control textarea"
										styleId="descriptionApp" property="appraisalBean.description"
										name="specialAppraisalForm" /></td>
							</tr>
							<tr>
								<td class="size3">Appraisal Star edit</td>
								<td>:</td>
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
										<html:hidden property="appraisalBean.appraisalStar"
											styleId="star" />
										<button type="button" id="edit-star-btn" class="default">Edit</button>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="text-right"><input type="button"
									onclick="flyToPage('appraisal')" class="button success"
									value="Appraisal" /> <input type="button"
									onclick="flyToPage('cancel')" class="button info"
									value="Cancel"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="task" name="specialAppraisalForm" />
	</html:form>

	<div id="lookUpEmployee" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
