package com.whb.Dao;

import java.util.List;

import com.Model.Competition;

public interface competitionDao {

	//按照竞赛ID查找竞赛
	public Competition findbyCompId(int CompId);
	//保存竞赛
	public void save(Competition competition);
	//!更新竞赛
	public void update(Competition competition);
	//按照竞赛类型查找竞赛
	public List<Competition> findbyCompTypeid(int compTypeid);
	//按照竞赛名称模糊查询
	public List<Competition> findbyCompName(String CompName);
	//分页查询
	public List<Competition> queryByPage(String hql, int offset, int pageSize);
    
	public List<Competition> findAll();
	
    public int getAllRowCount(String hql);
	
}
