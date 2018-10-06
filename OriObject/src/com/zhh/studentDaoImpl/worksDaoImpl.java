package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Teamcompetion;
import com.Model.Works;
import com.zhh.Dao.worksDao;

public class worksDaoImpl implements worksDao {
	Session session;
	Transaction tx;

	@Override
	public void save(Works works) {
		// TODO Auto-generated method stub
        try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(works);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Works judgeResubmit(int queId, Teamcompetion tc) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Works w where w.question = ? and question.teamcompetion = ?";
			List<Works> list = session.createQuery(hql).setParameter(0, queId).setParameter(1, tc).list();
			for(Works w:list){
				return w;
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
	public void update(Works works) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(works);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

}
