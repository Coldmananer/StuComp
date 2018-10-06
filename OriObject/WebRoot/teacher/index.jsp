<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>	
		<title>教师登录界面</title>
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' ' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
		<!--webfonts-->
	</head>
	<body>
	<div class="Login">
		<div class="Login-head">
			<h3>登录</h3>
		</div>

		<form action="tealogin" method="post">
			<div class="ticker">
				<h4>账号</h4>
				<input type="text"  name="username" value="请输入账号" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '请输入账号';}">
					<!-- <span></span> -->
				<div class="clear"></div>
			</div>
			<div>
				<h4>密码</h4>
				<input type="password" name="password" value="Password" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="clear"></div>
			</div>

			<div class="submit-button">
				<input type="submit" onclick="myFunction()" value="登录  >">
			</div>
			<div class="clear"></div>
	</div>

	</form>
	</div>
	</div>
	<!--//End-login-form-->
	<div class="copy-right">
		<p>
			Template by <a href="#">XXX</a>
		</p>
	</div>
	</div>
</body>
</html>


