package com.Model;

/**
 * Highladdercomp entity. @author MyEclipse Persistence Tools
 */

public class Highladdercomp implements java.io.Serializable {

	// Fields

	private Integer highLadderCompId;
	private Highladder highladder;
	private Competition competition;

	// Constructors

	/** default constructor */
	public Highladdercomp() {
	}

	/** full constructor */
	public Highladdercomp(Highladder highladder, Competition competition) {
		this.highladder = highladder;
		this.competition = competition;
	}

	// Property accessors

	public Integer getHighLadderCompId() {
		return this.highLadderCompId;
	}

	public void setHighLadderCompId(Integer highLadderCompId) {
		this.highLadderCompId = highLadderCompId;
	}

	public Highladder getHighladder() {
		return this.highladder;
	}

	public void setHighladder(Highladder highladder) {
		this.highladder = highladder;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

}