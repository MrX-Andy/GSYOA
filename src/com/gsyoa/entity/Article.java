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
 * ���¹���ʵ����
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ��������
 */
@Entity		//����������Ϊʵ����
@Table(name = "gsyoa_Article")		//�������ݿ��
public class Article {

	private int id; // ���
	private String title; // ���±���
	private String color; // ������ɫ
	private User userId; // �û�Id
	private Date createTime; // ����ʱ��
	private Date updateTime; // ����޸�ʱ��
	private String content; // ����˵��

	/**
	 * �޲ι��췽��
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �Զ���Id ���췽��
	 * @param id
	 */
	public Article(int id){
		super();
		this.id=id;
	}

	/**
	 * �вι��췽��
	 * @param id
	 * @param title
	 * @param color
	 * @param userId
	 * @param createTime
	 * @param updateTime
	 * @param content
	 */
	public Article(int id, String title, String color, User userId,	Date createTime, Date updateTime, String content) {
		super();
		this.id = id;
		this.title = title;
		this.color = color;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.content = content;
	}

	// get�� set

	@Id		// ��������
	@GeneratedValue		// �����Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 200)		// �����ַ�����Ϊ200
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 7)		// �����ַ�����Ϊ7
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@ManyToOne		// �������
	@JoinColumn(name = "userId")	// ���������ֶ�Ϊ@JoinColumn
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
