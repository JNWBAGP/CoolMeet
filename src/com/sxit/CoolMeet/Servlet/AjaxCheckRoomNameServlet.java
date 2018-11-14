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
		// ��ȡҳ�洫�����Ļ�������
		String roomname = request.getParameter("roomname");
		// ҵ���߼���ͨ�����ƺŲ��һ������Ƿ����
		MeetingRoomService msr = new MeetingRoomService();
		try {
			MeetingRoom mr=msr.findByMeetingRoomName(roomname);
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			if(mr!=null){//������ڣ�����Fail��ҳ��
				out.print("fail");
			}else{//��������ڣ�����Success��ҳ��
				out.print("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
