package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.VoucherDAO;
import com.gsyoa.entity.Voucher;

/**
 * ʵ��Impl�������ӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class VoucherDAOImpl implements VoucherDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveVoucher(Voucher voucher) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(voucher);
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
	public boolean deleteVoucher(Voucher voucher) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
		
			session.delete(voucher);
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
	public Voucher SelectVoucherById(int id) {
		Voucher voucher=new Voucher();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			voucher=(Voucher)session.get(Voucher.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return voucher;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> SelectAllVoucher() {
		List<Voucher> voucherList=new ArrayList<Voucher>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Voucher");
			voucherList=(List<Voucher>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return voucherList;
	}

	@Override
	public boolean updateVoucher(Voucher voucher) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(voucher);
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
