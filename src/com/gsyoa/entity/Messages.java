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
 * ��Ѷʵ����
 * 
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ����ӷ���ʱ�����ԡ�,�������
 */
@Entity	// ˵������࣬��ʹ�õ�ʱ����Ϊһ�ű�
@Table(name = "gsyoa_messages")	// �������ɵ����ݿ�ı���
public class Messages {

	private int id; // ���
	private User sendUserId; // ��������ΪUser��������Ϣ�û�Id
	private User receiveUserId; // ��������ΪUser��������Ϣ�û�Id
	private Date createTime;		//����ʱ��
	private String title; // ��Ϣ����
	private String content; // ��������
	private String state; // ״̬

	/**
	 * �޲ι��췽��
	 */
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Id���췽��
	 * @param id
	 */
	public Messages(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι��췽��
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

	// get�� set����

	@Id		// ���ø��ֶ�Ϊ����
	@GeneratedValue		// ��������ֶ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne		// ���ø��ֶ�Ϊ��� ���һ
	@JoinColumn(name = "sendUserId")	// ���ù����ֶ�Ϊ sendUserId �� ����˵�����������ݿ������ɵ��ֶ�Ϊ sendUserId
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
	

	@Column(length = 200)	// ���ó���Ϊ200
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

	@Column(length = 10)		// ���ó���Ϊ10
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
