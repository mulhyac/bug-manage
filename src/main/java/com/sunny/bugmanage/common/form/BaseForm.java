package com.sunny.bugmanage.common.form;

import java.io.Serializable;

/**
 * @author sunny
 * @date 2017-03-31 17:01
 * @description 基础form
 */
public class BaseForm<T extends Serializable> implements Serializable {
	/**
	 * 每页显示多少
	 */
	private Integer pageSize;
	/**
	 * 当前第几页
	 */
	private Integer pageNum;
	/**
	 * 模糊查询使用的key
	 */
	private String key;
	/**
	 * 主键id
	 */
	private T id;

	public Integer getPageSize() {
		if (this.pageSize <= 0) {
			this.pageSize = 10;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		if (this.pageNum <= 0) {
			this.pageNum = 1;
		}
		return (pageNum - 1) * this.pageSize;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
