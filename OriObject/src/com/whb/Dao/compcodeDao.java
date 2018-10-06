package com.whb.Dao;

import com.Model.Compcode;

public interface compcodeDao {
	
	// 按照竞赛代码找竞赛类型
	public Compcode findbyCompTypeId(int compTypeId);
	
	//
	// 保存竞赛类型
	public void save(Compcode compcode);
}
