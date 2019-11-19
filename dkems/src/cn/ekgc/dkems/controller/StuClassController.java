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
import cn.ekgc.dkems.service.StuClassService;
import cn.ekgc.dkems.service.impl.StuClassServiceImpl;
import cn.ekgc.dkems.util.ConstantUtil;
import cn.ekgc.dkems.util.DispatcherUtil;

public class StuClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StuClassService scs = new StuClassServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if ("/list".equals(uri)) {
			String pageNum = request.getParameter("num");
			String pageSize = request.getParameter("size");	
			Page<StuClass> page = new Page<StuClass>(pageNum, pageSize);
			page = scs.getStuClassByPage(page);
			request.setAttribute("page", page);
			DispatcherUtil.getRequestDispatcher("stuClass/list", request).forward(request, response);	
		} else if ("/addForm".equals(uri)) {
			DispatcherUtil.getRequestDispatcher("stuClass/add_form", request).forward(request, response);
		} else if ("/add".equals(uri)) {
			String stuClassNo = request.getParameter("stuClassNo");
			String sortOrder = request.getParameter("sortOrder");
			if (stuClassNo != null && !"".equals(stuClassNo) && 
					sortOrder != null && !"".equals(sortOrder)) {
				StuClass stuClass = new StuClass();
				stuClass.setStuClassNo(stuClassNo);
				stuClass.setSortOrder(Integer.parseInt(sortOrder));
				boolean flag = scs.SaveStuClass(stuClass);
				response.getWriter().write(JSON.toJSONString(flag));
				return;
			}
			response.getWriter().write(JSON.toJSONString(false));
			return;
		} else if ("/detialData".equals(uri)) {
			Long stuClassId = Long.parseLong(request.getParameter("stuClassId"));
			StuClass stuClass = scs.getStuClassById(stuClassId);
			request.setAttribute("stuClass", stuClass);
			DispatcherUtil.getRequestDispatcher("stuClass/detial", request).forward(request, response);
		} else if ("/updateForm".equals(uri)) {
			 Long stuClassId = Long.parseLong(request.getParameter("stuClassId"));
			 StuClass stuClass = scs.getStuClassById(stuClassId);
			 if (stuClass != null) {
				request.setAttribute("stuClass", stuClass);
				DispatcherUtil.getRequestDispatcher("stuClass/update_form", request).forward(request, response);
			}
		} else if ("/update".equals(uri)) {
			Long stuClassId = Long.parseLong(request.getParameter("stuClassId"));
			String stuClassNo = request.getParameter("stuClassNo");
			String sortOrder = request.getParameter("sortOrder");
			StuClass stuClass = new StuClass();
			stuClass.setStuClassId(stuClassId);
			stuClass.setStuClassNo(stuClassNo);
			stuClass.setSortOrder(Integer.parseInt(sortOrder));
			boolean flag = scs.updateBaseData(stuClass);
			response.getWriter().write(JSON.toJSONString(flag));
			return;
		} else if ("/delete".equals(uri)) {				
			Long stuClassId = Long.parseLong(request.getParameter("stuClassId"));
			scs.deleteData(stuClassId);
			response.sendRedirect(request.getContextPath() + "/stuClass/list.do");
		}
	}
}
