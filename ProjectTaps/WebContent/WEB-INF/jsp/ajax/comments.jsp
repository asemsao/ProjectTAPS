<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment Comments</title>
</head>
<body>
	<logic:notEmpty name="ajaxForm" property="historyComment">
		<html:form action="/ajax" method="post">
			<html:hidden property="task" styleId="task-comment" name="ajaxForm" />
			<html:hidden property="mode" styleId="mode-comment" name="ajaxForm" />
			<html:hidden property="page" styleId="page-comment" name="ajaxForm" />
			<html:hidden property="maxpage" styleId="maxpage-comment"
				name="ajaxForm" />
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=5 class="text-center text-bold">History Comment</th>
					</tr>
					<tr>
						<th class="text-center text-bold">Date</th>
						<th class="text-center text-bold">Comment</th>
						<th class="text-center text-bold">From</th>
						<th class="text-center text-bold">To</th>
						<th class="text-center text-bold">Status</th>
					</tr>
				</thead>
				<tbody>

					<logic:iterate id="comment" name="ajaxForm"
						property="historyComment">
						<tr>
							<td class="text-center"><bean:write property="commentDate"
									name="comment" /></td>
							<td class="text-center"><bean:write
									property="assignmentComment" name="comment" /></td>
							<td class="text-center"><bean:write property="commentFrom"
									name="comment" /></td>
							<td class="text-center"><bean:write property="commentTo"
									name="comment" /></td>
							<td class="text-center"><bean:write property="status"
									name="comment" /></td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
			<table class="table striped bordered hovered">
				<thead>
					<tr>
						<th colspan=5 class="text-center">
							<div class="pagination">
								<ul>
									<li class="first"><a
										onclick="javascript:pagingComment('first');"><i
											class="icon-first-2"></i></a></li>
									<li class="prev"><a
										onclick="javascript:pagingComment('prev');"><i
											class="icon-previous"></i></a></li>
									<li class="disabled"><a>Page <span
											id="current-page-comment"><bean:write name="ajaxForm"
													property="page" /></span> of <span id="max-page-comment"><bean:write
													name="ajaxForm" property="maxpage" /></span></a></li>
									<li class="next"><a
										onclick="javascript:pagingComment('next');"><i
											class="icon-next"></i></a></li>
									<li class="last"><a
										onclick="javascript:pagingComment('last');"><i
											class="icon-last-2"></i></a></li>
									<li class="disabled"><a>Total Record <span
											id="total-record-comment"><bean:write name="ajaxForm"
													property="countRecord" /></span></a></li>
								</ul>
							</div>
						</th>
					</tr>
				</thead>
			</table>
		</html:form>
	</logic:notEmpty>
	<logic:empty name="ajaxForm" property="historyComment">
		kosong bro
	</logic:empty>
</body>
</html>