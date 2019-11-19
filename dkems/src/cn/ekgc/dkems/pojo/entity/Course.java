package cn.ekgc.dkems.pojo.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long courseId;
	private String courseName;
	private String courseCode;
	private Integer sortOrder;
	private Date createTime;
	private Date updateTime;
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public static List<Course> parseToList(ResultSet resultSet) {
		List<Course> courseList = new ArrayList<Course>();
		try {
			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getLong("course_id"));
				course.setCourseName(resultSet.getString("course_name"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setSortOrder(resultSet.getInt("sort_order"));
				course.setCreateTime(resultSet.getDate("create_time"));
				courseList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}
}
