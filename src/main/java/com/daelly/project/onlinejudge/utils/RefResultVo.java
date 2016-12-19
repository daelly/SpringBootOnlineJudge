package com.daelly.project.onlinejudge.utils;

import java.io.Serializable;
import java.util.List;

public class RefResultVo implements Serializable {

	private static final long serialVersionUID = -8210784087727458549L;
	
	private String state = "1";
	
	private String msg = "Success";
	
	private Object result = null;
	
	private List<Object> jsonList = null;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<Object> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<Object> jsonList) {
		this.jsonList = jsonList;
	}
	
	public RefResultVo error(String msg) {
		this.setMsg(msg);
		this.setState("0");
		return this;
	}
	
	public RefResultVo result(Object result) {
		this.setResult(result);
		return this;
	}
	
	public RefResultVo list(List<Object> jsonList) {
		this.setJsonList(jsonList);
		return this;
	}
}
