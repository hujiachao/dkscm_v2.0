package cn.ekgc.dkems.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ekgc.dkems.pojo.entity.User;

public class SecurityFilter implements Filter {
	
	private List<String> uriList = new ArrayList<String>();
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		uriList.add("/loginForm");
		uriList.add("/login");
	}
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain chain) throws IOException, ServletException {
		// 类型转换
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 获得用户的uri地址
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		// 对URI进行判断是否在list之中
		if (uriList.contains(uri)) {
			// 判读用户是否已经登录
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				// 说明用户未登录，请求加载登录界面，放行请求
				chain.doFilter(request, response);
				return;
			} else {
				// 说明用户已经登录了，页面重定向到首页面
				response.sendRedirect(request.getContextPath() + "/user/index.do");
				return;
			}
		} else {
			// 用户此时的请求不是登录界面或登录请求，则需要验证用户是否已登录
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				// 说明用户登录，放行请求
				chain.doFilter(request, response);
				return;
			} else {
				// 说明用户未登录，页面重定向到首页面
				response.sendRedirect(request.getContextPath() + "/user/loginForm.do");
				return;
			}
		}
		
	}

}
