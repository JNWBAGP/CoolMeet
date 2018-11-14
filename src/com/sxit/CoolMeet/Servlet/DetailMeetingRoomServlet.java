package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.CoolMeet.Entity.MeetingRoom;
import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * �鿴����ҳ��
 * 
 * @author Administrator
 * 
 */

public class DetailMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailMeetingRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����roomid
		String roomid = request.getParameter("roomid");
		// ҵ���߼�������roomid��ѯ��������Ϣ
		MeetingRoomService msr = new MeetingRoomService();
		try {
			MeetingRoom mr = msr.selectByRoonId(Integer.parseInt(roomid));
			// ����������Ϣ��������������
			request.setAttribute("room",mr);
			// ��ת������������ҳ��
			request.getRequestDispatcher("pages/roomdetails.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
