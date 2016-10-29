package com.umt.vo;

/**
 * Dept entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Long id;
	private String deptname;
	private String other;

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String deptname, String other) {
		this.deptname = deptname;
		this.other = other;
	}
	
	

	// Property accessors

	public Dept(Long id, String deptname) {
		super();
		this.id = id;
		this.deptname = deptname;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}