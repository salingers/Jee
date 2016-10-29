package org.jsw.vo;

/**
 * Temp entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Temp implements java.io.Serializable {

	// Fields

	private Long id;
	private String uname;
	private String upwd;

	// Constructors

	/** default constructor */
	public Temp() {
	}

	/** minimal constructor */
	public Temp(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Temp(Long id, String uname, String upwd) {
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}