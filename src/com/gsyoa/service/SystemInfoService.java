package com.gsyoa.service;

import com.gsyoa.entity.SystemInfo;

/**
 * ϵͳ��ϢService�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface SystemInfoService {

	/**
	 * ����ϵͳ��Ϣ
	 * @param systemInfo	ϵͳ��Ϣʵ��
	 * @return	��������Ϣʵ��
	 */
	public boolean saveSystemInfo(SystemInfo systemInfo);		
	
	/**
	 * �޸�ϵͳ��Ϣ
	 * @param systemInfo	ϵͳ��Ϣʵ��
	 * @return	�޸ĺ��ϵͳ��Ϣ
	 */
	public boolean updateSystemInfo(SystemInfo systemInfo);
	
	/**
	 * ��ѯϵͳ��Ϣ
	 * @return	ϵͳ��Ϣʵ��
	 */
	public SystemInfo SelectSystemInfo(int id);
	
	
	
	

	
}
