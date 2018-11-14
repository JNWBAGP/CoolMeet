package com.sxit.CoolMeet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sxit.CoolMeet.Entity.Staff;

/**
 * ��¼������
 * 
 * @author zhaochenjiang
 *
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ͨ����ȡsession�еĶ����ж��Ƿ��¼
		HttpServletRequest hsr=(HttpServletRequest) request;
		Staff staff=(Staff) hsr.getSession().getAttribute("staff");
		if(staff!=null){//�ж϶����Ƿ�Ϊ�գ������Ϊ�գ�˵���ѵ�¼������ִ��
			chain.doFilter(request, response);
		}else{
			request.setAttribute("msg", "����Դ��¼��Ҫ��¼��ſɷ���");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
