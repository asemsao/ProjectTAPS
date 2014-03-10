<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/metro-bootstrap.css" rel="stylesheet">
<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
<link href="css/style-login.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#uname").attr("placeholder", "Username");
		$("#pass").attr("placeholder", "Password");
	});
	
	function enablingLogin() {
		$("#login-btn").removeAttr('disabled');
		$("#login-btn").attr('style', 'cursor: pointer;');
		$("#login-btn").attr('src', 'images/LOGIN_ENABLE.png');
	}
	function disablingLogin() {
		$("#login-btn").attr('disabled', 'disabled');
		$("#login-btn").attr('style', 'cursor: default;');
		$("#login-btn").attr('src', 'images/LOGIN_DISABLE.png');
	}
	$(document).ready(function() {
		disablingLogin();
		$("#uname").keyup(function(){
			if ($("#uname").val().length > 0 && $("#pass").val().length > 0)
				enablingLogin();
			else
				disablingLogin();
			});
		
		$("#pass").keyup(function(){
			if ($("#uname").val().length > 0 && $("#pass").val().length > 0)
				enablingLogin();
			else
				disablingLogin();
			});
	});
	
	function button(task) {
		if (document.loginForm.username.value != "") {
			document.loginForm.task.value = task;
			document.loginForm.submit();
		}
		else{
			alert("Username can't be empty");
		}
	}
</script>

<title>Login Taps</title>
</head>
<body class="metro login-background">
	<div class="panel-taps">
		<br /> <br /> <img src="images/LOGO_Taps6.png" class="logo-taps" />
		<h1 class="title-taps">Sign in to TAPS</h1>
		<html:form action="/ACE" method="post">
			<html:hidden property="task" name="loginForm" />
			<html:text property="username" name="loginForm" styleId="uname"
				styleClass="textbox-taps" />
			<br />
			<html:password property="password" name="loginForm" styleId="pass"
				styleClass="textbox-taps" />
			<br />
			<br />

			<div class="input-control checkbox align-left">
				<label class="check-label"> <html:checkbox
						property="keepMeSign"></html:checkbox> <span class="check"></span>
					Keep me signed in
				</label>
			</div>
			<br />
			<html:image styleClass="login-taps" styleId="login-btn"
				src="images/LOGIN_DISABLE.png" onmouseover="hover(this);"
				onmouseout="unhover(this)" onclick="button('login')"></html:image>
		</html:form>
	</div>
	<div class="footer-taps">Copyright &copy; 2014 ACE Batch-18. All
		rights reserved.</div>
</body>
</html>