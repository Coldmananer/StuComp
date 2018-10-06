package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.Student;
import com.zhh.Dao.studentDao;

public class studentDaoImpl implements studentDao{
	private Session session;
	private Transaction tx;

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public boolean login(String number, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Student s where s.stuNum = ? and s.password = ?";
		List<Student> list = session.createQuery(hql).setParameter(
				0, number).setParameter(1, password).list();
		tx.commit();
		if(list.size() != 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Student findByNumber(String number) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Student s where s.stuNum = ?";
		List<Student> list = session.createQuery(hql).setParameter(0, number).list();
		tx.commit();
		for(Student s:list){
			return s;
		}
		return null;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Student s where s.stuId = ?";
		List<Student> list = session.createQuery(hql).setParameter(0, id).list();
		tx.commit();
		for(Student s:list){
			return s;
		}
		return null;
	}
	

    
}
