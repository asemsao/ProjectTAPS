<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.struts.Globals"%> 
<%@page import="org.apache.struts.taglib.html.Constants"%> 
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />
<script type="text/javascript">
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            $('.avatar').attr('src', e.target.result);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	$(document).ready( function() {
		$("#cancelUpdateEmp").click(function(){
			$("#taskUpdateEmp").val('');
			$("#employeeAddEdit").submit();
		});
		$("#updateEmp").click(function(){
			$("#taskUpdateEmp").val('saveEditEmployee');
			employeeValidation();
		});
		
		$("#__input_file_wrapper__").attr('placeholder', 'Browse File');
		$("#employeeDomain").attr("placeholder", "Employee Domain");
		$("#employeeCode").attr("placeholder", "Employee Code");
		$("#employeeNik").attr("placeholder", "NIK");
		$("#firstName").attr("placeholder", "First Name");
		$("#lastName").attr("placeholder", "Last Name");
		$(".businessUnit").attr("placeholder", "Business Unit");
		$("#employeeAddress").attr("placeholder", "Address");
		$("#employeeAddress").attr("maxlength", "500");
		$("#phoneNumberAreaCode").attr("placeholder", "Area");
		$("#phoneNumberMidNumb").attr("placeholder", "Phone No");
		$("#phoneNumberLastNumb").attr("placeholder", "Ext");
		$("#mobileNumberAreaCode").attr("placeholder", "Area");
		$("#mobileNumberMidNumb").attr("placeholder", "Mobile No");
		$("#email").attr("placeholder", "Email");
		$("#lookUpOrganization").load("/ProjectTaps/ajax.do?mode=organizations&task=organizations");
		if ($("#messageCRUD").val() != "") {
			setTimeout(function() {
				$.Notify({
					style : {
						background : $("#messagecolor").val(),
						color : 'white'
					},
					shadow : true,
					position : 'top-right',
					content : $("#messageCRUD").val()
				});
			}, 1000);
		}
		$('.myCheckbox').prop('checked', true);
		if ($("#golonganNumber").val() == "6") {
			$("#golonganLevel").hide();
			$("#golonganLevel").val("");
		}
		$("#golonganNumber").change(function() {
			if ($("#golonganNumber").val() == "6") {
				$("#golonganLevel").hide();
				$("#golonganLevel").val("");
			} else {
				$("#golonganLevel").show();
			}
		});
	});
</script>
<script src="<%=request.getContextPath()%>/js/ajax.js"></script>
<title>Employee</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form enctype="multipart/form-data" action="/employee" method="POST" styleClass="employeeForm" styleId="employeeAddEdit">
					<html:hidden property="task" name="employeeForm" styleId="taskUpdateEmp"/>
					<input type="hidden" id="messageCRUD" value="<bean:write  property="message" name="employeeForm" />">
					<input type="hidden" id="messagecolor" value="<bean:write  property="color" name="employeeForm" />">
					<input type="hidden" name="<%=Constants.TOKEN_KEY%>" value="<%=session.getAttribute(Globals.TRANSACTION_TOKEN_KEY)%>" >
					<table class="table">
						<thead>
							<tr>
								<th colspan=4 class="text-center">Edit Employee</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<%
									if (session.getAttribute("recoveryMode").toString().equalsIgnoreCase("false")) {
								%>
										<th class="field-form">Employee Domain</th>
										<td class="field-separator">:</td>
										<td>
											<div class="input-control text">
												<div class="input-control text">
													<html:text property="newEmployee.employeeDomain" name="employeeForm" styleId="activeDirectory-domain" styleClass="employeeDomain" readonly="true"></html:text>
												</div>
											</div>
										</td>
										<td rowspan="6" class="text-center field-avatar">
											<img src="employee.do?task=getPhoto&employeeDomain=<bean:write name="employeeForm" property="employeeDomain" />" class="avatar"> <br>
											<div class="input-control file">
												<html:file property="profilePicture" accept="image/*" styleClass="profilePicture" onchange="readURL(this)"></html:file>
												<button class="btn-file"></button>
											</div>
										</td>
								<%
									} else {
								%>
										<th class="field-form">Employee Domain</th>
										<td class="field-separator">:</td>
										<td>
											<div class="input-control text">
												<div class="input-control text">
													<html:text property="newEmployee.employeeDomain" name="employeeForm" styleId="activeDirectory-domain" styleClass="employeeDomain" readonly="true"></html:text>
												</div>
											</div>
										</td>
										<td rowspan="7" class="text-center field-avatar">
											<img src="employee.do?task=getPhoto&employeeDomain=<bean:write name="employeeForm" property="employeeDomain" />" class="avatar"> <br>
											<div class="input-control file">
												<html:file property="profilePicture" accept="image/*" styleClass="profilePicture" onchange="readURL(this)"></html:file>
												<button class="btn-file"></button>
											</div></td>
								<%
									}
								%>
							</tr>
							<%
								if (session.getAttribute("recoveryMode").toString().equalsIgnoreCase("true")) {
							%>
									<tr>
										<th class="field-form">Password</th>
										<td class="field-separator">:</td>
										<td>
											<div class="input-control text">
												<div class="input-control text">
													<html:password property="password" name="employeeForm" styleId="password" />
												</div>
											</div>
										</td>
									</tr>
							<%
								}
							%>
							<tr>
								<th class="field-form">Employee Code</th>
								<td class="field-separator">:</td>
								<td><div class="input-control text">
										<html:text property="newEmployee.employeeCode" maxlength="3" name="employeeForm" styleId="employeeCode"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Employee NIK</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:text property="newEmployee.employeeNik" maxlength="8" name="employeeForm" styleId="employeeNik"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Employee First Name</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text">
										<html:text property="newEmployee.firstName" maxlength="20" name="employeeForm" styleId="firstName"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Employee Last Name</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control text ">
										<html:text property="newEmployee.lastName" name="employeeForm" maxlength="25" styleId="lastName"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Employee Gender</th>
								<td class="field-separator">:</td>
								<td>
									<div class="input-control radio margin10">
										<label> 
											<html:radio property="newEmployee.gender" value="M" name="employeeForm"></html:radio> 
											<span class="check"></span> Male
										</label>
									</div>
									<div class="input-control radio margin10">
										<label>
											<html:radio property="newEmployee.gender" value="F" name="employeeForm"></html:radio>
										<span class="check"></span> Female
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Business Unit</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="input-control text ">
										<html:hidden property="newEmployee.businessUnit" name="employeeForm" styleId="organization-code"></html:hidden>
										<html:text property="newEmployee.businessUnitName" readonly="true" name="employeeForm" styleId="organization-name" styleClass="businessUnit"></html:text>
										<button type="button" class="btn-search" id="organization"></button>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Address</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="input-control textarea">
										<html:textarea property="newEmployee.employeeAddress" styleClass="address-field" name="employeeForm" styleId="employeeAddress"></html:textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Phone No</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="input-control text ">
										<strong>(</strong>
										<html:text property="newEmployee.phoneNumberAreaCode" name="employeeForm" styleId="phoneNumberAreaCode" style="width: 45px;" maxlength="4"></html:text>
										<strong>)&nbsp;&nbsp;</strong>
										<html:text property="newEmployee.phoneNumberMidNumb" name="employeeForm" styleId="phoneNumberMidNumb" style="width: 70px;" maxlength="7"></html:text>
										<strong>&nbsp;&nbsp;-&nbsp;&nbsp;</strong>
										<html:text property="newEmployee.phoneNumberLastNumb" name="employeeForm" styleId="phoneNumberLastNumb" style="width: 50px;" maxlength="4"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Mobile No</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="input-control text ">
										<strong>(</strong>
										<html:text property="newEmployee.mobileNumberAreaCode" name="employeeForm" styleId="mobileNumberAreaCode" style="width: 45px;" maxlength="4"></html:text>
										<strong>)&nbsp;&nbsp;</strong>
										<html:text property="newEmployee.mobileNumberMidNumb" name="employeeForm" styleId="mobileNumberMidNumb" style="width: 100px;" maxlength="10"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Email</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="input-control text ">
										<html:text property="newEmployee.email" name="employeeForm" maxlength="30" styleId="email"></html:text>
									</div>
								</td>
							</tr>
							<tr>
								<th class="field-form">Grade</th>
								<td class="field-separator">:</td>
								<td colspan="2">
									<div class="auto-complete">
										<div class="input-control select">
											<html:select property="newEmployee.golonganNumber" style="width:70px;" name="employeeForm" styleId="golonganNumber">
												<html:option value="">Level</html:option>
												<html:option value="2">2</html:option>
												<html:option value="3">3</html:option>
												<html:option value="4">4</html:option>
												<html:option value="5">5</html:option>
												<html:option value="6">6</html:option>
											</html:select>
											<html:select property="newEmployee.golonganLevel" styleId="golonganLevel" style="width:70px;" name="employeeForm">
												<html:option value="">Grade</html:option>
												<html:option value="A">A</html:option>
												<html:option value="B">B</html:option>
												<html:option value="C">C</html:option>
												<html:option value="D">D</html:option>
												<html:option value="E">E</html:option>
												<html:option value="F">F</html:option>
											</html:select>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4" class="text-right">
									<button class="button success" id="updateEmp">Save</button>
									<button class="button info" id="cancelUpdateEmp">Cancel</button>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<div id="lookUpOrganization" class="hide"></div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>
