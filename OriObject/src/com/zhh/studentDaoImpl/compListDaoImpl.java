package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Competition;
import com.Model.Complist;
import com.zhh.Dao.compListDao;

public class compListDaoImpl implements compListDao{
	Session session;
	Transaction tx;

	@Override
	public List<Complist> findByComp(int compId) {
		// TODO Auto-generated method stub
		List<Complist> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from Complist cl where cl.compId = ? order by cl.rank asc";
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
   
}
