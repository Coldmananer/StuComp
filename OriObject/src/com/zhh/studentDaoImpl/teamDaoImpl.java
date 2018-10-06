package com.zhh.studentDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Team;
import com.zhh.Dao.teamDao;
import com.zhh.PageInfo.PageBean;

public class teamDaoImpl implements teamDao{
	private Session session;
	private Transaction tx;
	
	
	@Override
	public void save(Team team) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(team);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}


	@Override
	public Team findByName(String name) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		String hql = "from Team t where t.teamName = ?";
		List<Team> list = session.createQuery(hql).setParameter(0, name).list();
		tx.commit();
		for(Team t : list){
			return t;
		}
		return null;
	}


	@Override
	public void findAll(PageBean<Team> page) {
		// TODO Auto-generated method stub
		List<Team> list = new ArrayList<Team>();
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		
	}
    
	@Override
	public Team findByTeamId(int teamId) {

		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		String hql = "from Team t where t.teamId = ?";
		List<Team> list = session.createQuery(hql).setParameter(0, teamId).list();
		tx.commit();
		for(Team t : list){
			return t;
		}
		return null;
	}


	@Override
	public void update(Team team) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(team);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
}
