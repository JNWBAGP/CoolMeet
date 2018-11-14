package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.MeetingRoomService;
/**
 * 修改表单提交Servlet
 * 
 * @author Administrator
 *
 */
public class EditMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMeetingRoomServlet() {
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
		//获取页面传过来的值，包括会议室Id,门牌号,会议室名称，状态，备注,最多容纳人数
		String roomid=request.getParameter("roomid");
		String roomnum =request.getParameter("roomnum");
		String roomname=request.getParameter("roomname");
		String capacity=request.getParameter("capacity");
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		MeetingRoomService mrs=new MeetingRoomService();
		try {
			//业务逻辑：修改数据库中相应的数据
			mrs.saveMeetingRoom(Integer.parseInt(roomid), Integer.parseInt(roomnum), roomname, Integer.parseInt(capacity), status, description);
			//跳转到SearchMeetingRoomServlet
			request.getRequestDispatcher("SearchMeetingRoomServlet").forward(request, response);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
