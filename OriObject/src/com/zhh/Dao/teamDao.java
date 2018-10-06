package com.zhh.Dao;

import com.Model.Team;
import com.zhh.PageInfo.PageBean;

public interface teamDao {
      public void save(Team team);
      public Team findByName(String name);
      public Team findByTeamId(int teamId);
      public void findAll(PageBean<Team> page);
      public void update(Team team);
}
