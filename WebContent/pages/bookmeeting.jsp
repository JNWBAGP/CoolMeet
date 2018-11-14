<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
 
        <style type="text/css">
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>
        <script type="application/javascript">
            function employee(employeeid, employeename){
                this.employeeid = employeeid;
                this.employeename = employeename;
            }
            function department(departmentid, departmentname, employees){
                this.departmentid = departmentid;
                this.departmentname = departmentname;
                this.employees = employees;
            }
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;
            
            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
                }
                fillEmployees();
            }
            
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;
                var employees;
                for(var i=0;i<data.length;i++){
                    if (departmentid == data[i].departmentid){
                        employees = data[i].employees;
                        break;
                    }
                }
                for(i=0;i<employees.length;i++){
                    var emp = document.createElement("option");
                    emp.value = employees[i].employeeid;
                    emp.text = employees[i].employeename;
                    selEmployees.appendChild(emp);
                }
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }
            
            var ids="meetingname,numofparticipants,starttime,endtime";
        	var msgs="请输入会议名称，请输入参会人数，请输入开始时间，请输入结束时间";
            //会议名称不能为空
            //参加人数不能为空
            //开始时间不能为空
            //结束时间不能为空
      function checkNull(){
		//通过逗号拆分
		var idArray=ids.split(",");
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
    //验证参加人数必须为正整数
   	function checkInt(id){
 		var num=$("#"+id).val();
 		var reg=/^[1-9]\d*$/;
 		if(!reg.test(num)){
 			$("#"+id+"Error").html("请输入正整数");
			return false;
 		}
 		return true;
	}
    function checkCapacity(){
    	//获取选中会议室id
    	var roomid=$("#roomid").val();
    	//通过会议室id得到该会议室可容纳人数
    	
    	//获取到用户输入的预计参会人数
    	//会议室的可容纳人数和预计参会人数进行比对
    	//如果预计参会人数大于可容纳人数，则给出错误提示:XX会议室，可容纳人数为XX人，并返回false
    	//反之返回true
    	var flag=false;
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/AjaxCheckRoomNumServlet",
			async : false,
			data : "roomnum=" + roomnum,
			success : function(msg) {
				
			}
		});
    	
    }
            function bookmeeting(){
            //验证参加人数必须小于选择会议室的可容纳人数
            //验证选中的会议室在此时间内是否被占用
            //验证参加人员不能为空
            //结束时间必须大于开始时间
            //预定会议表单提交，执行提交操作
            if(checkNull()&&checkInt("numofparticipants"))
            }
        </script>
</head>
<body onload="body_load()">
<div class="page-content">
                <div class="content-nav">
                    会议预定 > 预定会议
                </div>
                <form>
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" name="meetingname" maxlength="20"/>
                                    <span style="color:red;" id="meetnameError"></span>
                                </td>
                            </tr>
                            	<tr>
                                <td>会议室名称：</td>
                                <td>
                                    <select name="roomid" id="roomid"> 
                                    <c:forEach items="${meetingroom }" var="room">   
                                     	<option value="${room.roomid }">${room.roomname }</option>
                                    </c:forEach>
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="text" id="numofparticipants" name="numofparticipants"/>
                                    <span style="color:red;" id="numofparticipantsError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                    <input type="text" id="starttime" name="starttime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'endtime\')}'})" class="Wdate"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input type="text" id="endtime" name="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'starttime\')}'})" class="Wdate"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea name="description" rows="5"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <select id="selDepartments" onchange="fillEmployees()">
                                        <option value="">请选择</option>
                                        <c:forEach items="${department }" var="department">
                                        	<option value="${department.departmentid }">${department.departmentname }</option>
                                        </c:forEach>
                                        </select>
                                        <select id="selEmployees" multiple="true">
                                        </select>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" multiple="true">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" onclick="bookmeeting()" class="clickbutton" value="预定会议"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>