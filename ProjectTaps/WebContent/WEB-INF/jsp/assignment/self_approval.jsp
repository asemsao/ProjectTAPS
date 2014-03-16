<%@page import="adins.ace.taps.form.assignment.SelfAssignmentForm"%>
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
<script type="text/javascript">
	function flyToPage(task) {
		document.selfAssignmentForm.task.value = task;
		document.selfAssignmentForm.submit();
	}
	
	$(document).ready(
			function() {
				var task_code = $("#task-code").val();
				$("#historyComment").load(
						"/ProjectTaps/ajax.do?mode=comments&task=comments&taskCode="
								+ task_code);
			});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Self Assignment</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
			<html:form action="/selfSupervisorAssignment" method="POST">
			<html:hidden property="selfAssignBean.currentStatus" name="selfAssignmentForm"
						styleId="status" />
			<html:hidden property="selfAssignBean.taskCode"
						name="selfAssignmentForm" styleId="task-code" />
			<html:hidden property="task" name="selfAssignmentForm" />
			<input type="hidden" name="tmpDescription" value="<bean:write 
				property="selfAssignBean.description" name="selfAssignmentForm" />" />
			<input type="hidden" name="tmpManHours" value="<bean:write 
				property="selfAssignBean.manHours" name="selfAssignmentForm" />" />
			<html:hidden property="selfAssignBean.assignTo"
						name="selfAssignmentForm" />
					<table class="table">
						<thead>
							<tr>
								<td colspan=4 class="text-center text-bold">
									<h3>
										<%
											if ("RFA".equals(session.getAttribute("status"))) {
										%>
										Request For Approval Self Assignment
										<%
											} else if ("APPROVED".equals(session.getAttribute("status"))) {
										%>
										Approved Self Assignment
										<%
											} else if ("CORRECTION".equals(session.getAttribute("status"))) {
										%>
										Correction Self Assignment
										<%
											} else if ("REJECTED".equals(session.getAttribute("status"))) {
										%>
										Rejected Self Assignment
										<%
											} else {
										%>
										View Self Assignment
										<%
											}
										%>
									</h3></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td colspan=2><bean:write property="selfAssignBean.assignmentDate"
											name="selfAssignmentForm"></bean:write></td>
								
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td colspan=2><bean:write property="selfAssignBean.assignmentType"
											name="selfAssignmentForm"></bean:write></td>
							</tr>
							<%if(session.getAttribute("type").equals("PROJECT")){ %>
							<tr>
								<td>Assign By</td>
								<td>:</td>
								<td><bean:write property="selfAssignBean.projectName"
											name="selfAssignmentForm"></bean:write></td>
								<td><b>Report to </b> : <bean:write property="selfAssignBean.reportToFullName"
											name="selfAssignmentForm"></bean:write>
								</td>
							</tr>
							<%} else{%>
								<tr>
								<td>Assign By</td>
								<td>:</td>
								<td><bean:write property="selfAssignBean.organizationName"
											name="selfAssignmentForm" /></td>
								<td><b>Report to </b> : <bean:write property="selfAssignBean.headUserName"
											name="selfAssignmentForm" />
								</td>
							</tr>
							<%} %>
							<tr>
								<td>Activty Type</td>
								<td>:</td>
								<td><bean:write property="selfAssignBean.activityType"
											name="selfAssignmentForm" /></td>
								<%if(session.getAttribute("adhoc").equals("ADHOC")){ %>
								<td><b>Adhoc to </b> : <bean:write property="selfAssignBean.adhocFullName"
											name="selfAssignmentForm" />
								</td>
								<%} %>
							</tr>
							<tr>
								<td>Reff Task Code</td>
								<td>:</td>
								<td colspan=2><bean:write property="selfAssignBean.reffTaskCode"
											name="selfAssignmentForm" /></td>
							</tr>
							<%
								if ("RFA".equals(session.getAttribute("status"))) {
							%>
							<tr>
								<td>Manhours</td>
								<td>:</td>
								<td colspan=2><div class="input-control select">
										<html:select property="selfAssignBean.manHours"
											name="selfAssignmentForm">
											<html:option value="">00:00</html:option>
											<html:option value="0.5">00:30</html:option>
											<html:option value="1.0">01:00</html:option>
											<html:option value="1.5">01:30</html:option>
											<html:option value="2.0">02:00</html:option>
											<html:option value="2.5">02:30</html:option>
											<html:option value="3.0">03:00</html:option>
											<html:option value="3.5">03:30</html:option>
											<html:option value="4.0">04:00</html:option>
											<html:option value="4.5">04:30</html:option>
											<html:option value="5.0">05:00</html:option>
											<html:option value="5.5">05:30</html:option>
											<html:option value="6.0">06:00</html:option>
											<html:option value="6.5">06:30</html:option>
											<html:option value="7.0">07:00</html:option>
											<html:option value="7.5">07:30</html:option>
											<html:option value="8.0">08:00</html:option>
											<html:option value="8.5">08:30</html:option>
											<html:option value="9.0">09:00</html:option>
											<html:option value="9.5">09:30</html:option>
											<html:option value="10.0">10:00</html:option>
											<html:option value="10.5">10:30</html:option>
											<html:option value="11.0">11:00</html:option>
											<html:option value="11.5">11:30</html:option>
											<html:option value="12.0">12:00</html:option>
											<html:option value="12.5">12:30</html:option>
											<html:option value="13.0">13:00</html:option>
											<html:option value="13.5">13:30</html:option>
											<html:option value="14.0">14:00</html:option>
											<html:option value="14.5">14:30</html:option>
											<html:option value="15.0">15:00</html:option>
											<html:option value="15.5">15:30</html:option>
											<html:option value="16.0">16:00</html:option>
											<html:option value="16.5">16:30</html:option>
											<html:option value="17.0">17:00</html:option>
											<html:option value="17.5">17:30</html:option>
											<html:option value="18.0">18:00</html:option>
											<html:option value="18.5">18:30</html:option>
											<html:option value="19.0">19:00</html:option>
											<html:option value="19.5">19:30</html:option>
											<html:option value="20.0">20:00</html:option>
											<html:option value="20.5">20:30</html:option>
											<html:option value="21.0">21:00</html:option>
											<html:option value="21.5">21:30</html:option>
											<html:option value="22.0">22:00</html:option>
											<html:option value="22.5">22:30</html:option>
											<html:option value="23.0">23:00</html:option>
											<html:option value="23.5">23:30</html:option>
											<html:option value="24.0">24:00</html:option>
										</html:select>
									</div></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td colspan=2><html:textarea property="selfAssignBean.description"
										name="selfAssignmentForm"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%}else{ %>
							<tr>
								<td>Manhours</td>
								<td>:</td>
								<td colspan=2><div class="input-control select">
										<html:select property="selfAssignBean.manHours"
											name="selfAssignmentForm" disabled="true">
											<html:option value="">00:00</html:option>
											<html:option value="0.5">00:30</html:option>
											<html:option value="1.0">01:00</html:option>
											<html:option value="1.5">01:30</html:option>
											<html:option value="2.0">02:00</html:option>
											<html:option value="2.5">02:30</html:option>
											<html:option value="3.0">03:00</html:option>
											<html:option value="3.5">03:30</html:option>
											<html:option value="4.0">04:00</html:option>
											<html:option value="4.5">04:30</html:option>
											<html:option value="5.0">05:00</html:option>
											<html:option value="5.5">05:30</html:option>
											<html:option value="6.0">06:00</html:option>
											<html:option value="6.5">06:30</html:option>
											<html:option value="7.0">07:00</html:option>
											<html:option value="7.5">07:30</html:option>
											<html:option value="8.0">08:00</html:option>
											<html:option value="8.5">08:30</html:option>
											<html:option value="9.0">09:00</html:option>
											<html:option value="9.5">09:30</html:option>
											<html:option value="10.0">10:00</html:option>
											<html:option value="10.5">10:30</html:option>
											<html:option value="11.0">11:00</html:option>
											<html:option value="11.5">11:30</html:option>
											<html:option value="12.0">12:00</html:option>
											<html:option value="12.5">12:30</html:option>
											<html:option value="13.0">13:00</html:option>
											<html:option value="13.5">13:30</html:option>
											<html:option value="14.0">14:00</html:option>
											<html:option value="14.5">14:30</html:option>
											<html:option value="15.0">15:00</html:option>
											<html:option value="15.5">15:30</html:option>
											<html:option value="16.0">16:00</html:option>
											<html:option value="16.5">16:30</html:option>
											<html:option value="17.0">17:00</html:option>
											<html:option value="17.5">17:30</html:option>
											<html:option value="18.0">18:00</html:option>
											<html:option value="18.5">18:30</html:option>
											<html:option value="19.0">19:00</html:option>
											<html:option value="19.5">19:30</html:option>
											<html:option value="20.0">20:00</html:option>
											<html:option value="20.5">20:30</html:option>
											<html:option value="21.0">21:00</html:option>
											<html:option value="21.5">21:30</html:option>
											<html:option value="22.0">22:00</html:option>
											<html:option value="22.5">22:30</html:option>
											<html:option value="23.0">23:00</html:option>
											<html:option value="23.5">23:30</html:option>
											<html:option value="24.0">24:00</html:option>
										</html:select>
									</div></td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td colspan=2><html:textarea property="selfAssignBean.description"
										name="selfAssignmentForm" readonly="true"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%} %>
							
							<%
								if ("RFA".equals(session.getAttribute("status"))||
										"APPROVED".equals(session.getAttribute("status"))) {
							%>	
							<tr>
								<td class="size3">Appraisal Star</td>
								<td>:</td>
								<td colspan=2>
									<div class="star-hider">
										<div class="rating-kiri" style="float: left;">
											<select id="rating-kiri" name="rating">
												<option value="-5">-5</option>
												<option value="-4">-4</option>
												<option value="-3">-3</option>
												<option value="-2">-2</option>
												<option value="-1">-1</option>
											</select>
										</div>

										<div class="rating-tengah" style="float: left;">
											<select id="rating-tengah" name="rating">
												<option value="0">0</option>
											</select>
										</div>

										<div class="rating-kanan" style="float: left;">
											<select id="rating-kanan" name="rating">
												<option value="1">+1</option>
												<option value="2">+2</option>
												<option value="3">+3</option>
												<option value="4">+4</option>
												<option value="5">+5</option>
											</select>
										</div>
										<p>&nbsp;Your current value : 0 &nbsp;</p>
										<html:hidden property="selfAssignBean.appraisalStar" styleId="star" name="selfAssignmentForm"/>
										<button id="edit-star-btn" class="default"
											style="display: none;">Edit</button>
									</div>
								</td>
							</tr>	
							<%} %>
							<%
								if ("RFA".equals(session.getAttribute("status"))) {
							%>	
							<tr>					
								<td>Comment</td>
								<td>:</td>
								<td colspan=2><html:textarea property="selfAssignBean.comment"
										name="selfAssignmentForm"
										styleClass="input-control textarea"></html:textarea></td>
							</tr>
							<%} %>
							
							<tr>
							<%
								if ("CORRECTION".equals(session.getAttribute("status")) ||
										"REJECTED".equals(session.getAttribute("status"))) {
							%>							
								<td colspan=4 class="text-right">
									<html:button property="cancel" onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Close</html:button>
								</td>
							
							<%}else if("RFA".equals(session.getAttribute("status"))){ %>
								<td colspan=4 class="text-right">
								<html:button property="approve-btn"
									onclick="javascript:flyToPage('approved');" styleClass="button success">Approve</html:button> 
								<html:button  property="correction-btn"
									onclick="javascript:flyToPage('correction');" styleClass="button warning">Correction</html:button> 
								<html:button property="reject-btn"
									onclick="javascript:flyToPage('reject');" styleClass="button danger">Reject</html:button> 
								<html:button property="cancel-btn"
									onclick="javascript:flyToPage('cancel');" styleClass="button info">Cancel</html:button></td>
							<%} else if("APPROVED".equals(session.getAttribute("status"))){ %>							
								<td colspan=4 class="text-right">
									<html:button property="assign" onclick="javascript:flyToPage('updateStar');"
										styleClass="button success">Update Star</html:button>
									<html:button property="cancel" onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Cancel</html:button>
								</td>	
							<%} else{ %>							
								<td colspan=4 class="text-right">
									<html:button property="cancel" onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Close</html:button>
								</td>	
							<%} %>
							</tr>
						</tbody>
					</table>
					</html:form>
					<div id="historyComment"></div>
					</div>
			</div>
		</div>
	
	<jsp:include page="/frame/footer.jsp" />
<%-- 	<div id="popup_updatestar" class="hide"><jsp:include --%>
<%-- 			page="../lookup/_approve.jsp" /></div> --%>
</body>
</html>
