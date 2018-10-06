package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Competition;
import com.Model.Teamcompetion;
import com.zhh.Dao.compDao;

public class compDaoImpl implements compDao {
	private Session session;
	private Transaction tx;

	@Override
	public Competition findById(int compId) {
		// TODO Auto-generated method stub
        try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Competition comp where comp.compId = ?";
			List<Competition> list = session.createQuery(hql).setParameter(0, compId).list();
			
			for(Competition c:list){
				return c;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
        return null;
	}
	
	@Override
	public List<Competition> findAplComp(){
		List<Competition> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Competition c where c.compstatus.compStateId = 1";
			list = session.createQuery(hql).list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competition> quryByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		List<Competition> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			list = query.list();
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
	public int getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		int rowCount = 0;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			rowCount = query.list().size();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return rowCount;
	}

	@Override
	public List<Competition> findRunningComp() {
		List<Competition> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Competition c where c.compstatus.compStateId = 2 or c.compstatus.compStateId = 3";
			list = session.createQuery(hql).list();
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
	public List<Competition> findEndComp() {
		List<Competition> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Competition c where c.compstatus.compStateId = 4 or c.compstatus.compStateId = 5";
			list = session.createQuery(hql).list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

}
