package cn.ekgc.dkems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.entity.Role;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.service.CourseService;
import cn.ekgc.dkems.service.UserService;
import cn.ekgc.dkems.service.impl.CourseServiceImpl;
import cn.ekgc.dkems.service.impl.UserServiceImpl;
import cn.ekgc.dkems.util.ConstantUtil;
import cn.ekgc.dkems.util.DispatcherUtil;
import cn.ekgc.dkems.util.MD5Util;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private CourseService courseService = new CourseServiceImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 获得uri地址
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		// 分发请求
		if ("/loginForm".equals(uri)) {
			// 加载登录界面
			DispatcherUtil.getRequestDispatcher("user/login_form", request).forward(request, response);
		} else if ("/login".equals(uri)) {
			// 获得用户的数据
			String cellphone = request.getParameter("cellphone");
			String password = request.getParameter("password");
			if (cellphone != null && !"".equals(cellphone.trim()) && 
					password != null && !"".equals(password.trim())) {
				password = MD5Util.encrypt(password);
				User user = userService.loginUser(cellphone, password);
				if (user != null && (ConstantUtil.STATUS_ENABLE).equals(user.getStatus())) {
					request.getSession().setAttribute("user", user);
					response.sendRedirect(request.getContextPath() + "/user/index.do");
					return;
				}
			}
			response.sendRedirect(request.getContextPath() + "/user/loginForm.do");
		} else if ("/index".equals(uri)) {
			DispatcherUtil.getRequestDispatcher("index", request).forward(request, response);
		} else if ("/logout".equals(uri)) {
			request.getSession().setAttribute("user", null);
			response.sendRedirect(request.getContextPath() + "/user/index.do");
		} else if ("/selectForm".equals(uri)) {
			User user = (User) request.getSession().getAttribute("user");
			List<Object> nullList = new ArrayList<Object>();
			List<Course> courseList = courseService.getAllCourse(user.getUserId());
			nullList.add(user.getUserId());
			nullList.add(courseList);
			request.setAttribute("nullList", nullList);
			DispatcherUtil.getRequestDispatcher("course/select", request).forward(request, response);
		} else if ("/select".equals(uri)) {
			String ids = request.getParameter("ids");
			User user = (User) request.getSession().getAttribute("user");
			if (ids != null && !"".equals(ids)) {
				String[] idArray = ids.split("-");
				userService.deleteCourse(user.getUserId());
				if (idArray != null && idArray.length > 0) {
					for (String id : idArray) {
						userService.selectCourse(user.getUserId(), Long.parseLong(id));
					}
					response.getWriter().write(JSON.toJSONString("true"));
					return;
				}
			}
			response.getWriter().write(JSON.toJSONString("false"));
			return;
		} else if ("/personalData".equals(uri)) {
			Long userId = Long.parseLong(request.getParameter("userId"));
			User user = userService.getUserByUserId(userId);
			List<Course> courseList = userService.getCourseByUserId(user.getUserId());
			List<Object> list = new ArrayList<Object>();
			list.add(user);
			list.add(courseList);
			request.setAttribute("list", list);
			DispatcherUtil.getRequestDispatcher("user/personal_data", request).forward(request, response);
		} else if ("/updateForm".equals(uri)) {	
			Long userId = Long.parseLong(request.getParameter("userId"));
			User user = userService.getUserByUserId(userId);
			request.setAttribute("user", user);
			DispatcherUtil.getRequestDispatcher("user/update_form", request).forward(request, response);
		} else if ("/update".equals(uri)) {
			Long userId = Long.parseLong(request.getParameter("userId"));
			String username = request.getParameter("username");
			String cellphone = request.getParameter("cellphone");
			String idCard = request.getParameter("idCard");
			String email = request.getParameter("email");
			String photo = request.getParameter("photo");
			String status = request.getParameter("status");
			User user = new User();
			user.setUserId(userId);
			user.setUsername(username);
			user.setCellphone(cellphone);
			user.setIdCard(idCard);
			user.setEmail(email);
			user.setPhoto(photo);
			user.setStatus(status);
			boolean flag = userService.updateBaseData(user);
			response.getWriter().write(JSON.toJSONString(flag));
			return;
		} else if ("/list".equals(uri)) {
			String pageNum = request.getParameter("num");
			String pageSize = request.getParameter("size");
			Page<User> page = new Page<User>(pageNum, pageSize);
			page = userService.getUserByPage(page);
			request.setAttribute("page", page);
			DispatcherUtil.getRequestDispatcher("user/list", request).forward(request, response);
		} else if ("/delete".equals(uri)) {	
			Long userId = Long.parseLong(request.getParameter("userId"));
			userService.deleteData(userId);
			response.sendRedirect(request.getContextPath() + "/user/list.do");
		} else if ("/updateFormStu".equals(uri)) {
			Long userId = Long.parseLong(request.getParameter("userId"));
			User user = userService.getUserByUserId(userId);
			request.setAttribute("user", user);
			DispatcherUtil.getRequestDispatcher("user/updateStu_form", request).forward(request, response);
		} 
	}
}
