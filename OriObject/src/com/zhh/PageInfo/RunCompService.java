package com.zhh.PageInfo;

import java.util.List;

import com.Model.Competition;
import com.zhh.Dao.compDao;
import com.zhh.studentDaoImpl.compDaoImpl;

public class RunCompService {
     compDao cd = new compDaoImpl();
     
     public PageBean<Competition> getPageBean(int pageSize, int page){
    	PageBean<Competition> pgb = new PageBean<Competition>();
    	String hql = "from Competition c where c.compstatus.compStateId = 2 or c.compstatus.compStateId = 3";
    	
    	int allRows = cd.getAllRowCount(hql);
		int totalPage = pgb.getTotalPages(pageSize, allRows);
		int currentPage = pgb.getCurPage(page);
		int offset = pgb.getCurrentPageOffset(pageSize, currentPage);
		
		List<Competition> list = cd.quryByPage(hql, offset, pageSize);
		
		pgb.setAllRows(allRows);
		pgb.setCurrentPage(currentPage);
		pgb.setList(list);
		pgb.setTotalPage(totalPage);
    	
    	return pgb;
     }
}
