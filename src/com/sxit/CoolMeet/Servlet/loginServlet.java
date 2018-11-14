package com.sxit.CoolMeet.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxit.CoolMeet.Entity.Staff;
import com.sxit.CoolMeet.Service.StaffService;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		//1.���ñ��뷽ʽ
		request.setCharacterEncoding("utf-8");
		//2.��ȡ����¼���洫�������û���������
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		//3.ҵ���߼���ͨ���û�����������֤�û��Ƿ����
		StaffService service=new StaffService();
		try {
			Staff staff=service.login(username, pwd);
			if(staff!=null){//4.������ڣ�����Ҫ���û�״̬
				String status=staff.getStatus(); 
				if(status.equals("0")){//4-0 ����������¼ʧ��
					//��������
					request.setAttribute("msg", "���û���������������ͨ�������е�¼");
					//����ת��
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if (status.equals("1")) {//4-1����ͨ������½�ɹ�����Ҫ�ж��û���ɫ
					String roles=staff.getRole();
					if (roles.equals("1")) {//4-1-1��ɫΪ����Ա����ת������Ա����
						//request.setAttribute("username", username);
						//���û��ύ����Ϣ���浽Session��
						HttpSession session=request.getSession();
						session.setAttribute("staff",staff);
						//����ת��
						request.getRequestDispatcher("pages/admin_index.jsp").forward(request, response);
					}else if (roles.equals("2")) {//4-1-2��ɫΪ��ͨ�û�����ת���û�����
						//���û��ύ����Ϣ���浽Session��
						HttpSession session=request.getSession();
						session.setAttribute("staff",staff);
						//����ת��
						request.getRequestDispatcher("pages/staff_index.jsp").forward(request, response);
					}
				}else if (status.equals("2")) {//4-2�������ܾ�����¼ʧ��
					//��������
					request.setAttribute("msg", "�Բ��������������ܾ�");
					//����ת��
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if (status.equals("3")) {//4-3�û������ã���¼ʧ��
					//��������
					request.setAttribute("msg", "�Բ��������˻��ѱ�����");
					//����ת��
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}			
			}else{//��������ڣ��û���������������󣬷��ص�¼����	
				//��������
				request.setAttribute("msg", "�û����������������");
				//����ת��
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//��ת������ҳ�棬��ʾ�û�
			request.setAttribute("msg","�����������ϵ����Ա");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
