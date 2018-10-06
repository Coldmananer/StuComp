package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Teamcompetion;

public interface teamcompetionDao {
	
	public void updateTeamcompetion(Teamcompetion teamcompetion);
	
	public Teamcompetion findbyCompIdteamId(int CompId,int teanId);
	
	// 按照竞赛类型查找团队_竞赛
	public List<Teamcompetion> findbyCompId(int CompId);

	// 分页查询
	public List<Teamcompetion> queryByPage(String hql, int offset, int pageSize);

	public int getAllRowCount(String hql);
	
}
