package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 部门 实体类
 * @author Hello_海生
 * @date 2013年12月10日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，整理、检查
 */
@Entity
@Table(name = "gsyoa_Department")
public class Department {
	private int id; // 部门ID
	private String name; // 部门名称
	private User mangerId; // 部门经理ID、外键关联到 User
	private String content;	//部门介绍

	/**
	 * 无参构造方法
	 */
	public Department() {
		super();
	}
	/**
	 * Id构造方法
	 * @param id
	 */
	public Department(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有构造方法
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

	// Get 和 Set

	@Id		// 设置该字段为主键
	@GeneratedValue		// 设置 主键自增
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)		// 设置部门名字长度 100
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "MangerId")		// 设置关联字段名称为
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
