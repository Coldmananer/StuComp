package com.whb.Dao;

import java.util.List;

import com.Model.Competition;
import com.Model.Question;

public interface questionDao {
	
	public void save(Question question);
	
	public void delete(Question question);
	
	public void update(Question question);
	
	public List<Question> findbyCompId(int CompId);
	
	public Question findbyQuestionId(int questionId);
	
	public List<Question> queryByPage(String hql, int offset, int pageSize);
    
    public int getAllRowCount(String hql);

	void updates(List<Question> question);
	
}
