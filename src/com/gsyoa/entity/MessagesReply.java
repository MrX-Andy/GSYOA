package com.gsyoa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * վ���Żظ�ʵ��
 * @author Hello_����
 * @date 2013��12��14��
 */
@Entity
@Table(name="gsyoa_messagesReply")
public class MessagesReply {
	private int id;		//վ���Żظ�Id
	private Messages messagesId;		//վ����Id
	private User sendUserId;			//�ظ���Id
	private Date	replyTime;			//�ظ�ʱ��
	private String	content;		//վ��������
	
	/**
	 * �޲ι���
	 */
	public MessagesReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id����
	 * @param id
	 */
	public MessagesReply(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * ���캯��
	 * @param id
	 * @param messagesId
	 * @param replyTime
	 * @param content
	 */
	public MessagesReply(int id, Messages messagesId, Date replyTime,String content) {
		super();
		this.id = id;
		this.messagesId = messagesId;
		this.replyTime = replyTime;
		this.content = content;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="messagesId")
	public Messages getMessagesId() {
		return messagesId;
	}
	public void setMessagesId(Messages messagesId) {
		this.messagesId = messagesId;
	}
	
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@ManyToOne
	@JoinColumn(name="sendUserId")
	public User getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(User sendUserId) {
		this.sendUserId = sendUserId;
	}
	
	
}
