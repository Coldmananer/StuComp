package com.zhh.PageInfo;

import java.util.List;

import com.Model.StuTeam;
import com.zhh.Dao.stuTeamDao;
import com.zhh.studentDaoImpl.stuTeamDaoImpl;

public class MyTeamService {
	private stuTeamDao std = new stuTeamDaoImpl();

	public PageBean<StuTeam> getPageBean(int pageSize, int page, int stuId) {
		PageBean<StuTeam> pgb = new PageBean<StuTeam>();
		String hql = "select st2 from StuTeam st1,StuTeam st2 where st1.student.stuId = " + stuId + "and st2.team = st1.team and st2.leader = true and st1.isPass"
				+ "= true";

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
