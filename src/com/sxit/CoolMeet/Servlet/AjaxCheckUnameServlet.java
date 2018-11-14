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
 * 异步验证用户名是否可用的Servlet
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
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//获取页面传过来的注册用户名
		String username=request.getParameter("username");
		//业务逻辑：验证用户名是否存在
		StaffService ssv=new StaffService();
		try {
			Staff staff= ssv.selectByName(username);
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			if(staff!=null){//如果存在，返回Fail给页面
				out.print("fail");
			}else{//如果不存在，返回Success给页面
				out.print("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
