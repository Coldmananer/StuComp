package com.whb.Action;

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

public class compdetailShowAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String compId;
	private int page;
	
	
	
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public String getCompId() {
		return compId;
	}



	public void setCompId(String compId) {
		this.compId = compId;
	}



	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
        competitionDao competitiondao = new competitionDaoImpl();
        //System.out.println(compId);
        int compId1 = Integer.parseInt(compId);
        Competition competition = competitiondao.findbyCompId(compId1);
//        System.out.println(compId1);
//		System.out.println(competition);
		int compcodeTypeid = competition.getCompcode().getCompTypeid();
		compcodeDao compcodeDao = new compcodeDaoImpl();
		Compcode compcode=compcodeDao.findbyCompTypeId(compcodeTypeid);
		String compType = compcode.getCompName();
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Compstatus compstatus = compstatusdao.findbyCompStatusId(competition.getCompstatus().getCompStateId());
		request.setAttribute("page", page);
		request.setAttribute("compstatus", compstatus.getCompStateName());
		request.setAttribute("compType", compType);
		request.setAttribute("competition", competition);
		return SUCCESS;
	}

}
