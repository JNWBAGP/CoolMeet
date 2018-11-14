package com.sxit.CoolMeet.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sxit.CoolMeet.Entity.Department;
import com.sxit.CoolMeet.Entity.MeetingRoom;
import com.sxit.CoolMeet.Service.DepartmentService;
import com.sxit.CoolMeet.Service.MeetingRoomService;

/**
 * Ԥ������׼��
 * @author Administrator
 *
 */
public class BookMeetingJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMeetingJspServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService ds=new DepartmentService();
		MeetingRoomService mrs=new MeetingRoomService();
		try {
			//ҵ���߼�����ȡ��������״̬�µĻ�����
			List<MeetingRoom> meetingroom=mrs.searchMeetingRoomsByStatus("0");
			//ҵ���߼�����ȡ���в���
			List<Department> department=ds.selectAlldep();
			//����ѯ���������������
			request.setAttribute("meetingroom", meetingroom);
			request.setAttribute("department", department);
			//��ת��Ԥ������ҳ��
			request.getRequestDispatcher("pages/bookmeeting.jsp").forward(request, response);
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
