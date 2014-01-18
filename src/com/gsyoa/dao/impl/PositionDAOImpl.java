package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.PositionDAO;
import com.gsyoa.entity.Position;

/**
 * ʵ��Implְ��ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class PositionDAOImpl implements PositionDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@Override
	public boolean savePosition(Position position) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(position);
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
	public boolean deletePosition(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Position  p=new Position();
			p.setId(id);
			session.delete(p);
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
	public Position SelectPositionById(int id) {
		Position position=new Position();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			position=(Position)session.get(Position.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return position;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> SelectAllPosition() {
		List<Position> positionList=new ArrayList<Position>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Position");
			positionList=(List<Position>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return positionList;
	}

	@Override
	public boolean updatePosition(Position position) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(position);
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
