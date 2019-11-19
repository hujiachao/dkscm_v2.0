package cn.ekgc.dkems.service;

import java.util.List;

import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.vo.Page;

public interface CourseService {
	Page<Course> getCourseByPage(Page<Course> page);

	boolean SaveCourse(Course course);

	List<Course> getAllCourse(Long userId);

	Course getCourseById(Long courseId);

	void deleteData(Long courseId);

	boolean updateBaseData(Course course);
}
