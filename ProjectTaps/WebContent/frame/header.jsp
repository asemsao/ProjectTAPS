<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<%@page import="java.util.List"%>
<%@page import="adins.ace.taps.bean.module.MenuBean"%>
<%@page import="adins.ace.taps.bean.module.RoleBean"%>
<%@page import="adins.ace.taps.manager.LoginManager"%>

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
						List<RoleBean> roleList	= (List) session.getAttribute("role");
						List<MenuBean> listMenu;
						for (int i = 0; i < roleList.size(); i++) {
						listMenu = lMan.getListMenu(roleList.get(i).getRoleId());
					%>
					
					<li><a class="dropdown-toggle element" href="#"><i
							class="icon-user-3"></i><%= roleList.get(i).getRoleName() %></a>
						 <ul class="dropdown-menu" data-role="dropdown">
							<%
								for (int j = 0; j < listMenu.size(); j++) {
									if(!listMenu.get(j).getTask().equals("dashboard")){
							%>
							<li><a href="javascript:menu('<%=listMenu.get(j).getTask() %>');">
								<%if(listMenu.get(j).getTask().equals("employeeReport") || listMenu.get(j).getTask().equals("employeeReportSupervisor") || listMenu.get(j).getTask().equals("report")) {%>
								<span class="icon-clipboard-2"></span> 
								<%}else if(listMenu.get(j).getTask().equals("assignment")) {%>
								<span class="icon-list"></span>
								<%}else if(listMenu.get(j).getTask().equals("appraisal")) {%>
								<span class="icon-trophy"></span> 
								<%}else if(listMenu.get(j).getTask().equals("employee")) {%>
								<span class="icon-user"></span> 
								<%}else if(listMenu.get(j).getTask().equals("organization")) {%>
								<span class="icon-briefcase-2"></span> 
								<%}else if(listMenu.get(j).getTask().equals("project")) {%>
								<span class="icon-puzzle"></span> 
								<%}else if(listMenu.get(j).getTask().equals("transferProject")) {%>
								<span class="icon-tab"></span> 
								<%}else if(listMenu.get(j).getTask().equals("manageRole")) {%>
								<span class="icon-cog"></span>
								<%} %>
							<%=listMenu.get(j).getMenuName()%></a></li>
							<%
								}}
							%>
						</ul>
					</li>
					<%} %>
					<ul class="element-menu place-right">
						<li><button class="element image-button image-left">
								<img src="<%=request.getContextPath()%>/images/ava.jpg" />
								<%=session.getAttribute("username") %>
							</button></li>
						<li><a title="Logout" href="javascript:menu('logout');"
							class="element"><span class="icon-exit"></span> Sign out</a></li>
					</ul>
			</div>

		</div>
	</div>
	<html:hidden property="task" name="menuForm" />
</html:form>