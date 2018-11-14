package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.StaffService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ���ύ�����ݣ������������û��������룬�ֻ��ţ��������䣬���ڲ���
		String staffname=request.getParameter("staffname");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String departmentid=request.getParameter("deptid");
		//ҵ���߼��������ݿ�������û�
		StaffService ssv=new StaffService();
			try {
				//ע��
				ssv.regiterStaff(staffname, username, pwd, phone, email, Integer.parseInt(departmentid));
				//��ʾע��ɹ�
				request.setAttribute("msg", "ע��ɹ�");
				//��ת����¼����
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		//
		
	}

}
