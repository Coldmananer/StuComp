package com.whb.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.competitionDao;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.util.CompetitionService;
import com.whb.util.CompetitionServiceImpl;
import com.whb.util.PageBean;

public class competitionShowAction extends ActionSupport{
	

	private static final long serialVersionUID = 1L;
	private String comptypeid;
	private int page;
    
	
	
    public String getComptypeid() {
		return comptypeid;
	}

	public void setComptypeid(String comptypeid) {
		this.comptypeid = comptypeid;
	}

	public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
	
	private CompetitionService competitionService = new CompetitionServiceImpl();
    
    

    @Override
    public String execute() throws Exception
    {
        //表示每页显示5条记录，page表示当前网页
//        PageBean pageBean = competitionService.getPageBean(5, page);
    	competitionDao competitiondao = new competitionDaoImpl();
        List<Competition> competitions = competitiondao.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean isAll = true;
        request.removeAttribute("competitions");
        request.setAttribute("competitions", competitions);
        ActionContext.getContext().getSession().remove("isAll");
        ActionContext.getContext().getSession().put("isAll", isAll);
        
        return SUCCESS;
    }
    
    public String showBycompType() throws Exception{
    	//表示每页显示5条记录，page表示当前网页
    	int type = Integer.parseInt(comptypeid);
    	competitionDao competitiondao = new competitionDaoImpl();
        List<Competition> competitions = competitiondao.findbyCompTypeid(type);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        boolean isAll = false;
        request.removeAttribute("competitions");
        request.setAttribute("competitions", competitions);
        ActionContext.getContext().getSession().remove("isAll");
        ActionContext.getContext().getSession().put("isAll", isAll);
        
        return SUCCESS;
    }
}
