package com.zhh.Dao;

import java.util.List;

import com.Model.Question;
import com.Model.Teamcompetion;

public interface questionDao {
	
    public List<Question> findByCompId(int CompId);
    public Question findById(int QueId);
    
}
