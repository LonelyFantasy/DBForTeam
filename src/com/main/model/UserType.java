package com.main.model;
/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月10日 下午1:40:29
* 类说明 456
*/
public enum UserType {
	
	SYSTEM_ADMIN("超级管理员",0),
	BUYER("采购员", 1),
	MANAGER("仓库管理员", 2);
	
	private String name;
	private int index;
	
	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public String toString() {
		return name;
	}
	
}
