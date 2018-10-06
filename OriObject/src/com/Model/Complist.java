package com.Model;

/**
 * Complist entity. @author MyEclipse Persistence Tools
 */

public class Complist implements java.io.Serializable {

	// Fields

	private Integer compListId;
	private Integer score;
	private Integer rank;
	private Integer compId;
	private Integer teamId;
	private String teamName;
	private String teamMembersName;
	private String tips;

	// Constructors

	/** default constructor */
	public Complist() {
	}

	/** full constructor */
	public Complist(Integer score, Integer rank, Integer compId, Integer teamId, String teamName,
			String teamMembersName, String tips) {
		this.score = score;
		this.rank = rank;
		this.compId = compId;
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamMembersName = teamMembersName;
		this.tips = tips;
	}

	// Property accessors

	public Integer getCompListId() {
		return this.compListId;
	}

	public void setCompListId(Integer compListId) {
		this.compListId = compListId;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getCompId() {
		return this.compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

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

	public String getTeamMembersName() {
		return this.teamMembersName;
	}

	public void setTeamMembersName(String teamMembersName) {
		this.teamMembersName = teamMembersName;
	}

	public String getTips() {
		return this.tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

}