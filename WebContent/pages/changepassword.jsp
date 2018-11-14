<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
<script type="text/javascript">
	//修改密码事件
	function changePwd(){
		//验证原密码是否为空，若为空，给出提示
		if($("#origin").val()==""){
			$("#originError").html("请输入原密码");
			return;
		}
		//验证原密码是否正确
		if($("#origin").val()!="${staff.pwd}"){
			$("#originError").html("原密码错误");
			return;
		}
		//验证新密码是否为空
		if($("#newPwd").val()==""){
			$("#newPwdError").html("请输入新密码");
			return;
		}
		//验证确认密码是否与新密码一致
		if($("#newPwd").val()!=$("#confirm").val()){
			$("#confirmError").html("两次密码输入不一致");
			return;
		}
		//修改密码表单提交
		$("#changePwdForm").submit();
	}
</script>
</head>
<body>
<div class="page-content">
                <div class="content-nav">
                    修改密码
                </div>
                <form action="${pageContext.request.contextPath}/ChangePwdServlet" method="post" id="changePwdForm" target="_parent">
                    <fieldset>
                        <legend>修改密码信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="origin" type="password" />
                                    <span style="color:red;" id="originError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>新密码:</td>
                                <td>
                                    <input id="newPwd" name="newPwd" type="password" />
                                    <span style="color:red;" id="newPwdError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>确认新密码：</td>
                                <td>
                                    <input id="confirm" type="password"/>
                                    <span style="color:red;" id="confirmError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" value="确认修改" class="clickbutton" onclick="changePwd()"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                    
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>