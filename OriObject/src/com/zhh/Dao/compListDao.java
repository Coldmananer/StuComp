package com.zhh.Dao;

import java.util.List;

import com.Model.Complist;

public interface compListDao {
     public List<Complist> findByComp(int compId);
}
