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
		// ����������뷽ʽ
		request.setCharacterEncoding("utf-8");
		// ����ҳ�洫�����Ĳ���id�Ͳ�������
		String departmentid = request.getParameter("departmentid");
		String departmentname = request.getParameter("departmentname");
		DepartmentService ds = new DepartmentService();
		try {
			// ҵ���߼���ͨ���������Ĳ���ID�޸Ĳ�������
			ds.updateDepartment(Integer.parseInt(departmentid), departmentname);
			//��ת�������ŵ�Servlet
			request.getRequestDispatcher("SearchDepartmentServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
