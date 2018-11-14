<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	var ids="employeename，username，password，confirm，phone，email";
	var msgs="请输入用姓名，请输入账户名，请输入密码，请确认密码，请输入电话号码，请输入电子邮箱";
	
	//验证非空
		//姓名不能为空，如果为空给出提示
		//账户不能为空
		//密码不能为空
		//确认密码不能为空
		//电话号码不能为空
		//电子邮件不能为空
	function checkNull(){
		//通过逗号拆分
		var idArray=ids.split("，");
		var msgArray=msgs.split("，");
		//循环便利给出错误提示
		for(var i=0;i<idArray.length;i++){
			if($("#"+idArray[i]).val()==""){
				$("#"+idArray[i]+"Error").html(msgArray[i]);
				return false;
			}
		}
		return true;
	}
	//异步验证账户名是否可用
	function ajaxCheckUname(){
		//账户是否存在，若存在给出错误提示
		var flag=false;
		var username = $("#username").val();
		$.ajax({
			type : "POST",
			url : "AjaxCheckUnameServlet",
			async : false,
			data : "username=" + username,
			success : function(msg) {
				if (msg == "fail") {
					$("#usernameError").html("用户名已存在");
				}else{
					flag=true;
				}
			}
		});
		return flag;
		
	}
	//密码长度不能小于6位
	//密码与确认密码一只
	function checkPwd(){
		if($("#password").val().length<6){
			$("#passwordError").html("密码长度不能小于6位");
			return false;
		}
		if($("#password").val()!=$("#confirm").val()){
			$("#confirmError").html("两次密码输入不一致");
			return false;
		}
		return true;
	}
	//电话的正确格式
	function checkPhone(){
		var reg=/^1[3|4|5|7|8][0-9]{9}$/;
		if(!reg.test($("#phone").val())){
			$("#phoneError").html("请输入正确格式的手机号");
			return false;
		}
		return true;
	}
	//电子邮件的正确格式
	function checkEmail(){
		var reg=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!reg.test($("#email").val())){
			$("#emailError").html("请输入正确格式的电子邮件");
			return false;
		}
		return true;
		
	}
	//注册事件
	function register() {
		if (checkNull() && ajaxCheckUname() && checkPwd() && checkPhone() && checkEmail()) {
			//提交注册表单
			$("#registerForm").submit();
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>

	</div>
<div class="page-content">
                <div class="content-nav">
                   人员管理 > 员工注册
                </div>
                <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" id="registerForm">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" name="staffname" maxlength="20"/>
                                    <span style="color:red;" id="employeenameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" id="username" name="username" maxlength="20"/>
                                    <span style="color:red;" id="usernameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" id="password" name="pwd" maxlength="20" placeholder="请输入6位以上的密码"/>
                                    <span style="color:red;" id="passwordError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="20"/>
                                    <span style="color:red;" id="confirmError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" id="phone" name="phone" maxlength="20"/>
                                    <span style="color:red;" id="phoneError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" id="email" name="email" maxlength="20"/>
                                     <span style="color:red;" id="emailError"></span>
                                </td>
                            </tr>
							<td>所在部门：</td>
							<tr>
                                <td>
                                    <select name="deptid">
                                    	<!-- 通过Servlet传过来的部门列表list，循环便利显示option选项 -->
                                		 <c:forEach items="${list}" var="d" >
                                			<option value="${d.departmentid}">${d.departmentname}</option>
                                		</c:forEach> 
                                     	<!-- <option value="1">技术部</option>
                                     	<option value="2">财务部</option>
										<option value="3">人事部</option>  -->
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="注册" onclick="register()"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
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
			src="images/footer.png" alt="CoolMeeting" />
	</div>
    </body>
</html>