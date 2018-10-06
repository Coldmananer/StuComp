package com.zhh.Dao;

import com.Model.Teamcompetion;
import com.Model.Works;

public interface worksDao {
    public void save(Works works);
    public void update(Works works);
    
    public Works judgeResubmit(int queId,Teamcompetion tc);
}
