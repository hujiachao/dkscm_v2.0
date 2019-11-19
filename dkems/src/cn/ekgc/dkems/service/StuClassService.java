package cn.ekgc.dkems.service;


import cn.ekgc.dkems.pojo.entity.StuClass;
import cn.ekgc.dkems.pojo.vo.Page;

public interface StuClassService {

	Page<StuClass> getStuClassByPage(Page<StuClass> page);

	boolean SaveStuClass(StuClass stuClass);

	StuClass getStuClassById(Long stuClassId);

	boolean updateBaseData(StuClass stuClass);

	void deleteData(Long stuClassId);

}
