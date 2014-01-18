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
 * 职务实体类
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，修改、整理、检查
 */
@Entity		//定义实体类
@Table(name = "gsyoa_Position")		//定义表名
public class Position {

	private int id; // 职务编号
	private String name; // 职务名
	private Set<User> userId = new HashSet<User>(); // 多对多外键

	/**
	 * 无参构造函数
	 */
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id构造方法
	 * @param id
	 */
	public Position(int id){
		super();
		this.id=id;
	}
	
	/**
	 * 有参构造方法
	 * @param id
	 * @param name
	 */
	public Position(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// get 和set

	@Id		// 设置主键
	@GeneratedValue		// 主键自动增长
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 100)	// 设置字符长度
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "positionId")		//设置多对多关联
	public Set<User> getUserId() {
		return userId;
	}
	public void setUserId(Set<User> userId) {
		this.userId = userId;
	}

}
