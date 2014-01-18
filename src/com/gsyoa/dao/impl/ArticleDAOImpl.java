package com.gsyoa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gsyoa.dao.ArticleDAO;
import com.gsyoa.entity.Article;

/**
 * 实现Impl文章公告接口
 * @author yang_小新
 * @date 2013年12月12日
 */
public class ArticleDAOImpl implements ArticleDAO {
	SessionFactory sessionFactory;	//声明Session工厂
	//sessionFactory 的Get set
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean saveArticle(Article Article) {
		boolean rs=false;
		Session session=sessionFactory.openSession(); 	//获取session
		Transaction tx=session.beginTransaction();
		try{
			session.save(Article);
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
	public boolean deleteArticle(int id) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Article  a=new Article();
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
	public Article SelectArticleById(int id) {
		Article article=new Article();
		Session  session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			article=(Article)session.get(Article.class, id);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return article;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> SelectAllArticle() {
		List<Article> articleList=new ArrayList<Article>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Article");
			articleList=(List<Article>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return articleList;
	}

	@Override
	public boolean updateArticle(Article Article) {
		boolean rs=false;
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(Article);
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
