package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Teamcompetion;

public interface teamcompetionDao {
	
	public void updateTeamcompetion(Teamcompetion teamcompetion);
	
	public Teamcompetion findbyCompIdteamId(int CompId,int teanId);
	
	// ���վ������Ͳ����Ŷ�_����
	public List<Teamcompetion> findbyCompId(int CompId);

	// ��ҳ��ѯ
	public List<Teamcompetion> queryByPage(String hql, int offset, int pageSize);

	public int getAllRowCount(String hql);
	
}
