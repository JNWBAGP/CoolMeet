package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.MeetingRoom;
import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * ��ѯ���л�����
 * 
 * @author Administrator
 *
 */

public class SearchMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMeetingRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ҵ���߼��������ݿ��в�ѯ���еĻ�����
		MeetingRoomService mrs=new MeetingRoomService();
		try {
			List<MeetingRoom> list=mrs.searchRoom();
			//���б���ҳ��
			request.setAttribute("list",list);
			//��ת��meetingroom.jsp
			request.getRequestDispatcher("pages/meetingroom.jsp").forward(request, response);
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
