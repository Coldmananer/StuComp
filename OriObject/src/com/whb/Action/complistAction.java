package com.whb.Action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Complist;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.complistDao;
import com.whb.Dao.impl.complistDaoImpl;

public class complistAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String compListId;
	private String score;
	private String tip;
	private String CompId;
	private String teamName;
	private String teamMembersName;
	private String teamId;
	
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamMembersName() {
		return teamMembersName;
	}
	public void setTeamMembersName(String teamMembersName) {
		this.teamMembersName = teamMembersName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getCompId() {
		return CompId;
	}
	public void setCompId(String compId) {
		CompId = compId;
	}
	public String getCompListId() {
		return compListId;
	}
	public void setCompListId(String compListId) {
		this.compListId = compListId;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String showdetails()throws Exception{
		complistDao complistdao = new complistDaoImpl();
		Complist complist = complistdao.findbyComplistId(Integer.valueOf(compListId));
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("complist", complist);
		Competition competition=(Competition)ActionContext.getContext().getSession().get("competition");
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String changeComplistdetails()throws Exception{
		complistDao complistdao = new complistDaoImpl();
		Complist complist = complistdao.findbyComplistId(Integer.valueOf(compListId));
		if(tip!=null&&!tip.equals("")){
			complist.setTips(tip);
			complistdao.update(complist);
		}
		if(score!=null&&!score.equals("")){
			//System.out.println("成绩是:"+score+"--");
			complist.setScore(Integer.valueOf(score));
			complistdao.update(complist);
			Competition competition=(Competition)ActionContext.getContext().getSession().get("competition");
			List<Complist> complists = complistdao.findbyCompId(competition.getCompId());
			Collections.sort(complists, new Comparator(){  
		        @Override  
		        public int compare(Object o1, Object o2) {  
		        	Complist complist1=(Complist)o1;  
		        	Complist complist2=(Complist)o2;  
		            if(complist1.getScore()<complist2.getScore()){  
		                return 1;  
		            }else if(complist1.getScore()==complist2.getScore()){  
		                return 0;  
		            }else{  
		                return -1;  
		            }  
		        }             
		    });
			for(int i=0;i<complists.size();i++){
				if(i==0)
					complists.get(0).setRank(i+1);
				else{
					//Complist complist =complists.get(i);
					if(complists.get(i).getScore()==complists.get(i-1).getScore())
						complists.get(i).setRank(complists.get(i-1).getRank());
					else
						complists.get(i).setRank(i+1);
				}
			}
			for(Complist complist_save:complists){
				complistdao.update(complist_save);
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Competition competition=(Competition)ActionContext.getContext().getSession().get("competition");
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String addComplist()throws Exception{
		complistDao complistdao = new complistDaoImpl();
		HttpServletRequest request = ServletActionContext.getRequest();
		Competition competition=(Competition)ActionContext.getContext().getSession().get("competition");
		int compid = competition.getCompId();
		Complist complist = new Complist();
		complist.setCompId(compid);
		try {
			complist.setScore(Integer.valueOf(score));
		} catch (Exception e) {
			return ERROR;
		}
		if(teamId!=null&&!teamId.equals(""))
			complist.setTeamId(Integer.valueOf(teamId));
		complist.setTeamMembersName(teamMembersName);
		complist.setTeamName(teamName);
		complist.setTips(tip);
		complistdao.save(complist);
		//因为新添加了complist，所以要更新排名
		List<Complist> complists = complistdao.findbyCompId(competition.getCompId());
		Collections.sort(complists, new Comparator(){  
	        @Override  
	        public int compare(Object o1, Object o2) {  
	        	Complist complist1=(Complist)o1;  
	        	Complist complist2=(Complist)o2;  
	            if(complist1.getScore()<complist2.getScore()){  
	                return 1;  
	            }else if(complist1.getScore()==complist2.getScore()){  
	                return 0;  
	            }else{  
	                return -1;  
	            }  
	        }             
	    });
		for(int i=0;i<complists.size();i++){
			if(i==0)
				complists.get(0).setRank(i+1);
			else{
				//Complist complist =complists.get(i);
				if(complists.get(i).getScore()==complists.get(i-1).getScore())
					complists.get(i).setRank(complists.get(i-1).getRank());
				else
					complists.get(i).setRank(i+1);
			}
		}
		for(Complist complist_save:complists){
			complistdao.update(complist_save);
		}
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}

	public String  showaddComplist()throws Exception{
		
		return SUCCESS;
	}

	public String resetcomplist()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Competition competition=(Competition)ActionContext.getContext().getSession().get("competition");
		complistDao complistdao = new complistDaoImpl();
		List<Complist> complists = complistdao.findbyCompId(competition.getCompId());
		for(Complist complist:complists){
			complistdao.delete(complist);
		}
		request.setAttribute("CompId", competition.getCompId().toString());
		return SUCCESS;
	}
	
}
