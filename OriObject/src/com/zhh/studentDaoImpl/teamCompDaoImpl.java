package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Teamcompetion;
import com.zhh.Dao.teamCompDao;

public class teamCompDaoImpl implements teamCompDao{
	private Session session;
	private Transaction tx;

	@Override
	public void save(Teamcompetion teamComp) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(teamComp);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public List<Teamcompetion> findMyAplComp(int teamId) {//查找我的报名中的竞赛
		// TODO Auto-generated method stub
		List<Teamcompetion> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Teamcompetion tc where tc.team.teamId = ? and tc.competition.compstatus.compStateId = 1";
			list = session.createQuery(hql).setParameter(0, teamId).list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public boolean reApl(int teamId, int compId) {//一支队伍重复报名竞赛
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Teamcompetion tc where tc.team.teamId = ? and tc.competition.compId = ?";
			int size = session.createQuery(hql).setParameter(0, teamId).setParameter(1, compId).list().size();
			if(size > 0){
				return true;
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

	@Override
	public List<Teamcompetion> findMyRunningComp(int teamId) {//我的进行中的竞赛
		// TODO Auto-generated method stubList<Teamcompetion> list = null;
		List<Teamcompetion> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Teamcompetion tc where tc.team.teamId = ? and (tc.competition.compstatus.compStateId = 2 "
					+ "or tc.competition.compstatus.compStateId = 3) and tc.isPass = true";
			list = session.createQuery(hql).setParameter(0, teamId).list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Teamcompetion> findMyEndComp(int teamId) {//我的结束的竞赛
		// TODO Auto-generated method stub
		List<Teamcompetion> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Teamcompetion tc where tc.team.teamId = ? and (tc.competition.compstatus.compStateId = 4 "
					+ "or tc.competition.compstatus.compStateId = 5) and tc.isPass = true";
			list = session.createQuery(hql).setParameter(0, teamId).list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public Teamcompetion findMyTC(int compId,int stuId) {//找到我是队长的队伍的参赛记录
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "select tc from Teamcompetion as tc,StuTeam as st where tc.competition.compId = ? and tc.team ="
					+ "st.team and st.role = '队长' and st.student.stuId = ?";
			List<Teamcompetion> list = session.createQuery(hql).setParameter(0, compId).setParameter(1, stuId).list();
			for(Teamcompetion tc : list){
				return tc;
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}
	
	

	@Override
	public void update(Teamcompetion teamComp) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(teamComp);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Teamcompetion findPTC(int compId, int stuId) {//找到个人参赛记录
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "select tc from Teamcompetion as tc,StuTeam as st where tc.competition.compId = ? and tc.team ="
					+ "st.team and st.role = '个人' and st.student.stuId = ?";
			List<Teamcompetion> list = session.createQuery(hql).setParameter(0, compId).setParameter(1, stuId).list();
			for(Teamcompetion tc : list){
				return tc;
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}

	
}
