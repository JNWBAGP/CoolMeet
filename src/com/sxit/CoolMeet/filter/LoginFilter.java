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
 * 登录过滤器
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
		//通过获取session中的对象判断是否登录
		HttpServletRequest hsr=(HttpServletRequest) request;
		Staff staff=(Staff) hsr.getSession().getAttribute("staff");
		if(staff!=null){//判断对象是否为空，如果不为空，说明已登录，继续执行
			chain.doFilter(request, response);
		}else{
			request.setAttribute("msg", "该资源登录需要登录后才可访问");
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
