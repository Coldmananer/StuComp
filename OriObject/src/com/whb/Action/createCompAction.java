package com.whb.Action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Compcode;
import com.Model.Competition;
import com.Model.Compstatus;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.compcodeDao;
import com.whb.Dao.competitionDao;
import com.whb.Dao.compstatusDao;
import com.whb.Dao.impl.compcodeDaoImpl;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.Dao.impl.compstatusDaoImpl;

public class createCompAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String compName;
	private int comptypeid;
	private int memberNum;
	
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	
	
	public int getComptypeid() {
		return comptypeid;
	}

	public void setComptypeid(int comptypeid) {
		this.comptypeid = comptypeid;
	}

	@Override
	public String execute() throws Exception {
		
		
		if(compName==null||comptypeid==-1||memberNum==-1){
			System.out.println("error");
			return  ERROR;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		competitionDao compDao = new competitionDaoImpl();
		int id = compDao.getAllRowCount("from Competition") +1 ;
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Compstatus compstatus = compstatusdao.findbyCompStatusId(1);
		compcodeDao compcodeDao = new compcodeDaoImpl();
		Compcode compcode =compcodeDao.findbyCompTypeId(comptypeid);//对象为空
		String compIntro = request.getParameter("compIntro");
		System.out.println(compIntro);
		Competition	comp = new Competition();
//		comp.setCompId(id);
		comp.setCompName(compName);
		comp.setPersonNum(memberNum);
		comp.setCompcode(compcode);	//是一个compcode类型
		comp.setCompIntro(compIntro);
		comp.setCompstatus(compstatus);
		//设置创建时间
		Timestamp time= new Timestamp(System.currentTimeMillis());
        comp.setStartTime(time);
		compDao.save(comp);
		
		return SUCCESS;
	}
	
}
