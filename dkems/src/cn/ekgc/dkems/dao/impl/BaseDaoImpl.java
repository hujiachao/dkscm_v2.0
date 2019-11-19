package cn.ekgc.dkems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.ekgc.dkems.dao.BaseDao;
import cn.ekgc.dkems.pojo.entity.User;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.util.ConnectionUtil;


public class BaseDaoImpl<E> implements BaseDao<E> {
	private Connection connection = ConnectionUtil.getConnection();
	public ResultSet findList(String sql, List<Object> list) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					statement.setObject(i + 1, list.get(i));
				}
			}
			ResultSet resultSet = statement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet findListByPage(String sql, Page<E> page) {
		try {
			sql = sql + " limit ?, ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (page.getPageNum() -1) * page.getPageSize());
			statement.setInt(2, page.getPageSize());
			return statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean executeUpdate(String sql, List<Object> list) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				statement.setObject(i + 1, list.get(i));
			}
			int count = statement.executeUpdate();
			if (count > 0) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public ResultSet findListById(String sql, Long stuClassId) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, stuClassId);
			ResultSet resultSet = statement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet findListByRoleId(String sql, Page<User> page) {
		// TODO Auto-generated method stub
		return null;
	}



}
