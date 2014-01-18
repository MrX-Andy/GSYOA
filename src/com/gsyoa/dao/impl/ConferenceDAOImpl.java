package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.ConferenceDAO;
import com.gsyoa.entity.Conference;



/**
 * ʵ��Impl����ӿ�
 * @author �ƽ�ΰ
 * @date 2013��12��27��
 */
public class ConferenceDAOImpl implements ConferenceDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean saveConference(Conference conference) {
		// TODO Auto-generated method stub
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			
			session.save(conference);
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
	public boolean deleteConference(int id) {
		// TODO Auto-generated method stub
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Conference  c=new Conference();
			c.setId(id);
			session.delete(c);
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
	public Conference SelectConferenceById(int id) {
		// TODO Auto-generated method stub
		Conference conference=new Conference();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			conference=(Conference)session.get(Conference.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return conference;	
	}

	@Override
	public List<Conference> SelectAllConference() {
		// TODO Auto-generated method stub
		List<Conference> conferenceList=new ArrayList<Conference>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Conference");
			conferenceList=(List<Conference>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return conferenceList;
	}

	@Override
	public boolean updateConference(Conference conference) {
		// TODO Auto-generated method stub
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(conference);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return rs;
	}

}
