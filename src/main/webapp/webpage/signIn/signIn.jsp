<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@include file="/root/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${picRoot}/titlePicture/treasure.jpg" />
<title>
	WELCOM TO TREASURE
</title>
</head>
<script type="text/javascript" src="${jsRoot}/jquery-1.9.1.min.js"></script>
<body>
	<div>
		<form action="${webRoot}/signIn/login.do" method="post">
			账号:<input type="text" name="name" value="kimmy">
			密码:<input type="password" name="password" value="kimmy">
			<input type="submit" value="登录">
		</form>
	</div>
	<div>
	</div>
</body>
</html>