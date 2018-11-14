package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;
import com.sxit.CoolMeet.util.PageResult;

/**
 *����Ա���б��Servlet
 *  
 * @author Administrator
 *
 */
 public class SearchStaffServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������뷽ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡҳ�洫�����Ĳ���
		String staffname=request.getParameter("employeename");
		String username=request.getParameter("username");
		String status="1";
		String statusStr=request.getParameter("status");
		if (statusStr!=null && !"".equals(statusStr)) {
			status=statusStr;
		}
		int currentPage=1;
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr!=null && !"".equals(currentPageStr))
		{
			currentPage=Integer.parseInt(currentPageStr);
		}
		PageResult<Staff> pr=new PageResult<Staff>();
		pr.setCurrentPage(currentPage);
		StaffService ssv=new StaffService();
		//��ʼ����
		int firstResult=(currentPage-1)*5;
		//��ʾ����
		int maxResult=5;
		try {
			//ҵ���߼�����ҳ���˲�ѯԱ���б�list ���ж��������ּ�Ҳ��ʾ����ǰ�ڼ�ҳ
			ssv.pageList(pr, firstResult, maxResult,staffname,username,status);
			//����ϢPage����ҳ��
			request.setAttribute("page", pr);
			request.setAttribute("staffname", staffname);
			request.setAttribute("username", username);
			request.setAttribute("status", status);
			//��ת��searchstaff.jsp
			request.getRequestDispatcher("pages/searchstaff.jsp").forward(request, response);
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
