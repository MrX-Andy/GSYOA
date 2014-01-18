package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.Article;

/**
 * ���¹���DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface ArticleDAO {

	/**
	 * �������¹�����Ϣ
	 * @param Article ���¹���ʵ��
	 * @return boolean
	 */
	public boolean saveArticle(Article Article);	
	
	/**
	 * ɾ�����¹�����Ϣ
	 * @param id ���¹���id
	 * @return boolean
	 */
	public boolean deleteArticle(int id);
	
	/**
	 * ����id��ѯ���¹�����Ϣ
	 * @param id ���¹���id
	 * @return Article
	 */
	public Article SelectArticleById(int id);
	
	/**
	 *��ѯȫ�����¹���
	 * @return List<Article>
	 */
	public List<Article> SelectAllArticle();
	
	/**
	 * �޸����¹�����Ϣ
	 * @param Article ���¹���ʵ��
	 * @return boolean
	 */
	public boolean updateArticle(Article Article);
	
}
