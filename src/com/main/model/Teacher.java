package com.main.model;
/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月19日 下午12:57:53
* 类说明
*/
public class Teacher {
	private int id;
	private String name;
	private String password;
	private String classid;

	public Teacher() {

	}

	public Teacher(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Teacher(int id, String name, String password, String classid) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.classid = classid;

	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
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
