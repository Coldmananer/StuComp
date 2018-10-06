package com.whb.Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Model.Compcode;
import com.Model.Competition;
import com.Model.Complist;
import com.Model.Compstatus;
import com.Model.StuTeam;
import com.Model.Teamcompetion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.compcodeDao;
import com.whb.Dao.competitionDao;
import com.whb.Dao.complistDao;
import com.whb.Dao.compstatusDao;
import com.whb.Dao.stuteamDao;
import com.whb.Dao.teamcompDao;
import com.whb.Dao.teamcompetionDao;
import com.whb.Dao.worksDao;
import com.whb.Dao.impl.compcodeDaoImpl;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.Dao.impl.complistDaoImpl;
import com.whb.Dao.impl.compstatusDaoImpl;
import com.whb.Dao.impl.stuteamDaoImpl;
import com.whb.Dao.impl.teamcompDaoImpl;
import com.whb.Dao.impl.teamcompetionDaoImpl;
import com.whb.Dao.impl.worksDaoImpl;
import com.whb.util.ComplistPageBean;
import com.whb.util.ComplistService;
import com.whb.util.QuestionPageBean;
import com.whb.util.QuestionService;
import com.whb.util.TeamCompPageBean;
import com.whb.util.TeamcompService;

public class compManagesAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CompId;
	private String teamId;
	private int page;
    private String compName;
    private String comptypeid;
    private String compIntro;
    private String memberNum;


	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getComptypeid() {
		return comptypeid;
	}

	public void setComptypeid(String comptypeid) {
		this.comptypeid = comptypeid;
	}

	public String getCompIntro() {
		return compIntro;
	}

	public void setCompIntro(String compIntro) {
		this.compIntro = compIntro;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
	
	private TeamcompService teamcompService = new TeamcompService();
	
	
	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}
	
	//�����Ա����ť�����¼�
	public String personnelManage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int compId;
		System.out.println(CompId);
		try {
			if(CompId == null)
				CompId = (String)request.getAttribute("CompId");
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		//teamcomp�ķ�ҳ��ʾ
		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page,compId);
       
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
		
		//����compid��ȡcompetition
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
        
		return SUCCESS;
	}
	
	// �����ֹ���������¼�
	public String endSignUpComp() throws Exception {
		Competition competition = (Competition) ActionContext.getContext().getSession().get("competition");
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Compstatus compstatus = compstatusdao.findbyCompStatusId(2);
		//System.out.println("!!!");
		System.out.println(compstatus.getCompStateName());
		competition.setCompstatus(compstatus);
		competitionDao competitiondao = new competitionDaoImpl();
		competitiondao.update(competition);

		ActionContext.getContext().getSession().remove("competition");
		ActionContext.getContext().getSession().put("competition", competition);

		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page, competition.getCompId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	// �����ʼ������ť�����¼�
	public String startComp() throws Exception {
		Competition competition = (Competition) ActionContext.getContext().getSession().get("competition");
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Compstatus compstatus = compstatusdao.findbyCompStatusId(3);
		System.out.println(compstatus.getCompStateName());
		competition.setCompstatus(compstatus);
		//��¼��ʼ������ʱ��
		Timestamp time= new Timestamp(System.currentTimeMillis());
		competition.setObStartTime(time);
		competitionDao competitiondao = new competitionDaoImpl();
		competitiondao.update(competition);

		ActionContext.getContext().getSession().remove("competition");
		ActionContext.getContext().getSession().put("competition", competition);

		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page, competition.getCompId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	// �������������ť�����¼�
	public String endComp() throws Exception {
		Competition competition = (Competition) ActionContext.getContext().getSession().get("competition");
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Compstatus compstatus = compstatusdao.findbyCompStatusId(4);// �ҵ�����������״̬
		System.out.println(compstatus.getCompStateName());
		competition.setCompstatus(compstatus);
		//��¼����������ʱ��
		Timestamp time= new Timestamp(System.currentTimeMillis());
		competition.setObEndTime(time);
		competitionDao competitiondao = new competitionDaoImpl();
		competitiondao.update(competition);

		ActionContext.getContext().getSession().remove("competition");
		ActionContext.getContext().getSession().put("competition", competition);

		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page, competition.getCompId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("pageBean");
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	// ���ְ�ť
	public String preGradeList() throws Exception {
	
		int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		//teamcomp�ķ�ҳ��ʾ
		TeamCompPageBean pageBean = teamcompService.getPageBean(5, page,compId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
		
		//����compid��ȡcompetition
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		//�ֱ����request��session�������
		request.setAttribute("competition", competition);
		ActionContext.getContext().getSession().remove("competition");
        ActionContext.getContext().getSession().put("competition", competition);
        //��complist�л�ȡ�ַܷ���request
        Map<Integer, Integer> grade = new HashMap<Integer, Integer>();
        complistDao complistdao = new complistDaoImpl();
        for(Teamcompetion teamcompetion:pageBean.getList()){
        	Complist complist = complistdao.findbyCompIdandteamId
        			(teamcompetion.getCompetition().getCompId(),
        					teamcompetion.getTeam().getTeamId());
        	if(complist !=null)
        	{
        		System.out.println(teamcompetion.getTeamCompId()+":"+complist.getScore());
        		grade.put(teamcompetion.getTeamCompId(), complist.getScore());
        	}
        }
        request.setAttribute("grade", grade);
		return SUCCESS;
	}
	
	//���������Ϣ�޸İ�ť�����¼�
	public String compupdate() throws Exception{
		
		competitionDao competitiondao = new competitionDaoImpl();
		try{
			Competition competition = competitiondao.findbyCompId(Integer.parseInt(CompId));
			compcodeDao compcodedao = new compcodeDaoImpl();
			Compcode compcode = compcodedao.findbyCompTypeId(Integer.parseInt(comptypeid));
			competition.setPersonNum(Integer.parseInt(memberNum));
			competition.setCompIntro(compIntro);
			competition.setCompName(compName);
			competition.setCompcode(compcode);
			competitiondao.update(competition);
		}catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	//չʾ��Ŀ�İ�ť
	public String showQuestion() throws Exception{
		int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		//teamcomp�ķ�ҳ��ʾ
		QuestionService questionService = new QuestionService();
		QuestionPageBean pageBean = questionService.getPageBean(5, page,compId);
		//-----
		System.out.println(pageBean.getList().size());
        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//����鿴�񵥰�ť�����¼�   δ��ɣ�����������������������������������������������������
	public String checkCompList() throws Exception{
		int compId = Integer.parseInt(CompId);
		teamcompetionDao teamcompetiondao = new teamcompetionDaoImpl();
		List<Teamcompetion> teamcompetions=teamcompetiondao.findbyCompId(compId);

		HttpServletRequest request = ServletActionContext.getRequest();
		//��ΰѵõ������ݷŵ�request�У�
		return SUCCESS;
	}
	
	//�����ɼ�
	public String uploadscore() throws Exception{
		int compId;
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		competitionDao competitiondao = new competitionDaoImpl();
		compstatusDao compstatusdao = new compstatusDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		Compstatus compstatus = compstatusdao.findbyCompStatusId(5);
		competition.setCompstatus(compstatus);
		//���ý���ʱ��
		Timestamp time= new Timestamp(System.currentTimeMillis());
		competition.setEndTime(time);
		competitiondao.update(competition);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("CompId", CompId);
        return "compmanage";
	}
	
	//�鿴�񵥰�ť
	public String show_complist()throws Exception{
		int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		ComplistService complistService = new ComplistService();
		ComplistPageBean pageBean = complistService.getPageBean(5, page,compId);
//        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);;
		return SUCCESS;
	}
	
	//������Ŀ��ť��
	public String uploadquestion() throws Exception{
		int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();
        competitionDao competitiondao = new competitionDaoImpl();
        compstatusDao compstatusdao = new compstatusDaoImpl();
        Compstatus compstatus = compstatusdao.findbyCompStatusId(2);
        Competition competition = competitiondao.findbyCompId(compId);
        competition.setCompstatus(compstatus);
        competitiondao.update(competition);
        request.setAttribute("CompId", CompId);
		return SUCCESS;
	}
	
	//Ԥ���ɰ񵥡�
	@SuppressWarnings("unchecked")
	public String preGrade() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {	//���޸İ񵥹����޷�����
			if(CompId==null){
				CompId = (String) request.getAttribute("CompId");
				compId =Integer.parseInt(CompId);
			}else{
				return ERROR;
			}
		}
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		complistDao complistdao = new complistDaoImpl();
		teamcompDao teamcompdao = new teamcompDaoImpl();
		stuteamDao stuteamdao = new stuteamDaoImpl();
		worksDao worksdao = new worksDaoImpl();
		List<Complist> complists = complistdao.findbyCompId(compId);//�ҵ��þ�����complist
		List<Complist> lists = new ArrayList<Complist>();//���������complist�ļ���
		//��һ��Ԥ���ɰ�
		if(complists == null && competition.getCompstatus().getCompStateId()==4){
			List<Teamcompetion> teamcompetions = teamcompdao.findbyCompId(compId);
			for(Teamcompetion teamcompetion:teamcompetions){
				if(teamcompetion.getIsPass() != true)
					continue;
				//��ȡ�þ����ö���ĳɼ�
				List<Object> score = worksdao.gettotalScore(teamcompetion.getTeamCompId());
				//���а񵥵���д
				Complist complist = new Complist();
				complist.setCompId(teamcompetion.getCompetition().getCompId());
				//java.lang.Long cannot be cast to java.lang.Integer����취
				//object��������long��
				Number num = null;
				if(score.get(0) != null)
					num = (Number) score.get(0); 
				else
					num = 0;
				complist.setScore(num.intValue());
				System.out.println(teamcompetion.getTeam().getTeamName()+"�ķ���:"+num.intValue());
				complist.setTeamId(teamcompetion.getTeam().getTeamId());
				complist.setTeamName(teamcompetion.getTeam().getTeamName());
				List<StuTeam> teammem = stuteamdao.findbyTeamId(teamcompetion.getTeam().getTeamId());
				//System.out.println("��Ա�У�"+teammem.size());
				//�Զ�Ա�������в���
				String memberName = null;
				for(StuTeam teammember:teammem){
					if(memberName == null){
						memberName = teammember.getStudent().getStuName();
					}else{
						memberName += ";"+teammember.getStudent().getStuName();
					}
				}
				complist.setTeamMembersName(memberName);
				lists.add(complist);
			}
			//��list��������
			Collections.sort(lists, new Comparator(){  
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
			//�������rank��д��
			for(int i=0;i<lists.size();i++){
				if(i==0)
					lists.get(0).setRank(i+1);
				else{
					Complist complist =lists.get(i);
					if(lists.get(i).getScore()==lists.get(i-1).getScore())
						lists.get(i).setRank(lists.get(i-1).getRank());
					else
						lists.get(i).setRank(i+1);
				}
			}
			for(Complist complist:lists){
				complistdao.save(complist);
			}
		}
		//��һ��Ԥ���ɰ񵥽���
		
		ComplistService complistService = new ComplistService();
		ComplistPageBean pageBean = complistService.getPageBean(5, page,compId);
//        HttpServletRequest request = ServletActionContext.getRequest();
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
        
		return SUCCESS;
	}
	

}
