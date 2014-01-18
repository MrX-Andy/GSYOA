package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �������ʵ����
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ����ӹ��캯��
 * Τ������2013��12��14�գ��޸ġ��������
 */
@Entity
@Table(name = "gsyoa_Type")
public class Type {

	private int id; // ���
	private String title; // ��������

	/**
	 * �޲ι��췽��
	 */
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �вι���
	 * @param id
	 */
	public Type(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι���
	 * @param id
	 * @param title
	 */
	public Type(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	// get��set

	@Id		// ����IdΪ����
	@GeneratedValue		// ���ֶ��Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)		// ���ø��ֶγ���Ϊ100
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
