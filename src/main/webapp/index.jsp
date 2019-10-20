<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@include file="/root/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${picRoot}/titlePicture/treasure.jpg" />
<title>
	THIS IS TREASURE
</title>
</head>
<script type="text/javascript" src="${jsRoot}/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		sayhello();
	});

	var helloWord = "THIS IS HELLO WORLD !!!!!!!!!!!!!!!!!!!!!!!";
	var helloArray = new Array(helloWord.length);
	//起页
	function sayhello(){
		for(i = 0; i < helloWord.length; i++){
			helloArray[i] = helloWord.substr(i, 1);
		}
		layOut();
		setTimeout(logInPage, 6000);
	}

	//输出
	function layOut(){
		for(i = 0; i < helloArray.length; i++){
			setTimeout(out, 1000 + i*100);
		}
	} 
	var j = 0;
	function out(){
		var hello = helloArray[j];
		document.write(hello);
		j++;
	}
	//跳页
	function logInPage(){
		window.location.href = "${webRoot}/signIn/indexPage.do";
	}
</script>
<body>
	<div>
	</div>
	<div>
		<!-- <input type="button" onclick="helloMelon()" value="haha"> -->
	</div>
</body>
</html>