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
<jsp:include page="/js/import.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$(".detailRole").click(function() {
			$("#task").val("detailRole");
			$("#param").val($(this).attr('alt').trim());
			$("#CRUDForm").submit();
		});
		$(".home").click(function() {
			$("#task").val("home");
			$("#CRUDForm").submit();
		});
		$("#first").click(function() {
			$("#mode").val("first");
			$("#CRUDForm").submit();
		});
		$("#prev").click(function() {
			$("#mode").val("prev");
			$("#CRUDForm").submit();
		});
		$("#next").click(function() {
			$("#mode").val("next");
			$("#CRUDForm").submit();
		});
		$("#last").click(function() {
			$("#mode").val("last");
			$("#CRUDForm").submit();
		});
		$("#search").click(function() {
			$("#mode").val("search");
			$("#CRUDForm").submit();
		});
		$(".grantAdmin").change(function() {
			var	task = $(this).is(':checked') + '';
			var domain = $(this).val();
			if(task == 'true'){
				task = 'insert';
			}else{
				task = 'delete';
			}
			var data = "task=" + task + "&param=" + domain;
			$.ajax({
				url : "/ProjectTaps/manageRole.do",
				type : "POST",
				data : data,
				context : this,
				error : function() {
					console.log("problem was here!");
				},
				success : function(data) {
					var json = $.parseJSON(data);

					if (json.message != "") {
						setTimeout(function() {
							$.Notify({
								style : {
									background : json.messagecolor,
									color : 'white'
								},
								shadow : true,
								position : 'top-right',
								content : json.message
							});
						}, 1000);
					} 
				}
			});
		});
		$("#searchKeyword").attr("placeholder", "Keyword of Employee");
	});
</script>

<title>Role Member</title>

</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/manageRole" method="post" styleClass="manageRoleForm" styleId="CRUDForm">
					<html:hidden property="task" styleId="task" name="manageRoleForm" />
					<html:hidden property="mode" styleId="mode" name="manageRoleForm" />
					<html:hidden property="param" styleId="mode" name="manageRoleForm" />
					<html:hidden property="message" styleId="message" name="manageRoleForm" />
					<html:hidden property="messagecolor" styleId="messagecolor" name="manageRoleForm" />
					<html:hidden property="page" name="manageRoleForm" />
					<html:hidden property="maxpage" name="manageRoleForm" />
					
					<table class="table">
						<tr>
							<th colspan=3 class="text-center"><h3>
									Role Member
									<bean:write name="manageRoleForm" property="roleName" />
								</h3></th>
						</tr>
						<tr>
							<th class="text-center">
								<div class="input-control select">
									<html:select property="searchCategory" name="manageRoleForm">
										<html:option value="All">All</html:option>
										<html:option value="employeeDomain">Employee Domain</html:option>
										<html:option value="employeeName">Employee Name</html:option>
									</html:select>
								</div>
							</th>
							<th class="text-center" colspan=2>
								<div class="input-control text">
									<html:text property="searchKeyword" name="manageRoleForm" styleId="searchKeyword"></html:text>
									<button id="search" class="btn-search"></button>
								</div>
							</th>
						</tr>
						</table>
						<table class="table striped bordered hovered">
							<thead>
							<tr>
								<th class="text-center">Employee Domain</th>
								<th class="text-center">Employee Name</th>
								<th class="text-center">Status Admin</th>
							</tr>
							</thead>
							<tbody>
							<logic:notEmpty name="manageRoleForm" property="listMember">
								<logic:iterate id="manageRole" name="manageRoleForm" property="listMember">
									<tr>
										<td class="text-center"><bean:write name="manageRole" property="employeeDomain" /></td>
										<td class="text-center"><bean:write name="manageRole" property="employeeName" /></td>
										<td class="text-center">
											<logic:equal value="0" name="manageRole" property="isAdmin">
												<div class="input-control switch" data-role="input-control">
													<label class="inline-block" style="margin-right: 20px">
														<input type="checkbox" class="grantAdmin" value="<bean:write name="manageRole"
																property="employeeDomain" />" />
														<span class="check"></span>
													</label>
												</div>
											</logic:equal> 
											<logic:notEqual value="0" name="manageRole" property="isAdmin">
												<div class="input-control switch" data-role="input-control">
													<label class="inline-block" style="margin-right: 20px">
														<input type="checkbox" class="grantAdmin" value="<bean:write name="manageRole"
																property="employeeDomain" />" checked /> 
														<span class="check"></span>
													</label>
												</div>
											</logic:notEqual></td>
									</tr>
								</logic:iterate>
								</logic:notEmpty>
							<logic:empty name="manageRoleForm" property="listMember">
								<tr>
									<td class="text-center" colspan="3">Employee Not Available</td>
								</tr>
							</logic:empty>
							</tbody>
						</table>
						<table class="table">
							<tr>
								<td colspan=2 class="text-center">
									<div class="pagination">
										<ul>
											<li class="first"><a id="first">
												<i class="icon-first-2"></i></a></li>
											<li class="prev"><a id="prev">
												<i class="icon-previous"></i></a></li>
											<li class="disabled"><a>Page <bean:write name="manageRoleForm" property="page" /> 
												of <bean:write name="manageRoleForm" property="maxpage" /></a></li>
											<li class="next"><a id="next"><i class="icon-next"></i></a></li>
											<li class="last"><a><i id="last" class="icon-last-2"></i></a></li>
											<li class="disabled"><a>Total Record 
												<bean:write name="manageRoleForm" property="countRecord" /></a></li>
										</ul>
									</div>
								</td>
								<td class="text-center"><input type="button" class="home" value="Back" /></td>
							</tr>
						</table>
				</html:form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
