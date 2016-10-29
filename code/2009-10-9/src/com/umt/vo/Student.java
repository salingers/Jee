package com.umt.vo;

public class Student {

	private int num;
	
	private String stuName;
	
	private String age;
	
	private Dept dept;
	

	public Student(int num, String stuName, String age, Dept dept) {
		super();
		this.num = num;
		this.stuName = stuName;
		this.age = age;
		this.dept = dept;
	}



	public Dept getDept() {
		return dept;
	}



	public void setDept(Dept dept) {
		this.dept = dept;
	}



	public Student() {
		super();
	}



	public Student(int num, String stuName, String age) {
		super();
		this.num = num;
		this.stuName = stuName;
		this.age = age;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getStuName() {
		return stuName;
	}



	public void setStuName(String stuName) {
		this.stuName = stuName;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
}
