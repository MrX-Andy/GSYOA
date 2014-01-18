package com.gsyoa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 报销单实体类
 * 
 * @author 杨云云
 * @date 2013年12月11日 
 * 杨兵新 ，2013年12月13日，增加Id构造函数 
 * 韦海生，2013年12月14日，修改、整理、检查
 * 杨兵新 ，2013年12月23日，增加List<VoucherInfo> 
 */
@Entity
@Table(name = "gsyoa_Voucher")
public class Voucher {

	private int id; // 编号
	private User createUserId; // 申请用户Id
	private Date createTime; // 申请时间
	private double money; // 申请总金额
	private String content; // 申请内容
	private String state; // 状态
	private List<VoucherInfo> voucherInfos = new ArrayList<VoucherInfo>();  //用于级联删除
	/**
	 * 无参构造方法
	 */
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 * @param id
	 */

	public Voucher(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 * @param id
	 * @param createUserId
	 * @param createTime
	 * @param dealUserId
	 * @param money
	 * @param content
	 * @param state
	 */
	public Voucher(int id, User createUserId, Date createTime,double money, String content, String state) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.money = money;
		this.content = content;
		this.state = state;
	}

	// get和set

	@Id		// 设置主键
	@GeneratedValue		// 主键自动增长
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne		// 设置该字段为主键
	@JoinColumn(name = "createUserId")		// 设置关联字段为createUserId
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

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(length = 10)		// 设置长度为10
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(targetEntity = VoucherInfo.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "voucherId")
    @Cascade(value = {CascadeType.SAVE_UPDATE, 	CascadeType.DELETE_ORPHAN,CascadeType.ALL})  
	public List<VoucherInfo> getVoucherInfos() {
		return voucherInfos;
	}

	public void setVoucherInfos(List<VoucherInfo> voucherInfos) {
		this.voucherInfos = voucherInfos;
	}
	
	
}
