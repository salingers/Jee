package com.umt.work;

/*
 * VO:value object
 */

public class Student {
	
	private int stuId;
	
	private String stuName;
	
	private String sex;
	
	private double mark;

	public Student(int stuId, String stuName, String sex, double mark) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.sex = sex;
		this.mark = mark;
	}

	public Student() {
		super();
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
	public String toString(){
		return this.getStuId() + "-" + this.getStuName() + "-" + this.getSex() + "-" + this.getMark();
	}

	
	
	
	
}
