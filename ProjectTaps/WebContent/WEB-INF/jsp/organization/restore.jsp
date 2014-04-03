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
		$("#first").click(function() {
			$("#task").val("first");
			$("#mode").val("restorePage");
			$("#CRUDForm").submit();
		});
		$("#prev").click(function() {
			$("#task").val("prev");
			$("#mode").val("restorePage");
			$("#CRUDForm").submit();
		});
		$("#next").click(function() {
			$("#task").val("next");
			$("#mode").val("restorePage");
			$("#CRUDForm").submit();
		});
		$("#last").click(function() {
			$("#task").val("last");
			$("#mode").val("restorePage");
			$("#CRUDForm").submit();
		});
		$("#search").click(function() {
			$("#task").val("search");
			$("#mode").val("restorePage");
			$("#CRUDForm").submit();
		});
		$("#back").click(function() {
			$("#task").val("");
			$("#mode").val("");
			$("#CRUDForm").submit();
		});
		$("input[id = 'grantActive']").change(function() {
			var elem = $(this);
			var code = $(this).val().split('@')[0];
			var name = $(this).val().split('@')[1];
			var	task = $(this).is(':checked') + '';
			if (task == 'true') {
				task = "submitRestore";
				elem.closest('tr').addClass('hide');
				var count = $("#totalRecord").html();
				var res = parseInt(count) - 1;
				$("#totalRecord").html(res);
			}
			var data = "task=" + task + "&code=" + code + "&name=" + name;
			$.ajax({
				url : "/ProjectTaps/organization.do",
				type : "POST",
				data : data,
				context : this,
				error : function() {
					console.log("problem was here!");
				},
				success : function(data) {
					var json = $.parseJSON(data);
					if (json.message != "") {
						if (json.message.indexOf("Failed") != -1) {
							elem.prop("checked", !elem.prop("checked"));
						}
						setTimeout(function() {
							$.Notify({
								style : {
									background : json.color,
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
		$("#searchKeyword").attr("placeholder", "Keyword of Inactive Organization");
	});
</script>
<title>Role Member</title>
</head>
<body class="metro">
	<jsp:include page="/frame/header.jsp" />
	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">
				<html:form action="/organization" method="post" styleId="CRUDForm">
					<html:hidden property="task" styleId="task" name="organizationForm" />
					<html:hidden property="mode" styleId="mode" name="organizationForm" />
					<html:hidden property="message" styleId="message" name="organizationForm" />
					<html:hidden property="color" styleId="color" name="organizationForm" />
					<html:hidden property="page" name="organizationForm" />
					<html:hidden property="maxpage" name="organizationForm" />
					
					
					<br />
						<h3 class="text-center">Restore Organization</h3>
						<table class="table">
						<tr>
							<th width="25%" class="text-center">
								<div class="input-control select">
									<html:select property="searchCategory" name="organizationForm">
										<html:option value="all">All</html:option>
										<html:option value="organizationCode">Organization Code</html:option>
										<html:option value="organizationName">Organization Name</html:option>
									</html:select>
								</div>
							</th>
							<th class="text-center">
								<div class="input-control text">
									<html:text property="searchKeyword" name="organizationForm" styleId="searchKeyword"></html:text>
									<button id="search" class="btn-search"></button>
								</div>
							</th>
						</tr>
					</table>
					<table class="table striped bordered hovered">
						<thead>
							<tr>
								<th class="text-center">Organization Code</th>
								<th class="text-center">Organization Name</th>
								<th class="text-center">Level</th>
								<th class="text-center">Status</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="organizationForm" property="listOrganizations">
								<logic:iterate id="org" name="organizationForm" property="listOrganizations">
									<tr>
										<td class="text-center"><bean:write name="org" property="organizationCode" /></td>
										<td class="text-center"><bean:write name="org" property="organizationName" /></td>
										<td class="text-center"><bean:write name="org" property="organizationLevel" /></td>
										<td class="text-center">
												<div class="input-control switch" data-role="input-control">
													<label class="inline-block" style="margin-right: 20px">
														<input type="checkbox" id="grantActive" value="<bean:write name="org" property="organizationCode" />@<bean:write name="org" property="organizationName" />" />
														<span class="check"></span>
													</label>
												</div>
										</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="organizationForm" property="listOrganizations">
								<tr>
									<td class="text-center" colspan="4">Organization Not Available</td>
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
										<li class="disabled"><a>Page <bean:write name="organizationForm" property="page" /> 
											of <bean:write name="organizationForm" property="maxpage" /></a></li>
										<li class="next"><a id="next"><i class="icon-next"></i></a></li>
										<li class="last"><a><i id="last" class="icon-last-2"></i></a></li>
										<li class="disabled"><a>Total Record <span id="totalRecord">
											<bean:write name="organizationForm" property="countRecord" /></span></a></li>
									</ul>
								</div>
							</td>
							<td class="text-right"><input type="button" class="home" value="Back" id="back" /></td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>
