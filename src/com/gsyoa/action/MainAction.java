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
 * ��ҳAction
 * @author Hello_����
 * @date 2013��12��15��
 */
public class MainAction extends ActionSupport {
	//����ҳ���ȡδ��վ����
	private int messagesSum=0;
	public int getMessagesSum() {
		return messagesSum;
	}
	
	//���Ž���
	private Department  department;
	public Department getDepartment() {
		return department;
	}
	
	// ���� վ���� ���񣬲����� Set����
	private MessagesService messagesService;
	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
	
	// ���� վ���� ���񣬲����� Set����
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	// ���� վ���� ���񣬲����� Set����
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	public String main() throws Exception {
		//��ѯվ����
		User user = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
		//��ȡδ����Ϣ����
		for (Messages m : messagesService.SelectMessagesByUserId(user.getId())) {
			if(!m.getState().equals("�Ѷ�")  && !m.getState().equals("ɾ��"))messagesSum++;
		}
		//��ȡ������Ϣ
		ServletActionContext.getRequest().setAttribute("articleList",articleService.SelectAllArticle());
		//��ȡ��������
		department=departmentService.SelectDepartmentById(user.getDepartmentId().getId());
		return "main";
	}
}
