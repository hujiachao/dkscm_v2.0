package cn.ekgc.dkems.pojo.vo;

import java.io.Serializable;
import java.util.List;

import cn.ekgc.dkems.util.ConstantUtil;

public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<E> list;
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalCount;
	private Integer totalPage;
	
	public Page() {};
	public Page(String num, String size) {
		if (num != null && !"".equals(num.trim())) {
			this.pageNum = Integer.parseInt(num);
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		if (size != null && !"".equals(size.trim())) {
			this.pageSize = Integer.parseInt(size);
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
