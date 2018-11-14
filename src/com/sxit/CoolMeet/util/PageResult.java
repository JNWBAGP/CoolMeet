package com.sxit.CoolMeet.util;

import java.util.List;

public class PageResult<T> {
	private int totalCount;//��������
	private int totalPage;//������ҳ
	private int currentPage;//��ǰ����ҳ
	private List<T> pageList;//��ҳ�б�

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	
}
