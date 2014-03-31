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
		document.organizationForm.task.value = task;
		document.organizationForm.submit();
	};

	$(document).ready(function() {
		$("#first").click(function() {
			$("#task").val("first");
			$("#CRUDForm").submit();
		});
		$("#prev").click(function() {
			$("#task").val("prev");
			$("#CRUDForm").submit();
		});
		$("#next").click(function() {
			$("#task").val("next");
			$("#CRUDForm").submit();
		});
		$("#last").click(function() {
			$("#task").val("last");
			$("#CRUDForm").submit();
		});
		$("#search").click(function() {
			$("#task").val("structure");
			$("#mode").val("structure");
			$("#CRUDForm").submit();
		});
		$("#back").click(function() {
			$("#task").val("back");
			$("#mode").val("");
			$("#CRUDForm").submit();
		});
		$("#searchKeyword").attr("placeholder", "Keyword of Business Unit");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Business Unit Member</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/organization" method="post" styleId="CRUDForm">
					<html:hidden property="task" name="organizationForm" styleId="task" />
					<html:hidden property="mode" name="organizationForm" styleId="mode" />
					<html:hidden property="organizationCode" name="organizationForm" />
					<html:hidden property="orgBean.headDomain" name="organizationForm" />
					<html:hidden property="page" name="organizationForm" />
					<html:hidden property="maxpage" name="organizationForm" />
					
					<table class="table">
						<thead>
							<tr>
								<th colspan="3"><h3>Business Unit Member</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="field-form">Business Unit</th>
								<td class="field-separator">:</td>
								<td><bean:write name="organizationForm" property="orgBean.organizationName" /></td>
							</tr>
							<tr>
								<th class="field-form">Business Unit Head</th>
								<td class="field-separator">:</td>
								<td><bean:write name="organizationForm" property="orgBean.headName" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-control select">
										<html:select property="searchCategory" name="organizationForm">
											<html:option value="All">All</html:option>
											<html:option value="memberDomain">Employee Domain</html:option>
											<html:option value="memberCode">Employee Code</html:option>
											<html:option value="memberName">Employee Name</html:option>
										</html:select>
									</div>
								</td>
								<td class="field-separator">:</td>
								<td class="text-center">
									<div class="input-control text">
										<html:text property="searchKeyword" name="organizationForm" styleId="searchKeyword"></html:text>
										<button id="search" class="btn-search"></button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">User Domain</th>
								<th class="text-center">Employee Name</th>
								<th class="text-center">Employee Code</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="organizationForm"
								property="listMemberOrganizations">
								<logic:iterate id="organization" name="organizationForm" property="listMemberOrganizations">
									<tr>
										<td class="text-center"><bean:write name="organization" property="memberDomain" /></td>
										<td><bean:write name="organization" property="memberName" /></td>
										<td class="text-center"><bean:write name="organization" property="memberCode" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<tr>

							</tr>
						</tbody>
					</table>

					<table class="table striped bordered hovered">
						<tr>
							<td class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a id="first">
											<i class="icon-first-2"></i></a></li>
										<li class="prev"><a id="prev">
											<i class="icon-previous"></i></a></li>
										<li class="disabled">
											<a>Page <bean:write name="organizationForm" property="page" /> 
												of <bean:write name="organizationForm" property="maxpage" /></a></li>
										<li class="next"><a id="next"><i class="icon-next"></i></a></li>
										<li class="last"><a id="last"><i class="icon-last-2"></i></a></li>
										<li class="disabled"><a>Total Record 
											<bean:write name="organizationForm" property="countRecord" /></a></li>
									</ul>
								</div>
							</td>
							<td class="text-right field-form"><html:button property="cancel" styleId="back" styleClass="button info">Back</html:button></td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>