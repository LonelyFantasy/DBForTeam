package com.main.model;
/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月17日 上午10:57:09
* 类说明
*/
public class Student {

	private String id;
	private String name;
	private int age;
	private String grade;
	private String classId;
	private String className;
	private String sex;
	private String major;
	private String secondary;
	
	public Student() {
		
	}
	
	//构造方法
	public Student(String id, String name, int age, String grade, String classId, String className, String sex,
			String major, String secondary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classId = classId;
		this.className = className;
		this.sex = sex;
		this.major = major;
		this.secondary = secondary;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	
	
	
}
