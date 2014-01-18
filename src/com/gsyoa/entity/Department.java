package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ���� ʵ����
 * @author Hello_����
 * @date 2013��12��10��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ��������
 */
@Entity
@Table(name = "gsyoa_Department")
public class Department {
	private int id; // ����ID
	private String name; // ��������
	private User mangerId; // ���ž���ID����������� User
	private String content;	//���Ž���

	/**
	 * �޲ι��췽��
	 */
	public Department() {
		super();
	}
	/**
	 * Id���췽��
	 * @param id
	 */
	public Department(int id) {
		super();
		this.id = id;
	}

	/**
	 * �й��췽��
	 * @param id
	 * @param name
	 * @param mangerId
	 */
	public Department(int id, String name, User mangerId) {
		super();
		this.id = id;
		this.name = name;
		this.mangerId = mangerId;
	}

	// Get �� Set

	@Id		// ���ø��ֶ�Ϊ����
	@GeneratedValue		// ���� ��������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)		// ���ò������ֳ��� 100
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "MangerId")		// ���ù����ֶ�����Ϊ
	public User getMangerId() {
		return mangerId;
	}
	public void setMangerId(User mangerId) {
		this.mangerId = mangerId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
