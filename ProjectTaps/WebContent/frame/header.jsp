<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<%@page import="java.util.List"%>
<%@page import="adins.ace.taps.bean.module.MenuBean"%>
<%@page import="adins.ace.taps.bean.module.RoleBean"%>
<%@page import="adins.ace.taps.manager.LoginManager"%>
<%@page import="adins.ace.taps.configuration.App"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#star-achivement-icon").mouseover(function() {
			$(this).removeClass('icon-star');
			$(this).addClass('icon-star-3');
		});
		$("#star-achivement-icon").mouseout(function() {
			$(this).removeClass('icon-star-3');
			$(this).addClass('icon-star');
		});
	});
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
							class="icon-user-3"></i><span class="menu-header"><%=roleList.get(i).getRoleName()%></span></a>
						<ul class="dropdown-menu" data-role="dropdown">
							<%
								for (int j = 0; j < listMenu.size(); j++) {
								if (!listMenu.get(j).getTask().equals("dashboard")) {
									if (listMenu.get(j).getTask().equals("employeeReport")|| listMenu.get(j).getTask().equals("employeeReportSupervisor")|| listMenu.get(j).getTask().equals("report")) {
							%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-clipboard-2"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("assignment")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-list"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("appraisal") && !session.getAttribute("organizationLevel").equals("2")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-trophy"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("employee")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-user"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("organization")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-briefcase-2"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("project")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-puzzle"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("transferProject")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-tab"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									} else if (listMenu.get(j).getTask().equals("manageRole")) {
								%>
								<li><a
									href="javascript:menu('<%=listMenu.get(j).getTask()%>');"> <span
										class="icon-cog"></span> <%=listMenu.get(j).getMenuName()%></a></li>
								<%
									}
								}
							}
							%>
						</ul></li>
					<%
						}
					%>
				</ul>
				<ul class="element-menu place-right">
					<li>
						<div class="element place-right" title="Stars Achievement">
							<span id="star-achivement-icon" class="icon-star"></span> <span
								class="star-achievement"><%=session.getAttribute("star")%></span>
						</div>
					</li>
					<li><a class="dropdown-toggle element image-button image-left"
						href="#"><img src="<%=session.getAttribute("pathPhoto")%>" />
							<span class="menu-header"><%=session.getAttribute("fullname")%></span></a>
						<%
							if ("true".equals(App.getConfiguration("recovery_mode"))) {
						%>
						<ul class="dropdown-menu" data-role="dropdown">
							<li><a title="Change Password" id="change-password"><span
									class="icon-key-2"></span> Change Password</a></li>
						</ul> <% } %>
					</li>
					<li><a title="Logout" href="javascript:menu('logout');"
						class="element"><span class="icon-exit"></span> Sign out</a></li>
				</ul>
			</div>

		</div>
	</div>
	<html:hidden property="task" name="menuForm" />
</html:form>

<%
	if ("true".equals(App.getConfiguration("recovery_mode"))) {
%>
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
</script>
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
<%
	}
%>