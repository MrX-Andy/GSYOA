package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 详细报销单实体类
 * 
 * @author 杨云云
 * @date 2013年12月11日
 * 杨兵新 ，2013年12月13日，增加Id构造函数 
 * 韦海生，2013年12月14日，修改、整理、检查
 * 黄建伟，2013年12月16日，修改 meney为 money
 */
@Entity
@Table(name = "gsyoa_VoucherInfo")
public class VoucherInfo {

	private int id; // 编号
	private Voucher voucherId; // 报销单Id
	private String item; // 报销项目
	private double money; // 报销金额
	private String content; // 费用说明

	/**
	 * 无参构造函数
	 */
	public VoucherInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id构造
	 * @param id
	 */
	public VoucherInfo(int id) {
		super();
		this.id = id;
	}


	/**
	 * 有参构造
	 * 
	 * @param id
	 * @param voucherId
	 * @param item
	 * @param money
	 * @param content
	 */
	public VoucherInfo(int id, Voucher voucherId, String item, double money,	String content) {
		super();
		this.id = id;
		this.voucherId = voucherId;
		this.item = item;
		this.money = money;
		this.content = content;
	}

	// get和set

	@Id	// 设置主键
	@GeneratedValue		// 自动增长
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne		// 设置该字段为外籍
	@JoinColumn(name = "voucherId" ,referencedColumnName = "id", unique = false)		// 设置相关联字段为voucherId
	public Voucher getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Voucher voucherId) {
		this.voucherId = voucherId;
	}

	@Column(length = 200)		// 设置长度为200
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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

}
