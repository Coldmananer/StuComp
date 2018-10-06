package com.zhh.Dao;

import java.util.List;

import com.Model.Student;

public interface studentDao {
	public void save(Student student);
	public void update(Student student);
	public boolean login(String number,String password);
	public Student findByNumber(String number);
	public Student findById(Integer id);
	
}
