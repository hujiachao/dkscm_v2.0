package cn.ekgc.dkems.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class DispatcherUtil {

	public static RequestDispatcher getRequestDispatcher(String view, HttpServletRequest request) {
		String dispatcher = ConstantUtil.VIEW_PREFIX + view + ConstantUtil.VIEW_SUFFIX;
		return request.getRequestDispatcher(dispatcher);
	}
	
}
