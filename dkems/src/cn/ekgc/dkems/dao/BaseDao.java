package cn.ekgc.dkems.dao;

import java.sql.ResultSet;
import java.util.List;

import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;

public interface BaseDao<E> {
	ResultSet findList(String sql, List<Object> List);
	ResultSet findListByPage(String sql, Page<E> page);
	boolean executeUpdate(String sql, List<Object> List);
	ResultSet findListByRoleId(String sql, Page<User> page);
	ResultSet findListById(String sql, Long stuClassId);
}
