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
	public List<Teamcompetion> findMyAplComp(int teamId) {//�����ҵı����еľ���
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
	public boolean reApl(int teamId, int compId) {//һ֧�����ظ���������
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
	public List<Teamcompetion> findMyRunningComp(int teamId) {//�ҵĽ����еľ���
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
	public List<Teamcompetion> findMyEndComp(int teamId) {//�ҵĽ����ľ���
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
	public Teamcompetion findMyTC(int compId,int stuId) {//�ҵ����Ƕӳ��Ķ���Ĳ�����¼
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "select tc from Teamcompetion as tc,StuTeam as st where tc.competition.compId = ? and tc.team ="
					+ "st.team and st.role = '�ӳ�' and st.student.stuId = ?";
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
	public Teamcompetion findPTC(int compId, int stuId) {//�ҵ����˲�����¼
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "select tc from Teamcompetion as tc,StuTeam as st where tc.competition.compId = ? and tc.team ="
					+ "st.team and st.role = '����' and st.student.stuId = ?";
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
