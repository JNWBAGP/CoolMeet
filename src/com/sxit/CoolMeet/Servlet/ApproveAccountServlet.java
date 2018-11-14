package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;

/**
 * Servlet implementation class ApproveAccountServlet
 */
public class ApproveAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ҵ���߼�����ѯ���д�����״̬�µ�Ա����Ϣ
		StaffService ssv=new StaffService();
		try {
			List<Staff> list=ssv.selectByStats("0");
			//��Ա����Ϣ�ŵ�����������
			request.setAttribute("list", list);
			//��ת������Ա������
			request.getRequestDispatcher("pages/approveaccount.jsp").forward(request, response);
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
