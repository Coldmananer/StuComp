package com.whb.Action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Complist;
import com.Model.Teamcompetion;
import com.Model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.complistDao;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.worksDao;
import com.whb.Dao.impl.complistDaoImpl;
import com.whb.Dao.impl.teamcompDaoImpl;
import com.whb.Dao.impl.worksDaoImpl;

public class teamGiveScoreAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private String teamId;
	private int compId;
	private String teamCompId;
	private int score;
	private int workId;
	
	
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTeamCompId() {
		return teamCompId;
	}
	public void setTeamCompId(String teamCompId) {
		this.teamCompId = teamCompId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(teamId==null){
			compId = (int)request.getAttribute("compId");
			teamId = (String)request.getAttribute("teamId");
		}
		int totalScore = 00;		//显示在下面的竞赛总分
		//System.out.println("teamId:"+teamId+",compId:"+compId);
		Competition comp = (Competition)ActionContext.getContext().getSession().get("competition");
		compId = comp.getCompId();
		int teamid = Integer.parseInt(teamId);
		teamcompDao teamcompdao = new teamcompDaoImpl();
		Teamcompetion teamcompetion = teamcompdao.findbyteamIdcompId(teamid, compId);
//		List<Teamcompetion> teamcompetions = teamcompdao.findbyteamIdcompId(teamid, compId);
		worksDao worksdao = new worksDaoImpl();
		List<Works> works = worksdao.findbyTeamCompId(teamcompetion.getTeamCompId());
		if(works != null){
			for(Works work:works){
				System.out.println(work.getWorkName());
				if(work.getScore() != null )
					totalScore += work.getScore();
			}
		}else{
			request.setAttribute("message", "暂未上传作品");
		}
		request.setAttribute("teamcompetion", teamcompetion);
		request.setAttribute("works", works);
		request.setAttribute("totalScore", totalScore);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String givescore() throws Exception{
		System.out.println(score);
		worksDao worksdao = new worksDaoImpl();
		Works work = worksdao.findbyWorkId(workId);
		teamcompDao teamcompdao = new teamcompDaoImpl();
		Teamcompetion teamcompetion = work.getTeamcompetion();
		complistDao complistdao = new complistDaoImpl();
		Complist complist = complistdao.findbyCompIdandteamId
				(teamcompetion.getCompetition().getCompId(), teamcompetion.getTeam().getTeamId());
		work.setScore(score);
		worksdao.update(work);
		if (complist != null) {
			List<Works> works = worksdao.findbyTeamCompId(teamcompetion.getTeamCompId());
			int complistscore = 0;
			for(Works teamcompwork:works){
				if(teamcompwork.getScore()!=null)
					complistscore += teamcompwork.getScore();
			}
			System.out.println("更新的分数"+complistscore);
			complist.setScore(complistscore);
			complistdao.update(complist);
			// 改变了complist的成绩后对complist中的排名进行排序
			Competition competition = (Competition) ActionContext.getContext().getSession().get("competition");
			List<Complist> complists = complistdao.findbyCompId(competition.getCompId());
			Collections.sort(complists, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					Complist complist1 = (Complist) o1;
					Complist complist2 = (Complist) o2;
					if (complist1.getScore() < complist2.getScore()) {
						return 1;
					} else if (complist1.getScore() == complist2.getScore()) {
						return 0;
					} else {
						return -1;
					}
				}
			});
			for (int i = 0; i < complists.size(); i++) {
				if (i == 0)
					complists.get(0).setRank(i + 1);
				else {
					// Complist complist =complists.get(i);
					if (complists.get(i).getScore() == complists.get(i - 1).getScore())
						complists.get(i).setRank(complists.get(i - 1).getRank());
					else
						complists.get(i).setRank(i + 1);
				}
			}
			for (Complist complist_save : complists) {
				complistdao.update(complist_save);
			}

		}

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("compId", work.getTeamcompetion().getCompetition().getCompId());
		request.setAttribute("teamId", work.getTeamcompetion().getTeam().getTeamId().toString());
		return "teamGiveScore";
	}
	
}
