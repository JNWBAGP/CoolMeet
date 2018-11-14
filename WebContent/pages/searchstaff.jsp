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
 	function  gotoPage(currentPage){
	 $("#currentPage").val(currentPage);
	 $("#searchForm").submit();
 }
 	function tz(){
 		var tzPage=$("#pagenum").val();
 		var reg=/^[1-9]\d*$/;
 		if(reg.test(tzPage)){
 			var totalPage="${page.totalPage}";
 			if(parseInt(tzPage)>parseInt(totalPage)){//如果输入的数值大于最后一页,则跳转到最后一页
 				gotoPage(totalPage);
 			}else{
 				gotoPage(tzPage);
 			}
 		}else{//如果是非正数，则跳转到第一页
 			gotoPage('1');
 		}
 	}
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
<input type="text" style="display:none;" name="status" id="status"/>
<input type="text" style="display:none;" name="staffid" id="staffid"/>
<input type="text" style="display:none;"name="index" value="searchStaff"/>
</form>
<div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form action="${pageContext.request.contextPath }/SearchStaffServlet" method="post" id="searchForm">
                <input type="text" name="currentPage" id="currentPage" style="display:none">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" name="employeename" maxlength="20" value="${staffname }"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" name="username" maxlength="20" value="${username }"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio" name="status" value="1" <c:if test="${status=='1' }">checked</c:if>  /><label>已批准</label>
                                    <input type="radio" name="status" value="0" <c:if test="${status=='0' }">checked</c:if>  /><label>待审批</label>
									<input type="radio" name="status" value="2" <c:if test="${status=='2' }">checked</c:if>  /><label>未通过</label>
                                    <input type="radio" name="status" value="3" <c:if test="${status=='3' }">checked</c:if>  /><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">${page.totalCount }</span>条结果，
                            分成<span class="info-number">${page.totalPage }</span>页显示，
                            当前第<span class="info-number">${page.currentPage }</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页"  onclick="gotoPage('1')"/>
                        <!--     当前页码大于一的情况下显示上一页 -->
                      		<c:if test="${page.currentPage >1}"> 
                            <input type="button" class="clickbutton" value="上页"  onclick="gotoPage('${page.currentPage-1}')"/>
                            </c:if>
                         <!--      当前页码小于最大页码的情况下显示下一页 -->
                         	<c:if test="${page.currentPage <page.totalPage}"> 
                            <input type="button" class="clickbutton" value="下页"  onclick="gotoPage('${page.currentPage+1}')"/>
                            </c:if>
                            <input type="button" class="clickbutton" value="末页"  onclick="gotoPage('${page.totalPage}')"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转" onclick="tz()"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${page.pageList }" var="staff">
                    <tr>
                        <td>${staff.staffname }</td>
                        <td>${staff.username }</td>
                        <td>${staff.phone }</td>
                        <td>${staff.email }</td>
                        <td>
                       <!--  状态为1的时候展现禁用按钮 -->
                       <c:if test="${staff.status=='1'}">
                       		<a class="clickbutton" onclick="changeStatus('3','${staff.staffid}')"">禁用</a>
                       </c:if>
                       <!--  状态为2、3的时候展现启用按钮 -->
                       <c:if test="${staff.status=='3' }">
							<a class="clickbutton" onclick="changeStatus('1','${staff.staffid}')">启用</a>
                       </c:if>
                       <!--  状态为0的时候两个按钮均展现 -->
                       <c:if test="${staff.status=='0'||staff.status=='2' }">
                            <a class="clickbutton" onclick="changeStatus('1','${staff.staffid}')">通过</a>
                        </c:if>
                        <c:if test="${staff.status=='0' }">
                            <a class="clickbutton" onclick="changeStatus('2','${staff.staffid}')">拒绝</a>
                         </c:if>
                        </td> 
                    </tr>
                    </c:forEach>
                    <c:if test="${page.pageList.size()==0 }">
                    <tr>
                    <td colspan="5">没有找到匹配的数据</td>
                    </tr>
                    </c:if>
                </table>
            </div>
</body>
</html>