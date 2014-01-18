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
 * 文章公告
 * @author yang_小新
 * @date 2013年12月13日
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
	 * 保存文章公告-测试成功		
	 */			
	@Test
	public void testSaveArticle() {
		
		Article article=new Article();
		article.setColor("红色");
		article.setContent("做好毕业设计论文-OA系统开发-韦海生、黄建伟、杨兵新、杨云云");
		article.setCreateTime(new Date());
		article.setTitle("毕业论文");
		article.setUpdateTime(new Date());
		article.setUserId(new User(1));		
		articleService.saveArticle(article);	
		System.out.println("-------------"+article.getContent());
	}
/**
 * 删除文章公告-测试成功
 */
	@Test
	public void testDeleteArticle() {
	boolean b=	articleService.deleteArticle(1);
		
		if(b==true){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
/**
 * 根据id查询文章公告-测试成功
 */
	@Test
	public void testSelectArticleById() {
		   Article article=  articleService.SelectArticleById(1);
		   System.out.println("新闻内容："+article.getContent()+" ----标题  "+article.getTitle());	

	}
/**
 * 查询全部文章公告-测试成功
 */
	@Test
	public void testSelectAllArticle() {
		List<Article> list=(List<Article>)articleService.SelectAllArticle();		
		System.out.println("新闻内容："+list.get(0).getContent());
	}

	/**
	 * 修改文章公告-测试成功
	 */
	@Test
	public void testUpdateArticle() {
		Article article=  articleService.SelectArticleById(1);
		 System.out.println("修改前："+article.getContent()+"   "+article.getUpdateTime());
		 article.setContent(article.getContent()+"第一次修改");
		 article.setUpdateTime(new Date());
		 articleService.updateArticle(article);
		 Article article2=  articleService.SelectArticleById(1);
		 System.out.println("修改后："+article2.getContent()+"   "+article2.getUpdateTime());
	}

}
