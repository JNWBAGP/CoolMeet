<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	//添加部门
	function addDepartment(){
		if($("#departmentnaem")!=""){
			$("#addDepartment").submit();
		}
	}
	//删除部门
	function deleteDepartment(departmentid){
		if(confirm("如果删除该部门，则该部门下的员工也将被删除，确定删除吗")){
			window.location.href="${pageContext.request.contextPath}/DeleteDepartmentServlet?departmentid="+departmentid;
		}
	}
	//进入编辑状态
	function editDepartment(departmentid,departmentname){
		//把选中的部门名称变为可编辑状态
		$("#tdDepname"+departmentid).html("<input id='editdepname"+departmentid+"' type='text' value='"+departmentname+"'/>");
		//隐藏“编辑” 按钮
		$("#editBtn"+departmentid).hide();
		//添加“确定”按钮
		$("#confirmBtn"+departmentid).show();
		//显示“取消”按钮
		$("#cancelBtn"+departmentid).show();
	}
	function cancelEdit(departmentid,departmentname){
		//选中的部门名称变为不可编辑
		$("#tdDepname"+departmentid).html(departmentname);
		//“编辑”按钮显示
		$("#editBtn"+departmentid).show();
		//“确定”按钮隐藏
		$("#confirmBtn"+departmentid).hide();
		//“取消”按钮隐藏
		$("#cancelBtn"+departmentid).hide();
	}
	function confirmEditDepartment(departmentid){
		//部门id和部门名称赋值
		$("#editID").val(departmentid);
		var depname=$("#editdepname"+departmentid).val();
		if(depname!=""){
			$("#editname").val(depname);
			//提交表单
			$("#editForm").submit();
		}
	}

</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpdateDepartmentServlet" method="post" id="editForm">
<input style="display: none;" type="text" name="departmentid" id="editID"/>
<input style="display: none;" type="text" name="departmentname" id="editname"/>
</form>
	<div class="page-content">
		<div class="content-nav">人员管理 > 部门管理</div>
		<form id ="addDepartment" action="AddDepartmentServlet" method="post">
			<fieldset>
				<legend>添加部门</legend>
				部门名称: <input type="text" id="departmentname" name="departmentname" maxlength="20" /> <input
					type="button" class="clickbutton" value="添加" onclick="addDepartment()" />
			</fieldset>
		</form>
		<table class="listtable">
			<caption>所有部门:</caption>
			<tr class="listheader">
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list }" var="department">
				<tr>
					<td>${department.departmentid }</td>
					<td id="tdDepname${department.departmentid }">${department.departmentname }</td>
					<td><a id="editBtn${department.departmentid }" class="clickbutton" onclick="editDepartment('${department.departmentid }','${department.departmentname }')">编辑</a> 
						<a id="confirmBtn${department.departmentid }" style="display:none;" class="clickbutton" onclick="confirmEditDepartment('${department.departmentid }')">确定</a>
						<a id="cancelBtn${department.departmentid }" style="display:none;" class="clickbutton" onclick="cancelEdit('${department.departmentid }','${department.departmentname }');">取消</a>
					    <a class="clickbutton" onclick="deleteDepartment('${department.departmentid }')">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>