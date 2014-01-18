package com.gsyoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ��ϸ������ʵ����
 * 
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯�� 
 * Τ������2013��12��14�գ��޸ġ��������
 * �ƽ�ΰ��2013��12��16�գ��޸� meneyΪ money
 */
@Entity
@Table(name = "gsyoa_VoucherInfo")
public class VoucherInfo {

	private int id; // ���
	private Voucher voucherId; // ������Id
	private String item; // ������Ŀ
	private double money; // �������
	private String content; // ����˵��

	/**
	 * �޲ι��캯��
	 */
	public VoucherInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id����
	 * @param id
	 */
	public VoucherInfo(int id) {
		super();
		this.id = id;
	}


	/**
	 * �вι���
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

	// get��set

	@Id	// ��������
	@GeneratedValue		// �Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne		// ���ø��ֶ�Ϊ�⼮
	@JoinColumn(name = "voucherId" ,referencedColumnName = "id", unique = false)		// ����������ֶ�ΪvoucherId
	public Voucher getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Voucher voucherId) {
		this.voucherId = voucherId;
	}

	@Column(length = 200)		// ���ó���Ϊ200
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
