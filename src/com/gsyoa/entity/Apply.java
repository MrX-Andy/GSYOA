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
 * ���뵥ʵ����
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ��������
 * �ƽ�ΰ��2013��12��16�գ��޸� creaeTimeΪ createTime
 */
@Entity	// ˵������࣬��ʹ�õ�ʱ����Ϊһ�ű�
@Table(name = "gsyoa_apply")	// �������ɵ����ݿ�ı���
public class Apply {
	private int id; // ���
	private User createUserId; // �����û�Id
	private Date createTime; // ����ʱ��
	private Type typeId; // ��������
	private User dealUserId; // ��������Id
	private String content; // ��������
	private String state; // ״̬

	/**
	 * �޲ι��췽��
	 */
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * �вι���
	 * @param id
	 */
	public Apply(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι���
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

	// get��set

	@Id		// ���ø��ֶ�Ϊ����
	@GeneratedValue		// ��������ֶ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	// ���ø��ֶ�Ϊ��� ���һ
	@JoinColumn(name = "createUserId")
	// �����ֶ�ΪcreateUserId
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

	@ManyToOne		// ���ø��ֶ�Ϊ���
	@JoinColumn(name = "typeId")		// �����ֶ�ΪtypeId
	public Type getTypeId() {
		return typeId;
	}
	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}

	@ManyToOne	// ���ø��ֶ�Ϊ���
	@JoinColumn(name = "dealUserId")		// �����ֶ�ΪtypeId
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
	// ���ø��ֶγ���Ϊ10
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
