package com.whb.Dao;

import java.util.List;

import com.Model.StuTeam;

public interface stuteamDao {

	public List<StuTeam> findbyTeamId(int teamId);
	
}
