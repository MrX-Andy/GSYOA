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
 * ��������ϸ
 * @author yang_С��
 * @date 2013��12��13��
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
	 * ���汨������ϸ��Ϣ-���Գɹ�
	 */
	@Test
	public void testSaveVoucherInfo() {
		VoucherInfo voucherInfo=new VoucherInfo();
		voucherInfo.setContent("���2Ԫ��ˮ��22Ԫ������3Ԫ");
		voucherInfo.setItem("�������");
		voucherInfo.setMoney(1222);
		voucherInfo.setVoucherId(new Voucher(1));
		voucherInfoService.saveVoucherInfo(voucherInfo);
		
		System.out.println("-------------"+voucherInfo.getContent());
	}
/**
 * ɾ����������ϸ-���Գɹ�
 */
	@Test
	public void testDeleteVoucherInfo() {
		
     boolean b=voucherInfoService.deleteVoucherInfo(1);
		
		if(b==true){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
/**
 * ����id��ѯ��������ϸ-���Գɹ�
 */
	@Test
	public void testSelectVoucherInfoById() {
		VoucherInfo voucherInfo=  voucherInfoService.SelectVoucherInfoById(1);
		   System.out.println("������Ŀ��"+voucherInfo.getItem()+" ����������ϸ"+voucherInfo.getContent());	
		
	}

	/**
	 * ��ѯȫ����������ϸ-���Գɹ�
	 */
	@Test
	public void testSelectAllVoucherInfo() {
		List<VoucherInfo> list=(List<VoucherInfo>)voucherInfoService.SelectAllVoucherInfo();		
		System.out.println("����������ϸ��"+list.get(0).getContent());
	
	}

	/**
	 * �޸ı�������ϸ-���Գɹ�
	 */
	@Test
	public void testUpdateVoucherInfo() {
		
		VoucherInfo voucherInfo=  voucherInfoService.SelectVoucherInfoById(1);
		 System.out.println("�޸�ǰ��"+voucherInfo.getContent());
		 voucherInfo.setContent("���2Ԫ������3�£��ֻ�����16Ԫ");
		 voucherInfoService.updateVoucherInfo(voucherInfo);
		 VoucherInfo voucherInfo2=  voucherInfoService.SelectVoucherInfoById(1);
		 System.out.println("�޸ĺ�"+voucherInfo2.getContent()+"   "+voucherInfo2.getItem());
	}

}
