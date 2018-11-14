package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.MeetingRoomService;
/**
 * ɾ��������Servlet
 * 
 * @author Administrator
 *
 */
public class DeleteMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMeetingRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ�洫������IDֵ
		String roomid=request.getParameter("roomid");
		MeetingRoomService mrs=new MeetingRoomService();
		//ҵ���߼���ͨ��������id  1060068700
		try {
			mrs.deleteMeetingRoom(Integer.parseInt(roomid));
			//��ת��SearchMeetingRoomServlet
			request.getRequestDispatcher("SearchMeetingRoomServlet").forward(request, response);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
