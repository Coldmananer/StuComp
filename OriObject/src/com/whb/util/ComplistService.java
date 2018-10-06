package com.whb.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.Model.Complist;
import com.Model.Question;
import com.Model.Teamcompetion;
import com.whb.Dao.complistDao;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.impl.complistDaoImpl;
import com.whb.Dao.impl.teamcompDaoImpl;

public class ComplistService {

	private complistDao complistdao = new complistDaoImpl();
    
    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
	@SuppressWarnings("unchecked")
	public ComplistPageBean getPageBean(int pageSize, int page,int CompId)
    {
		ComplistPageBean pageBean = new ComplistPageBean();
        
        String hql = "from Complist where compId="+CompId;
        
        int allRows = complistdao.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Complist> list = complistdao.queryByPage(hql, offset, pageSize);

        Collections.sort(list, new Comparator(){  
	        @Override  
	        public int compare(Object o1, Object o2) {  
	        	Complist complist1=(Complist)o1;  
	        	Complist complist2=(Complist)o2;  
	            if(complist1.getScore()<complist2.getScore()){  
	                return 1;  
	            }else if(complist1.getScore()==complist2.getScore()){  
	                return 0;  
	            }else{  
	                return -1;  
	            }  
	        }             
	    });
       
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }
	
	
	
}
