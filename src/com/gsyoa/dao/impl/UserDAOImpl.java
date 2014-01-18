package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.UserDAO;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;

/**
 * ʵ��Impl�û��ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 * Τ���� 2013��12��14�� ���Ӷ�Զ����������������
 */
public class UserDAOImpl implements UserDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveUser(User user) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(user);
			tx.commit();
			rs=true;			
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();       //�ر�session
		}
		return rs;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			User  u=new User();
			u.setId(id);
			session.delete(u);
			tx.commit();
			rs=true;
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return rs;
	}

	@Override
	public User SelectUserById(int id) {
		User user=new User();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from User where id="+id);
			if(query.list().size()>0)user=(User)query.list().get(0);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return user;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> SelectAllUser() {
		List<User> userList=new ArrayList<User>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from User");
			userList=(List<User>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return userList;
	}

	@Override
	public boolean updateUser(User user) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(user);
			tx.commit();
			rs=true;		
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return rs;
	}
	@Override	//�����û��ǳ� ���� �û���Ϣ
	public User selectUserByName(String name) {
		User user=new User();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from User where name="+name);
			if(query.list().size()>0) user=(User)query.list().get(0);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return user;		
	}

}
