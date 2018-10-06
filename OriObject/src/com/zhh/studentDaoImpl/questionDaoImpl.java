package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Question;
import com.Model.Teamcompetion;
import com.zhh.Dao.questionDao;

public class questionDaoImpl implements questionDao{
	private Session session;
	private Transaction tx;


	@Override
	public List<Question> findByCompId(int compId) {
		// TODO Auto-generated method stub
		List<Question> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Question q where q.competition.compId = ?";
			list = session.createQuery(hql).setParameter(0, compId).list();
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
	public Question findById(int QueId) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Question q where q.questionId = ?";
			List<Question> list = session.createQuery(hql).setParameter(0, QueId).list();
			for(Question q : list){
				return q;
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
