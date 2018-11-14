<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
//验证状态，如果要删除的会议室在启用状态，需要验证会议室是否被占用
function ajaxCheckRoomTakeup(roomid,roomStatus){
	var flag=false;
	if(roomStatus=="0"){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/AjaxCheckRoomTakeupServlet",
			async : false,
			data : "roomid=" + roomid,
			success : function(msg) {
				if (msg == "fail") {
					alert("会议室已被占用，不可修改为停用状态");
				}else{
					flag=true;
				}
			}
		});
	}else{
		flag=true;
	}
return flag;
}
	function deleteMeetingRoom(roomid,roomStatus){
		if(ajaxCheckRoomTakeup(roomid,roomStatus)){
			//证明该会议室没有被占用，可以删除
			window.location.href="${pageContext.request.contextPath}/DeleteMeetingRoomServlet?roomid="+roomid;
		}
	}

</script>
</head>
<body>
 <div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list }" var="meetingroom">
                    <tr>
                        <td>${meetingroom.roomnum }</td>
                        <td>${meetingroom.roomname }</td>
                        <td>${meetingroom.capacity }</td>
                        <td>
                        	<c:if test="${meetingroom.roomStatus=='0' }">启用</c:if>
                        	<c:if test="${meetingroom.roomStatus=='1' }">停用</c:if>
                        </td>
                        <td>
                            <a class="clickbutton" href="${pageContext.request.contextPath}/DetailMeetingRoomServlet?roomid=${meetingroom.roomid}">查看详情</a>
							<a class="clickbutton" onclick="deleteMeetingRoom('${meetingroom.roomid}','${meetingroom.roomStatus }')">删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
</body>
</html>