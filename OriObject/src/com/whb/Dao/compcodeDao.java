package com.whb.Dao;

import com.Model.Compcode;

public interface compcodeDao {
	
	// ���վ��������Ҿ�������
	public Compcode findbyCompTypeId(int compTypeId);
	
	//
	// ���澺������
	public void save(Compcode compcode);
}
