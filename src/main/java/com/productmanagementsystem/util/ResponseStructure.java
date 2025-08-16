package com.productmanagementsystem.util;

import java.time.LocalDateTime;

public class ResponseStructure<T> {

	private int statusCode;
	private LocalDateTime locldatetime;
	private String msg;
	private T data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getLocldatetime() {
		return locldatetime;
	}
	public void setLocldatetime(LocalDateTime locldatetime) {
		this.locldatetime = locldatetime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
