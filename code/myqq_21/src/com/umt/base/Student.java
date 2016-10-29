package com.umt.base;

import java.io.Serializable;

public class Student implements Serializable {

	private String name;
	private String sex;
	
	
	public Student() {
		super();
	}
	public Student(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String toString() {
		return this.name;
	}
	
	
	
	
	
}
