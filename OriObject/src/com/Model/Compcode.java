package com.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Compcode entity. @author MyEclipse Persistence Tools
 */

public class Compcode implements java.io.Serializable {

	// Fields

	private Integer compTypeid;
	private String compName;
	private String compIntr;
	private Set competitions = new HashSet(0);
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Compcode() {
	}

	/** full constructor */
	public Compcode(String compName, String compIntr, Set competitions, Set teachers) {
		this.compName = compName;
		this.compIntr = compIntr;
		this.competitions = competitions;
		this.teachers = teachers;
	}

	// Property accessors

	public Integer getCompTypeid() {
		return this.compTypeid;
	}

	public void setCompTypeid(Integer compTypeid) {
		this.compTypeid = compTypeid;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompIntr() {
		return this.compIntr;
	}

	public void setCompIntr(String compIntr) {
		this.compIntr = compIntr;
	}

	public Set getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(Set competitions) {
		this.competitions = competitions;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}