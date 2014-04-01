<%@page import="adins.ace.taps.configuration.App"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="adins.ace.taps.module.GetUserDomainModule"%>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" href="images/LOGO_TITLE.png">
<link href="css/metro-bootstrap.css" rel="stylesheet">
<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
<link href="css/style-login.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script src="js/jquery/jquery-1.8.3.js"></script>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.widget.min.js"></script>
<script src="js/metro/metro.min.js"></script>
<script src="js/other/jquery.noty.min.js"></script>

<script type="text/javascript">

	function enablingLogin() {
		$("#login-btn").removeAttr('disabled');
		$("#login-btn").removeClass('login-disable');
		$("#login-btn").addClass('login-enable');
		$("#login-btn i").removeClass('color-disable');
		$("#login-btn i").addClass('color-enable');
		$("#login-btn").attr('style', 'cursor: pointer;');
		$("#login-btn").attr('src', 'images/LOGIN_ENABLE.png');
	}
	function disablingLogin() {
		$("#login-btn").attr('disabled', 'disabled');
		$("#login-btn").removeClass('login-enable');
		$("#login-btn").addClass('login-disable');
		$("#login-btn i").removeClass('color-enable');
		$("#login-btn i").addClass('color-disable');
		$("#login-btn").attr('style', 'cursor: default;');
		$("#login-btn").attr('src', 'images/LOGIN_DISABLE.png');
	}
	
	function error(content) {
        var n = noty({
            text        : content,
            type        : 'warning',
            layout      : 'topCenter',
        });
    }

	$(document).ready(function() {
		$("#uname").attr("placeholder", "Username");
		$("#pass").attr("placeholder", "Password");
		disablingLogin();
		$("#uname").keyup(function() {
			if ($("#uname").val().length > 0 && $("#pass").val().length > 0)
				enablingLogin();
			else
				disablingLogin();
		});

		$("#pass").keyup(function() {
			if ($("#uname").val().length > 0 && $("#pass").val().length > 0)
				enablingLogin();
			else
				disablingLogin();
		});
		
		$("#login-btn").click(function() {
			$("#loginMessage").val('<i class="icon-warning"></i>&nbsp;&nbsp;Invalid username / password<br/>/ server is having some problems.');
		});
		
		if ($("#loginMessage").val() != "") {
			error($("#loginMessage").val());
			$("#loginMessage").val("");
		}
		
	});

	function button(task) {
		if (document.loginForm.username.value != "") {
			document.loginForm.task.value = task;
			document.loginForm.submit();
		} else {
			error("Username can't be empty");
		}
	}
</script>

<title>Login Taps</title>
</head>
<body class="metro">
	<div class="panel-taps">
		<br /><br /> <img src="images/LOGO_LOGIN.png" class="logo-taps" />
		<h1 class="title-taps">Please sign in</h1>
		
		<html:form action="/login" method="post">
			<html:hidden property="task" name="loginForm" />
			<html:hidden property="message" name="loginForm" styleId="loginMessage" />
			<br />
			<div class="text-center">
				<% 
					GetUserDomainModule checkAD = new GetUserDomainModule();
					session.setAttribute("aDStatus", checkAD.checkAD());
					if (session.getAttribute("aDStatus").toString().equalsIgnoreCase("true")) { 
				%>
						<p class="fg-green">
							<img class="ad-icon" src="images/online.png">
							&nbsp; Active Directory
						</p>
				<% } else{ %>
				 		<p class="fg-red">
							<img class="ad-icon" src="images/offline.png">
							&nbsp; Active Directory
						</p>
				<% } %>
			</div>
			<br />
			<html:text property="username" name="loginForm" styleId="uname" styleClass="textbox-taps" />
			<br />
			<html:password property="password" name="loginForm" styleId="pass" styleClass="textbox-taps" />
			<br />
			<br />
			<br />
			<div class="input-control align-center">
				<button class="login-taps login-disable" id="login-btn" onmouseover="hover(this);" onmouseout="unhover(this)" onclick="button('login')">
					Sign in <i class="icon-arrow-right-4 color-disable"></i>
				</button>
			</div>
		</html:form>
	</div>
	
	<div class="footer-taps">
		Timesheet and performance score. Copyright &copy;
		2014 ACE Batch-18. All rights reserved.
	</div>
</body>
</html>
