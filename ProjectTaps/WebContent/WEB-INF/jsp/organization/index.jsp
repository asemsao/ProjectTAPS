<%@page import="com.sun.xml.internal.messaging.saaj.util.transform.EfficientStreamingTransformer"%>
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
	$(document).ready(function() {
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
		$("#new").click(function() {
			$("#task").val("new");
			$("#CRUDForm").submit();
		});
		$(".sturctureOrganization").click(function() {
			$("#task").val("structure");
			$("#organizationCode").val($(this).attr('alt').trim());
			$("#CRUDForm").submit();
		});
		$(".editOrganization").click(function() {
			$("#task").val("edit");
			$("#organizationCode").val($(this).attr('alt').trim());
			$("#CRUDForm").submit();
		});
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
		$(".delete-link").click(function() {
			$("#organizationCode").val($(this).attr('alt').trim());
			$("#CRUDForm").val($(this).attr('alt').trim());
		});
		$("#searchKeyword").attr("placeholder", "Keyword of Business Unit");
		
		$("#restore-organization").click(function() {
			$("#task").val("restorePage");
			$("#CRUDForm").submit();
		});
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Business Unit</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/organization" method="post" styleId="CRUDForm">
					<html:hidden property="task" styleId="task" name="organizationForm" />
					<html:hidden property="organizationCode" styleId="organizationCode" name="organizationForm" />
					<html:hidden property="page" name="organizationForm" />
					<html:hidden property="maxpage" name="organizationForm" />
					<html:hidden property="organizationCode" styleId="organizationCode" name="organizationForm" />
					<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="organizationForm" />">
					<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="organizationForm" />">
					<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" >

					<table class="table">
						<tr>
							<th colspan="8" class="text-center"><h3>Business Unit</h3></th>
						</tr>
						<tr>
							<td class="text-center field-form">
								<div class="input-control select">
									<html:select property="searchCategory" name="organizationForm">
										<html:option value="all">All</html:option>
										<html:option value="organizationCode">Business Unit Code</html:option>
										<html:option value="organizationName">Business Unit Name</html:option>
										<html:option value="headName">Head Name</html:option>
									</html:select>
								</div>
							</td>
							<td class="text-center">
								<div class="input-control text">
									<html:text property="searchKeyword" name="organizationForm" styleId="searchKeyword"></html:text>
									<button id="search" class="btn-search"></button>
								</div>
							</td>
						</tr>
					</table>

					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center" colspan = "<%=Integer.parseInt(request.getAttribute("maxLevel").toString())+1 %>">Business Unit Code</th>
								<th class="text-center">Business Unit Name</th>
								<th class="text-center">Head Name</th>
								<th class="text-center">Member</th>
								<th class="text-center">Edit</th>
								<th class="text-center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="organizationForm" property="listOrganizations">
								<logic:iterate id="organization" name="organizationForm" property="listOrganizations">
									<tr>
									<%String maxLevel=request.getAttribute("maxLevel").toString();
									for(int i=0; i<=Integer.parseInt(maxLevel);i++){ %>
										<td>
										<logic:equal value="<%=String.valueOf(i) %>" name="organization" property="organizationLevel">
											<bean:write name="organization" property="organizationCode" />
										</logic:equal>												
										</td>
										<%} %>										
										<td><bean:write name="organization" property="organizationName" /></td>
										<td><bean:write name="organization" property="headName" /></td>
										<td class="text-center">
											<a class="sturctureOrganization" alt="<bean:write name='organization' property='organizationCode' />" data-hint="Member Organization" data-hint-position="bottom">
												<img src="<%=request.getContextPath()%>/images/MEMBER.png" />
											</a>
										</td>
										<td class="text-center">
											<a class='editOrganization' alt="<bean:write name='organization' property='organizationCode' />" data-hint="Edit Organization" data-hint-position="bottom">
												<img alt="" src="<%=request.getContextPath()%>/images/EDIT.png">
											</a>
										</td>
										<td class="text-center">
											<a href="#" class="delete-link deleteOrganization" data-hint="Delete Organization" data-hint-position="bottom" alt="<bean:write name="organization" property="organizationCode" />">
												<img alt="" src="<%=request.getContextPath()%>/images/DELETE.png">
											</a>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</tbody>
					</table>

					<table class="table">
						<tr>
							<td class="text-center">
								<div class="pagination">
									<ul>
										<li class="first"><a id="first"><i class="icon-first-2"></i></a></li>
										<li class="prev"><a id="prev"><i class="icon-previous"></i></a></li>
										<li class="disabled"><a>Page <bean:write name="organizationForm" property="page" /> 
											of <bean:write name="organizationForm" property="maxpage" /></a></li>
										<li class="next"><a id="next"><i class="icon-next"></i></a></li>
										<li class="last"><a id="last"><i class="icon-last-2"></i></a></li>
										<li class="disabled"><a>Total Record 
											<bean:write name="organizationForm" property="countRecord" /></a></li>
									</ul>
								</div>
							</td>
							<td>
							<button id="restore-organization" data-hint="Restore Organization" data-hint-position="bottom">Restore Organization</button>
							</td>
							<td class="text-center field-form">
								<a id="new"	data-hint="Add Organization" data-hint-position="bottom">
									<img alt="" src="<%=request.getContextPath()%>/images/ADD_ORGANIZATIONS.png">
								</a>
							</td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<div class="hide" id="lookUpDeleteOrganization"></div>
	<jsp:include page="/frame/footer.jsp" /></body>
</html>
