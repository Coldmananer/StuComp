package com.whb.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Compstatus;
import com.opensymphony.xwork2.ActionSupport;

public class addcomp extends ActionSupport {
	
	public String compName;
	public int compType;
	public boolean ifmanual;
	public int memberNum;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String  ueditor = request.getParameter("editorValue");
		
		return super.execute();
	}
	
}
