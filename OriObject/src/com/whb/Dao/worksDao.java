package com.whb.Dao;

import java.util.List;

import com.Model.Works;

public interface worksDao {

	public void save(Works work);
	
	public Works findbyWorkId(int workId);
	
	public List<Works> findbyTeamCompId(int teamCompId);
	
	public void update(Works work);
	
	public List<Object> gettotalScore(int teamCompId);
}
