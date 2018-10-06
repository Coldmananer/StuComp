package com.whb.util;

public interface  CompetitionService {
	
	public PageBean getPageBean(int pageSize, int page);

	public PageBean getPageBeanbyCompType(int pageSize, int page,int comptypeId);
}
