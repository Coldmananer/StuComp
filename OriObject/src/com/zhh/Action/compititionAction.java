package com.zhh.Action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Complist;
import com.Model.Question;
import com.Model.StuTeam;
import com.Model.Student;
import com.Model.Team;
import com.Model.Teamcompetion;
import com.Model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhh.Dao.compDao;
import com.zhh.Dao.compListDao;
import com.zhh.Dao.questionDao;
import com.zhh.Dao.stuTeamDao;
import com.zhh.Dao.teamCompDao;
import com.zhh.Dao.teamDao;
import com.zhh.Dao.worksDao;
import com.zhh.PageInfo.PageBean;
import com.zhh.PageInfo.RunCompService;
import com.zhh.PageInfo.aplCompService;
import com.zhh.PageInfo.endCompService;
import com.zhh.studentDaoImpl.compDaoImpl;
import com.zhh.studentDaoImpl.compListDaoImpl;
import com.zhh.studentDaoImpl.questionDaoImpl;
import com.zhh.studentDaoImpl.stuTeamDaoImpl;
import com.zhh.studentDaoImpl.teamCompDaoImpl;
import com.zhh.studentDaoImpl.teamDaoImpl;
import com.zhh.studentDaoImpl.worksDaoImpl;

public class compititionAction extends ActionSupport {
	private int compId;
	private int page;
	private int studentId;
	private int teamId;
	private int MemberNum;
	private int queId;
	private Works works; // 作品对象
	private File work; // 作品文件
	private String workFileContentType; // 封装上传文件类型的属性
	private String workFileName; // 封装上传文件属性
	private Competition comp;
	private Question question;
	private List<Competition> clist;
	private List<StuTeam> stlist;
	private List<Teamcompetion> tclist;
	private List<Question> qlist;
	private List<Complist> cllist;
	private aplCompService acsv = new aplCompService();
	private RunCompService rcsv = new RunCompService();
	private endCompService ecsv = new endCompService();
	private compDao cd = new compDaoImpl();
	private stuTeamDao std = new stuTeamDaoImpl();
	private teamDao td = new teamDaoImpl();
	private teamCompDao tcd = new teamCompDaoImpl();
	private questionDao qd = new questionDaoImpl();
	private worksDao wd = new worksDaoImpl();
	private compListDao cld = new compListDaoImpl();

	public String showAplComp() {// 遍历报名中的竞赛
		clist = cd.findAplComp();
		return SUCCESS;
	}

	public String showCompDetial() {// 显示报名中的竞赛详情
		comp = cd.findById(compId);
		ActionContext.getContext().getSession().remove("comp");
		ActionContext.getContext().getSession().put("comp", comp);
		if (comp.getCompstatus().getCompStateId() == 1) {
			return SUCCESS;
		} else {
			return "success1";
		}
	}

	public String selectTeam() {// 遍历可以报名的团队
		stlist = std.findLeaderTeam(studentId);
		System.out.println(studentId);
		return SUCCESS;
	}

	public String applyForComp() {// 团队报名竞赛
		MemberNum = std.findMemberNum(teamId);

		Team team = td.findByTeamId(teamId);
		Teamcompetion tc = new Teamcompetion();
		tc.setTeam(team);// 根据团队id插入团队

		Competition competition = (Competition) ActionContext.getContext().getSession().get("comp");
		tc.setCompetition(competition);

		if (tcd.reApl(teamId, competition.getCompId())) {
			return "reApl";
		} else if (MemberNum <= competition.getPersonNum()) {
			tcd.save(tc);
			return SUCCESS;
		}
		return ERROR;
	}

	public String IndivAplForComp() {// 个人报名
		Team team = std.findIndividualTeam(studentId).getTeam();// 找到每个人单人的团队并插入
		Teamcompetion tc = new Teamcompetion();
		tc.setTeam(team);

		tc.setIsPass(false);

		Competition competition = (Competition) ActionContext.getContext().getSession().get("comp");
		tc.setCompetition(competition);
		if (!tcd.reApl(team.getTeamId(), competition.getCompId())) {
			tcd.save(tc);
			return SUCCESS;
		}
		return "reApl";
	}

	public String myComp_aplComp() {// 我的竞赛_报名中的竞赛
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		List<StuTeam> list1 = std.findByStudentId(student.getStuId());
		tclist = new ArrayList<Teamcompetion>();

		for (StuTeam st : list1) {
			tclist.addAll(tcd.findMyAplComp(st.getTeam().getTeamId()));
		}
		return SUCCESS;
	}

	public String showRunningComp() {// 遍历进行中的竞赛
		clist = cd.findRunningComp();
		return SUCCESS;
	}

	public String myComp_RunningComp() {// 我的竞赛_进行中的竞赛
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		List<StuTeam> list1 = std.findByStudentId(student.getStuId());
		tclist = new ArrayList<Teamcompetion>();

		for (StuTeam st : list1) {
			tclist.addAll(tcd.findMyRunningComp(st.getTeam().getTeamId()));
		}
		return SUCCESS;
	}

	public String showCompDetialWithQue() {// 有竞赛题目按钮的竞赛详情
		comp = cd.findById(compId);
		ActionContext.getContext().getSession().remove("comp");
		ActionContext.getContext().getSession().put("comp", comp);
		return SUCCESS;
	}

	public String showQue() {// 查找所有题目
		qlist = qd.findByCompId(compId);
		return SUCCESS;
	}

	public String showQueIntro() {
		question = qd.findById(queId);
		return SUCCESS;
	}

	public String showEndComp() {// 遍历已经结束的竞赛
		PageBean<Competition> pageBean = ecsv.getPageBean(10, page);
		HttpServletRequest request = ServletActionContext.getRequest();

		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	public String Personal_submitWork() {// 个人提交作品
		String realpath = ServletActionContext.getServletContext().getRealPath("/works");
		File file = new File(realpath);

		if (!file.exists()) {
			file.mkdirs();
		}
		String newfilename = System.currentTimeMillis() + "." + FilenameUtils.getExtension(this.getWorkFileName());

		try {
			FileUtils.copyFile(work, new File(file, newfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		works.setFilePath(newfilename);
		works.setSubmitTime(new Timestamp(System.currentTimeMillis()));

		Student student = (Student) ActionContext.getContext().getSession().get("student");
		Competition comp = (Competition) ActionContext.getContext().getSession().get("comp");
		Teamcompetion tc = tcd.findPTC(comp.getCompId(), student.getStuId());// 找到个人参赛的记录
		if (wd.judgeResubmit(works.getQuestion(), tc) == null) {
			works.setTeamcompetion(tc);
			wd.save(works);
		} else {
			Works works1 = wd.judgeResubmit(works.getQuestion(), tc);
			works.setQuestion(works1.getQuestion());
			works.setTeamcompetion(tc);
			works.setWorkId(works1.getWorkId());
			wd.update(works);
		}
		tc.setSubmitTime(new Timestamp(System.currentTimeMillis()));
		tcd.update(tc);
		return SUCCESS;
	}

	public String submitWork() {// 如果是队长直接提交文件,不是队长就提示不是队长不能提交文件
		String realpath = ServletActionContext.getServletContext().getRealPath("/works");
		File file = new File(realpath);

		if (!file.exists()) {
			file.mkdirs();
		}
		String newfilename = System.currentTimeMillis() + "." + FilenameUtils.getExtension(this.getWorkFileName());
		try {
			FileUtils.copyFile(work, new File(file, newfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		works.setFilePath(newfilename);
		works.setSubmitTime(new Timestamp(System.currentTimeMillis()));
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		Competition comp = (Competition) ActionContext.getContext().getSession().get("comp");
		Teamcompetion tc = tcd.findMyTC(comp.getCompId(), student.getStuId());
		if (tc != null) {// 判断是不是队长，
			if (wd.judgeResubmit(works.getQuestion(), tc) == null) {// 判断之前有无提交，若有提交则覆盖

				works.setTeamcompetion(tc);
				wd.save(works);
			} else {
				Works works1 = wd.judgeResubmit(works.getQuestion(), tc);
				works.setQuestion(works1.getQuestion());
				works.setTeamcompetion(tc);
				works.setWorkId(works1.getWorkId());
				wd.update(works);

			}
			tc.setSubmitTime(new Timestamp(System.currentTimeMillis()));
			tcd.update(tc);
			return SUCCESS;
		} else {
			return "NotLeader";
		}
	}

	public String myComp_endComp() {// 我的竞赛_结束的竞赛
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		List<StuTeam> list1 = std.findByStudentId(student.getStuId());
		tclist = new ArrayList<Teamcompetion>();

		for (StuTeam st : list1) {
			tclist.addAll(tcd.findMyEndComp(st.getTeam().getTeamId()));
		}
		return SUCCESS;
	}

	public String showEndCompDetial() {// 结束的竞赛的详情
		comp = cd.findById(compId);
		ActionContext.getContext().getSession().remove("comp");
		ActionContext.getContext().getSession().put("comp", comp);
		return SUCCESS;
	}

	public String findCompList() {
		cllist = cld.findByComp(compId);
		Competition comp1 = (Competition) ActionContext.getContext().getSession().get("comp");
		if (comp1.getPersonNum() == 1) {
			return "Indivi";
		} else {
			return SUCCESS;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public Competition getComp() {
		return comp;
	}

	public void setComp(Competition comp) {
		this.comp = comp;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public List<StuTeam> getStlist() {
		return stlist;
	}

	public void setStlist(List<StuTeam> stlist) {
		this.stlist = stlist;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getMemberNum() {
		return MemberNum;
	}

	public void setMemberNum(int memberNum) {
		MemberNum = memberNum;
	}

	public List<Teamcompetion> getTclist() {
		return tclist;
	}

	public void setTclist(List<Teamcompetion> tclist) {
		this.tclist = tclist;
	}

	public List<Question> getQlist() {
		return qlist;
	}

	public void setQlist(List<Question> qlist) {
		this.qlist = qlist;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	public File getWork() {
		return work;
	}

	public void setWork(File work) {
		this.work = work;
	}

	public String getWorkFileContentType() {
		return workFileContentType;
	}

	public void setWorkFileContentType(String workFileContentType) {
		this.workFileContentType = workFileContentType;
	}

	public String getWorkFileName() {
		return workFileName;
	}

	public void setWorkFileName(String workFileName) {
		this.workFileName = workFileName;
	}

	public List<Complist> getCllist() {
		return cllist;
	}

	public void setCllist(List<Complist> cllist) {
		this.cllist = cllist;
	}

	public List<Competition> getClist() {
		return clist;
	}

	public void setClist(List<Competition> clist) {
		this.clist = clist;
	}

}
