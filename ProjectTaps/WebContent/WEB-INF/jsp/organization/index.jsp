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
	$(document).ready(function() {
		$("#first").click(function() {
			$("#task").val("first");
			$("#organizationForm").submit();
		});
		$("#prev").click(function() {
			$("#task").val("prev");
			$("#organizationForm").submit();
		});
		$("#next").click(function() {
			$("#task").val("next");
			$("#organizationForm").submit();
		});
		$("#last").click(function() {
			$("#task").val("last");
			$("#organizationForm").submit();
		});
	});
</script>
<title>Organization</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/organization" method="post"
					styleId="organizationForm">
					<html:hidden property="task" styleId="task" name="organizationForm" />
					<html:hidden property="page" name="organizationForm" />
					<html:hidden property="maxpage" name="organizationForm" />

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th colspan=6 class="text-center">Organization</th>
							</tr>
							<tr>
								<th class="text-center" colspan=1>
									<div class="input-control select">
										<select>
											<option value="">All</option>
											<option value="organizationCode">Organization Code</option>
											<option value="organizationName">Organization Name</option>
											<option value="headName">Head Name</option>
										</select>
									</div>
								</th>
								<th class="text-center" colspan=5>
									<div class="input-control text">
										<input type="text" placeholder="Keyword of Organization" />
										<button class="btn-search"></button>
									</div>
								</th>
							</tr>
							<tr>
								<th class="text-center">Organization Code</th>
								<th class="text-center">Organization Name</th>
								<th class="text-center">Head Name</th>
								<th class="text-center">Member</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="organizationForm"
								property="listOrganizations">
								<logic:iterate id="organization" name="organizationForm"
									property="listOrganizations">
									<tr>
										<td><bean:write name="organization"
												property="organizationCode" /></td>
										<td><bean:write name="organization"
												property="organizationName" /></td>
										<td><bean:write name="organization" property="headName" /></td>
										<td class="text-center"><a href="structure.jsp"
											data-hint="Member Organization" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/MEMBER.png" /></a></td>
										<td class="text-center"><a href="new.jsp"
											data-hint="Edit Organization" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
										<td class="text-center"><a href="javascript:confDel()"
											data-hint="Delete Organization" data-hint-position="bottom"><img
												alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
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
											<li class="last"><a><i id="last" class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record <bean:write
														name="organizationForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
								<td class="text-center"><a href="new.jsp"
									data-hint="Add Organization" data-hint-position="bottom"><img
										alt=""
										src="<%=request.getContextPath()%>/images/ADD_ORGANIZATIONS.png"></a></td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</html>