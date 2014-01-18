package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.MessagesReplyDAO;
import com.gsyoa.entity.MessagesReply;
/**
 * 信息回复处理类
 * @author Hello_海生
 * @date 2013年12月19日
 */
public class MessagesReplyDAOImpl implements MessagesReplyDAO {
	SessionFactory sessionFactory;	//声明Session工厂
	//sessionFactory 的Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveMessagesReply(MessagesReply messagesReply) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//获取session
		Transaction tx=session.beginTransaction();
		try{
			session.save(messagesReply);
			tx.commit();
			rs=true;						
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();       //关闭session
		}
		return rs;
	}

	@Override
	public boolean deleteMessagesReply(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			MessagesReply  m=new MessagesReply();
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
	public MessagesReply selectMessagesReplyById(int id) {
		MessagesReply messagesReply=new MessagesReply();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			messagesReply=(MessagesReply)session.get(MessagesReply.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messagesReply;		
	}

	@Override
	public List<MessagesReply> selectAllMessages() {
		List<MessagesReply> messagesReplyList=new ArrayList<MessagesReply>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from MessagesReply");
			messagesReplyList=(List<MessagesReply>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messagesReplyList;
	}

	@Override
	public List<MessagesReply> selectMessagesReplyByMessagesId(int id) {
		List<MessagesReply> messagesReplyList=new ArrayList<MessagesReply>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from MessagesReply where messagesId="+id);
			messagesReplyList=(List<MessagesReply>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return messagesReplyList;
	}

	@Override
	public boolean updateMessagesReply(MessagesReply messagesReply) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(messagesReply);
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
