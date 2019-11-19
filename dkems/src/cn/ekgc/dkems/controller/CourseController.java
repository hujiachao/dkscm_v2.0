package cn.ekgc.dkems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.service.CourseService;
import cn.ekgc.dkems.service.impl.CourseServiceImpl;
import cn.ekgc.dkems.util.DispatcherUtil;

public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if ("/list".equals(uri)) {
			String pageNum = request.getParameter("num");
			String pageSize = request.getParameter("size");	
			Page<Course> page = new Page<Course>(pageNum, pageSize);
			page = courseService.getCourseByPage(page);
			request.setAttribute("page", page);
			DispatcherUtil.getRequestDispatcher("course/list", request).forward(request, response);	
		} else if ("/addForm".equals(uri)) {
			DispatcherUtil.getRequestDispatcher("course/add_form", request).forward(request, response);
		} else if ("/add".equals(uri)) {
			String courseName = request.getParameter("courseName");
			if (courseName != null && !"".equals(courseName)) {
				Course course = new Course();
				course.setCourseName(courseName);
				boolean flag = courseService.SaveCourse(course);
				response.getWriter().write(JSON.toJSONString(flag));
				return;
			}
			response.getWriter().write(JSON.toJSONString(false));
			return;
		} else if ("/detialData".equals(uri)) {
			Long courseId = Long.parseLong(request.getParameter("courseId"));
			Course course = courseService.getCourseById(courseId);
			request.setAttribute("course", course);
			DispatcherUtil.getRequestDispatcher("course/detial", request).forward(request, response);
		} else if ("/updateForm".equals(uri)) {
			Long courseId = Long.parseLong(request.getParameter("courseId"));
			Course course = courseService.getCourseById(courseId);
			if (course != null) {
				request.setAttribute("course", course);
				DispatcherUtil.getRequestDispatcher("course/update_form", request).forward(request, response);
			}
		} else if ("/update".equals(uri)) {
			Long courseId = Long.parseLong(request.getParameter("courseId"));
			String courseName = request.getParameter("courseName");
			String courseCode = request.getParameter("courseCode");
			Integer sortOrder = Integer.parseInt(request.getParameter("sortOrder"));
			Course course = new Course();
			course.setCourseId(courseId);
			course.setCourseName(courseName);
   			course.setCourseCode(courseCode);
			course.setSortOrder(sortOrder);
			boolean flag = courseService.updateBaseData(course);
			response.getWriter().write(JSON.toJSONString(flag));
			return;
		} else if ("/delete".equals(uri)) {				
			Long courseId = Long.parseLong(request.getParameter("courseId"));
			courseService.deleteData(courseId);
			response.sendRedirect(request.getContextPath() + "/course/list.do");
		}
	}
}
