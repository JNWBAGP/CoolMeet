package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Service.MeetingRoomService;
/**
 * �޸ı��ύServlet
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
		//��ȡҳ�洫������ֵ������������Id,���ƺ�,���������ƣ�״̬����ע,�����������
		String roomid=request.getParameter("roomid");
		String roomnum =request.getParameter("roomnum");
		String roomname=request.getParameter("roomname");
		String capacity=request.getParameter("capacity");
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		MeetingRoomService mrs=new MeetingRoomService();
		try {
			//ҵ���߼����޸����ݿ�����Ӧ������
			mrs.saveMeetingRoom(Integer.parseInt(roomid), Integer.parseInt(roomnum), roomname, Integer.parseInt(capacity), status, description);
			//��ת��SearchMeetingRoomServlet
			request.getRequestDispatcher("SearchMeetingRoomServlet").forward(request, response);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
