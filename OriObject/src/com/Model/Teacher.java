package com.Model;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teaId;
	private Compcode compcode;
	private String password;
	private String phoneNum;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(Compcode compcode, String password, String phoneNum) {
		this.compcode = compcode;
		this.password = password;
		this.phoneNum = phoneNum;
	}

	// Property accessors

	public Integer getTeaId() {
		return this.teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public Compcode getCompcode() {
		return this.compcode;
	}

	public void setCompcode(Compcode compcode) {
		this.compcode = compcode;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}