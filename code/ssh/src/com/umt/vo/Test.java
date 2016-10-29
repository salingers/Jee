package com.umt.vo;

/**
 * Test entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String pwd;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** minimal constructor */
	public Test(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Test(Long id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}