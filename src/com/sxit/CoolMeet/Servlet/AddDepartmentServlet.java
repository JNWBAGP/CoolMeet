package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.DepartmentService;

/**
 * Servlet implementation class AddDepartmentServlet
 */
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ��������ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡҳ�洫�����Ĳ�������
		String departmentname=request.getParameter("departmentname");
		//ҵ���߼��������ݿ�����Ӳ���
		DepartmentService ds=new DepartmentService();
		try {
			ds.saveDepartment(departmentname);
			//��ʾ����ɹ�
			request.setAttribute("msg", "��ӳɹ�");
			//��תSearchDepartmentServlet
			request.getRequestDispatcher("SearchDepartmentServlet").forward(request, response);
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
