package com.gsyoa.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.ApplyDAO;
import com.gsyoa.entity.Apply;

/**
 * ʵ��Impl���뵥�ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class ApplyDAOImpl implements ApplyDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveApply(Apply apply) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(apply);
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
	public boolean deleteApply(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Apply  a=new Apply();
			a.setId(id);
			session.delete(a);
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
	public Apply SelectApplyById(int id) {
		Apply apply=new Apply();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			apply=(Apply)session.get(Apply.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return apply;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apply> SelectAllApply() {
		List<Apply> applyList=new ArrayList<Apply>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Apply");
			applyList=(List<Apply>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return applyList;
	}

	@Override
	public boolean updateApply(Apply apply) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(apply);
			tx.commit();
			rs=true;		
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return rs;
	}

}
