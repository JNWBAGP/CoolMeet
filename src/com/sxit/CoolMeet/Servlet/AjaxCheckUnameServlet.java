package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;
/**
 * �첽��֤�û����Ƿ���õ�Servlet
 * @author zhaochenjiang
 *
 */
public class AjaxCheckUnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckUnameServlet() {
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
		//�����������
		request.setCharacterEncoding("utf-8");
		//��ȡҳ�洫������ע���û���
		String username=request.getParameter("username");
		//ҵ���߼�����֤�û����Ƿ����
		StaffService ssv=new StaffService();
		try {
			Staff staff= ssv.selectByName(username);
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			if(staff!=null){//������ڣ�����Fail��ҳ��
				out.print("fail");
			}else{//��������ڣ�����Success��ҳ��
				out.print("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
