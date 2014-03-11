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
</script>
<jsp:include page="/js/import.jsp" />

<title>Appraisal</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/specialAppraisal" method="post" styleClass="specialAppraisalForm">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">

					<table class="table striped bordered hovered">
						<thead>
						<tr>
								<th colspan=4 class="text-center"><h3>Special
										Appraisal</h3></th>
							</tr>
								<th>
								Employee Name  :
								</th>

								<th colspan=3>
									<div class="input-control text">
										<html:text property="searchKeyword" name="specialAppraisalForm" styleId="searchKeyword"></html:text>
										<button class="btn-search" onclick="javascript:flyToPage('search');"></button>
									</div>
								</th>
							</tr>
							
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
										<td class="text-center"><bean:write
												name="specialAppraisal" property="appraisalStar" /></td>
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
									<td class="text-center" colspan="7">Special Appraisal Not
										Found</td>
								</tr>
							</logic:empty>

							<tr>
							<tr>
								<td colspan=3 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a href="javascript:flyToPage('first');"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a href="javascript:flyToPage('prev');"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write
														name="specialAppraisalForm" property="page" /> of <bean:write
														name="specialAppraisalForm" property="maxpage" /></a></li>
											<li class="next"><a href="javascript:flyToPage('next');"><i class="icon-next"></i></a></li>
											<li class="last"><a href="javascript:flyToPage('last');"><i class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <bean:write
														name="specialAppraisalForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
								
								<td class="text-center"><a
									href="javascript:flyToPage('New');"
									data-hint="View Special Appraisal" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/ADD_STAR.png"></a></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<html:hidden property="task" name="specialAppraisalForm" />
		<html:hidden property="param" name="specialAppraisalForm" />
		<html:hidden property="maxpage" name="specialAppraisalForm" />
		<html:hidden property="page" name="specialAppraisalForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>