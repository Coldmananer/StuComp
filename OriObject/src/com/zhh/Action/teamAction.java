package com.zhh.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.StuTeam;
import com.Model.Student;
import com.Model.Team;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhh.Dao.stuTeamDao;
import com.zhh.Dao.studentDao;
import com.zhh.Dao.teamDao;
import com.zhh.PageInfo.MyTeamService;
import com.zhh.PageInfo.PageBean;
import com.zhh.PageInfo.StuTeamService;
import com.zhh.PageInfo.searchAllTeamsService;
import com.zhh.studentDaoImpl.stuTeamDaoImpl;
import com.zhh.studentDaoImpl.studentDaoImpl;
import com.zhh.studentDaoImpl.teamDaoImpl;

public class teamAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Team team;
	private StuTeam stuTeam;
	private teamDao td = new teamDaoImpl();
	private stuTeamDao std = new stuTeamDaoImpl();
	private studentDao sd = new studentDaoImpl();
	private int page;
	private int teamId;
	private int stuteamId;
	private List<StuTeam> list;
	private StuTeamService stsv = new StuTeamService();
	private MyTeamService mt = new MyTeamService();
	private searchAllTeamsService sat = new searchAllTeamsService();

	public String createTeam() {//注册团队，自动插入当前登录者为队长
		td.save(team);
		Team t1 = td.findByTeamId(team.getTeamId());
		StuTeam stt = new StuTeam();
		stt.setTeam(t1);
		stt.setIsPass(true);
		stt.setLeader(true);
		stt.setRole("队长"); 
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		stt.setStudent(student);
		std.save(stt);
		return "success";
	}
	
	public String showAllTeams(){//根据角色为队长的记录从stuteam表中查出所有团队
		PageBean<StuTeam> pageBean = stsv.getPageBean(10, page);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		
        System.out.println(pageBean.getCurrentPage());
		return SUCCESS;
	}
	
	public String showMyTeams(){//根据当前登录学生id从stuteam中选出所有自己的团队	
		
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		PageBean<StuTeam> pageBean = mt.getPageBean(10, page, student.getStuId());
        HttpServletRequest request = ServletActionContext.getRequest();	
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		
		return SUCCESS;
	}
	
	public String search(){//多条件查询，ref可以为队长姓名或学号或团队名称
		HttpServletRequest request = ServletActionContext.getRequest();
		String ref = request.getParameter("ref");
		request.removeAttribute("ref");
		request.setAttribute("ref",ref);
		
		PageBean<StuTeam> pageBean = sat.getPageBean(10, page, ref);
		
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		
		return "list";
	}
	
	public String showTeamDetial(){//根据团队id从team表中查找为唯一记录
		team = td.findByTeamId(teamId);        
		return SUCCESS;
	}
	
	public String showMyTeamDetial(){//显示自己团队的详情
		stuTeam = std.findById(stuteamId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("stuTeam");
		request.setAttribute("stuTeam", stuTeam);
		list = std.findMembers(stuTeam.getTeam().getTeamId());
		return SUCCESS;
	}
	
	public String updateTeam(){//修改团队信息
		td.update(team);
		return SUCCESS;
	}
	
	public String manageMemebers(){
		list = std.findNotPassMember(teamId);
		return SUCCESS;
	}
	
	public String passMember(){
		stuTeam = std.findById(stuteamId);
		stuTeam.setIsPass(true);
		std.update(stuTeam);
		return "list";
	}
	
	public String deleteMember(){
		stuTeam = std.findById(stuteamId);
		std.delete(stuTeam);
		return "success";
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public StuTeam getStuTeam() {
		return stuTeam;
	}

	public void setStuTeam(StuTeam stuTeam) {
		this.stuTeam = stuTeam;
	}

	public int getStuteamId() {
		return stuteamId;
	}

	public void setStuteamId(int stuteamId) {
		this.stuteamId = stuteamId;
	}

	public List<StuTeam> getList() {
		return list;
	}

	public void setList(List<StuTeam> list) {
		this.list = list;
	}

}
