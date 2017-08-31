package cauc.edu.cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cauc.edu.cn.model.AFUserInfo;

/**
 * Servlet Filter implementation class IsLoginFilter
 */

public class IsLoginFilter implements Filter 
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 首先，该方法不是人为控制调用，而是tomcat自动调用
	 * 在每次请求之前，会先经过该方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		//将request、response强制类型转换成http ....
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//尝试从session中获取当前登录用户信息
		HttpSession session = httpServletRequest.getSession();
		AFUserInfo afuser =  (AFUserInfo) session.getAttribute("CURRENTLOGINUSER");
		//判断session中的用户是否为空
		
		//先获取本次请求的URL地址
		String requestURI = httpServletRequest.getRequestURI();		
		String requestPath = requestURI.substring(requestURI.lastIndexOf("/")+1, requestURI.length());
		
		if(afuser==null&&!requestPath.equals("Login.jsp")&&!requestPath.equals("LoginServlet"))
		{
			//未登录（应该使用请求重定向）
			
			//请求转发
			//特点：首先请求转发只允许跳转到本项目下的任意页面
			//在跳转时，会携带request和response对象（作用域）
//			httpServletRequest.getRequestDispatcher(arg0)
			
			//请求重定向
			//特点：请求重定向是操作浏览器的URL地址栏，允许跳转到本项目外的页面
			//在跳转时，不会携带request和response作用域
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/Login.jsp");
		}
		else
		{
			//已登录
			chain.doFilter(request, response);
		}
		
	}

}

