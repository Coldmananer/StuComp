package com.Model;

/**
 * StuTeam entity. @author MyEclipse Persistence Tools
 */

public class StuTeam implements java.io.Serializable {

	// Fields

	private Integer stuteamid;
	private Team team;
	private Student student;
	private Boolean leader;
	private Boolean isPass;
	private String role;

	// Constructors

	/** default constructor */
	public StuTeam() {
	}

	/** full constructor */
	public StuTeam(Team team, Student student, Boolean leader, Boolean isPass, String role) {
		this.team = team;
		this.student = student;
		this.leader = leader;
		this.isPass = isPass;
		this.role = role;
	}

	// Property accessors

	public Integer getStuteamid() {
		return this.stuteamid;
	}

	public void setStuteamid(Integer stuteamid) {
		this.stuteamid = stuteamid;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Boolean getLeader() {
		return this.leader;
	}

	public void setLeader(Boolean leader) {
		this.leader = leader;
	}

	public Boolean getIsPass() {
		return this.isPass;
	}

	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}