package cn.ekgc.dkems.service.impl;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import cn.ekgc.dkems.dao.CourseDao;
import cn.ekgc.dkems.dao.impl.CourseDaoImpl;
import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();
	public Page<Course> getCourseByPage(Page<Course> page) {
		String sql = "select * from sys_course";
		ResultSet resultSet = courseDao.findListByPage(sql, page);
		List<Course> list = Course.parseToList(resultSet);
		Integer totalCount = Course.parseToList(courseDao.findList(sql, null)).size();
		Integer totalPage = (totalCount % page.getPageSize() ==0) ? 
				(totalCount / page.getPageSize()) : (totalCount / page.getPageSize()) + 1;
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		return page;
	}
	
	public boolean SaveCourse(Course course) {
		List<Object> list = Arrays.asList(course.getCourseName());
		String sql = "insert into sys_course(course_name) values(?)";
		return courseDao.executeUpdate(sql, list);
	}

	
	public List<Course> getAllCourse(Long userId) {
		String sql = "select * from sys_course";
		ResultSet resultSet = courseDao.findList(sql, null);
		List<Course> courseList = Course.parseToList(resultSet);
		return courseList;
	}

	public Course getCourseById(Long courseId) {
		String sql = "select * from sys_course where course_id=?";
		ResultSet resultSet = courseDao.findListById(sql, courseId);
		try {
			if (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getLong("course_id"));
				course.setCourseName(resultSet.getString("course_name"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setSortOrder(resultSet.getInt("sort_order"));
				course.setCreateTime(resultSet.getDate("create_time"));
				return course;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateBaseData(Course course) {
		String sql = "update sys_course set course_name=?, course_code=?, sort_order=? where course_id=?";
		List<Object> list = Arrays.asList(course.getCourseName(), course.getCourseCode(), course.getSortOrder(), course.getCourseId());
		return courseDao.executeUpdate(sql, list);
	}

	public void deleteData(Long course_id) {
		String sql = "delete from sys_course where course_id=?";
		List<Object> list = Arrays.asList(course_id);
		courseDao.executeUpdate(sql, list);
		
	}
}
