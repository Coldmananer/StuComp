package com.zhh.Dao;

import java.util.List;

import com.Model.Teamcompetion;

public interface teamCompDao {
    public void save(Teamcompetion teamComp);
    public void update(Teamcompetion teamComp);
    
    public List<Teamcompetion> findMyAplComp(int teamId);
    public List<Teamcompetion> findMyRunningComp(int teamId);
    public List<Teamcompetion> findMyEndComp(int teamId);
    public Teamcompetion findMyTC(int compId,int stuId);
    public Teamcompetion findPTC(int compId,int stuId);
    public boolean reApl(int teamId,int compId);
}
