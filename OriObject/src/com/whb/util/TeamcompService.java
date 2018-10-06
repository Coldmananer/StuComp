package com.whb.util;

import java.util.ArrayList;
import java.util.List;

import com.Model.Teamcompetion;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.impl.teamcompDaoImpl;

public class TeamcompService {

	private teamcompDao teamcompdao = new teamcompDaoImpl();
    
    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
	public TeamCompPageBean getPageBean(int pageSize, int page,int CompId)
    {
        TeamCompPageBean pageBean = new TeamCompPageBean();
        
        String hql = "from Teamcompetion where compId="+CompId ;
        
        int allRows = teamcompdao.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Teamcompetion> list = teamcompdao.queryByPage(hql, offset, pageSize);
        int off=0;
        /*去除重复的项。在展示的teamcomp的时候不会出现多个相同的队伍.因为是从teamcomp表中查找，
         * 一个team参加一个comp会有多条teamcomp记录，所以在展示的时候会出现多个名字相同的团队，其
         * 内容也都是一样的，所以要用一下代码出去相同重复的东西
         */
        List<Integer> rep = new ArrayList<Integer>();
        List<Teamcompetion> reallist = new ArrayList<Teamcompetion>();
        for(int i=0;i<list.size();i++){
        	Teamcompetion teamcomp=(Teamcompetion)list.get(i);
        	if(!rep.contains(teamcomp.getTeam().getTeamId())){
        		rep.add(teamcomp.getTeam().getTeamId());
        		reallist.add(teamcomp);
        	}else{
        		off++;
        	}
        }
        allRows -= off;
        totalPage -= off/pageSize;
        pageBean.setList(reallist);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }
	
	
	
}
