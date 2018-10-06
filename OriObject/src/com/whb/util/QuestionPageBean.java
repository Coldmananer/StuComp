package com.whb.util;

import java.util.List;

import com.Model.Question;

public class QuestionPageBean {  
	
	private List<questionFileClass> list; //ͨ��hql�����ݿ��ҳ��ѯ������list����
    
    private int allRows; //�ܼ�¼��
    
    private int totalPage; //��ҳ��
    
    private int currentPage; //��ǰҳ

    public List<questionFileClass> getList()
    {
        return list;
    }

    public void setList(List<questionFileClass> list)
    {
        this.list = list;
    }

    public int getAllRows()
    {
        return allRows;
    }

    public void setAllRows(int allRows)
    {
        this.allRows = allRows;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }
    
    /**
     * �õ���ҳ��
     * @param pageSize ÿҳ��¼��
     * @param allRows  �ܼ�¼��
     * @return ��ҳ��
     */
    public int getTotalPages(int pageSize, int allRows)
    {
        int totalPage = (allRows % pageSize == 0)? (allRows / pageSize): (allRows / pageSize) + 1;
        
        return totalPage;
    }
    
    /**
     * �õ���ǰ��ʼ��¼��
     * @param pageSize ÿҳ��¼��
     * @param currentPage ��ǰҳ
     * @return
     */
    public int getCurrentPageOffset(int pageSize, int currentPage)
    {
        int offset = pageSize * (currentPage - 1);
        
        return offset;
    }
    
    /**
     * �õ���ǰҳ�� ���Ϊ0 ��ʼ��һҳ������Ϊ��ǰҳ
     * @param page
     * @return
     */
    public int getCurPage(int page)
    {
        int currentPage = (page == 0)? 1: page;
        
        return currentPage;
    }
}