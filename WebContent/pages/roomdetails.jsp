<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
 <script type="text/javascript">
	var ids="roomnum，roomname，capacity";
	var msgs="请输入门牌号，请输入会议名称，请输入最多容纳人数";
		//门牌号不能为空
	  //会议名称不能为空，
	  //最多容纳人数不能为空
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
	//验证是否为正数
	//门牌号是否为正整数
	//最多容纳人数是否为正整数
 	function checkInt(id){
 		var num=$("#"+id).val();
 		var reg=/^[1-9]\d*$/;
 		if(!reg.test(num)){
 			$("#"+id+"Error").html("请输入正整数");
			return false;
 		}
 		return true;
	}
	 //门牌的唯一性
	 	function ajaxCheckRoomnum(){
		//账户是否存在，若存在给出错误提示
		var flag=false;
		var roomnum = $("#roomnum").val();
		//获取当前门牌号
		var rn="${room.roomnum}";
		if(roomnum==rn){//如果当前门牌号和查看详情的门牌号一致，说明并没有修改门牌号，不需要进行唯一验证
			flag=true;
		}else{
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/AjaxCheckRoomNumServlet",
				async : false,
				data : "roomnum=" + roomnum,
				success : function(msg) {
					if (msg == "fail") {
						$("#roomnumError").html("门牌号已存在");
					}else{
						flag=true;
					}
				}
			});
		}
		return flag;
		
	}
	 //验证会议室名称的唯一性
	 function ajaxCheckRoomname(){
		//账户是否存在，若存在给出错误提示
		var flag=false;
		var roomname= $("#roomname").val();
		var rname="${room.roomname}";
		if(rname==roomname){
			flag=true;
		}else{
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/AjaxCheckRoomNameServlet",
				async : false,
				data : "roomname=" + roomname,
				success : function(msg) {
					if (msg == "fail") {
						$("#roomnameError").html("会议室名称已存在");
					}else{
						flag=true;
					}
				}
			});
		}
		return flag;
	}
	 //验证状态，在修改状态为停用之前，需要验证会议室是否被占用
	function ajaxCheckRoomTakeup(){
		var flag=false;
		var status=$("input:radio[name='status']:checked").val();
		var roomid="${room.roomid}";
		if(status=="1"){
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/AjaxCheckRoomTakeupServlet",
				async : false,
				data : "roomid=" + roomid,
				success : function(msg) {
					if (msg == "fail") {
						$("#statusError").html("会议室已被占用，不可修改为停用状态");
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
		 
	 
  function editMeetingRoom(){
	  if(checkNull()&&checkInt("roomnum")&&checkInt("capacity")&&ajaxCheckRoomnum()&&ajaxCheckRoomname()&&ajaxCheckRoomTakeup()){
	  //修改表单提交
		$("#editForm").submit();
	  }
  }
 
 </script>
</head>
<body>
           <div class="page-content">
                <div class="content-nav">
                    会议预定 > 添加会议室
                </div>
                <form action="${pageContext.request.contextPath}/EditMeetingRoomServlet" method="post" id="editForm">
                <input style="display:none;"type="text" name="roomid" value="${room.roomid }" />
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnum" name="roomnum" type="text" value="${room.roomnum }" maxlength="10"/>
                                    <span style="color:red;" id="roomnumError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="roomname" name="roomname" type="text" value="${room.roomname }" maxlength="20"/>
                                    <span style="color:red;" id="roomnameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="capacity" name="capacity" type="text" value="${room.capacity }"/>
                                    <span style="color:red;" id="capacityError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" <c:if test="${room.roomStatus=='0' }">checked</c:if> value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" <c:if test="${room.roomStatus=='1'}">checked</c:if> value="1"/><label for="status">停用</label>
                                   <span style="color:red;" id="statusError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" name="description" maxlength="200" rows="5" cols="60">${room.description }</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" value="确认修改" class="clickbutton" onclick="editMeetingRoom()"/>
                                    <input type="reset" value="重置" class="clickbutton"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>