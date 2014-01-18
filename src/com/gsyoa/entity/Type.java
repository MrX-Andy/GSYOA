package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 申请类别实体类
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加构造函数
 * 韦海生，2013年12月14日，修改、整理、检查
 */
@Entity
@Table(name = "gsyoa_Type")
public class Type {

	private int id; // 编号
	private String title; // 申请类型

	/**
	 * 无参构造方法
	 */
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 * @param id
	 */
	public Type(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 * @param id
	 * @param title
	 */
	public Type(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	// get和set

	@Id		// 设置Id为主键
	@GeneratedValue		// 该字段自动增长
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)		// 设置该字段长度为100
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
