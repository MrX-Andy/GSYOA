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
 * ������ʵ����
 * 
 * @author ������
 * @date 2013��12��11�� 
 * ����� ��2013��12��13�գ�����Id���캯�� 
 * Τ������2013��12��14�գ��޸ġ��������
 * ����� ��2013��12��23�գ�����List<VoucherInfo> 
 */
@Entity
@Table(name = "gsyoa_Voucher")
public class Voucher {

	private int id; // ���
	private User createUserId; // �����û�Id
	private Date createTime; // ����ʱ��
	private double money; // �����ܽ��
	private String content; // ��������
	private String state; // ״̬
	private List<VoucherInfo> voucherInfos = new ArrayList<VoucherInfo>();  //���ڼ���ɾ��
	/**
	 * �޲ι��췽��
	 */
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �вι���
	 * @param id
	 */

	public Voucher(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι���
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

	// get��set

	@Id		// ��������
	@GeneratedValue		// �����Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne		// ���ø��ֶ�Ϊ����
	@JoinColumn(name = "createUserId")		// ���ù����ֶ�ΪcreateUserId
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

	@Column(length = 10)		// ���ó���Ϊ10
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
