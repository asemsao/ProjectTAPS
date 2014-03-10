<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<script type="text/javascript">
function menu(task) {
	document.menuForm.task.value = task;
	document.menuForm.submit();
}
</script>
<html:form action="/menu" method="POST" styleClass="menuForm">	
<div class="bg-dark">
	<div class="navigation-bar dark header-taps">
		<div class="navigation-bar-content container">
			<a href="#" class="element"> <img alt="logo" class="logo" src="<%=request.getContextPath()%>/images/LOGO_PANJANG3.png"></a>
			<a class="pull-menu" href="#"></a>
			<span class="element-divider"></span>
			<ul class="element-menu">
			<li>
			<a href="javascript:menu('dashboard');" class="heading"> <span
					class="icon-home"></span> Dashboard</a>
				</li>
			<li>
    <a class="dropdown-toggle element" href="#"><i class="icon-user-3"></i> Employee</a>
    <ul class="dropdown-menu" data-role="dropdown">
    <li><a href="javascript:menu('assignment');"><span class="icon-clipboard-2"></span> Employee Report</a></li>
    </ul>
    </li>
    <li>
    <a class="dropdown-toggle element" href="#"><i class="icon-user-3"></i> Supervisor</a>
    <ul class="dropdown-menu" data-role="dropdown">
    <li><a href="javascript:menu('assignment');"><span class="icon-clipboard-2"></span> Employee Report</a></li>
    <li><a href="javascript:menu('assignment');"><span class="icon-list"></span> Assignment</a></li>
    </ul>
    </li>
    <li>
    <a class="dropdown-toggle element" href="#"><i class="icon-user-3"></i> Head BU</a>
    <ul class="dropdown-menu" data-role="dropdown">
    <li><a href="javascript:menu('report');"><span class="icon-clipboard-2"></span> Employee Report</a></li>
    <li><a href="javascript:menu('appraisal');"><span class="icon-trophy"></span> Special Appraisal</a></li>
    </ul>
    </li>
    <li>
    <a class="dropdown-toggle element" href="#"><i class="icon-user-3"></i> Administrator</a>
    <ul class="dropdown-menu" data-role="dropdown">
    <li><a href="javascript:menu('employee');"><span class="icon-user"></span> Employee</a></li>
    <li><a href="javascript:menu('organization');"><span class="icon-briefcase-2"></span> Organization</a></li>
    <li><a href="javascript:menu('project');"><span class="icon-puzzle"></span> Project</a></li>
    </ul>
    </li>
    </ul>
    
    <ul class="element-menu place-right">
				<li><button class="element image-button image-left"><img src="<%=request.getContextPath()%>/images/ava.jpg" />Wirya Jaya</button></li>			
				<li><a title="Logout" href="#" class="element"><span class="icon-exit"></span> Sign out</a></li>
			</ul>
			
		</div>

	</div>
</div>
<html:hidden property="task" name="menuForm" />
</html:form>