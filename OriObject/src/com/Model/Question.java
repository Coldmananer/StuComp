package com.Model;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private Integer questionId;
	private Competition competition;
	private String questionName;
	private String questionIntro;
	private String questionNum;
	private String fileDesc;
	private String questionAnsw;
	private String fileName;

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** full constructor */
	public Question(Competition competition, String questionName, String questionIntro, String questionNum,
			String fileDesc, String questionAnsw, String fileName) {
		this.competition = competition;
		this.questionName = questionName;
		this.questionIntro = questionIntro;
		this.questionNum = questionNum;
		this.fileDesc = fileDesc;
		this.questionAnsw = questionAnsw;
		this.fileName = fileName;
	}

	// Property accessors

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionIntro() {
		return this.questionIntro;
	}

	public void setQuestionIntro(String questionIntro) {
		this.questionIntro = questionIntro;
	}

	public String getQuestionNum() {
		return this.questionNum;
	}

	public void setQuestionNum(String questionNum) {
		this.questionNum = questionNum;
	}

	public String getFileDesc() {
		return this.fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getQuestionAnsw() {
		return this.questionAnsw;
	}

	public void setQuestionAnsw(String questionAnsw) {
		this.questionAnsw = questionAnsw;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}