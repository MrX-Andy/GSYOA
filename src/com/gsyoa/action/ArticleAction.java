package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Article;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.User;
import com.gsyoa.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	//声明，MessageInfo 实体，用于 提示
			private MessageInfo message;
			public MessageInfo getMessage() {
				return message;
			}
			public void setMessage(MessageInfo message) {
				this.message = message;
			}
			
			private User user;
			private Article article;
			private ArticleService articleService;
			public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			public Article getArticle() {
				return article;
			}
			public void setArticle(Article article) {
				this.article = article;
			}
			public ArticleService getArticleService() {
				return articleService;
			}
			public void setArticleService(ArticleService articleService) {
				this.articleService = articleService;
			}
			
			
			
			public String send(){
				if(article!=null){
					article = articleService.SelectArticleById(article.getId());
				}
				return "send";
			}
			
			public String save(){
				User userSession = (User) ActionContext.getContext().getSession().get("User");	
				if(article.getContent().equals("") || article.getTitle().equals("")){
					message = new MessageInfo(0, "标题和内容不能为空！", "", "");
				}else{
					if(article.getColor().equals("")	)article.setColor("#0000FF");
					if(article.getId()==0){
						article.setCreateTime(new Date());
						article.setUpdateTime(new Date());
						article.setUserId(new User(userSession.getId()));
						if(articleService.saveArticle(article))message = new MessageInfo(0, "文章发布成功！", "", "");
						else message = new MessageInfo(0, "文章发布失败", "", "");
					}else{
						article.setUpdateTime(new Date());
						if(articleService.updateArticle(article))message = new MessageInfo(0, "文章修改成功！", "", "");
						else message = new MessageInfo(0, "文章修改失败", "", "");
					}
				}
				
				return "message";
			}
			
			
			public String list(){
				
				List<Article> articleList = articleService.SelectAllArticle();
				ServletActionContext.getRequest().setAttribute("articleList",articleList);
				return "list";
			}
			
			
			public String delete(){
				
				if(article==null)message = new MessageInfo(0, "请不要非法操作", "", "");
				else{
					message = new MessageInfo(0, "删除失败！", "", "");
					if(articleService.deleteArticle(article.getId()))message = new MessageInfo(0, "删除成功！", "", "");
				}
				return "message";
			}
			
			public String show(){
				article = articleService.SelectArticleById(article.getId());
				return "show";
			}
			
}
