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
 * �첽��֤���ƺ��Ƿ�Ϊһ
 * 
 * @author Administrator
 * 
 */
public class AjaxCheckRoomNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxCheckRoomNumServlet() {
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
		// ��ȡҳ�洫���������ƺ�
		String roomnum = request.getParameter("roomnum");
		// ҵ���߼���ͨ�����ƺŲ��һ������Ƿ����
		MeetingRoomService msr = new MeetingRoomService();
		try {
			MeetingRoom mr=msr.findByMeetingRoomNum(Integer.parseInt(roomnum));
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
