package com.gsyoa.service;

import com.gsyoa.entity.SystemInfo;

/**
 * 系统信息Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface SystemInfoService {

	/**
	 * 保存系统信息
	 * @param systemInfo	系统信息实体
	 * @return	保存后的信息实体
	 */
	public boolean saveSystemInfo(SystemInfo systemInfo);		
	
	/**
	 * 修改系统信息
	 * @param systemInfo	系统信息实体
	 * @return	修改后的系统信息
	 */
	public boolean updateSystemInfo(SystemInfo systemInfo);
	
	/**
	 * 查询系统信息
	 * @return	系统信息实体
	 */
	public SystemInfo SelectSystemInfo(int id);
	
	
	
	

	
}
