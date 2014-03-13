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
			$("#task").val("search");
			$("#CRUDForm").submit();
		});
		$("#searchKeyword").attr("placeholder", "Keyword of Organization");
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Business Unit Member</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/organization" method="post">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">

					<table class="table">
						<thead>
							<tr>
								<th colspan="2">Business Unit Member</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><b>Business Unit</b></td>
								<td colspan="2"> : <bean:write name="organizationForm"
										property="orgBean.organizationName" /></td>
							</tr>
							<tr>
								<td><b>Business Unit Head</b></td>
								<td colspan="2"> : <bean:write name="organizationForm"
										property="orgBean.headName" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="auto-complete">
										<div class="control-group">
											<html:select property="searchCategory"
												name="organizationForm">
												<html:option value="all">All</html:option>
												<html:option value="userDomain">Employee Domain</html:option>
												<html:option value="employeeCode">Employee Code</html:option>
												<html:option value="employeeName">Employee Name</html:option>
											</html:select>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="input-control text size11">
										<html:text property="searchKeyword" name="organizationForm"
											styleId="searchKeyword"></html:text>
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
								<th class="text-center">Employee Code</th>
								<th class="text-center">Employee Name</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="organizationForm"
								property="listMemberOrganizations">
								<logic:iterate id="organization" name="organizationForm"
									property="listMemberOrganizations">
									<tr>
										<td><bean:write name="organization"
												property="memberDomain" /></td>
										<td><bean:write name="organization"
												property="memberCode" /></td>
										<td><bean:write name="organization"
												property="memberName" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<tr>
								<td colspan=5 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a id="first"><i
													class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prev"><i
													class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write
														name="organizationForm" property="page" /> of <bean:write
														name="organizationForm" property="maxpage" /></a></li>
											<li class="next"><a id="next"><i class="icon-next"></i></a></li>
											<li class="last"><a id="last"><i class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <bean:write
														name="organizationForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
								<td class="text-center"><td colspan=3 class="text-right"><html:button
										property="cancel" onclick="javascript:flyToPage('Cancel');"
										styleClass="button info">Back</html:button></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
		<html:hidden property="task" name="organizationForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>