package com.gsyoa.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.SystemInfoDAO;
import com.gsyoa.entity.SystemInfo;

/**
 * ʵ��Implϵͳ��Ϣ�ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class SystemInfoDAOImpl implements SystemInfoDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean saveSystemInfo(SystemInfo systemInfo) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(systemInfo);
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
	public boolean updateSystemInfo(SystemInfo systemInfo) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(systemInfo);
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
	public SystemInfo SelectSystemInfo(int id) {
		SystemInfo systemInfo=new SystemInfo();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			systemInfo=(SystemInfo)session.get(SystemInfo.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return systemInfo;
	}

}
