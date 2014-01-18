package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统信息实体类
 * 
 * @author 杨云云
 * @date 2013年12月11日 
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 *韦海生，2013年12月14日，修改、整理、检查
 */
@Entity
@Table(name = "gsyoa_SystemInfo")
public class SystemInfo {
	private int id;			//没有什么意义，可以省略
	private String name; // 网站名称
	private String email; // 网站邮件
	private String phone; // 网站电话
	private String qq; // 客服QQ
	private String address; // 网站公司地址

	/**
	 * 无参构造方法
	 */
	public SystemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造方法
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

	// get 和set
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

	@Column(length = 100)		// 设置该字段字符长度为100
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 11)		// 设置该字段字符长度为11
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 11)		// 设置该字段字符长度为11
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
