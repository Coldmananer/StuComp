package com.whb.Dao;

import java.util.List;

import com.Model.Competition;

public interface competitionDao {

	//���վ���ID���Ҿ���
	public Competition findbyCompId(int CompId);
	//���澺��
	public void save(Competition competition);
	//!���¾���
	public void update(Competition competition);
	//���վ������Ͳ��Ҿ���
	public List<Competition> findbyCompTypeid(int compTypeid);
	//���վ�������ģ����ѯ
	public List<Competition> findbyCompName(String CompName);
	//��ҳ��ѯ
	public List<Competition> queryByPage(String hql, int offset, int pageSize);
    
	public List<Competition> findAll();
	
    public int getAllRowCount(String hql);
	
}
