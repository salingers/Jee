package com.umt.vo;


/**
 * VO:value object
 * @author Administrator
 *
 */
public class User {

	private int id;
	
	private String name;
	
	private String pwd;
	
	private int empId;

	
	public User() {
		super();
	}

	public User(int id, String name, String pwd, int empId) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.empId = empId;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
}
