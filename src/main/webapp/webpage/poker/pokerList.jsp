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
	<h1>LOG IN SUCCESS</h1>
	
	<c:forEach items="${pokerList }" var="poker"></c:forEach>
	共:&nbsp;${fn:length(pokerList) }&nbsp;条绑定账户
	<c:if test="${not empty pokerList }">
	<c:forEach items="${pokerList }" var="poker">
		<div>
			${poker.name} 
			&nbsp;<span><a href="javascript:void(0)">登录</a></span>&nbsp;
			<c:if test="${poker.is_default != 1}"><span><a href="javascript:void(0)">编辑<a href="javascript:void(0)">默认</a></span></c:if>
			<span><a href="javascript:void(0)">编辑</a>
				<div style="display:none">
					<input type="text" value="${poker.password}">
					<a href="javascript:void(0)">密码</a><br>
					<a href="javascript:void(0)">编辑</a><br>
					<a href="javascript:void(0)" onclick="showTestArea()">测试登录</a><br>
					<div id="testArea" style="display:none">
						<img id="safeCodeImg" alt="" src=""><br>
						请输入校验码:<input id="safeCode" type="text">
						<input type="button" onclick="pokerLogin()" value="登录">
					</div>
				</div>
			</span>
		</div>
	</c:forEach>
	</c:if>
	<div>
		<a href="javascript:void(0);" onclick="showBindArea()">绑定新账号</a>
		<div id="bindArea" style="display:none">
			账号:<input id="newPokerName" type="text" name="name" value="15554269716">
			密码:<input id="newPokerPassword" type="password" name="password" value="159357">
			<input type="button" onclick="bindPoker()" value="绑定">
		</div>
	</div>
</body>
<script type="text/javascript">
//绑定账号
function bindPoker(){

	var name = $("#newPokerName").val();
	var password = $("#newPokerPassword").val();
	
	$.post("${webRoot}/poker/pokerBind.do",{
		name:name,
		password:password 
		},function(data){
			if(data == 1){
				alert("绑定成功");
			}else if(data == 2){
				alert("绑定失败");
			}else if(data == 3){
				alert("已绑定过");
			}
	})
}
//展示绑定新账号区域
function showBindArea(){
	$("#bindArea").show();
}
//展示测试登录区域
function showTestArea(){
	$("#safeCodeImg").attr("src", "${webRoot}/static/picture/safeCode/" + name)
	$("#testArea").show();
}
//测试登录扑克网站
function pokerLogin(){

}
</script>
</html>