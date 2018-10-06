package com.Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Highladder entity. @author MyEclipse Persistence Tools
 */

public class Highladder implements java.io.Serializable {

	// Fields

	private Integer highLadderId;
	private String highLadderName;
	private Timestamp startTime;
	private Timestamp endTime;
	private String charge;
	private String introduction;
	private Set highladdercomps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Highladder() {
	}

	/** full constructor */
	public Highladder(String highLadderName, Timestamp startTime, Timestamp endTime, String charge, String introduction,
			Set highladdercomps) {
		this.highLadderName = highLadderName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.charge = charge;
		this.introduction = introduction;
		this.highladdercomps = highladdercomps;
	}

	// Property accessors

	public Integer getHighLadderId() {
		return this.highLadderId;
	}

	public void setHighLadderId(Integer highLadderId) {
		this.highLadderId = highLadderId;
	}

	public String getHighLadderName() {
		return this.highLadderName;
	}

	public void setHighLadderName(String highLadderName) {
		this.highLadderName = highLadderName;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getCharge() {
		return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set getHighladdercomps() {
		return this.highladdercomps;
	}

	public void setHighladdercomps(Set highladdercomps) {
		this.highladdercomps = highladdercomps;
	}

}