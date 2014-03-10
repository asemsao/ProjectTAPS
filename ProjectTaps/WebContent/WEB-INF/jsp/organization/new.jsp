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
<script language="JavaScript">
	$(document)
			.ready(
					function() {
						$(
								"#searchOrganizationOnLookUp, #next-ajax, #prev-ajax, #first-ajax, #last-ajax")
								.click(
										function(e) {
											$("#task").val($(this).attr("id"));
											var task = $("#task").val();
											var search = $("#search").val();
											var value = $("#value").val();
											var page = $("#page").val();
											var maxpage = $("#maxpage").val();
											var data = "task=" + task
													+ "&search=" + search
													+ "&value=" + value
													+ "&page=" + page
													+ "&maxpage=" + maxpage;
											$
													.ajax({
														url : "/ProjectTaps/organization.do",
														type : "POST",
														data : data,
														context : this,
														error : function() {
														},
														success : function(data) {
															var json = $
																	.parseJSON(data);

															var content = "<table ";
											content += "class='table striped bordered hovered'>";
															content += "<thead>";
															content += "<tr>";
															content += "<td>No</td>";
															content += "<td>Name</td>";
															content += "</tr>";
															content += "</thead>";
															content += "<tbody>";
															content += "<thead>";
															content += "<tr>";
															content += "<th class='text-center'>Choose</th>";
															content += "<th class='text-center'>Organization Code</th>";
															content += "<th class='text-center'>Organization Name</th>";
															content += "<th class='text-center'>Head Name</th>";
															content += "</tr>";
															content += "</thead>";
															content += "<tbody>";
															for ( var i in json.listOrganizations) {
																content += "<tr>";
																content += "<td class='text-center'>";
																content += "<input type='radio' name='organization_choose'";
												content += "value='"+json.listOrganizations[i].organizationCode+"' />";
																content += "</td>";
																content += "<td>";
																content += json.listOrganizations[i].organizationCode;
																content += "</td>";
																content += "<td>";
																content += json.listOrganizations[i].organizationName;
																content += "</td>";
																content += "<td>";
																content += json.listOrganizations[i].headName;
																content += "</td>";
																content += "</tr>";
															}
															content += "</tbody>";
															content += "</table>";
															$(
																	"#table-ajax-organization")
																	.html(
																			content);
															$("#current-page")
																	.html(
																			json.page);
															$("#max-page")
																	.html(
																			json.maxpage);
															$("#max-page")
																	.html(
																			json.countRecord);
														}
													});
										});
					});
</script>


<title>Add Organization</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<table class="table">
					<thead>
						<tr>
							<th colspan="3">Add Organization</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Organization Code</td>
							<td>:</td>
							<td><div class="input-control text size3">
									<input type="text" placeholder="Organization Code" />
								</div></td>
						</tr>
						<tr>
							<td>Organization Name</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Organization Name" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Head Name</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Head of Organization"
										readonly="readonly" />
									<button class="btn-search" id="employee"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td>Parent Organization</td>
							<td>:</td>
							<td>
								<div class="input-control text size3">
									<input type="text" placeholder="Parent Organization"
										readonly="readonly" id="parent_organization" />
									<button class="btn-search" id="organization"></button>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3" class="text-right">
								<button id="save-btn" onclick="" class="success">Save</button>
								<button id="cancel-btn" onclick="">Cancel</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="lookUpOrganization" class="hide">
		<html:form action="/organization" method="post">
			<html:hidden property="task" styleId="task" name="organizationForm"
				value="next-ajax" />
			<html:hidden styleId="page" property="page" name="organizationForm" />
			<html:hidden styleId="maxpage" property="maxpage"
				name="organizationForm" />

			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=4 class="text-center">Organization</th>
					</tr>
					<tr>
						<th class="text-center" colspan=1>
							<div class="input-control select">
								<html:select property="search" name="organizationForm"
									styleId="search">
									<html:option value="">All</html:option>
									<html:option value="organizationCode">Organization Code</html:option>
									<html:option value="organizationName">Organization Name</html:option>
									<html:option value="headName">Head Name</html:option>
								</html:select>
							</div>
						</th>
						<th class="text-center" colspan=3>
							<div class="input-control text">
								<html:text property="value" name="organizationForm"
									styleId="value" value="devririza"></html:text>
								<button type="button" id="searchOrganizationOnLookUp"
									class="btn-search"></button>
							</div>
						</th>
					</tr>
				</thead>
			</table>
			<div id="table-ajax-organization">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th class="text-center">Choose</th>
							<th class="text-center">Organization Code</th>
							<th class="text-center">Organization Name</th>
							<th class="text-center">Head Name</th>

						</tr>
					</thead>
					<tbody>
						<logic:notEmpty name="organizationForm"
							property="listOrganizations">
							<logic:iterate id="organization" name="organizationForm"
								property="listOrganizations">
								<tr>
									<td class="text-center"><input type='radio'
										name='organization_choose'
										value='<bean:write name="organization"
										property="organizationCode" />@<bean:write name="organization"
										property="organizationName" />' />
									</td>
									<td><bean:write name="organization"
											property="organizationCode" /></td>
									<td><bean:write name="organization"
											property="organizationName" /></td>
									<td><bean:write name="organization" property="headName" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>

					</tbody>
				</table>
			</div>
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=3 class="text-center">
							<div class="pagination">
								<ul>
									<li class="first"><a id="first-ajax"
										onclick="javascript:firstOrganization();"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a id="prev-ajax"
										onclick="javascript:prevOrganization();"><i class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <span id="current-page"><bean:write
													name="organizationForm" property="page" /></span> of <span
											id="max-page"> <bean:write name="organizationForm"
													property="maxpage" /></span></a></li>
									<li class="next-ajax"><a id="next-ajax"
										onclick="javascript:nextOrganization();"><i
											class="icon-next"></i></a></li>
									<li class="last"><a id="last-ajax"
										onclick="javascript:lastOrganization();"><i
											class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <span
											id="total-record"><bean:write name="organizationForm"
													property="countRecord" /></span></a></li>
								</ul>
							</div>
						</th>
						<th class="text-center"><button type="button"
								class='button success'
								onclick="javascript:chooseBussinessUnit()">Add</button></th>
					</tr>
				</thead>
			</table>
		</html:form>
	</div>




	<jsp:include page="/frame/footer.jsp" />
	<!-- 	<div id="popup_employee" class="hide"> -->
	<%-- 		<jsp:include page="/lookup/_employee.jsp" /></div> --%>
	<!-- 	<div id="popup_organization" class="hide"> -->
	<%-- 		<jsp:include page="/lookup/_organization.jsp" /></div> --%>
</body>

</html>