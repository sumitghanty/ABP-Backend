package com.mazars.in.model.intermediatemodel;

import java.util.List;

public class UserInfo {
	private int id;
	private String value;
	private Boolean flag;
	private List<UserDetailsInfo> data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<UserDetailsInfo> getData() {
		return data;
	}
	public void setData(List<UserDetailsInfo> data) {
		this.data = data;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
}
