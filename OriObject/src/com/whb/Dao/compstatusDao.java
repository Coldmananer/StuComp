package com.whb.Dao;

import com.Model.Compcode;
import com.Model.Compstatus;

public interface compstatusDao {

	// 按照竞赛代码找竞赛类型
	public Compstatus findbyCompStatusId(int CompStatusId);

}
