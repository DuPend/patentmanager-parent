package com.patentmanager.entity;

import java.io.Serializable;

/**
 * @Description  返回结果封装类
 * @author:  dupeng
 * @date: 2019年11月20日 15:15:24
 * @version: V1.0
 */
public class Result implements Serializable{
	
	private boolean success;
	private String message;
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
