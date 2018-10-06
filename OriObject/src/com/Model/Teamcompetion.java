package com.Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Teamcompetion entity. @author MyEclipse Persistence Tools
 */

public class Teamcompetion implements java.io.Serializable {

	// Fields

	private Integer teamCompId;
	private Team team;
	private Competition competition;
	private Timestamp submitTime;
	private Boolean isPass;
	private Set workses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teamcompetion() {
	}

	/** full constructor */
	public Teamcompetion(Team team, Competition competition, Timestamp submitTime, Boolean isPass, Set workses) {
		this.team = team;
		this.competition = competition;
		this.submitTime = submitTime;
		this.isPass = isPass;
		this.workses = workses;
	}

	// Property accessors

	public Integer getTeamCompId() {
		return this.teamCompId;
	}

	public void setTeamCompId(Integer teamCompId) {
		this.teamCompId = teamCompId;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Boolean getIsPass() {
		return this.isPass;
	}

	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}

	public Set getWorkses() {
		return this.workses;
	}

	public void setWorkses(Set workses) {
		this.workses = workses;
	}

}