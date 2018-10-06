package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Complist;

public interface complistDao {
	
	public void save(Complist complist);
	
	public void update(Complist complist);
	
	public Complist findbyComplistId(int complistId);
	
	public Complist findbyCompIdandteamId(int compId,int teamId);
	
	public List<Complist> findbyCompId(int compId);

	// ∑÷“≥≤È—Ø
	public List<Complist> queryByPage(String hql, int offset, int pageSize);

	public int getAllRowCount(String hql);

	public void delete(Complist complist);
}
