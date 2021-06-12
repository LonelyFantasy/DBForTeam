package com.main.model;
/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月12日 下午9:42:14
 * 类说明
 */
public class SystemAdmin {

	private int id;
	private String name;
	private String password;

	public SystemAdmin() {

	}

	public SystemAdmin(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public SystemAdmin(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return name+" "+password;
	}

}
