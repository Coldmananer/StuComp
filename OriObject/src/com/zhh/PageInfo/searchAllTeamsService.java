package com.zhh.PageInfo;

import java.util.List;

import com.Model.StuTeam;
import com.zhh.Dao.stuTeamDao;
import com.zhh.studentDaoImpl.stuTeamDaoImpl;

public class searchAllTeamsService {
      
	private stuTeamDao std = new stuTeamDaoImpl();
	public PageBean<StuTeam> getPageBean(int pageSize, int page, String ref) {
		PageBean<StuTeam> pgb = new PageBean<StuTeam>();
		String hql = "from StuTeam as st where st.student.stuNum = '" + ref + "' or st.team.teamName = '" + 
		ref + "' or st.student.stuName = '" + ref + "' and st.role = '�ӳ�'";

		int allRows = std.getAllRowCount(hql);
		int totalPage = pgb.getTotalPages(pageSize, allRows);
		int currentPage = pgb.getCurPage(page);
		int offset = pgb.getCurrentPageOffset(pageSize, currentPage);

		List<StuTeam> list = std.queryByPage(hql, offset, pageSize);

		System.out.println(list);

		pgb.setAllRows(allRows);
		pgb.setCurrentPage(currentPage);
		pgb.setList(list);
		pgb.setTotalPage(totalPage);

		return pgb;
	}
	
}
