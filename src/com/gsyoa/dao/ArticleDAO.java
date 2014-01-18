package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.Article;

/**
 * 文章公告DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface ArticleDAO {

	/**
	 * 保存文章公告信息
	 * @param Article 文章公告实体
	 * @return boolean
	 */
	public boolean saveArticle(Article Article);	
	
	/**
	 * 删除文章公告信息
	 * @param id 文章公告id
	 * @return boolean
	 */
	public boolean deleteArticle(int id);
	
	/**
	 * 根据id查询文章公告信息
	 * @param id 文章公告id
	 * @return Article
	 */
	public Article SelectArticleById(int id);
	
	/**
	 *查询全部文章公告
	 * @return List<Article>
	 */
	public List<Article> SelectAllArticle();
	
	/**
	 * 修改文章公告信息
	 * @param Article 文章公告实体
	 * @return boolean
	 */
	public boolean updateArticle(Article Article);
	
}
