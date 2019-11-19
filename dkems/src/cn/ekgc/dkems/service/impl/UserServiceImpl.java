package cn.ekgc.dkems.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.ekgc.dkems.dao.UserDao;
import cn.ekgc.dkems.dao.impl.UserDaoImpl;
import cn.ekgc.dkems.pojo.entity.Course;
import cn.ekgc.dkems.pojo.entity.Role;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	public User loginUser(String cellphone, String password) {
		List<Object> list = Arrays.asList(cellphone, password);
		String sql = "select "
				+ "su.user_id, su.username, su.cellphone, su.password, su.status, sr.role_id, "
				+ "sr.role_name, ssc.stu_class_no from sys_user su join sys_role sr on "
				+ "su.role_id=sr.role_id JOIN sys_stu_class ssc ON ssc.stu_class_id=su.stu_class_id "
				+ "where su.cellphone=? and su.password=?";
		ResultSet resultSet = userDao.findList(sql, list);
		List<User> userList = User.parseToList(resultSet);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	
	public void deleteCourse(Long userId) {
		String sql = "delete from sys_user_course where user_id=?";
		List<Object> list = Arrays.asList(userId);
		userDao.executeUpdate(sql, list);
	}


	public void selectCourse(Long userId, Long courseId) {
		String sql = "insert into sys_user_course (user_id, course_id) values(?, ?)";
		List<Object> list = Arrays.asList(userId, courseId);
		userDao.executeUpdate(sql, list);
	}

	public User getUserByUserId(Long userId) {
		String sql =  "SELECT"
				+ " su.user_id, su.username, su.cellphone, su.email, su.photo, sr.role_id, sr.role_name, "
				+ "ssc.stu_class_no, su.id_card, su.status FROM sys_user su JOIN sys_role sr ON "
				+ "su.role_id=sr.role_id JOIN sys_stu_class ssc ON ssc.stu_class_id=su.stu_class_id "
				+ "WHERE su.user_id=?";
		List<Object> list = Arrays.asList(userId);
		ResultSet resultSet = userDao.findList(sql, list);
		User user = new User();
		try {
			if (resultSet.next()) {
				user.setUserId(resultSet.getLong("user_id"));
				user.setUsername(resultSet.getString("username"));
				user.setCellphone(resultSet.getString("cellphone"));
				user.setStatus(resultSet.getString("status"));
				user.setIdCard(resultSet.getString("id_card"));
				user.setEmail(resultSet.getString("email"));
				user.setPhoto(resultSet.getString("photo"));
				Role role = new Role();
				role.setRoleId(resultSet.getLong("role_id"));
				role.setRoleName(resultSet.getString("role_name"));
				user.setRole(role);
				StuClass stuClass = new StuClass();
				stuClass.setStuClassNo(resultSet.getString("stu_class_no"));
				user.setStuClass(stuClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Course> getCourseByUserId(Long userId) {
		String sql = "SELECT * FROM sys_user_course suc JOIN sys_course sc ON suc.course_id=sc.course_id WHERE suc.user_id=?";
		List<Object> list = Arrays.asList(userId);
		ResultSet resultSet = userDao.findList(sql, list);
		List<Course> courseList = new ArrayList<Course>();
		try {
			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getLong("course_id"));
				course.setCourseName(resultSet.getString("course_name"));
				course.setCourseCode(resultSet.getString("course_code"));
				courseList.add(course);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	public boolean updateBaseData(User user) {
		String sql = "update sys_user set username=?, cellphone=?, id_card=?, email=?, photo=?, "
				+ "status=? where user_id=?";
		Long userId = user.getUserId();
		String username = user.getUsername();
		String cellphone = user.getCellphone();
		String idCard = user.getIdCard();
		String email = user.getEmail();
		String photo = user.getPhoto();
		String status = user.getStatus();
		List<Object> list = Arrays.asList(username, cellphone, idCard, email, photo, status, userId);
		return userDao.executeUpdate(sql, list);
	}

	public Page<User> getUserByPage(Page<User> page) {
		String sql = "SELECT su.user_id, su.username, su.cellphone, su.password, su.email,"
				+ " su.id_card, su.photo, su.status, sr.role_id, sr.role_name, sr.role_code,"
				+ " ssc.stu_class_no FROM sys_user su JOIN sys_role sr ON su.role_id=sr.role_id"
				+ " JOIN sys_stu_class ssc ON su.stu_class_id=ssc.stu_class_id WHERE su.role_id=2";
		ResultSet resultSet = userDao.findListByPage(sql, page);
		List<User> list = User.parseToList(resultSet);
		Integer totalCount = User.parseToList(userDao.findList(sql, null)).size();
		Integer totalPage = (totalCount % page.getPageSize() == 0) ? 
				(totalCount / page.getPageSize()) : (totalCount / page.getPageSize()) + 1;
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		return page;
	}

	public void deleteData(Long userId) {
		String sql = "delete from sys_user where user_id=?";
		List<Object> list = Arrays.asList(userId);
		userDao.executeUpdate(sql, list);
	}

}
