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
 * 站内信回复实体
 * @author Hello_海生
 * @date 2013年12月14日
 */
@Entity
@Table(name="gsyoa_messagesReply")
public class MessagesReply {
	private int id;		//站内信回复Id
	private Messages messagesId;		//站内信Id
	private User sendUserId;			//回复方Id
	private Date	replyTime;			//回复时间
	private String	content;		//站内信内容
	
	/**
	 * 无参构造
	 */
	public MessagesReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id构造
	 * @param id
	 */
	public MessagesReply(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * 构造函数
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
