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
 * ���뵥ʵ����
 * @author �ƽ�ΰ
 * @date 2013��12��27��
 */
@Entity	// ˵������࣬��ʹ�õ�ʱ����Ϊһ�ű�
@Table(name = "gsyoa_conference")	// �������ɵ����ݿ�ı���
public class Conference {
	private int id; // ���
	private String title; // ����
	private User createUserId; // �û�Id
	private Date createTime; // ����ʱ��
	private String address; // ��������
	private String content; // ��������
	/**
	 * �޲ι��췽��
	 */
	public Conference() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �вι���
	 * @param id
	 */
	public Conference(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι���
	 * @param id
	 * @param createUserId
	 * @param title
	 * @param address
	 * @param createTime
	 * @param content
	 */
	public Conference(int id,String title,User createUserId,String address,Date createTime, String content) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createTime = createTime;
		
		
		this.content = content;
		
	}

	// get��set

	@Id		// ���ø��ֶ�Ϊ����
	@GeneratedValue		// ��������ֶ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
   
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	// ���ø��ֶ�Ϊ��� ���һ
	@JoinColumn(name = "createUserId")
	// �����ֶ�ΪcreateUserId
	public User getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(User createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


}
