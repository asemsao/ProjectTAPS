<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<%@page import="java.util.List"%>
<%@page import="adins.ace.taps.bean.module.MenuBean"%>
<%@page import="adins.ace.taps.bean.module.RoleBean"%>
<%@page import="adins.ace.taps.manager.LoginManager"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#change-password").on('click', function() {
			$.Dialog({
				shadow : true,
				overlay : true,
				draggable : true,
				icon : '<span class="icon-key-2"></span>',
				title : 'Change Password',
				width : 500,
				padding : 10,
				content : 'This Window is draggable by caption.',
				onShow : function() {
					var content = $("#changePassword").html();
					$.Dialog.title("Change Password");
					$.Dialog.content(content);
				}

			});
		});
	});

	function changePassword() {
		var params = new Object();
		params.task = $("task-change-password").val();
		params.oldPassword = $("#old-password").val();
		params.newPassword = $("#new-password").val();
		params.newPasswordConfirmation = $("#new-password-confirmation").val();
		var data = "task=changePassword&params=" + JSON.stringify(params);
		$.ajax({
			url : "/ProjectTaps/login.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				alert("success");
			}
		});
	}
</script>

<html:form action="/menu" method="POST" styleId="menuForm">
	<div class="bg-dark">
		<div class="navigation-bar dark header-taps">
			<div class="navigation-bar-content container">
				<a href="#" class="element"> <img alt="logo" class="logo"
					src="<%=request.getContextPath()%>/images/LOGO_PANJANG3.png"></a>
				<a class="pull-menu" href="#"></a> <span class="element-divider"></span>
				<ul class="element-menu">
					<li><a href="javascript:menu('dashboard');" class="heading">
							<span class="icon-home"></span> Dashboard
					</a></li>
					<%
						LoginManager lMan = new LoginManager();
							List<RoleBean> roleList = (List) session.getAttribute("role");
							List<MenuBean> listMenu;
							for (int i = 0; i < roleList.size(); i++) {
								listMenu = lMan.getListMenu(roleList.get(i).getRoleId());
					%>

					<li><a class="dropdown-toggle element" href="#"><i
							class="icon-user-3"></i><%=roleList.get(i).getRoleName()%></a>
						<ul class="dropdown-menu" data-role="dropdown">
							<%
								for (int j = 0; j < listMenu.size(); j++) {
											if (!listMenu.get(j).getTask().equals("dashboard")) {
							%>
							<li><a
								href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <%
 	if (listMenu.get(j).getTask()
 							.equals("employeeReport")
 							|| listMenu.get(j).getTask()
 									.equals("employeeReportSupervisor")
 							|| listMenu.get(j).getTask()
 									.equals("report")) {
 %> <span class="icon-clipboard-2"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("assignment")) {
 %> <span class="icon-list"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("appraisal")) {
 %> <span class="icon-trophy"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("employee")) {
 %> <span class="icon-user"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("organization")) {
 %> <span class="icon-briefcase-2"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("project")) {
 %> <span class="icon-puzzle"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("transferProject")) {
 %> <span class="icon-tab"></span> <%
 	} else if (listMenu.get(j).getTask()
 							.equals("manageRole")) {
 %> <span class="icon-cog"></span> <%
 	}
 %> <%=listMenu.get(j).getMenuName()%></a></li>
							<%
								}
										}
							%>
						</ul></li>
					<%
						}
					%>
				</ul>
				<ul class="element-menu place-right">
					<li><a class="dropdown-toggle element image-button image-left"
						href="#"><img src="<%=session.getAttribute("pathPhoto")%>" />
							<%=session.getAttribute("fullname")%></a>
						<ul class="dropdown-menu" data-role="dropdown">
							<li><a title="Change Password" id="change-password"><span
									class="icon-key-2"></span> Change Password</a></li>
						</ul></li>
					<li><a title="Logout" href="javascript:menu('logout');"
						class="element"><span class="icon-exit"></span> Sign out</a></li>
				</ul>
			</div>

		</div>
	</div>
	<html:hidden property="task" name="menuForm" />
</html:form>

<div id="changePassword" class="hide">
	<html:form action="/employee" method="post">
		<html:hidden property="task" name="employeeForm"
			styleId="task-change-password" value="changePassword" />
		<table class="table">
			<tr>
				<th colspan=3 class="text-center"><h3><%=session.getAttribute("fullname")%></h3></th>
			</tr>
			<tr>
				<td width="25%">Old Password</td>
				<td>:</td>
				<td><div class="input-control text">
						<html:password property="password" name="employeeForm"
							styleId="old-password" />
					</div></td>
			</tr>
			<tr>
				<td width="25%">New Password</td>
				<td>:</td>
				<td><div class="input-control text">
						<html:password property="newPassword" name="employeeForm"
							styleId="new-password" />
					</div></td>
			</tr>
			<tr>
				<td width="25%">Confirmation</td>
				<td>:</td>
				<td><div class="input-control text">
						<html:password property="newPasswordConfirmation"
							name="employeeForm" styleId="new-password-confirmation" />
					</div></td>
			</tr>
			<tr>
				<td colspan=3 class="text-center"><button
						id="btn-change-password" class="button success">Change
						Password</button></td>
			</tr>
		</table>
	</html:form>
</div>