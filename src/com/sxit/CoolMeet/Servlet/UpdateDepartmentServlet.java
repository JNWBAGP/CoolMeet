package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.DepartmentService;

/**
 * Servlet implementation class UpdateDepartmentServlet
 */
public class UpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求编码方式
		request.setCharacterEncoding("utf-8");
		// 接收页面传过来的部门id和部门名称
		String departmentid = request.getParameter("departmentid");
		String departmentname = request.getParameter("departmentname");
		DepartmentService ds = new DepartmentService();
		try {
			// 业务逻辑：通过传过来的部门ID修改部门名称
			ds.updateDepartment(Integer.parseInt(departmentid), departmentname);
			//跳转到管理部门的Servlet
			request.getRequestDispatcher("SearchDepartmentServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
