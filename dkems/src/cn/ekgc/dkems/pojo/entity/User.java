package cn.ekgc.dkems.pojo.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String cellphone;
	private String password;
	private Role role;
	private StuClass stuClass;
	private String email;
	private String idCard;
	private String photo;
	private String status;
	private Integer sortOrder;
	private Date createTime;
	private Date updateTime;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public StuClass getStuClass() {
		return stuClass;
	}
	public void setStuClass(StuClass stuClass) {
		this.stuClass = stuClass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public static List<User> parseToList(ResultSet resultSet) {
		List<User> userList = new ArrayList<User>();
		try {
			
			while (resultSet.next()) {
				
				User user = new User();
				user.setUserId(resultSet.getLong("user_id"));
				user.setUsername(resultSet.getString("username"));
				user.setCellphone(resultSet.getString("cellphone"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getString("status"));
				Role role = new Role();
				role.setRoleId(resultSet.getLong("role_id"));
				role.setRoleName(resultSet.getString("role_name"));
				StuClass stuClass = new StuClass();
				stuClass.setStuClassNo(resultSet.getString("stu_class_no"));
				user.setStuClass(stuClass);
				user.setRole(role);
				userList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
}
