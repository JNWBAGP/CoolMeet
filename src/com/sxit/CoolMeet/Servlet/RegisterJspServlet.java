package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Department;
import com.sxit.CoolMeet.Service.DepartmentService;

/*
 * Ա��ע��Servlet
 * 
 * 
 * 
 * 
 * */
public class RegisterJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterJspServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ��뷽ʽ
		request.setCharacterEncoding("utf-8");
		DepartmentService ds=new DepartmentService();
		try {
			//ҵ���߼�����ѯ���в�����Ϣ
			List<Department> list=ds.selectAlldep();
			//�Ѳ�����Ϣ����ע��ҳ��
			request.setAttribute("list", list);
			//��ת��ע��ҳ��
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
