package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.StaffService;


/**
 * �޸�ָ��״̬��Servlet
 * 
 * @author Administrator
 *
 */
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
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
		//��ȡҳ�洫������״ֵ̬��Ա��id
		String status=request.getParameter("status");
		String staffid=request.getParameter("staffid");
		String index=request.getParameter("index");
		//ҵ���߼��������ݿ����޸�״̬
		StaffService ssv=new StaffService();
			try {
				ssv.changeStatus(status, Integer.parseInt(staffid));
				//��ʾ�����ɹ�
				request.setAttribute("msg","�����ɹ�");
				if (index!=null&&!"".equals(index)) {
					//��ת��SearchStaffServlet
					request.getRequestDispatcher("SearchStaffServlet").forward(request, response);
				}else{
					//��ת��ApproveAccountServlet
					request.getRequestDispatcher("ApproveAccountServlet").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	
	
	}

}
