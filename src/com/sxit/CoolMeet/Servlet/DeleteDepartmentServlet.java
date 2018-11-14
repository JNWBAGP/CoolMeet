package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.DepartmentService;

/**
 * Servlet implementation class DeleteDepartmentServlet
 */
public class DeleteDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// ��ֻ����ʽ
		request.setCharacterEncoding("utf-8");
		// ��ȡ�û��������Ĳ���������ID
		String departmentid = request.getParameter("departmentid");
		// ҵ���߼���ɾ��ָ�����Ų���ɾ���ò����µ�Ա��
		DepartmentService ds = new DepartmentService();
		try {
			ds.deleteStaffByDepid(Integer.parseInt(departmentid));
			// ��ת�����б�Servlet��ȥ
			request.getRequestDispatcher("SearchDepartmentServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
