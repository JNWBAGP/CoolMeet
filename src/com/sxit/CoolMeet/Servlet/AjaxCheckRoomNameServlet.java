package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.MeetingRoom;
import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * Servlet implementation class AjaxCheckRoomNameServlet
 */
public class AjaxCheckRoomNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckRoomNameServlet() {
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
		// 获取页面传过来的会议名称
		String roomname = request.getParameter("roomname");
		// 业务逻辑：通过门牌号查找会议室是否存在
		MeetingRoomService msr = new MeetingRoomService();
		try {
			MeetingRoom mr=msr.findByMeetingRoomName(roomname);
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			if(mr!=null){//如果存在，返回Fail给页面
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
