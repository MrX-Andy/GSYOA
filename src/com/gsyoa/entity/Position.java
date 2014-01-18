package com.gsyoa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * ְ��ʵ����
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ��޸ġ��������
 */
@Entity		//����ʵ����
@Table(name = "gsyoa_Position")		//�������
public class Position {

	private int id; // ְ����
	private String name; // ְ����
	private Set<User> userId = new HashSet<User>(); // ��Զ����

	/**
	 * �޲ι��캯��
	 */
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id���췽��
	 * @param id
	 */
	public Position(int id){
		super();
		this.id=id;
	}
	
	/**
	 * �вι��췽��
	 * @param id
	 * @param name
	 */
	public Position(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// get ��set

	@Id		// ��������
	@GeneratedValue		// �����Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)	// �����ַ�����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "positionId")		//���ö�Զ����
	public Set<User> getUserId() {
		return userId;
	}
	public void setUserId(Set<User> userId) {
		this.userId = userId;
	}

}
