package com.whb.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.competitionDao;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.util.TeamCompPageBean;
import com.whb.util.TeamcompService;

public class compManageAction extends ActionSupport {

	
	private static final long serialVersionUID = -5695609276947547415L;
	private String CompId;
	private int page;
    
    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
	
	private TeamcompService teamcompService = new TeamcompService();
	
	
	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}
	
	//展示竞赛人员
	@Override
	public String execute() throws Exception {
		int compId;
//		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		//teamcomp的分页显示
		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page,compId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
		
		//根据compid获取competition
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		//分别存入request和session方便操作
		request.setAttribute("competition", competition);
		ActionContext.getContext().getSession().remove("competition");
        ActionContext.getContext().getSession().put("competition", competition);
        
		return SUCCESS;
	}
	
	
}
