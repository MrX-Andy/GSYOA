package com.gsyoa.service.impl;

import com.gsyoa.dao.SystemInfoDAO;
import com.gsyoa.entity.SystemInfo;
import com.gsyoa.service.SystemInfoService;

public class SystemInfoServiceImpl implements SystemInfoService {
	private SystemInfoDAO systemInfoDAO;
	
	public SystemInfoDAO getSystemInfoDAO() {
		return systemInfoDAO;
	}

	public void setSystemInfoDAO(SystemInfoDAO systemInfoDAO) {
		this.systemInfoDAO = systemInfoDAO;
	}

	@Override
	public boolean saveSystemInfo(SystemInfo systemInfo) {
		// TODO Auto-generated method stub
		return systemInfoDAO.saveSystemInfo(systemInfo);
	}

	@Override
	public boolean updateSystemInfo(SystemInfo systemInfo) {
		// TODO Auto-generated method stub
		return systemInfoDAO.updateSystemInfo(systemInfo);
	}

	@Override
	public SystemInfo SelectSystemInfo(int id) {
		// TODO Auto-generated method stub
		return systemInfoDAO.SelectSystemInfo(id);
	}

}
