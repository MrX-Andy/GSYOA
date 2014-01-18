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
 * 文章公告实体类
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，整理、检查
 */
@Entity		//声明该类型为实体类
@Table(name = "gsyoa_Article")		//定义数据库表
public class Article {

	private int id; // 编号
	private String title; // 文章标题
	private String color; // 标题颜色
	private User userId; // 用户Id
	private Date createTime; // 发布时间
	private Date updateTime; // 最后修改时间
	private String content; // 费用说明

	/**
	 * 无参构造方法
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 自定义Id 构造方法
	 * @param id
	 */
	public Article(int id){
		super();
		this.id=id;
	}

	/**
	 * 有参构造方法
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

	// get和 set

	@Id		// 设置主键
	@GeneratedValue		// 主键自动增长
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 200)		// 设置字符长度为200
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 7)		// 设置字符长度为7
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@ManyToOne		// 设置外键
	@JoinColumn(name = "userId")	// 外键相关联字段为@JoinColumn
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
