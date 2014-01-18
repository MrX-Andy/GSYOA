package com.gsyoa.action;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.SystemInfo;
import com.gsyoa.entity.User;
import com.gsyoa.service.SystemInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SystemInfoAction extends ActionSupport {
	//������MessageInfo ʵ�壬���� ��ʾ
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}
	
	private SystemInfo systemInfo;
	public SystemInfo getSystemInfo() {
		return systemInfo;
	}
	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}
	
	private SystemInfoService systemInfoService;
	public SystemInfoService getSystemInfoService() {
		return systemInfoService;
	}
	public void setSystemInfoService(SystemInfoService systemInfoService) {
		this.systemInfoService = systemInfoService;
	}
	
	public String update(){

		if(systemInfo.getName().equals("") || systemInfo.getAddress().equals("") || systemInfo.getEmail().equals("") || systemInfo.getPhone().equals("") || systemInfo.getQq().equals("") ){
			message = new MessageInfo(0, "��Ϣ������������ʧ�ܣ�", "", "");
		}else{
			systemInfo.setId(1);
			systemInfoService.updateSystemInfo(systemInfo);
			message = new MessageInfo(0, "ϵͳ��Ϣ�޸ĳɹ���", "", "");
		}
		return "message";
	}
			
			
}
