package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.ArticleDAO;
import com.gsyoa.entity.Article;
import com.gsyoa.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO;
	
	
	
	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public boolean saveArticle(Article Article) {
		// TODO Auto-generated method stub
		return articleDAO.saveArticle(Article);
	}

	@Override
	public boolean deleteArticle(int id) {
		// TODO Auto-generated method stub
		return articleDAO.deleteArticle(id);
	}

	@Override
	public Article SelectArticleById(int id) {
		// TODO Auto-generated method stub
		return articleDAO.SelectArticleById(id);
	}

	@Override
	public List<Article> SelectAllArticle() {
		// TODO Auto-generated method stub
		return articleDAO.SelectAllArticle();
	}

	@Override
	public boolean updateArticle(Article Article) {
		// TODO Auto-generated method stub
		return articleDAO.updateArticle(Article);
	}

}
