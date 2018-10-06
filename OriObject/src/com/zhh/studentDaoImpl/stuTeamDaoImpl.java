package com.zhh.studentDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateSessionFactory;
import com.Model.StuTeam;
import com.zhh.Dao.stuTeamDao;

public class stuTeamDaoImpl implements stuTeamDao{
	private Session session;
	private Transaction tx;
	
	@Override
	public void save(StuTeam st) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(st);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public StuTeam findById(Integer stuteamId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.stuteamid = ?";
			list = session.createQuery(hql).setParameter(0, stuteamId).list();
			tx.commit();
			for(StuTeam st:list){
				return st;
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
	public List<StuTeam> findMembers(int teamId) {
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.team.teamId = ? and st.isPass=true";
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
	public List<StuTeam> findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.student.stuId = ?";
			list = session.createQuery(hql).setParameter(0, studentId).list();
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
	public List<StuTeam> queryByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		    List<StuTeam> list = null;
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
	public List<StuTeam> findByTeamId(int teamId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.team.teamId = ?";
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
	public List<StuTeam> findNotPassMember(int teamId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.team.teamId=? and st.isPass=false";
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
	public void update(StuTeam st) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.update(st);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void delete(StuTeam st) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.delete(st);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public List<StuTeam> findLeaderTeam(int studentId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.role = '队长' and st.student.stuId = ?";
			list = session.createQuery(hql).setParameter(0, studentId).list();
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
	public int findMemberNum(int teamId) {
		// TODO Auto-generated method stub
		int memberNum = 0;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.team.teamId = ?";
			memberNum = session.createQuery(hql).setParameter(0, teamId).list().size();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return memberNum;
	}

	@Override
	public StuTeam findIndividualTeam(int stuId) {
		// TODO Auto-generated method stub
		List<StuTeam> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.role = '个人' and st.student.stuId = ?";
			list = session.createQuery(hql).setParameter(0, stuId).list();
			tx.commit();
			for(StuTeam st:list){
				return st;
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
	public Boolean reAppleTeam(int teamId, int stuId) {
		// TODO Auto-generated method stub
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "from StuTeam st where st.team.teamId = ? and st.student.stuId = ?";
			int size = session.createQuery(hql).setParameter(0, teamId).setParameter(1, stuId).list().size();
			tx.commit();
			if(size == 0){
				return false;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return true;
	}
	
}
