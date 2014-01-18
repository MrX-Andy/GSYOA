package com.gsyoa.test;



import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gsyoa.entity.User;
import com.gsyoa.entity.Voucher;
import com.gsyoa.service.VoucherService;
/**
 * 报销单
 * @author yang_小新
 * @date 2013年12月13日
 */
public class VoucherTest {


	  private static VoucherService voucherService;			
			@BeforeClass
			public static void setUpBeforeClass() throws Exception {
				try {
					@SuppressWarnings("resource")
					ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
					voucherService = (VoucherService)applicationContext.getBean("voucherService");					
					
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}	
	/**
	 * 保存报销单-测试成功
	 */
	@Test
	public void testSaveVoucher() {

		Voucher voucher=new Voucher();
		voucher.setContent("开发所用资金");
		voucher.setCreateTime(new Date());
		voucher.setCreateUserId(new User(1));
		//voucher.setDealUserId(new User(1));
		voucher.setMoney(12.0);
		voucher.setState("正常");
		voucherService.saveVoucher(voucher);
		System.out.println("-------------"+voucher.getContent());
	}
/**
 * 删除报销单-测试成功
 */
	@Test
	public void testDeleteVoucher() {
		Voucher	voucher =new Voucher(1);
		
	boolean b=voucherService.deleteVoucher(voucher);
		
		if(b==true){
			System.out.println("删除成功----");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询报销单信息-测试成功
	 */
	@Test
	public void testSelectVoucherById() {
		Voucher voucher=  voucherService.SelectVoucherById(1);
		   System.out.println("报销内容："+voucher.getContent()+" 金额"+voucher.getMoney());	
		
	}

	/**
	 * 查询全部报销单信息
	 */
	@Test
	public void testSelectAllVoucher() {
		List<Voucher> list=(List<Voucher>)voucherService.SelectAllVoucher();		
		System.out.println("报销内容："+list.get(0).getContent());
	
	}

	/**
	 * 修改报销单信息-测试成功
	 */
	@Test
	public void testUpdateVoucher() {
		Voucher voucher=  voucherService.SelectVoucherById(1);
		 System.out.println("修改前："+voucher.getContent());
		 voucher.setContent ("因开发OA系统，资金不足 ````");
		 voucherService.updateVoucher(voucher);
		 Voucher voucher2=  voucherService.SelectVoucherById(1);
		 System.out.println("修改后："+voucher2.getContent()+"   "+voucher2.getMoney());
	}

}
