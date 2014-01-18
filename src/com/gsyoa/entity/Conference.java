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
 * 申请单实体类
 * @author 黄建伟
 * @date 2013年12月27日
 */
@Entity	// 说明这个类，在使用的时候作为一张表
@Table(name = "gsyoa_conference")	// 设置生成的数据库的表名
public class Conference {
	private int id; // 编号
	private String title; // 标题
	private User createUserId; // 用户Id
	private Date createTime; // 会议时间
	private String address; // 会议内容
	private String content; // 会议内容
	/**
	 * 无参构造方法
	 */
	public Conference() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 * @param id
	 */
	public Conference(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 * @param id
	 * @param createUserId
	 * @param title
	 * @param address
	 * @param createTime
	 * @param content
	 */
	public Conference(int id,String title,User createUserId,String address,Date createTime, String content) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createTime = createTime;
		
		
		this.content = content;
		
	}

	// get和set

	@Id		// 设置该字段为主键
	@GeneratedValue		// 设置这个字段自增
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
   
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	// 设置该字段为外键 多对一
	@JoinColumn(name = "createUserId")
	// 关联字段为createUserId
	public User getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(User createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


}
