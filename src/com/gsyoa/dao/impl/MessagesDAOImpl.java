package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.MessagesDAO;
import com.gsyoa.entity.Messages;

/**
 * ʵ��Impl��Ѷ�ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 * 2013��12��16�գ�Τ���� ���� �����û�Id ��ѯ�����û��µ�����վ����
 */
public class MessagesDAOImpl implements MessagesDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveMessages(Messages messages) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(messages);
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
	public boolean deleteMessages(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Messages  m=new Messages();
			m.setId(id);
			session.delete(m);
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
	public Messages SelectMessagesById(int id) {
		Messages messages=new Messages();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			messages=(Messages)session.get(Messages.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messages;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> SelectAllMessages() {
		List<Messages> messagesList=new ArrayList<Messages>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Messages");
			messagesList=(List<Messages>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messagesList;
	}

	@Override
	public boolean updateMessages(Messages messages) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(messages);
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
	public List<Messages> SelectMessagesByUserId(int id) {
		List<Messages> messagesList=new ArrayList<Messages>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Messages where  receiveUserId = "+id +" or sendUserId="+id);
			messagesList=(List<Messages>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messagesList;
	}

}
