<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@include file="/root/mytags.jsp"%>
<!DOCTYPE html>
<html>
<header>
<script type="text/javascript" src="${jsRoot}/jquery-1.9.1.min.js"></script>
</header>
<body style="background-image: url('${picRoot}/backgroundPIC/index_background.jpg');background-repeat: no-repeat; background-size: 120% 120%;">
	<div>
		<div>
			
		</div>
		<div style="height:1px;width:1px;background:#228B22; color:#FFF;opacity:0.5;margin-top:25%;margin-left:35%;">
			<div style="border-radius:25px;text-align: center;background:#000; color:#FFF;opacity:1;margin-top:30%;margin-left:10%;height:200px;width:600px">
				<p style="margin-top:60%;">
					<br>
					<br>
					<a href="${webRoot}/signIn/signInPage.do"><font size="6" style="weight:900;color:#FFF">登录</font></a><br><br>
					<a href="${webRoot}/signIn/registerPage.do"><font size="6" style="weight:900;color:#FFF">注册</font></a>
					<br>
					<div style="text-align: right;">
						<%-- <a href="${webRoot}/signIn/findBack.do"><font size="3" style="weight:900;color:#FFF">忘记密码?</font></a> --%>
						<a href="javascript:haha();"><font size="3" style="weight:900;color:#FFF">忘记密码?</font></a>
					</div>
				</p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function haha(){
		alert("忘了 就忘了吧, 反正再注册新号也会忘的/xyx");
	}
</script>
</html>