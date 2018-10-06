package com.whb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Model.Competition;
import com.Model.Question;
import com.Model.Teamcompetion;
import com.whb.Dao.competitionDao;
import com.whb.Dao.questionDao;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.Dao.impl.questionDaoImpl;
import com.whb.Dao.impl.teamcompDaoImpl;

public class QuestionService {

	private questionDao questiondao = new questionDaoImpl();
    
    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
	public QuestionPageBean getPageBean(int pageSize, int page,int CompId)
    {
		QuestionPageBean pageBean = new QuestionPageBean();
        
        String hql = "from Question where compId="+CompId;
        
        int allRows = questiondao.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Question> list1 = questiondao.queryByPage(hql, offset, pageSize);
        List<questionFileClass> list = new ArrayList<questionFileClass>();
        //把question转换成questionfileclass,这样方便显示下载链接
        for(Question q:list1){
        	questionFileClass questionfileclass = new questionFileClass();
        	questionfileclass.setQuestion(q);
        	if(q.getFileDesc()!=null){
        		String[] FileDescArr = q.getFileDesc().split(";");
        		String[] FileNameArr = q.getFileName().split(";");
        		Map<String,String> map = new HashMap<String, String>();
        		for(int i=0;i<FileDescArr.length;i++){
//        			System.out.println("这是"+i+"--"+FileDescArr[i]+":"+FileNameArr[i]);
        			map.put(FileDescArr[i], FileNameArr[i]);
        		}
        		questionfileclass.setFile(map);
        	}
        	list.add(questionfileclass);
        }
       
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }
	


	
}
