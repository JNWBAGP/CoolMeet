package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.StaffService;


/**
 * 修改指定状态的Servlet
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
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//获取页面传过来的状态值和员工id
		String status=request.getParameter("status");
		String staffid=request.getParameter("staffid");
		String index=request.getParameter("index");
		//业务逻辑：在数据库里修改状态
		StaffService ssv=new StaffService();
			try {
				ssv.changeStatus(status, Integer.parseInt(staffid));
				//提示操作成功
				request.setAttribute("msg","操作成功");
				if (index!=null&&!"".equals(index)) {
					//跳转到SearchStaffServlet
					request.getRequestDispatcher("SearchStaffServlet").forward(request, response);
				}else{
					//跳转到ApproveAccountServlet
					request.getRequestDispatcher("ApproveAccountServlet").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	
	
	}

}
