package cn.ekgc.dkems.service;

import java.util.List;

import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.entity.Role;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;

public interface UserService {

	User loginUser(String cellphone, String password);

	void deleteCourse(Long userId);

	void selectCourse(Long userId, Long parseLong);

	User getUserByUserId(Long userId);

	List<Course> getCourseByUserId(Long userId);

	boolean updateBaseData(User user);

	Page<User> getUserByPage(Page<User> page);

	void deleteData(Long userId);

	

}
