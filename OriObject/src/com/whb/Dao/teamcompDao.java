package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Teamcompetion;

public interface teamcompDao {

	// ���澺��
	public void save(Teamcompetion teamcompetion);

	// ���վ����Ų�ѯ
	public List<Teamcompetion> findbyCompId(int compId);

	// ���ն���Ų���
	public List<Teamcompetion> findbyteamId(int teamId);
	
	public Teamcompetion findbyteamIdcompId(int teamId,int compId);
	
	public Teamcompetion findbyteamCompId(int teamCompId);
	
	public void update(Teamcompetion teamcompetion);

	public void delete(Teamcompetion teamcompetion);
	// ��ҳ��ѯ
	public List<Teamcompetion> queryByPage(String hql, int offset, int pageSize);

	public int getAllRowCount(String hql);
	
	public List<Object[]> orderbyscore(int compId);
	
}
