<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/js/import.jsp" />

<title>New Self Assignment</title>

<script type="text/javascript">
	function flyToPage(task) {
		document.newSelfAssignmentForm.newTask.value = task;
		document.newSelfAssignmentForm.assignmentType.value = getRadioValue("assignment_type");
		document.newSelfAssignmentForm.activityType.value = getRadioValue("activity_type");
		document.newSelfAssignmentForm.submit();
	}
	
	function getRadioValue(theRadioGroup)
	{
	    var elements = document.getElementsByName(theRadioGroup);
	    for (var i = 0, l = elements.length; i < l; i++)
	    {
	        if (elements[i].checked)
	        {
	            return elements[i].value;
	        }
	    }
	}
</script>

</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<html:form action="/newSelfAssignment" method="POST">
		<div class="container container-taps">
			<div class="grid">
				<div class="row row-taps shadow-taps">
					<table class="table">
						<thead>
							<tr>
								<th colspan=3 class="text-center"><h3>New Self
										Assignment</h3></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Assignment Date</td>
								<td>:</td>
								<td><div class="input-control text" id="datepicker">
										<html:text property="selfAssignBean.assignmentDate"
											name="newSelfAssignmentForm"></html:text>
										<button type="button" class="btn-date"></button>
									</div></td>
							</tr>
							<tr>
								<td>Assignment Type</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											checked="checked" value="BU" /> <span
											class="check"></span> Business Unit
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="assignment_type"
											value="Project" /> <span class="check"></span> Project
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td>Assign By</td>
								<td>:</td>
								<td><div id="bu">
										<bean:write property="selfAssignBean.organizationName" name="newSelfAssignmentForm"/>
										 &nbsp;&nbsp; <b>Report to
										</b> : <bean:write property="selfAssignBean.headUserName" name="newSelfAssignmentForm"/>
									</div>
									<div class="pr">
										<div class="input-control text">
											<input type="text" placeholder="Project" readonly="readonly" />
											<button type="button" class="btn-search" id="project"></button>
										</div>
									</div></td>
							</tr>
							<tr>
								<td><div class="pr">Report To</div></td>
								<td><div class="pr">:</div></td>
								<td><div class="pr">
										<div class="input-control text">
											<input type="text" placeholder="Employee" readonly="readonly" />
											<button type="button" class="btn-search" id="employee"></button>
										</div>
									</div></td>
							</tr>
							<tr>
								<td>Activity Type</td>
								<td>:</td>
								<td>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											checked="checked" value="Routine" /> <span class="check"></span>
											Routine
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											value="Initiative" /> <span class="check"></span> Initiative
										</label>
									</div>
									<div class="input-control radio margin10">
										<label> <input type="radio" name="activity_type"
											value="AdHoc" /> <span class="check"></span> AdHoc
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="adhoc">Ad Hoc To</div></td>
								<td><div class="adhoc">:</div></td>
								<td><div class="adhoc">
										<div class="input-control text">
											<input type="text" placeholder="Ad Hoc To"
												readonly="readonly" />
											<button type="button" class="btn-search" id="employee-2"></button>
										</div>
									</div></td>
							</tr>
							<tr>
								<td>Reff Task Code</td>
								<td>:</td>
								<td><div class="input-control text">
										<input type="text" placeholder="Reff Task Code"
											readonly="readonly" />
										<button type="button" class="btn-search" id="task"></button>
									</div></td>
							</tr>
							<tr>
								<td>Manhours</td>
								<td>:</td>
								<td>
									<div class="input-control select">
										<html:select property="selfAssignBean.manHours"
											name="newSelfAssignmentForm">
											<html:option value="">00:00</html:option>
											<html:option value="00:30">00:30</html:option>
											<html:option value="01:00">01:00</html:option>
											<html:option value="01:30">01:30</html:option>
											<html:option value="02:00">02:00</html:option>
											<html:option value="02:30">02:30</html:option>
											<html:option value="03:00">03:00</html:option>
											<html:option value="03:30">03:30</html:option>
											<html:option value="04:00">04:00</html:option>
											<html:option value="04:30">04:30</html:option>
											<html:option value="05:00">05:00</html:option>
											<html:option value="05:30">05:30</html:option>
											<html:option value="06:00">06:00</html:option>
											<html:option value="06:30">06:30</html:option>
											<html:option value="07:00">07:00</html:option>
											<html:option value="07:30">07:30</html:option>
											<html:option value="08:00">08:00</html:option>
											<html:option value="08:30">08:30</html:option>
											<html:option value="09:00">09:00</html:option>
											<html:option value="09:30">09:30</html:option>
											<html:option value="10:00">10:00</html:option>
											<html:option value="10:30">10:30</html:option>
											<html:option value="11:00">11:00</html:option>
											<html:option value="11:30">11:30</html:option>
											<html:option value="12:00">12:00</html:option>
											<html:option value="12:30">12:30</html:option>
											<html:option value="13:00">13:00</html:option>
											<html:option value="13:30">13:30</html:option>
											<html:option value="14:00">14:00</html:option>
											<html:option value="14:30">14:30</html:option>
											<html:option value="15:00">15:00</html:option>
											<html:option value="15:30">15:30</html:option>
											<html:option value="16:00">16:00</html:option>
											<html:option value="16:30">16:30</html:option>
											<html:option value="17:00">17:00</html:option>
											<html:option value="17:30">17:30</html:option>
											<html:option value="18:00">18:00</html:option>
											<html:option value="18:30">18:30</html:option>
											<html:option value="19:00">19:00</html:option>
											<html:option value="19:30">19:30</html:option>
											<html:option value="20:00">20:00</html:option>
											<html:option value="20:30">20:30</html:option>
											<html:option value="21:00">21:00</html:option>
											<html:option value="21:30">21:30</html:option>
											<html:option value="22:00">22:00</html:option>
											<html:option value="22:30">22:30</html:option>
											<html:option value="23:00">23:00</html:option>
											<html:option value="23:30">23:30</html:option>
											<html:option value="24:00">24:00</html:option>
										</html:select>
									</div>
								</td>
							</tr>
							<tr>
								<td>Description</td>
								<td>:</td>
								<td><html:textarea property="selfAssignBean.description"
										name="newSelfAssignmentForm"
										styleClass="input-control textarea"></html:textarea> </textarea></td>
							</tr>
							<tr>
								<td colspan=3 class="text-right"><html:button
										property="save" onclick="javascript:flyToPage('save');"
										styleClass="button success">Save</html:button> <html:button
										property="assign" onclick="javascript:flyToPage('RFA');"
										styleClass="button success">RFA</html:button> <html:button
										property="cancel" onclick="javascript:flyToPage('cancel');"
										styleClass="button info">Cancel</html:button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<html:hidden property="newTask" name="newSelfAssignmentForm" />
		<html:hidden property="assignmentType" name="newSelfAssignmentForm" />
		<html:hidden property="activityType" name="newSelfAssignmentForm" />
	</html:form>
	<jsp:include page="/frame/footer.jsp" />
	<div id="popup_employee" class="hide"><jsp:include
			page="/lookup/_employee.jsp" /></div>
	<div id="popup_employee-2" class="hide">
		<jsp:include page="/lookup/_employee.jsp" /></div>
	<div id="popup_project" class="hide">
		<jsp:include page="/lookup/_project.jsp" /></div>
	<div id="popup_task" class="hide">
		<jsp:include page="/lookup/_task.jsp" /></div>
</body>
</html>