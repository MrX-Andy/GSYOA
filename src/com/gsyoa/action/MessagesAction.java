package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Messages;
import com.gsyoa.entity.MessagesReply;
import com.gsyoa.entity.User;
import com.gsyoa.service.MessagesReplyService;
import com.gsyoa.service.MessagesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * վ���Ŵ���
 * @author Hello_����
 * @date 2013��12��16��
 * Τ���� 2013��12��23�գ��������
 */
public class MessagesAction extends ActionSupport {
	//վ����ʵ��
	private Messages messages;
	public Messages getMessages() {
		return messages;
	}
	public void setMessages(Messages messages) {
		this.messages = messages;
	}
	
	//�ظ�ʵ��
	private MessagesReply messagesReply;
	public MessagesReply getMessagesReply() {
		return messagesReply;
	}
	public void setMessagesReply(MessagesReply messagesReply) {
		this.messagesReply = messagesReply;
	}
	
	//������MessageInfo ʵ�壬���� ��ʾ
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}
	
	
	// ���� վ���� ���񣬲����� Set����
	private MessagesService messagesService;
	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
	
	//���� վ���� ���񣬲����� Set����
	private MessagesReplyService messagesReplyService;
	public void setMessagesReplyService(MessagesReplyService messagesReplyService) {
		this.messagesReplyService = messagesReplyService;
	}
	
	
	//����վ����
	public String send(){
		if(messages.getTitle().equals("") || messages.getReceiveUserId().equals("") || messages.getContent().equals("")){
			message = new MessageInfo(0, "���������Ϣ�������������������ٽ����ύ��", "", "");
		}else{
			User user = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
			messages.setSendUserId(new User(user.getId()));
			messages.setState("δ��");
			messages.setCreateTime(new Date());
			if(messagesService.saveMessages(messages))message = new MessageInfo(0, "��Ϣ�ѷ��ͳɹ���", "", "");
			else message = new MessageInfo(0, "��Ϣ����ʧ�ܣ�����ϵ����Ա��", "", "");
		}
		return "message";
	}
	
	//վ�����б�
	public String list(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
		List<Messages> messagesList= messagesService.SelectMessagesByUserId(user.getId());	//��ѯ���û��µ�������Ϣ
		List<Messages> msgList=new ArrayList<Messages>();		//����һ�� ��Ϣ�������� ��ѡ
		for (Messages messages : messagesList) {		
			if(!messages.getState().equals("ɾ��"))msgList.add(messages);		//��ȡδɾ������Ϣ
		}
		ServletActionContext.getRequest().setAttribute("messagesList",msgList);
		return "list";		//�����б�ҳ
	}
	
	//�ظ�վ���� ҳ��
	public String reply(){
		Messages m= messagesService.SelectMessagesById(messages.getId());		//����Id  ��ȡ��վ���ŵ���Ϣ
		if(m==null)message=new MessageInfo(0, "����վ���Ų����ڣ�", "", "");
		else{
			ServletActionContext.getRequest().setAttribute("messages",m);		//�洢վ���� ��Ϣ 
			if(!m.getState().equals("ɾ��")){		//���������Ϣ���� �Ѿ�ɾ������ �޸�״̬Ϊ�Ѷ��� 
				m.setState("�Ѷ�");
				messagesService.updateMessages(m);
			}
			List<MessagesReply> messagesReplyList = messagesReplyService.selectMessagesReplyByMessagesId(m.getId());		//��ѯ�ظ���Ϣ
			ServletActionContext.getRequest().setAttribute("messagesReplyList",messagesReplyList);			
		}
		return "reply";
	}
	
	//������Ϣ�ظ�
	public String doReply(){
		if(messagesReply.getContent().equals(""))message = new MessageInfo(0, "�ظ����ݲ���Ϊ�գ�", "", "");
		else{
			User u = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
			messagesReply.setReplyTime(new Date());
			messagesReply.setSendUserId(u);	
			if(messagesReplyService.saveMessagesReply(messagesReply)){
				Messages m= messagesService.SelectMessagesById(messagesReply.getMessagesId().getId());
				m.setState("�»ظ�");
				messagesService.updateMessages(m);
				message = new MessageInfo(0, "��Ϣ�ظ��ɹ���", "", "");
			}else{
				message = new MessageInfo(0, "��Ϣ�ظ�ʧ�ܣ�", "", "");
			}
		}
		return "message";
	}
	
	//ɾ��վ����
	public String delete(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
		Messages m = messagesService.SelectMessagesById(messages.getId());						//��ѯ����վ���ŵ� ��Ϣ
		if(m.getReceiveUserId().getId()!=user.getId())message = new MessageInfo(0, "�ö�Ϣ����������������ɾ����", "","");
		else{
			if(m.getState().equals("ɾ��")){		//��� ����վ���ŵ�  ״̬  �� ɾ���� �� ����ɾ��
				if(messagesService.deleteMessages(m.getId()))message = new MessageInfo(0, "����ɾ���ɹ���", "","");
				else message = new MessageInfo(0, "����ɾ��ʧ�ܣ�", "","");
			}else{
				m.setState("ɾ��");
				if(messagesService.updateMessages(m))message = new MessageInfo(0, "ɾ���ɹ���", "","");
				else message = new MessageInfo(0, "ɾ��ʧ�ܣ�", "","");
			}
		}
		return "message";
	}
	
	//��ɾ����Ϣ�б�
	public String deletelist(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//��ȡ�û�session
		List<Messages> messagesList= messagesService.SelectMessagesByUserId(user.getId());		//��ѯ���û���������Ϣ
		List<Messages> msgList=new ArrayList<Messages>();		
		for (Messages messages : messagesList) {
			if(messages.getState().equals("ɾ��"))msgList.add(messages);	//������ȡ  ��ɾ��������
		}
		ServletActionContext.getRequest().setAttribute("messagesList",msgList);	
		return "list";
	}
	
	//�ָ���ɾ����վ����
	public String recovery(){
		Messages m = messagesService.SelectMessagesById(messages.getId());
		if(m==null)message = new MessageInfo(0, "��վ���Ų����ڻ��ѱ�ɾ����", "","");
		else{
			m.setState("�Ѷ�");
			if(messagesService.updateMessages(m))message = new MessageInfo(0, "����Ϣ�ָ��ɹ���", "","");
			else	message = new MessageInfo(0, "����Ϣ�ָ�ʧ�ܣ�", "","");
		}
		return "message";
	}
	
	
}
