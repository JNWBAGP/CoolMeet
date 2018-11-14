package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;
import com.sxit.CoolMeet.util.PageResult;

/**
 *搜索员工列表的Servlet
 *  
 * @author Administrator
 *
 */
 public class SearchStaffServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码方式
		request.setCharacterEncoding("utf-8");
		//获取页面传过来的参数
		String staffname=request.getParameter("employeename");
		String username=request.getParameter("username");
		String status="1";
		String statusStr=request.getParameter("status");
		if (statusStr!=null && !"".equals(statusStr)) {
			status=statusStr;
		}
		int currentPage=1;
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr!=null && !"".equals(currentPageStr))
		{
			currentPage=Integer.parseInt(currentPageStr);
		}
		PageResult<Staff> pr=new PageResult<Staff>();
		pr.setCurrentPage(currentPage);
		StaffService ssv=new StaffService();
		//起始条数
		int firstResult=(currentPage-1)*5;
		//显示条数
		int maxResult=5;
		try {
			//业务逻辑：分页过滤查询员工列表list 共有多少条，分级也显示，当前第几页
			ssv.pageList(pr, firstResult, maxResult,staffname,username,status);
			//把信息Page传给页面
			request.setAttribute("page", pr);
			request.setAttribute("staffname", staffname);
			request.setAttribute("username", username);
			request.setAttribute("status", status);
			//跳转到searchstaff.jsp
			request.getRequestDispatcher("pages/searchstaff.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
