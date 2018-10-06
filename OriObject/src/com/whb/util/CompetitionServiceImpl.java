package com.whb.util;

import java.util.List;

import com.Model.Competition;
import com.whb.Dao.competitionDao;
import com.whb.Dao.impl.competitionDaoImpl;

public class CompetitionServiceImpl implements CompetitionService {

	private competitionDao compDAO = new competitionDaoImpl();
    
    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
    @Override
    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        
        String hql = "from Competition";
        
        int allRows = compDAO.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Competition> list = compDAO.queryByPage(hql, offset, pageSize);
        
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }

	@Override
	public PageBean getPageBeanbyCompType(int pageSize, int page, int comptypeId) {
		
		PageBean pageBean = new PageBean();
        
        String hql = "from Competition where compTypeid="+comptypeId;
        
        int allRows = compDAO.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Competition> list = compDAO.queryByPage(hql, offset, pageSize);
        
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
	}

}
