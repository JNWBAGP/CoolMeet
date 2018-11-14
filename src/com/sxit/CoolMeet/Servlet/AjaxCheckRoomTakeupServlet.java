package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * 异步验证该会议室是否被占用
 * 
 * @author Administrator
 *
 */
public class AjaxCheckRoomTakeupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckRoomTakeupServlet() {
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
		//获取需要验证会议室的ID
		String roomid=request.getParameter("roomid");
		//业务逻辑：查询会议室是否被占用
		MeetingRoomService mrs=new MeetingRoomService();
		try {
			int count=mrs.findRoomByTakeup(Integer.parseInt(roomid));
			PrintWriter out=response.getWriter();
			if(count>0){
				out.print("fail");
			}else{
				out.print("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果被占用，返回fail，没有被占用返回success
		
	}

}
