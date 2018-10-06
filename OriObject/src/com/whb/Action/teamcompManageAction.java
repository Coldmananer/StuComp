package com.whb.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Teamcompetion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.teamcompetionDao;
import com.whb.Dao.impl.teamcompDaoImpl;
import com.whb.Dao.impl.teamcompetionDaoImpl;

public class teamcompManageAction extends ActionSupport {

	private static final long serialVersionUID = -4008656582506115626L;
	private String teamId;
	private String compId;
	private int[] persons;
	
	public int[] getPersons() {
		return persons;
	}
	public void setPersons(int[] persons) {
		this.persons = persons;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	
	@Override
	public String execute() throws Exception {
		teamcompetionDao teamcompetiondao = new teamcompetionDaoImpl();
		try {
			int CompId = Integer.parseInt(compId);
			int TeamId = Integer.parseInt(teamId);
			Teamcompetion teamcompetion = teamcompetiondao.findbyCompIdteamId(CompId, TeamId);
		} catch (Exception e) {
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String pass() throws Exception{
		teamcompetionDao teamcompetiondao = new teamcompetionDaoImpl();
		try {
			compId = compId.trim();		//传入的compId前面不知道为什么有很多的空格，去除就可以用了
//			System.out.println("compId:"+compId+"----teamId:"+teamId);
			int CompId = Integer.parseInt(compId);
			System.out.println(CompId);
			int TeamId = Integer.parseInt(teamId);
			System.out.println("CompId:"+CompId+"----TeamId:"+TeamId);
			Teamcompetion teamcompetion = teamcompetiondao.findbyCompIdteamId(CompId, TeamId);
			teamcompetion.setIsPass(true);
			teamcompetiondao.updateTeamcompetion(teamcompetion);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("compId", CompId);
			request.setAttribute("teamId", TeamId);
		} catch (Exception e) {
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String refuse() throws Exception{
		teamcompetionDao teamcompetiondao = new teamcompetionDaoImpl();
		try {
			compId = compId.trim();
			int CompId = Integer.parseInt(compId);
			int TeamId = Integer.parseInt(teamId);
			Teamcompetion teamcompetion = teamcompetiondao.findbyCompIdteamId(CompId, TeamId);
			teamcompetion.setIsPass(false);
			teamcompetiondao.updateTeamcompetion(teamcompetion);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("compId", CompId);
			request.setAttribute("teamId", TeamId);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String allpass()throws Exception{
		teamcompDao teamcompdao = new teamcompDaoImpl();
		for(int person:persons){
			Teamcompetion teamcompetion = teamcompdao.findbyteamCompId(person);
			teamcompetion.setIsPass(true);
			teamcompdao.update(teamcompetion);
			System.out.println(person);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Competition competition=(Competition) ActionContext.getContext().getSession().get("competition");
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}
	
	public String allrefuse()throws Exception{
		teamcompDao teamcompdao = new teamcompDaoImpl();
		for(int person:persons){
			Teamcompetion teamcompetion = teamcompdao.findbyteamCompId(person);
			teamcompetion.setIsPass(false);
			teamcompdao.update(teamcompetion);
			System.out.println(person);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Competition competition=(Competition) ActionContext.getContext().getSession().get("competition");
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}
	
}
