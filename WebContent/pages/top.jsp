<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>无标题文档</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
</head>

<body>
  <div class="page-header">
            <div class="header-banner">
                <br /><img src="${pageContext.request.contextPath}/images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong>${staff.username} </strong>
                <a href="${pageContext.request.contextPath}/pages/changepassword.jsp" target="main">[修改密码]</a>
                <a href="${pageContext.request.contextPath}/LogoutServlet" target="_parent">[退出]</a>
            </div>
        </div>
</body>
</html>
