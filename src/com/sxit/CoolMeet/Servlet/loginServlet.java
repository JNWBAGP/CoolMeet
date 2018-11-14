package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		//1.设置编码方式
		request.setCharacterEncoding("utf-8");
		//2.获取到登录界面传过来的用户名和密码
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		//3.业务逻辑：通过用户名和密码验证用户是否存在
		StaffService service=new StaffService();
		try {
			Staff staff=service.login(username, pwd);
			if(staff!=null){//4.如果存在，则需要判用户状态
				String status=staff.getStatus(); 
				if(status.equals("0")){//4-0 待审批，登录失败
					//请求属性
					request.setAttribute("msg", "该用户待审批，请审批通过后再行登录");
					//请求转发
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if (status.equals("1")) {//4-1审批通过，登陆成功，需要判断用户角色
					String roles=staff.getRole();
					if (roles.equals("1")) {//4-1-1角色为管理员，跳转至管理员界面
						//request.setAttribute("username", username);
						//将用户提交的信息储存到Session中
						HttpSession session=request.getSession();
						session.setAttribute("staff",staff);
						//请求转发
						request.getRequestDispatcher("pages/admin_index.jsp").forward(request, response);
					}else if (roles.equals("2")) {//4-1-2角色为普通用户，跳转至用户界面
						//将用户提交的信息储存到Session中
						HttpSession session=request.getSession();
						session.setAttribute("staff",staff);
						//请求转发
						request.getRequestDispatcher("pages/staff_index.jsp").forward(request, response);
					}
				}else if (status.equals("2")) {//4-2审批被拒绝，登录失败
					//请求属性
					request.setAttribute("msg", "对不起，您的审批被拒绝");
					//请求转发
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if (status.equals("3")) {//4-3用户被禁用，登录失败
					//请求属性
					request.setAttribute("msg", "对不起，您的账户已被禁用");
					//请求转发
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}			
			}else{//如果不存在，用户名或密码输入错误，返回登录界面	
				//请求属性
				request.setAttribute("msg", "用户名或密码输入错误");
				//请求转发
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//跳转到错误页面，提示用户
			request.setAttribute("msg","网络错误，请联系管理员");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
