package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.DepartmentDAO;
import com.gsyoa.entity.Department;

/**
 * ʵ��Impl���Žӿ�
 * @author yang_С��
 * @date 2013��12��12��
 */
public class DepartmentDAOImpl implements DepartmentDAO {
	SessionFactory sessionFactory;	//����Session����
	//sessionFactory ��Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveDepartment(Department department) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//��ȡsession
		Transaction tx=session.beginTransaction();
		try{
			session.save(department);
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
	public boolean deleteDepartment(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Department  d=new Department();
			d.setId(id);
			session.delete(d);
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
	public Department SelectDepartmentById(int id) {
		Department department=new Department();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			department=(Department)session.get(Department.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return department;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> SelectAllDepartment() {
		List<Department> departmentList=new ArrayList<Department>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Department");
			departmentList=(List<Department>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return departmentList;
	}

	@Override
	public boolean updateDepartment(Department department) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(department);
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
