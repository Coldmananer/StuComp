package com.zhh.Dao;

import java.util.List;

import com.Model.StuTeam;

public interface stuTeamDao {
    public void save(StuTeam st);
    public StuTeam findById(Integer stuteamId);
    public int findMemberNum(int teamId);
    public List<StuTeam> findMembers(int teamId);
    public List<StuTeam> findByStudentId(int studentId);
    public List<StuTeam> findLeaderTeam(int studentId);
    public List<StuTeam> findByTeamId(int teamId);
    public List<StuTeam> findNotPassMember(int teamId);
    public StuTeam findIndividualTeam(int stuId);
    public Boolean reAppleTeam(int teamId,int stuId);
    public void update(StuTeam st);
    public void delete(StuTeam st);
    
    public List<StuTeam> queryByPage(String hql, int offset, int pageSize);
    public int getAllRowCount(String hql);
}
