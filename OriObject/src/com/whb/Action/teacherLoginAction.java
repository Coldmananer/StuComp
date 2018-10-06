package com.whb.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.impl.teacherDaoImpl;

public class teacherLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private int username;
	private String password;
	
	public int getUsername() {
		return username;
	}
	
	public void setUsername(int username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		
		teacherDaoImpl teacherDaoImpl = new teacherDaoImpl();
		Teacher teacher = teacherDaoImpl.findByteaId(username);
		if(teacher == null)
			return ERROR;
		String real_password = teacher.getPassword();
		//System.out.println("real_teacher:"+teacher.getTeaId()+"-"+real_password);
		System.out.println("input_teacher:"+username+"-"+password);
		ActionContext.getContext().getSession().put("teaid", username);
		ActionContext.getContext().getSession().put("teacher", teacher);
		if(password.equals(real_password))
			return SUCCESS;
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "¥ÌŒÛµƒ’À∫≈ªÚ√‹¬Î");
		return ERROR;
	}

}
