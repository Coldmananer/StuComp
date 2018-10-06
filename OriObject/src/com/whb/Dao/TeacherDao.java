package com.whb.Dao;

import java.util.List;

import com.Model.Teacher;

public interface TeacherDao {
	public int save(Teacher teacher) throws Exception;
	public void update(Teacher teacher) throws Exception;
	public Teacher findByteaId(int teaId)throws Exception;
	public List<Teacher> findBycompType(int compType)throws Exception;
}
