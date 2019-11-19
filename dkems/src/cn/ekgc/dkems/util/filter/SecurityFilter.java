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
		// ����ת��
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// ����û���uri��ַ
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		// ��URI�����ж��Ƿ���list֮��
		if (uriList.contains(uri)) {
			// �ж��û��Ƿ��Ѿ���¼
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				// ˵���û�δ��¼��������ص�¼���棬��������
				chain.doFilter(request, response);
				return;
			} else {
				// ˵���û��Ѿ���¼�ˣ�ҳ���ض�����ҳ��
				response.sendRedirect(request.getContextPath() + "/user/index.do");
				return;
			}
		} else {
			// �û���ʱ�������ǵ�¼������¼��������Ҫ��֤�û��Ƿ��ѵ�¼
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				// ˵���û���¼����������
				chain.doFilter(request, response);
				return;
			} else {
				// ˵���û�δ��¼��ҳ���ض�����ҳ��
				response.sendRedirect(request.getContextPath() + "/user/loginForm.do");
				return;
			}
		}
		
	}

}
