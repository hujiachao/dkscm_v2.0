package cn.ekgc.dkems.pojo.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long stuClassId;
	private String stuClassNo;
	private Integer sortOrder;
	private Date createTime;
	private Date updateTime;
	
	public Long getStuClassId() {
		return stuClassId;
	}
	public void setStuClassId(Long stuClassId) {
		this.stuClassId = stuClassId;
	}
	public String getStuClassNo() {
		return stuClassNo;
	}
	public void setStuClassNo(String stuClassNo) {
		this.stuClassNo = stuClassNo;
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
	public static List<StuClass> parseToList(ResultSet resultSet) {
		List<StuClass> stuClassList = new ArrayList<StuClass>();
		try {
			while (resultSet.next()) {
				StuClass stuClass = new StuClass();
				stuClass.setStuClassId(resultSet.getLong("stu_class_id"));
				stuClass.setStuClassNo(resultSet.getString("stu_class_no"));
				stuClass.setSortOrder(resultSet.getInt("sort_order"));
				stuClass.setCreateTime(resultSet.getDate("create_time"));
				stuClassList.add(stuClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stuClassList;
	}
}
