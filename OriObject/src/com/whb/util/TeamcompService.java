package com.whb.util;

import java.util.ArrayList;
import java.util.List;

import com.Model.Teamcompetion;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.impl.teamcompDaoImpl;

public class TeamcompService {

	private teamcompDao teamcompdao = new teamcompDaoImpl();
    
    /**
     * pageSizeΪÿҳ��ʾ�ļ�¼��
     * pageΪ��ǰ��ʾ����ҳ
     */
	public TeamCompPageBean getPageBean(int pageSize, int page,int CompId)
    {
        TeamCompPageBean pageBean = new TeamCompPageBean();
        
        String hql = "from Teamcompetion where compId="+CompId ;
        
        int allRows = teamcompdao.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Teamcompetion> list = teamcompdao.queryByPage(hql, offset, pageSize);
        int off=0;
        /*ȥ���ظ������չʾ��teamcomp��ʱ�򲻻���ֶ����ͬ�Ķ���.��Ϊ�Ǵ�teamcomp���в��ң�
         * һ��team�μ�һ��comp���ж���teamcomp��¼��������չʾ��ʱ�����ֶ��������ͬ���Ŷӣ���
         * ����Ҳ����һ���ģ�����Ҫ��һ�´����ȥ��ͬ�ظ��Ķ���
         */
        List<Integer> rep = new ArrayList<Integer>();
        List<Teamcompetion> reallist = new ArrayList<Teamcompetion>();
        for(int i=0;i<list.size();i++){
        	Teamcompetion teamcomp=(Teamcompetion)list.get(i);
        	if(!rep.contains(teamcomp.getTeam().getTeamId())){
        		rep.add(teamcomp.getTeam().getTeamId());
        		reallist.add(teamcomp);
        	}else{
        		off++;
        	}
        }
        allRows -= off;
        totalPage -= off/pageSize;
        pageBean.setList(reallist);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }
	
	
	
}
