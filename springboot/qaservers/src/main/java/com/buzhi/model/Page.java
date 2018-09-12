package com.buzhi.model;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public class Page extends Pageable{
	/**每页记录数**/
	private int pageSize;
	/**当前页**/
	private int num;
	/**总页数**/
	private int total;
	/**当前返回数**/
	private int size;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	

}
