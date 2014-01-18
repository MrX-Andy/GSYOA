package com.gsyoa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

/**
 * 短讯实体类
 * 
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，增加发送时间属性、,整理、检查
 */
@Entity	// 说明这个类，在使用的时候作为一张表
@Table(name = "gsyoa_messages")	// 设置生成的数据库的表名
public class Messages {

	private int id; // 编号
	private User sendUserId; // 设置类型为User，发送信息用户Id
	private User receiveUserId; // 设置类型为User，接收信息用户Id
	private Date createTime;		//发送时间
	private String title; // 信息标题
	private String content; // 短信内容
	private String state; // 状态

	/**
	 * 无参构造方法
	 */
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Id构造方法
	 * @param id
	 */
	public Messages(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造方法
	 * @param id
	 * @param sendUserId
	 * @param receiveUserId
	 * @param title
	 * @param content
	 * @param state
	 */
	public Messages(int id, User sendUserId, User receiveUserId, String title,	String content, String state) {
		super();
		this.id = id;
		this.sendUserId = sendUserId;
		this.receiveUserId = receiveUserId;
		this.title = title;
		this.content = content;
		this.state = state;
	}

	// get和 set方法

	@Id		// 设置该字段为主键
	@GeneratedValue		// 设置这个字段自增
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne		// 设置该字段为外键 多对一
	@JoinColumn(name = "sendUserId")	// 设置关联字段为 sendUserId ， 就是说，让它在数据库中生成的字段为 sendUserId
	public User getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(User sendUserId) {
		this.sendUserId = sendUserId;
	}

	@ManyToOne
	@JoinColumn(name = "receiveUserId")
	public User getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(User receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	@Column(length = 200)	// 设置长度为200
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(length = 10)		// 设置长度为10
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
