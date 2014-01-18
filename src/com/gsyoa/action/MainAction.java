package com.gsyoa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Article;
import com.gsyoa.entity.Department;
import com.gsyoa.entity.Messages;
import com.gsyoa.entity.User;
import com.gsyoa.service.ArticleService;
import com.gsyoa.service.DepartmentService;
import com.gsyoa.service.MessagesService;
import com.gsyoa.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页Action
 * @author Hello_海生
 * @date 2013年12月15日
 */
public class MainAction extends ActionSupport {
	//用于页面获取未读站内信
	private int messagesSum=0;
	public int getMessagesSum() {
		return messagesSum;
	}
	
	//部门介绍
	private Department  department;
	public Department getDepartment() {
		return department;
	}
	
	// 声明 站内信 服务，并设置 Set方法
	private MessagesService messagesService;
	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
	
	// 声明 站内信 服务，并设置 Set方法
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	// 声明 站内信 服务，并设置 Set方法
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	public String main() throws Exception {
		//查询站内信
		User user = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
		//获取未读信息数量
		for (Messages m : messagesService.SelectMessagesByUserId(user.getId())) {
			if(!m.getState().equals("已读")  && !m.getState().equals("删除"))messagesSum++;
		}
		//获取公告信息
		ServletActionContext.getRequest().setAttribute("articleList",articleService.SelectAllArticle());
		//获取所属部门
		department=departmentService.SelectDepartmentById(user.getDepartmentId().getId());
		return "main";
	}
}
