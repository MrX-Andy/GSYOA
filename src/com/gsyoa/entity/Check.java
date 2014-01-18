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
 * �����ʵ����
 * @author ������
 * @date 2013��12��11��
 * ����� ��2013��12��13�գ�����Id���캯��
 * Τ������2013��12��14�գ��������
 */
@Entity		//����Ϊʵ����
@Table(name = "gsyoa_check")		//�������ݿ��
public class Check {

	private int id; // ���
	private Apply applyId; // ������Id
	private Date checkTime; // ����ʱ��
	private User checkUserId; // ������Id
	private String result; // �������
	private String content; // ������

	/**
	 * �޲ι��췽��
	 */
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Id���캯��
	 * @param id
	 */
	public Check(int id) {
		super();
		this.id = id;
	}

	/**
	 * �вι���
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

	// get ��set

	@Id		// ��������
	@GeneratedValue		// �����Զ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne		// ����Ϊ���
	@JoinColumn(name = "applyId")		// ������ֶ�ΪapplyId
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

	@ManyToOne		// ����Ϊ���
	@JoinColumn(name = "checkUserId")		// ������ֶ�ΪapplyId
	public User getCheckUserId() {
		return checkUserId;
	}
	public void setCheckUserId(User checkUserId) {
		this.checkUserId = checkUserId;
	}

	@Column(length = 100)		// ���ø��ֶ��ַ�����Ϊ100
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
