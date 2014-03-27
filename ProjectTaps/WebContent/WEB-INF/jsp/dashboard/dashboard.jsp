<%@page import="adins.ace.taps.bean.module.RoleBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!doctype html>
<html>
<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="/js/import.jsp" />
<title>Taps</title>
<script type="text/javascript">
	$(document).ready(function() {
		if ($("#messagecp").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#messagecp").val()
				});
			}, 1000);
		}
		if ($("#spv").val() == "true") {
			$("#menu-dashboard").addClass('spanSpv');
		}else{
			$("#menu-dashboard").addClass('spanEmp');
		}
	});
	function flyToPage(task) {
		document.dashboardForm.task.value = task;
		document.dashboardForm.submit();
	}
</script>
<script src="<%=request.getContextPath()%>/js/other/dashboard.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/jquery-ui.min.js"></script>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	
	<%
		List<RoleBean> roleList = (List) session.getAttribute("role");
		boolean is_spv = false;
		for (int i = 0; i < roleList.size(); i++) {
			if (roleList.get(i).getRoleId().equals("spv")) {
				is_spv = true;
				break;
			}
		}
	%>
	
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<%
					String msg = "";
					String color = "";
					if (session.getAttribute("messagecp") != null) {
						msg = session.getAttribute("messagecp").toString();
						color = session.getAttribute("messagecolor").toString();
						session.removeAttribute("messagecp");
						session.removeAttribute("messagecolor");
					}
				%>
				<input type="hidden" id="messagecp" value="<%=msg%>" />
				<input type="hidden" id="messagecolor" value="<%=color%>" />
				<input type="hidden" id="spv" value="<%=is_spv%>" />
				<html:form action="/dashboard" method="post">
					<html:hidden property="task" name="dashboardForm" />
					<h2 class="fg-steel">Things To Do</h2>
					<div id="menu-dashboard" class="center-taps">
						<%
								for (int i = 0; i < roleList.size(); i++) {
									if (roleList.get(i).getRoleId().equals("spv")) {
						%>
						<a href="#" onclick="javascript:flyToPage('approvalDashboard');"
							data-hint="Approval Assignment" data-hint-position="left"
							class="tile bg-cyan" id="rfa-link"> <span
							class="tile-content icon"> <img alt=""
								src="images/APPROVAL_ASSIGNMENT.png">
						</span> <span class="brand"> <span id="rfa-badge"
								class="badge bg-gray"><span id="rfa"><bean:write
											property="totalRFA" name="dashboardForm" /></span></span>
						</span>
						</a> <a href="#"
							onclick="javascript:flyToPage('approvalSelfDashboard');"
							data-hint="Approval Self Assignment" data-hint-position="left"
							class="tile bg-cyan" id="rfa-s-link"> <span
							class="tile-content icon"> <img alt=""
								src="images/APPROVAL_NEW_ASSIGNMENT.png">
						</span> <span class="brand"> <span id="rfa-s-badge"
								class="badge bg-gray"><span id="rfa-s"> <bean:write
											property="totalRFAself" name="dashboardForm" /></span></span>
						</span> <%
 	}
 		}
 %>

						</a> <a href="#" onclick="javascript:flyToPage('claimDashboard');"
							data-hint="Claim Assignment" data-hint-position="left"
							class="tile bg-cyan" id="claim-link"> <span
							class="tile-content icon"> <img alt=""
								src="images/CLAIM_ASSIGNMENT.png">
						</span> <span class="brand"> <span id="claim-badge"
								class="badge bg-gray"><span id="claim"><bean:write
											property="totalClaim" name="dashboardForm" /></span></span>
						</span>
						</a> <a href="#"
							onclick="javascript:flyToPage('correctionDashboard');"
							data-hint="Correction Assignment" data-hint-position="left"
							class="tile bg-cyan" id="correction-link"> <span
							class="tile-content icon"> <img alt=""
								src="images/CORRECTION_ASSIGNMENT.png">
						</span> <span class="brand"> <span id="correction-badge"
								class="badge bg-gray"><span id="correction"> <bean:write
											property="totalCorrection" name="dashboardForm" /></span></span>
						</span>
						</a> <a href="#"
							onclick="javascript:flyToPage('correctionSelfDashboard');"
							data-hint="Correction Self Assignment" data-hint-position="left"
							class="tile bg-cyan" id="correction-s-link"> <span
							class="tile-content icon"> <img alt=""
								src="images/CORRECTION_NEW_ASSIGNMENT.png">
						</span> <span class="brand"> <span id="correction-s-badge"
								class="badge bg-gray"><span id="correction-s"> <bean:write
											property="totalCorrectionSelf" name="dashboardForm" /></span></span>
						</span>
						</a>
					</div>
				</html:form>
			</div>

			<div class="row row-taps shadow-taps">
				<div class="span-ranking-taps">
					<h2 class="fg-steel">TOP 10 <i class="icon-arrow-right-4"></i>&nbsp;<%=session.getAttribute("organizationCode") %> (This Month)</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th colspan=2>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTenOrganization"
								name="dashboardForm">
								<logic:iterate id="employee" property="listTopTenOrganization"
									name="dashboardForm">
									<tr>
										<td class="text-center"><img
											src="dashboard.do?task=getPhoto&employeeDomain=<bean:write name="employee" property="userDomain" />"
											class="ava-rank"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTenOrganization"
								name="dashboardForm">
								<tr>
									<td class="text-center" colspan="3">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>

					<h2 class="fg-steel">TOP 10 <i class="icon-arrow-right-4"></i>&nbsp;<%=session.getAttribute("organizationCode") %> (Last Month)</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th colspan=2>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTenOrganizationPrev"
								name="dashboardForm">
								<logic:iterate id="employee"
									property="listTopTenOrganizationPrev" name="dashboardForm">
									<tr>
										<td class="text-center"><img
											src="dashboard.do?task=getPhoto&employeeDomain=<bean:write name="employee" property="userDomain" />"
											class="ava-rank"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTenOrganizationPrev"
								name="dashboardForm">
								<tr>
									<td class="text-center" colspan="3">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
				</div>

				<div class="span-ranking-taps">
					<h2 class="fg-steel">TOP 10 <i class="icon-arrow-right-4"></i>&nbsp;All Business Unit (This Month)</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th colspan=2>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTen" name="dashboardForm">
								<logic:iterate id="employee" property="listTopTen"
									name="dashboardForm">
									<tr>
										<td class="text-center"><img
											src="dashboard.do?task=getPhoto&employeeDomain=<bean:write name="employee" property="userDomain" />"
											class="ava-rank"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTen" name="dashboardForm">
								<tr>
									<td class="text-center" colspan="3">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>

					<h2 class="fg-steel">TOP 10 <i class="icon-arrow-right-4"></i>&nbsp;All Business Unit (Last Month)</h2>
					<table class="table bordered shadow-taps">
						<thead>
							<tr>
								<th colspan=2>Employee</th>
								<th>Total Star</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty property="listTopTenPrev" name="dashboardForm">
								<logic:iterate id="employee" property="listTopTenPrev"
									name="dashboardForm">
									<tr>
										<td class="text-center"><img
											src="dashboard.do?task=getPhoto&employeeDomain=<bean:write name="employee" property="userDomain" />"
											class="ava-rank"></td>
										<td><bean:write property="employeeName" name="employee" /></td>
										<td class="text-center"><bean:write property="totalStar"
												name="employee" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty property="listTopTenPrev" name="dashboardForm">
								<tr>
									<td class="text-center" colspan="3">Data Not Found</td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
