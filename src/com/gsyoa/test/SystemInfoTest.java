package com.gsyoa.test;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.gsyoa.entity.SystemInfo;

import com.gsyoa.service.SystemInfoService;
/**
 * 系统信息
 * @author yang_小新
 * @date 2013年12月13日
 */
public class SystemInfoTest {
	 private static SystemInfoService systemInfoService;	
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				systemInfoService = (SystemInfoService)applicationContext.getBean("systemInfoService");					
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}

	/**
	 * 保存系统信息-测试成功
	 */
	
	@Test
	public void testSaveSystemInfo() {
		SystemInfo systemInfo=new SystemInfo();
		systemInfo.setAddress("国商院168号");
		systemInfo.setEmail("guowu@admin.com");
		systemInfo.setName("国商院站");
		systemInfo.setPhone("10001");
		systemInfo.setQq("7000000");
		systemInfoService.saveSystemInfo(systemInfo);
		
	}
/**
 * 修改SystemInfo-测试成功
 */
	@Test
	public void testUpdateSystemInfo() {
		SystemInfo systemInfo=  systemInfoService.SelectSystemInfo(1);
		 System.out.println("修改前："+systemInfo.getName());
		 
		 systemInfo.setName("广西国商院站");
		 systemInfoService.updateSystemInfo(systemInfo);		
		 System.out.println("修改后："+systemInfo.getName());
	}
/**
 * 查询系统信息-测试成功
 */
	@Test
	public void testSelectSystemInfo() {
		SystemInfo systemInfo=  systemInfoService.SelectSystemInfo(1);
		   System.out.println("网站名称："+systemInfo.getName());	
	}

}
