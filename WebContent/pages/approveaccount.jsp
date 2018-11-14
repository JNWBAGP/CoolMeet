<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
 <script type="text/javascript">
 	$(function (){
 		var msg="${msg}";
 		if(msg!=""){
 			alert(msg);
 		}
 	});
 	function changeStatus(status,staffid){
 		$("#status").val(status);
 		$("#staffid").val(staffid);
 		//提交状态
 		$("#changeStatusForm").submit();
 	}
 
 
 </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ChangeStatusServlet" method="post" id="changeStatusForm">
<input type="text" style="display:none;" name="status" id="status">
<input type="text" style="display:none;" name="staffid" id="staffid">
</form>
   <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
              <!--循环遍历list，没便利一次增加一行 -->
              		<c:forEach items="${list}" var="staff">
              		   <tr>
                        <td>${staff.staffname}</td>
                        <td>${staff.username}</td>
                        <td>${staff.phone}</td>
                        <td>${staff.email}</td>
                        <td>
                            <input type="button" class="clickbutton" value="通过" onclick="changeStatus('1','${staff.staffid}')"/>
                            <input type="button" class="clickbutton" value="拒绝" onclick="changeStatus('2','${staff.staffid}')"/>
                        </td>
                    </tr> 
              		</c:forEach>
                               
                </table>
            </div>
</body>
</html>