package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Teamcompetion;

public interface teamcompDao {

	// 保存竞赛
	public void save(Teamcompetion teamcompetion);

	// 按照竞赛号查询
	public List<Teamcompetion> findbyCompId(int compId);

	// 按照队伍号查找
	public List<Teamcompetion> findbyteamId(int teamId);
	
	public Teamcompetion findbyteamIdcompId(int teamId,int compId);
	
	public Teamcompetion findbyteamCompId(int teamCompId);
	
	public void update(Teamcompetion teamcompetion);

	public void delete(Teamcompetion teamcompetion);
	// 分页查询
	public List<Teamcompetion> queryByPage(String hql, int offset, int pageSize);

	public int getAllRowCount(String hql);
	
	public List<Object[]> orderbyscore(int compId);
	
}
