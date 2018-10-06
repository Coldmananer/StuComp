package com.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Team entity. @author MyEclipse Persistence Tools
 */

public class Team implements java.io.Serializable {

	// Fields

	private Integer teamId;
	private String teamName;
	private Integer teamLeader;
	private String teamIntro;
	private Set teamcompetions = new HashSet(0);
	private Set stuTeams = new HashSet(0);

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(String teamName, Integer teamLeader, String teamIntro, Set teamcompetions, Set stuTeams) {
		this.teamName = teamName;
		this.teamLeader = teamLeader;
		this.teamIntro = teamIntro;
		this.teamcompetions = teamcompetions;
		this.stuTeams = stuTeams;
	}

	// Property accessors

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamLeader() {
		return this.teamLeader;
	}

	public void setTeamLeader(Integer teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getTeamIntro() {
		return this.teamIntro;
	}

	public void setTeamIntro(String teamIntro) {
		this.teamIntro = teamIntro;
	}

	public Set getTeamcompetions() {
		return this.teamcompetions;
	}

	public void setTeamcompetions(Set teamcompetions) {
		this.teamcompetions = teamcompetions;
	}

	public Set getStuTeams() {
		return this.stuTeams;
	}

	public void setStuTeams(Set stuTeams) {
		this.stuTeams = stuTeams;
	}

}