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
	
	//չʾ������Ա
	@Override
	public String execute() throws Exception {
		int compId;
//		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		//teamcomp�ķ�ҳ��ʾ
		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page,compId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
		
		//����compid��ȡcompetition
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		//�ֱ����request��session�������
		request.setAttribute("competition", competition);
		ActionContext.getContext().getSession().remove("competition");
        ActionContext.getContext().getSession().put("competition", competition);
        
		return SUCCESS;
	}
	
	
}
