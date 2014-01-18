package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Article;
/**
 * 文章Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface ArticleService {
	/**
	 * 保存文章
	 * @param Article	文章实体
	 * @return	保存后的实体
	 */
	public boolean saveArticle(Article Article);	
	
	/**
	 * 删除文章
	 * @param id	文章Id
	 * @return	布尔型
	 */
	public boolean deleteArticle(int id);
	
	/**
	 * 根据Id查询文章
	 * @param id	文章Id
	 * @return	文章实体
	 */
	public Article SelectArticleById(int id);
	
	/**
	 * 查询所有文章
	 * @return	List<Article>  文章数列实体
	 */
	public List<Article> SelectAllArticle();
	
	/**
	 * 更新文章
	 * @param Article	文章实体
	 * @return	修改后的文章实体
	 */
	public boolean updateArticle(Article Article);
	
}
