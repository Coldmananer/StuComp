package com.zhh.Action;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.zhh.studentDaoImpl.stuTeamDaoImpl;
import com.zhh.studentDaoImpl.studentDaoImpl;
import com.zhh.studentDaoImpl.teamDaoImpl;

public class studentAction extends ActionSupport {
	/**
	 * 
	 */
	private javax.servlet.http.HttpServletResponse response;
	private String number;
	private String password;
	private static final long serialVersionUID = 1L;
	private Student student;
	private studentDao sd = new studentDaoImpl();
	private int teamId;
	private stuTeamDao std = new stuTeamDaoImpl();
	private teamDao td = new teamDaoImpl();

	public String register() {// 注册
		sd.save(student);
		return "success";
	}

	public String login() {// 登录

		HttpServletRequest request = ServletActionContext.getRequest();
		String number = (String) request.getParameter("number");
		String password = (String) request.getParameter("password");
		student = sd.findByNumber(number);
		ActionContext.getContext().getSession().put("student", student);
		if (number.isEmpty() || password.isEmpty()) {
			return "error";
		} else {
			if (sd.login(number, password)) {
				return "Loginsuccess";
			} else
				return "error";
		}
	}

	public String EdtInfo() {// 跳入信息修改
		return "FindSuccess";
	}

	public String Updata() {// 修改信息
		sd.update(student);
		ActionContext.getContext().getSession().put("student", student);
		return "UpdataSuccess";
	}

	public String applyForTeam() {// 报名团队
		HttpServletRequest request = ServletActionContext.getRequest();
		Team team = td.findByTeamId(teamId);
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		if (!std.reAppleTeam(teamId, student.getStuId())) {
			StuTeam stt = new StuTeam();
			stt.setIsPass(false);
			stt.setLeader(false);
			stt.setRole("队员");
			stt.setStudent(student);
			stt.setTeam(team);
			std.save(stt);
			return SUCCESS;
		} else {
			String message = "请勿重复报名";
			request.setAttribute("message", message);
			return "reApl";
		}
	}

	public String ModifyPassword() {// 修改密码
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");// 防止弹出的信息出现乱码
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		int passwordQue = Integer.parseInt(request.getParameter("passwordQue"));
		String answer = request.getParameter("answer");
		String oldPassword = request.getParameter("oldPassword");
		if (student.getPasswordQue() == passwordQue && student.getAnswer() == answer
				&& student.getPassword() == oldPassword) {
			String newPassword = request.getParameter("newPassword");
			student.setPassword(newPassword);
			sd.update(student);
			return SUCCESS;
		} else {
			out.print("<script>alert('信息输入错误')</script>");
			return null;
		}

	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public javax.servlet.http.HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(javax.servlet.http.HttpServletResponse response) {
		this.response = response;
	}

}
