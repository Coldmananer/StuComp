package com.Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Competition entity. @author MyEclipse Persistence Tools
 */

public class Competition implements java.io.Serializable {

	// Fields

	private Integer compId;
	private Compstatus compstatus;
	private Compcode compcode;
	private String compName;
	private Timestamp startTime;
	private Timestamp endTime;
	private String compIntro;
	private Integer personNum;
	private String teacher;
	private Timestamp obStartTime;
	private Timestamp obEndTime;
	private Set teamcompetions = new HashSet(0);
	private Set questions = new HashSet(0);
	private Set highladdercomps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Competition() {
	}

	/** full constructor */
	public Competition(Compstatus compstatus, Compcode compcode, String compName, Timestamp startTime,
			Timestamp endTime, String compIntro, Integer personNum, String teacher, Timestamp obStartTime,
			Timestamp obEndTime, Set teamcompetions, Set questions, Set highladdercomps) {
		this.compstatus = compstatus;
		this.compcode = compcode;
		this.compName = compName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.compIntro = compIntro;
		this.personNum = personNum;
		this.teacher = teacher;
		this.obStartTime = obStartTime;
		this.obEndTime = obEndTime;
		this.teamcompetions = teamcompetions;
		this.questions = questions;
		this.highladdercomps = highladdercomps;
	}

	// Property accessors

	public Integer getCompId() {
		return this.compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Compstatus getCompstatus() {
		return this.compstatus;
	}

	public void setCompstatus(Compstatus compstatus) {
		this.compstatus = compstatus;
	}

	public Compcode getCompcode() {
		return this.compcode;
	}

	public void setCompcode(Compcode compcode) {
		this.compcode = compcode;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
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

	public String getCompIntro() {
		return this.compIntro;
	}

	public void setCompIntro(String compIntro) {
		this.compIntro = compIntro;
	}

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Timestamp getObStartTime() {
		return this.obStartTime;
	}

	public void setObStartTime(Timestamp obStartTime) {
		this.obStartTime = obStartTime;
	}

	public Timestamp getObEndTime() {
		return this.obEndTime;
	}

	public void setObEndTime(Timestamp obEndTime) {
		this.obEndTime = obEndTime;
	}

	public Set getTeamcompetions() {
		return this.teamcompetions;
	}

	public void setTeamcompetions(Set teamcompetions) {
		this.teamcompetions = teamcompetions;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	public Set getHighladdercomps() {
		return this.highladdercomps;
	}

	public void setHighladdercomps(Set highladdercomps) {
		this.highladdercomps = highladdercomps;
	}

}