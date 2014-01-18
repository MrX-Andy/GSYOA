package com.gsyoa.dao;

import com.gsyoa.entity.SystemInfo;

/**
 * ϵͳ��ϢDAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface SystemInfoDAO {

	/**
	 * ����ϵͳ��Ϣ
	 * @param systemInfo  ϵͳ��Ϣʵ��
	 * @return  boolean
	 */
	public boolean saveSystemInfo(SystemInfo systemInfo);		
	
	/**
	 * �޸�ϵͳ��Ϣ
	 * @param systemInfo ϵͳ��Ϣʵ��
	 * @return
	 */
	public boolean updateSystemInfo(SystemInfo systemInfo);
	
	/**
	 * id��ѯϵͳ��Ϣ
	 * @return SystemInfo
	 */
	public SystemInfo SelectSystemInfo(int id);
	
}
