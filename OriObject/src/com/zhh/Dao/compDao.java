package com.zhh.Dao;

import java.util.List;

import com.Model.Competition;

public interface compDao {
     public Competition findById(int compId);
     public List<Competition> findAplComp();
     public List<Competition> findRunningComp();
     public List<Competition> findEndComp();
     
     public List<Competition> quryByPage(String hql, int offset, int pageSize);
     public int getAllRowCount(String hql);
}
