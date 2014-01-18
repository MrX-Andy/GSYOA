package com.gsyoa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * �û�ʵ����
 * 
 * @author Hello_����
 * @date 2013��12��10�� 
 * ����� ��2013��12��13�գ�����Id���캯�� 
 * Τ������2013��12��14�գ��޸ġ��������
 */
@Entity
@Table(name = "gsyoa_user")
public class User {
	private int id; // �û�ID
	private String name; // �û�����
	private String password; // �û�����
	private String email; // �û�e-mail
	private String phone; // �û��绰 ����Ϊint�������ݿ��д�11λ�ַ�ò���е����⣬������String
	private String state; // �û�״̬
	private Department departmentId; // ��������
	private Set<Position> positionId = new HashSet<Position>(); // ����ְ�񡣶�Զ�

	/**
	 * �޲ҹ���
	 */
	public User() {
		super();
	}

	/**
	 * �вι��췽��
	 * @param id	 �û�ID
	 */
	public User(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι��췽��
	 * @param id        �û�ID
	 * @param name  �û�����
	 * @param password	 �û�����
	 * @param email	�û�e-mail
	 * @param phone �û��绰
	 * @param state  �û�״̬
	 * @param departmentId ��������
	 */
	public User(int id, String name, String password, String email,	String phone, String state, Department departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.departmentId = departmentId;
	}

	// get��set

	@Id	// ��������
	@GeneratedValue		// ��������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 16)		// �����û�������
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 32)		// �����û����볤�ȣ� Ϊʲô��32λ�ģ� ��Ϊ md5 ���ܺ��� 32λ�� ������Ҫmd5����
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 100)		// �����ʼ���ַ����
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 11)		// �����ֻ����볤��
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 10)		// ����״̬����
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@ManyToOne
	@JoinColumn(name = "departmentId")		// �����������ţ��������
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToMany(fetch=FetchType.EAGER)			//ʵ�������
	@JoinTable(name = "GSYOA_User_Position", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "positionId") })
	public Set<Position> getPositionId() {
		return positionId;
	}
	public void setPositionId(Set<Position> positionId) {
		this.positionId = positionId;
	}

}
