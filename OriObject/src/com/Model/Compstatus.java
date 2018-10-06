package com.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Compstatus entity. @author MyEclipse Persistence Tools
 */

public class Compstatus implements java.io.Serializable {

	// Fields

	private Integer compStateId;
	private String compStateName;
	private String comments;
	private Set competitions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Compstatus() {
	}

	/** full constructor */
	public Compstatus(String compStateName, String comments, Set competitions) {
		this.compStateName = compStateName;
		this.comments = comments;
		this.competitions = competitions;
	}

	// Property accessors

	public Integer getCompStateId() {
		return this.compStateId;
	}

	public void setCompStateId(Integer compStateId) {
		this.compStateId = compStateId;
	}

	public String getCompStateName() {
		return this.compStateName;
	}

	public void setCompStateName(String compStateName) {
		this.compStateName = compStateName;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(Set competitions) {
		this.competitions = competitions;
	}

}