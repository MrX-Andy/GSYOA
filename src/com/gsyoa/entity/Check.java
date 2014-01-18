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
 * 申请表实体类
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数
 * 韦海生，2013年12月14日，整理、检查
 */
@Entity		//定义为实体类
@Table(name = "gsyoa_check")		//设置数据库表
public class Check {

	private int id; // 编号
	private Apply applyId; // 申请人Id
	private Date checkTime; // 审批时间
	private User checkUserId; // 处理人Id
	private String result; // 审核类型
	private String content; // 审核意见

	/**
	 * 无参构造方法
	 */
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id构造函数
	 * @param id
	 */
	public Check(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 * @param id
	 * @param applyId
	 * @param checkTime
	 * @param checkUserId
	 * @param result
	 * @param content
	 */
	public Check(int id, Apply applyId, Date checkTime, User checkUserId,String result, String content) {
		super();
		this.id = id;
		this.applyId = applyId;
		this.checkTime = checkTime;
		this.checkUserId = checkUserId;
		this.result = result;
		this.content = content;
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

	@ManyToOne		// 设置为外键
	@JoinColumn(name = "applyId")		// 相关联字段为applyId
	public Apply getApplyId() {
		return applyId;
	}
	public void setApplyId(Apply applyId) {
		this.applyId = applyId;
	}

	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@ManyToOne		// 设置为外键
	@JoinColumn(name = "checkUserId")		// 相关联字段为applyId
	public User getCheckUserId() {
		return checkUserId;
	}
	public void setCheckUserId(User checkUserId) {
		this.checkUserId = checkUserId;
	}

	@Column(length = 100)		// 设置该字段字符长度为100
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
