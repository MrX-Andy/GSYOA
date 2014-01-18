package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.VoucherInfoDAO;
import com.gsyoa.entity.VoucherInfo;

/**
 * ʵ��Impl��������ϸ�ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class VoucherInfoDAOImpl implements VoucherInfoDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@Override
	public boolean saveVoucherInfo(VoucherInfo voucherInfo) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(voucherInfo);
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
	public boolean deleteVoucherInfo(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			VoucherInfo  v=new VoucherInfo();
			v.setId(id);
			session.delete(v);
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
	public VoucherInfo SelectVoucherInfoById(int id) {
		VoucherInfo voucherInfo=new VoucherInfo();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			voucherInfo=(VoucherInfo)session.get(VoucherInfo.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return voucherInfo;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VoucherInfo> SelectAllVoucherInfo() {
		List<VoucherInfo> voucherInfoList=new ArrayList<VoucherInfo>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from VoucherInfo");
			voucherInfoList=(List<VoucherInfo>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return voucherInfoList;
	}

	@Override
	public boolean updateVoucherInfo(VoucherInfo voucherInfo) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(voucherInfo);
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
