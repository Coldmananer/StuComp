package com.whb.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Compcode;
import com.Model.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.TeacherDao;
import com.whb.Dao.compcodeDao;
import com.whb.Dao.impl.compcodeDaoImpl;
import com.whb.Dao.impl.teacherDaoImpl;

public class teacherInformationAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	
	private String teaName;
	private String phoneNum;
	private String password;
	

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String show(){
		Teacher teacher = (Teacher) ActionContext.getContext().getSession().get("teacher");
		compcodeDao compcodedao = new compcodeDaoImpl();
		Compcode compcode = compcodedao.findbyCompTypeId(teacher.getCompcode().getCompTypeid());
		HttpServletRequest request =  ServletActionContext.getRequest();
		request.setAttribute("compcode", compcode);
		return SUCCESS;
	}
	
	public String change() throws Exception{
		Teacher teacher = (Teacher) ActionContext.getContext().getSession().get("teacher");
		TeacherDao teacherdao = new teacherDaoImpl();
		teacher.setPassword(password);
		teacher.setPhoneNum(phoneNum);
//		teacher.setTeaName(teaName);
		teacherdao.update(teacher);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "信息已修改");
		return SUCCESS;
	}
	
}
