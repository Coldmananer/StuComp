package com.Model;

import java.sql.Timestamp;

/**
 * Works entity. @author MyEclipse Persistence Tools
 */

public class Works implements java.io.Serializable {

	// Fields

	private Integer workId;
	private Teamcompetion teamcompetion;
	private String workName;
	private String introduction;
	private Timestamp submitTime;
	private Integer submitId;
	private Integer question;
	private String filePath;
	private Integer score;

	// Constructors

	/** default constructor */
	public Works() {
	}

	/** full constructor */
	public Works(Teamcompetion teamcompetion, String workName, String introduction, Timestamp submitTime,
			Integer submitId, Integer question, String filePath, Integer score) {
		this.teamcompetion = teamcompetion;
		this.workName = workName;
		this.introduction = introduction;
		this.submitTime = submitTime;
		this.submitId = submitId;
		this.question = question;
		this.filePath = filePath;
		this.score = score;
	}

	// Property accessors

	public Integer getWorkId() {
		return this.workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public Teamcompetion getTeamcompetion() {
		return this.teamcompetion;
	}

	public void setTeamcompetion(Teamcompetion teamcompetion) {
		this.teamcompetion = teamcompetion;
	}

	public String getWorkName() {
		return this.workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getSubmitId() {
		return this.submitId;
	}

	public void setSubmitId(Integer submitId) {
		this.submitId = submitId;
	}

	public Integer getQuestion() {
		return this.question;
	}

	public void setQuestion(Integer question) {
		this.question = question;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}