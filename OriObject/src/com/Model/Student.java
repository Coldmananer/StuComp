package com.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String stuNum;
	private String stuName;
	private String password;
	private String class_;
	private String phoneNum;
	private String qq;
	private String email;
	private Integer compNum;
	private Integer passwordQue;
	private String answer;
	private Set stuTeams = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String stuNum, String stuName, String password, String class_, String phoneNum, String qq,
			String email, Integer compNum, Integer passwordQue, String answer, Set stuTeams) {
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.password = password;
		this.class_ = class_;
		this.phoneNum = phoneNum;
		this.qq = qq;
		this.email = email;
		this.compNum = compNum;
		this.passwordQue = passwordQue;
		this.answer = answer;
		this.stuTeams = stuTeams;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuNum() {
		return this.stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCompNum() {
		return this.compNum;
	}

	public void setCompNum(Integer compNum) {
		this.compNum = compNum;
	}

	public Integer getPasswordQue() {
		return this.passwordQue;
	}

	public void setPasswordQue(Integer passwordQue) {
		this.passwordQue = passwordQue;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Set getStuTeams() {
		return this.stuTeams;
	}

	public void setStuTeams(Set stuTeams) {
		this.stuTeams = stuTeams;
	}

}