package com.patentmanager.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description  分页分装类
 * @author:  dupeng
 * @date: 2019年11月20日 15:15:24
 * @version: V1.0
 */

public class PageResult implements Serializable{
	private long total;
	private List rows;
	
	
	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
}
