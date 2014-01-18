package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.TypeDAO;
import com.gsyoa.entity.Type;

/**
 * 实现Impl申请单类别接口
 * @author yang_小新
 * @date 2013年12月12日
 */
public class TypeDAOImpl implements TypeDAO {
	SessionFactory sessionFactory;	//声明Session工厂
	//sessionFactory 的Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveType(Type Type) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//获取session
		Transaction tx=session.beginTransaction();
		try{
			session.save(Type);
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
	public boolean deleteType(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Type  t=new Type();
			t.setId(id);
			session.delete(t);
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
	public Type SelectTypeById(int id) {
		Type type=new Type();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			type=(Type)session.get(Type.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return type;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> SelectAllType() {
		List<Type> typeList=new ArrayList<Type>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Type");
			typeList=(List<Type>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return typeList;
	}

	@Override
	public boolean updateType(Type type) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(type);
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
