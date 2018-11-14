<%@ page language="java" contentType="text/html;utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
<script type="text/javascript">
	function login() {
		var username = $("#username").val();
		if (username == "") {
			$("#usernameError").html("用户名为空");
			return;
		}
		var password = $("#password").val();
		if (password == "") {
			$("#passwordError").html("密码为空");
			return;
		}
		$("#loginForm").submit();

	}
	//获取焦点事件
	function focusOn(idError){
		//错误提示清空
		$("#"+idError).html();
	}
	//失去焦点事件
	function focusLose(id,msg){
		if($("#"+id).val()==""){
			$("#"+id+"Error").html(msg);
		}else if($("#"+id).val()!=""){
			$("#"+id+"Error").html();
		}
	}
</script>
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="${pageContext.request.contextPath}/images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>

	</div>
	<div class="page-body">

		<div class="page-content">
			<div class="content-nav">登录</div>
			<form action="loginServlet" method="post" id="loginForm">
				<fieldset>
					<legend>登录信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>账号名:</td>
							<td><input id="username"  type="text" name="username" onfocus="focusOn('usernameError')" onblur="focusLose('username','请输入用户名')"/><span style="color:red;" id="usernameError"></span></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input id="password" name="pwd" type="password" onfocus="focusOn('passwordError')" onblur="focusLose('password','请输入密码')"  /><span style="color:red;" id="passwordError"></span></td>
						</tr>
						<tr>
							<td colspan="2" class="command"><input type="button"
								value="登录" class="clickbutton" onclick="login()" /> <input
								type="button" value="取消" class="clickbutton"
								onclick="window.history.back();" />${msg}
								<a href="${pageContext.request.contextPath}/RegisterJspServlet">员工注册</a>
								</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="${pageContext.request.contextPath}/images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>