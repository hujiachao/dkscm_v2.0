package cn.ekgc.dkems.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String encoding;
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain chain) throws IOException, ServletException {
		// 类型转换
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 设置编码格式
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}

}
