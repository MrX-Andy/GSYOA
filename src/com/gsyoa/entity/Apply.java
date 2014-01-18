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
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，整理、检查
 * 黄建伟，2013年12月16日，修改 creaeTime为 createTime
 */
@Entity	// 说明这个类，在使用的时候作为一张表
@Table(name = "gsyoa_apply")	// 设置生成的数据库的表名
public class Apply {
	private int id; // 编号
	private User createUserId; // 申请用户Id
	private Date createTime; // 申请时间
	private Type typeId; // 申请类型
	private User dealUserId; // 待处理人Id
	private String content; // 申请内容
	private String state; // 状态

	/**
	 * 无参构造方法
	 */
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 * @param id
	 */
	public Apply(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 * @param id
	 * @param createUserId
	 * @param createTime
	 * @param typeId
	 * @param dealUserId
	 * @param content
	 * @param state
	 */
	public Apply(int id, User createUserId, Date createTime, Type typeId,User dealUserId, String content, String state) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.typeId = typeId;
		this.dealUserId = dealUserId;
		this.content = content;
		this.state = state;
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

	@ManyToOne		// 设置该字段为外键
	@JoinColumn(name = "typeId")		// 关联字段为typeId
	public Type getTypeId() {
		return typeId;
	}
	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}

	@ManyToOne	// 设置该字段为外键
	@JoinColumn(name = "dealUserId")		// 关联字段为typeId
	public User getDealUserId() {
		return dealUserId;
	}
	public void setDealUserId(User dealUserId) {
		this.dealUserId = dealUserId;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(length = 10)
	// 设置该字段长度为10
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
