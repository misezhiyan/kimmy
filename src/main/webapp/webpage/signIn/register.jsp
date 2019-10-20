<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@include file="/root/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${picRoot}/titlePicture/treasure.jpg" />
<title>
	WELCOM TO TREASURE
</title>
</head>
<script type="text/javascript" src="${jsRoot}/jquery-1.9.1.min.js"></script>
<body style="background-image: url('${picRoot}/backgroundPIC/index_background.jpg');background-repeat: no-repeat; background-size: 120% 120%;">
	<div>
		<div style="height:1px;width:1px;background:#228B22;opacity:0.5;margin-top:25%;margin-left:35%;">
			<div style="border-radius:25px;text-align: center;background:#000; color:#FFF;opacity:1;margin-top:30%;margin-left:10%;height:200px;width:600px">
				<form id="registerForm">
					<br>
					<br>
					<span><font size="5" style="weight:900;color:#FFF;">账号:</font></span>
					<input type="text" name="name" id="name" style="height:28px;width:250px"><br>
					<span><font size="5" style="weight:900;color:#FFF;">密码:</font></span>
					<input type="password" name="password" id="password" style="height:28px;width:250px"><br>
					<br><br>
					<input type="button" onclick="register()" value="注册">
				</form>
			</div>
		</div>
	</div>
	<div>
	</div>
</body>
<script type="text/javascript">
function register(){
	var name = $("#name").val();
	var password = $("#password").val();
	$.post("${webRoot}/signIn/register.do", {name:name, password:password}, function(data){
		alert(data);
	})
}
</script>
</html>