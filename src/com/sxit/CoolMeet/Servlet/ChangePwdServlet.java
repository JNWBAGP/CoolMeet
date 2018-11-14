package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;

/**
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
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
		//1.���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//2.��ȡ�û���������������
		String newPwd=request.getParameter("newPwd");
		//��ȡ��ǰ�û���ID
		Staff staff=(Staff) request.getSession().getAttribute("staff");
		//3.ҵ���߼����޸ĵ�ǰ�û�������
		StaffService staffService=new StaffService();
		try {
			staffService.changePwd(staff.getStaffid(), newPwd);
			//4.��ʾ�����޸ĳɹ�
			request.setAttribute("msg", "�޸�����ɹ��������µ�¼");
			//5.���µ�¼
			request.getRequestDispatcher("login.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
