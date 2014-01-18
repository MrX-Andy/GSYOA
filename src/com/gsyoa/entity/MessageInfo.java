package com.gsyoa.entity;

/**
 * �Զ�����ʾ��Ϣʵ��
 * @author Hello_����
 * @date 2013��12��10��
 * �ƽ�ΰ��2013��12��16�գ��޸� ����MssageInfoΪ MessageInfo
 */
public class MessageInfo {
	private int time;				//��תʱ��	��Ϊ0 ��Ϊ����ת
	private String msg;			//��ʾ��Ϣ
	private String http;			//Ҫ��ת����Ŀ�� URL
	private String httpTitle;	//Ŀ��URL �ı���

	/**
	 * ����ʵ�幹�캯��
	 * @param time	���������ת
	 * @param msg	��ʾ��Ϣ
	 * @param http	Ҫ��ת���ĵ�ַ
	 * @param httpTitle		��ҳ����
	 */
	public MessageInfo(int time,String msg,String http,String httpTitle) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.msg = msg;
		this.http = http;
		this.httpTitle = httpTitle;
	}
	
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getHttp() {
		return http;
	}
	public void setHttp(String http) {
		this.http = http;
	}
	
	public String getHttpTitle() {
		return httpTitle;
	}
	public void setHttpTitle(String httpTitle) {
		this.httpTitle = httpTitle;
	}
	
}
