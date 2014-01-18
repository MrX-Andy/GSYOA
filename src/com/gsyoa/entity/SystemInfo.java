package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ϵͳ��Ϣʵ����
 * 
 * @author ������
 * @date 2013��12��11�� 
 * ����� ��2013��12��13�գ�����Id���캯��
 *Τ������2013��12��14�գ��޸ġ��������
 */
@Entity
@Table(name = "gsyoa_SystemInfo")
public class SystemInfo {
	private int id;			//û��ʲô���壬����ʡ��
	private String name; // ��վ����
	private String email; // ��վ�ʼ�
	private String phone; // ��վ�绰
	private String qq; // �ͷ�QQ
	private String address; // ��վ��˾��ַ

	/**
	 * �޲ι��췽��
	 */
	public SystemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �вι��췽��
	 * @return
	 */
	public SystemInfo(String name, String email, String phone, String qq,
			String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
	}

	// get ��set
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 100)		// ���ø��ֶ��ַ�����Ϊ100
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 11)		// ���ø��ֶ��ַ�����Ϊ11
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 11)		// ���ø��ֶ��ַ�����Ϊ11
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
