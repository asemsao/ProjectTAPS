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
<title>AJAX Project</title>
</head>

<body class="metro">
	<html:form action="/ajax" method="post">
		<html:hidden property="task" styleId="task-project" name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-project" name="ajaxForm" />
		<html:hidden property="page" styleId="page-project" name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-project"
			name="ajaxForm" />
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=7 class="text-center">Employee List</th>
				</tr>
				<tr>
					<th class="text-center" colspan=2>
						<div class="input-control select">
							<html:select property="searchCategory" name="ajaxForm"
								styleClass="search-category-project">

							</html:select>
						</div>
					</th>
					<th class="text-center" colspan=5>
						<div class="input-control text">
							<html:text property="searchKeyword" name="ajaxForm"
								styleClass="search-keyword-project"
								onkeydown="if (event.keyCode == 13){ javascript:pagingProject('search'); return false;}"></html:text>
							<button type="button" class="btn-search"
								onclick="javascript:pagingProject('search');"></button>
						</div>
					</th>
				</tr>
			</thead>
		</table>
		<div id="table-ajax-project">
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th class="text-center">Choose</th>
						<th class="text-center">Code</th>
						<th class="text-center">Name</th>
						<th class="text-center">Client</th>
						<th class="text-center">Start Date</th>
						<th class="text-center">Phase</th>
						<th class="text-center">Organization</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="ajaxForm" property="listProject">
						<logic:iterate id="project" name="ajaxForm" property="listProject">
							<tr>
								<td><bean:write name="project" property="projectCode" /></td>
								<td><bean:write name="project" property="projectName" /></td>
								<td><bean:write name="project" property="client" /></td>
								<td class="text-center"><bean:write name="project"
										property="organizationCode" /></td>
								<td><bean:write name="project" property="phase" /></td>
								<td><bean:write name="project" property="startDate" /></td>
								<td><bean:write name="project" property="endDate" /></td>
								<td class="text-center"><bean:write name="project"
										property="runningDay" /></td>
								<td class="text-center"><a
									href="javascript:flyToPage('member','<bean:write name="project" property="projectCode" />');"
									data-hint="Project Member" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/MEMBER.png"></a></td>
								<td class="text-center"><a
									href="javascript:flyToPage('edit','<bean:write name="project" property="projectCode" />');"
									data-hint="Edit Project" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
								<td class="text-center"><a href="javascript:confDel()"
									data-hint="Delete Project" data-hint-position="bottom"><img
										alt="" src="<%=request.getContextPath()%>/images/DELETE.png"></a></td>
							</tr>



							<tr>
								<td class="text-center"><input type='radio'
									name='project_choose'
									value='<bean:write name="project"
										property="projectCode" />' />
								</td>
								<td class="text-center"><bean:write name="project"
										property="projectCode" /></td>
								<td><bean:write name="project"
										property="projectName" /></td>
								<td class="text-center"><bean:write name="project" property="client" /></td>
								<td class="text-center"><bean:write name="project" property="startDate" /></td>
								<td class="text-center"><bean:write name="project" property="phase" /></td>
								<td class="text-center"><bean:write name="project" property="organizationCode" /></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="ajaxForm" property="listProject">
						<tr>
							<td class="text-center" colspan=7>Data not found</td>
						</tr>
					</logic:empty>
				</tbody>
			</table>
		</div>
		<table class="table striped bordered hovered">
			<thead>
				<tr>
					<th colspan=3 class="text-center">
						<div class="pagination">
							<ul>
								<li class="first"><a
									onclick="javascript:pagingProject('first');"><i
										class="icon-first-2"></i></a></li>
								<li class="prev"><a
									onclick="javascript:pagingProject('prev');"><i
										class="icon-previous"></i></a></li>
								<li class="disabled"><a>Page <span
										id="current-page-project"><bean:write name="ajaxForm"
												property="page" /></span> of <span id="max-page-project"><bean:write
												name="ajaxForm" property="maxpage" /></span></a></li>
								<li class="next"><a
									onclick="javascript:pagingProject('next');"><i
										class="icon-next"></i></a></li>
								<li class="last"><a
									onclick="javascript:pagingProject('last');"><i
										class="icon-last-2"></i></a></li>
								<li class="disabled"><a>Total Record <span
										id="total-record-project"><bean:write name="ajaxForm"
												property="countRecord" /></span></a></li>
							</ul>
						</div>
					</th>
					<th class="text-center"><button type="button"
							class='button success' onclick="javascript:chooseEmployee()">Add</button></th>
				</tr>
			</thead>
		</table>
	</html:form>
</body>

</html>