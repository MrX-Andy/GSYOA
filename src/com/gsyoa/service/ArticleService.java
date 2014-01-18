package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Article;
/**
 * ����Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface ArticleService {
	/**
	 * ��������
	 * @param Article	����ʵ��
	 * @return	������ʵ��
	 */
	public boolean saveArticle(Article Article);	
	
	/**
	 * ɾ������
	 * @param id	����Id
	 * @return	������
	 */
	public boolean deleteArticle(int id);
	
	/**
	 * ����Id��ѯ����
	 * @param id	����Id
	 * @return	����ʵ��
	 */
	public Article SelectArticleById(int id);
	
	/**
	 * ��ѯ��������
	 * @return	List<Article>  ��������ʵ��
	 */
	public List<Article> SelectAllArticle();
	
	/**
	 * ��������
	 * @param Article	����ʵ��
	 * @return	�޸ĺ������ʵ��
	 */
	public boolean updateArticle(Article Article);
	
}
