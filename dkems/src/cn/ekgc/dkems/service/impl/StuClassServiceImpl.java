package cn.ekgc.dkems.service.impl;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import cn.ekgc.dkems.dao.StuClassDao;
import cn.ekgc.dkems.dao.impl.StuClassDaoImpl;
import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.vo.Page;
import cn.ekgc.dkems.service.StuClassService;

public class StuClassServiceImpl implements StuClassService {
	private StuClassDao scd = new StuClassDaoImpl();
	public Page<StuClass> getStuClassByPage(Page<StuClass> page) {
		String sql = "select * from sys_stu_class";
		ResultSet resultSet = scd.findListByPage(sql, page);
		List<StuClass> list = StuClass.parseToList(resultSet);
		Integer totalCount = StuClass.parseToList(scd.findList(sql, null)).size();
		Integer totalPage = (totalCount % page.getPageSize() ==0) ? 
				(totalCount / page.getPageSize()) : (totalCount / page.getPageSize()) + 1;
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		return page;
	}
	
	public boolean SaveStuClass(StuClass stuClass) {
		List<Object> list = Arrays.asList(stuClass.getStuClassNo(), stuClass.getSortOrder());
		String sql = "insert into sys_stu_class(stu_class_no, sort_order) values(?, ?)";
		return scd.executeUpdate(sql, list);
	}

	public StuClass getStuClassById(Long stuClassId) {
		String sql = "select * from sys_stu_class where stu_class_id=?";
		ResultSet resultSet = scd.findListById(sql, stuClassId);
		try {
			if (resultSet.next()) {
				StuClass stuClass = new StuClass();
				stuClass.setStuClassId(resultSet.getLong("stu_class_id"));
				stuClass.setStuClassNo(resultSet.getString("stu_class_no"));
				stuClass.setSortOrder(resultSet.getInt("sort_order"));
				stuClass.setCreateTime(resultSet.getDate("create_time"));
				return stuClass;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	public boolean updateBaseData(StuClass stuClass) {
		String sql = "update sys_stu_class set stu_class_no=?, sort_order=? where stu_class_id=?";
		String stuClassNo = stuClass.getStuClassNo();
		Integer sortOrder = stuClass.getSortOrder();
		Long stuClassId = stuClass.getStuClassId();
		List<Object> list = Arrays.asList(stuClassNo, sortOrder, stuClassId);
		return scd.executeUpdate(sql, list);
	}

	public void deleteData(Long stuClassId) {
		String sql = "delete from sys_stu_class where stu_class_id=?";
		List<Object> list = Arrays.asList(stuClassId);
		scd.executeUpdate(sql, list);
		
	}

}
