package com.gsyoa.entity;

/**
 * 自定义提示信息实体
 * @author Hello_海生
 * @date 2013年12月10日
 * 黄建伟，2013年12月16日，修改 类名MssageInfo为 MessageInfo
 */
public class MessageInfo {
	private int time;				//跳转时间	，为0 则为不跳转
	private String msg;			//提示信息
	private String http;			//要跳转到的目的 URL
	private String httpTitle;	//目的URL 的标题

	/**
	 * 错误实体构造函数
	 * @param time	多少秒后跳转
	 * @param msg	提示信息
	 * @param http	要跳转到的地址
	 * @param httpTitle		网页标题
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
