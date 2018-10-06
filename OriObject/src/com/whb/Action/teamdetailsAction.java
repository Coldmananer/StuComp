package com.whb.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.StuTeam;
import com.Model.Student;
import com.Model.Team;
import com.Model.Teamcompetion;
import com.Model.Works;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.TeamDao;
import com.whb.Dao.competitionDao;
import com.whb.Dao.stuteamDao;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.worksDao;
import com.whb.Dao.impl.TeamDaoImpl;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.Dao.impl.stuteamDaoImpl;
import com.whb.Dao.impl.teamcompDaoImpl;
import com.whb.Dao.impl.worksDaoImpl;
import com.zhh.Dao.studentDao;
import com.zhh.studentDaoImpl.studentDaoImpl;

/**
 * 把com.zhh里面的DAO全部改到com.WHB中
 * @author Administrator
 *
 */
public class teamdetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int teamId;
	private int compId;
	
	
	
	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	@Override
	public String execute() throws Exception {
		TeamDao teamdao = new TeamDaoImpl();
		Team team = teamdao.findByTeamId(teamId);
		stuteamDao stuteamdao = new stuteamDaoImpl();
		List<StuTeam> stuTeams = stuteamdao.findbyTeamId(teamId);
		studentDao studentdao = new studentDaoImpl();
		List<Student> students= new ArrayList<Student>();
		for(StuTeam stuTeam : stuTeams){
			Student s = studentdao.findById(stuTeam.getStudent().getStuId());
			System.out.println(stuTeam.getStudent().getStuId());
			System.out.println(s.getStuName()+":"+s.getClass());
			students.add(s);
		}
		teamcompDao teamcompdao = new teamcompDaoImpl();
		Teamcompetion teamcompetion = teamcompdao.findbyteamIdcompId(teamId, compId);
		
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		int competitionstate = competition.getCompstatus().getCompStateId();
		List<Works> works = null;
		if(competitionstate!=1&&competitionstate!=2){
			worksDao worksdao = new worksDaoImpl();
			works = worksdao.findbyTeamCompId(teamcompetion.getTeamCompId());
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("works");
		request.removeAttribute("team");
		request.removeAttribute("students");
		request.setAttribute("team", team);
		request.setAttribute("students", students);
		if(teamcompetion!=null){
			request.removeAttribute("teamcompetion");
			request.setAttribute("teamcompetion", teamcompetion);
		}
		if(works!=null){
			request.setAttribute("works", works);
		}
		
		return SUCCESS;
	}
	
	public String refuseTeam()throws Exception{
		teamcompDao teamcompdao = new teamcompDaoImpl();
		Teamcompetion teamcompetion = teamcompdao.findbyteamIdcompId(teamId, compId);
		teamcompetion.setIsPass(false);
		teamcompdao.update(teamcompetion);
		return SUCCESS;
	}
}
