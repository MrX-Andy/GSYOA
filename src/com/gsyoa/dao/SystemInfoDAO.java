package com.gsyoa.dao;

import com.gsyoa.entity.SystemInfo;

/**
 * 系统信息DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface SystemInfoDAO {

	/**
	 * 保存系统信息
	 * @param systemInfo  系统信息实体
	 * @return  boolean
	 */
	public boolean saveSystemInfo(SystemInfo systemInfo);		
	
	/**
	 * 修改系统信息
	 * @param systemInfo 系统信息实体
	 * @return
	 */
	public boolean updateSystemInfo(SystemInfo systemInfo);
	
	/**
	 * id查询系统信息
	 * @return SystemInfo
	 */
	public SystemInfo SelectSystemInfo(int id);
	
}
