package com.gsyoa.test;



import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Article;
import com.gsyoa.entity.User;
import com.gsyoa.service.ArticleService;
/**
 * ���¹���
 * @author yang_С��
 * @date 2013��12��13��
 */
public class ArticleTest {

	  private static ArticleService articleService;	
			@BeforeClass
			public static void setUpBeforeClass() throws Exception {
				try {
					@SuppressWarnings("resource")
					ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					articleService = (ArticleService)applicationContext.getBean("articleService");					
			} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * �������¹���-���Գɹ�		
	 */			
	@Test
	public void testSaveArticle() {
		
		Article article=new Article();
		article.setColor("��ɫ");
		article.setContent("���ñ�ҵ�������-OAϵͳ����-Τ�������ƽ�ΰ������¡�������");
		article.setCreateTime(new Date());
		article.setTitle("��ҵ����");
		article.setUpdateTime(new Date());
		article.setUserId(new User(1));		
		articleService.saveArticle(article);	
		System.out.println("-------------"+article.getContent());
	}
/**
 * ɾ�����¹���-���Գɹ�
 */
	@Test
	public void testDeleteArticle() {
	boolean b=	articleService.deleteArticle(1);
		
		if(b==true){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
/**
 * ����id��ѯ���¹���-���Գɹ�
 */
	@Test
	public void testSelectArticleById() {
		   Article article=  articleService.SelectArticleById(1);
		   System.out.println("�������ݣ�"+article.getContent()+" ----����  "+article.getTitle());	

	}
/**
 * ��ѯȫ�����¹���-���Գɹ�
 */
	@Test
	public void testSelectAllArticle() {
		List<Article> list=(List<Article>)articleService.SelectAllArticle();		
		System.out.println("�������ݣ�"+list.get(0).getContent());
	}

	/**
	 * �޸����¹���-���Գɹ�
	 */
	@Test
	public void testUpdateArticle() {
		Article article=  articleService.SelectArticleById(1);
		 System.out.println("�޸�ǰ��"+article.getContent()+"   "+article.getUpdateTime());
		 article.setContent(article.getContent()+"��һ���޸�");
		 article.setUpdateTime(new Date());
		 articleService.updateArticle(article);
		 Article article2=  articleService.SelectArticleById(1);
		 System.out.println("�޸ĺ�"+article2.getContent()+"   "+article2.getUpdateTime());
	}

}
