package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * Servlet implementation class AddMeetingRoomServlet
 */
public class AddMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMeetingRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取从页面传过来的值，包括 门牌号、会议室名称、容纳人数、会议室状态、备注
		String roomnum = request.getParameter("roomnum");
		String roomname = request.getParameter("roomname");
		String capacity = request.getParameter("capacity");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		MeetingRoomService mr = new MeetingRoomService();
		try {
			// 业务逻辑：数据库中添加会议室
			mr.addMeetingRoom(Integer.parseInt(roomnum), roomname,
					Integer.parseInt(capacity), status, description);
			//提示添加成功
			request.setAttribute("msg","添加成功");
			//跳转到添加页面
			request.getRequestDispatcher("pages/addmeetingroom.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
