package com.gsyoa.test;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.gsyoa.entity.SystemInfo;

import com.gsyoa.service.SystemInfoService;
/**
 * ϵͳ��Ϣ
 * @author yang_С��
 * @date 2013��12��13��
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
	 * ����ϵͳ��Ϣ-���Գɹ�
	 */
	
	@Test
	public void testSaveSystemInfo() {
		SystemInfo systemInfo=new SystemInfo();
		systemInfo.setAddress("����Ժ168��");
		systemInfo.setEmail("guowu@admin.com");
		systemInfo.setName("����Ժվ");
		systemInfo.setPhone("10001");
		systemInfo.setQq("7000000");
		systemInfoService.saveSystemInfo(systemInfo);
		
	}
/**
 * �޸�SystemInfo-���Գɹ�
 */
	@Test
	public void testUpdateSystemInfo() {
		SystemInfo systemInfo=  systemInfoService.SelectSystemInfo(1);
		 System.out.println("�޸�ǰ��"+systemInfo.getName());
		 
		 systemInfo.setName("��������Ժվ");
		 systemInfoService.updateSystemInfo(systemInfo);		
		 System.out.println("�޸ĺ�"+systemInfo.getName());
	}
/**
 * ��ѯϵͳ��Ϣ-���Գɹ�
 */
	@Test
	public void testSelectSystemInfo() {
		SystemInfo systemInfo=  systemInfoService.SelectSystemInfo(1);
		   System.out.println("��վ���ƣ�"+systemInfo.getName());	
	}

}
