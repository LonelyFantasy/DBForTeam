package com.main.model;
/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月10日 下午3:41:14
 * 类说明
 */
public class SystemAdmin {

	private String id;
	private String name;
	private String phone_number;
	private String password;

	public SystemAdmin(String name, String password) {//登录初始化方法
		this.name = name;
		this.password = password;
	}

	public SystemAdmin(String id,String name, String phone_number, String password) {//账户信息初始化方法
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
