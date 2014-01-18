package com.gsyoa.test;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Voucher;
import com.gsyoa.entity.VoucherInfo;
import com.gsyoa.service.VoucherInfoService;
/**
 * 报销单详细
 * @author yang_小新
 * @date 2013年12月13日
 */
public class VoucherInfoTest {

	  private static VoucherInfoService voucherInfoService;			
			@BeforeClass
			public static void setUpBeforeClass() throws Exception {
				try {
					@SuppressWarnings("resource")
					ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					voucherInfoService = (VoucherInfoService)applicationContext.getBean("voucherInfoService");					
					
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * 保存报销单详细信息-测试成功
	 */
	@Test
	public void testSaveVoucherInfo() {
		VoucherInfo voucherInfo=new VoucherInfo();
		voucherInfo.setContent("电费2元，水费22元，网费3元");
		voucherInfo.setItem("软件开发");
		voucherInfo.setMoney(1222);
		voucherInfo.setVoucherId(new Voucher(1));
		voucherInfoService.saveVoucherInfo(voucherInfo);
		
		System.out.println("-------------"+voucherInfo.getContent());
	}
/**
 * 删除报销单详细-测试成功
 */
	@Test
	public void testDeleteVoucherInfo() {
		
     boolean b=voucherInfoService.deleteVoucherInfo(1);
		
		if(b==true){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
/**
 * 根据id查询报销单详细-测试成功
 */
	@Test
	public void testSelectVoucherInfoById() {
		VoucherInfo voucherInfo=  voucherInfoService.SelectVoucherInfoById(1);
		   System.out.println("报销项目："+voucherInfo.getItem()+" 报销费用详细"+voucherInfo.getContent());	
		
	}

	/**
	 * 查询全部报销单详细-测试成功
	 */
	@Test
	public void testSelectAllVoucherInfo() {
		List<VoucherInfo> list=(List<VoucherInfo>)voucherInfoService.SelectAllVoucherInfo();		
		System.out.println("报销费用详细："+list.get(0).getContent());
	
	}

	/**
	 * 修改报销单详细-测试成功
	 */
	@Test
	public void testUpdateVoucherInfo() {
		
		VoucherInfo voucherInfo=  voucherInfoService.SelectVoucherInfoById(1);
		 System.out.println("修改前："+voucherInfo.getContent());
		 voucherInfo.setContent("电费2元，网费3月，手机话费16元");
		 voucherInfoService.updateVoucherInfo(voucherInfo);
		 VoucherInfo voucherInfo2=  voucherInfoService.SelectVoucherInfoById(1);
		 System.out.println("修改后："+voucherInfo2.getContent()+"   "+voucherInfo2.getItem());
	}

}
