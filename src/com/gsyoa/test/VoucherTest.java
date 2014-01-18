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
 * ������
 * @author yang_С��
 * @date 2013��12��13��
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
	 * ���汨����-���Գɹ�
	 */
	@Test
	public void testSaveVoucher() {

		Voucher voucher=new Voucher();
		voucher.setContent("���������ʽ�");
		voucher.setCreateTime(new Date());
		voucher.setCreateUserId(new User(1));
		//voucher.setDealUserId(new User(1));
		voucher.setMoney(12.0);
		voucher.setState("����");
		voucherService.saveVoucher(voucher);
		System.out.println("-------------"+voucher.getContent());
	}
/**
 * ɾ��������-���Գɹ�
 */
	@Test
	public void testDeleteVoucher() {
		Voucher	voucher =new Voucher(1);
		
	boolean b=voucherService.deleteVoucher(voucher);
		
		if(b==true){
			System.out.println("ɾ���ɹ�----");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * ����id��ѯ��������Ϣ-���Գɹ�
	 */
	@Test
	public void testSelectVoucherById() {
		Voucher voucher=  voucherService.SelectVoucherById(1);
		   System.out.println("�������ݣ�"+voucher.getContent()+" ���"+voucher.getMoney());	
		
	}

	/**
	 * ��ѯȫ����������Ϣ
	 */
	@Test
	public void testSelectAllVoucher() {
		List<Voucher> list=(List<Voucher>)voucherService.SelectAllVoucher();		
		System.out.println("�������ݣ�"+list.get(0).getContent());
	
	}

	/**
	 * �޸ı�������Ϣ-���Գɹ�
	 */
	@Test
	public void testUpdateVoucher() {
		Voucher voucher=  voucherService.SelectVoucherById(1);
		 System.out.println("�޸�ǰ��"+voucher.getContent());
		 voucher.setContent ("�򿪷�OAϵͳ���ʽ��� ````");
		 voucherService.updateVoucher(voucher);
		 Voucher voucher2=  voucherService.SelectVoucherById(1);
		 System.out.println("�޸ĺ�"+voucher2.getContent()+"   "+voucher2.getMoney());
	}

}
