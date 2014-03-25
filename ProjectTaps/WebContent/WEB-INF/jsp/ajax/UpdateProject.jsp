<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX UPDATE PROJECT</title>
</head>
<body>
	<html:form action="/ajax" method="post" >
		<html:hidden property="projectCode"
			styleId="projectCode-project-update" name="ajaxForm" />
		<html:hidden property="task" styleId="task-project-update"
			name="ajaxForm" />
		<html:hidden property="mode" styleId="mode-project-update"
			name="ajaxForm" />
		<html:hidden property="page" styleId="page-project-update"
			name="ajaxForm" />
		<html:hidden property="maxpage" styleId="maxpage-project-update"
			name="ajaxForm" />
		<html:hidden property="assignmentCategory"
			styleId="assignmentCategory-project-update" name="ajaxForm" />
		<html:hidden property="assignmentType"
			styleId="assignmentType-project-update" name="ajaxForm" />
		<html:hidden property="paramProjectCode" 
			name="ajaxForm" styleId="projectCode-project-update"/>
				
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=7 class="text-center">Pending Assignment List</th>
					</tr>
					<tr>
						<th class="text-center" colspan=2>
							<div class="input-control select">
								<html:select property="searchCategory" name="ajaxForm"
									styleClass="search-category-project-update">
									<html:option value="All">All</html:option>
									<html:option value="taskCode">Assignment Code</html:option>
									<html:option value="taskType">Assignment Category</html:option>
									<html:option value="employee">Employee Name</html:option>
								</html:select>
							</div>
						</th>
						<th class="text-center" colspan=5>
							<div class="input-control text">
								<html:text property="searchKeyword" name="ajaxForm"
									styleClass="search-keyword-project-update"
									onkeydown="if (event.keyCode == 13){ javascript:pagingProjectUpdate('search'); return false;}"></html:text>
								<button type="button" class="btn-search"
									onclick="javascript:pagingProjectUpdate('search');"></button>
							</div>
						</th>
					</tr>
				</thead>
			</table>
			<div id="table-ajax-project-update">
				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th class="text-center">Date</th>
							<th class="text-center">Code</th>
							<th class="text-center">Type</th>
							<th class="text-center">Report To</th>
							<th class="text-center">Deadline</th>
						</tr>
					</thead>
					<tbody>
						<logic:notEmpty name="ajaxForm" property="listEmployeeReport">
							<logic:iterate id="assignment" name="ajaxForm"
								property="listEmployeeReport">
								<tr>
									<td class="text-center"><bean:write name="assignment"
											property="assignmentDate" /></td>
									<td class="text-center"><bean:write name="assignment"
											property="assignmentCode" /></td>
									<td class="text-center"><bean:write name="assignment"
											property="assignmentCategory" /></td>
									<td><bean:write name="assignment" property="fullName" /></td>
									<td class="text-center"><bean:write name="assignment"
											property="assignmentDueDate" /></td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<logic:empty name="ajaxForm" property="listEmployeeReport">
							<tr>
								<td class="text-center" colspan=6>No Pending Assignment</td>
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
										onclick="javascript:pagingProjectUpdate('first');"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a
										onclick="javascript:pagingProjectUpdate('prev');"><i
											class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <span
											id="current-page-project-update"><bean:write
													name="ajaxForm" property="page" /></span> of <span
											id="max-page-project-update"><bean:write
													name="ajaxForm" property="maxpage" /></span></a></li>
									<li class="next"><a
										onclick="javascript:pagingProjectUpdate('next');"><i
											class="icon-next"></i></a></li>
									<li class="last"><a
										onclick="javascript:pagingProjectUpdate('last');"><i
											class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <span
											id="total-record-project-update"><bean:write
													name="ajaxForm" property="countRecord" /></span></a></li>
								</ul>
							</div>
						</th>
						<th class="text-center">
						<%if(request.getAttribute("buttonMode").toString().equals("enable")){ %>
						<button type="button"
								class='button danger'
								onclick="javascript:chooseProjectUpdate('update')">Update</button>
						<%}%>
							<button type="button" class='button info'
								onclick="javascript:chooseProjectUpdate('cancel')">Cancel</button>
						</th>
					</tr>
				</thead>
			</table>
		
	</html:form>
</body>
</html>