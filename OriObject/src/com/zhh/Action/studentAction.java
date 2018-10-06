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

	public String register() {// ע��
		sd.save(student);
		return "success";
	}

	public String login() {// ��¼

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

	public String EdtInfo() {// ������Ϣ�޸�
		return "FindSuccess";
	}

	public String Updata() {// �޸���Ϣ
		sd.update(student);
		ActionContext.getContext().getSession().put("student", student);
		return "UpdataSuccess";
	}

	public String applyForTeam() {// �����Ŷ�
		HttpServletRequest request = ServletActionContext.getRequest();
		Team team = td.findByTeamId(teamId);
		Student student = (Student) ActionContext.getContext().getSession().get("student");
		if (!std.reAppleTeam(teamId, student.getStuId())) {
			StuTeam stt = new StuTeam();
			stt.setIsPass(false);
			stt.setLeader(false);
			stt.setRole("��Ա");
			stt.setStudent(student);
			stt.setTeam(team);
			std.save(stt);
			return SUCCESS;
		} else {
			String message = "�����ظ�����";
			request.setAttribute("message", message);
			return "reApl";
		}
	}

	public String ModifyPassword() {// �޸�����
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");// ��ֹ��������Ϣ��������
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
			out.print("<script>alert('��Ϣ�������')</script>");
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
