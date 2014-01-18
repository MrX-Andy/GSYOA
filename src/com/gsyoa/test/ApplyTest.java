package com.gsyoa.test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Type;
import com.gsyoa.entity.User;
import com.gsyoa.service.ApplyService;
import com.gsyoa.service.TypeService;
import com.gsyoa.service.UserService;

/**
 * ���뵥
 * @author yang_С��
 * @date 2013��12��13��
 */
public class ApplyTest {
	
	  private static ApplyService applyService;		
	  @SuppressWarnings("unused")
	private static TypeService typeService;	
	  @SuppressWarnings("unused")
	private static UserService userService;	

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				applyService = (ApplyService)applicationContext.getBean("applyService");					
				typeService = (TypeService)applicationContext.getBean("typeService");	
				userService = (UserService)applicationContext.getBean("userService");			
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
/**
 * �������뵥-���Գɹ�
 */
	@Test
	public void testSaveApply() {
		Apply apply = new Apply();
		apply.setContent("���ڿ���OAϵͳ����չ���");		
		apply.setCreateUserId(new User(2));		
		apply.setCreateTime(new Date());				
		apply.setDealUserId(new User(2));	
		apply.setState("����");		
		apply.setTypeId(new Type(1));				
		applyService.saveApply(apply);
		System.out.println("-------------"+apply.getContent());
	
	}
/**
 * ɾ�����뵥-���Գɹ�
 */
	@Test
	public void testDeleteApply() {
		boolean b=applyService.deleteApply(1);
		if(b==true){
			System.out.println("ɾ���ɹ�------");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * ����id��ѯ���뵥��Ϣ-���Գɹ�
	 */
	@Test
	public void testSelectApplyById() {
		   Apply apply=  applyService.SelectApplyById(1);
		   if(apply==null){
				 System.out.println("���ݿ�û������--���Ȳ�������");
			 }
		   System.out.println(apply.getContent()+"    "+apply.getState());	
		
	}

	/**
	 * ��ѯȫ�����뵥��Ϣ-���Գɹ�
	 */
	@Test
	public void testSelectAllApply() {
		List<Apply> list=(List<Apply>)applyService.SelectAllApply();	
		System.out.println("���뵥���ݣ�"+list.get(0).getContent());
	}

	/**
	 * �޸����뵥��Ϣ-���Գɹ�
	 */
	@Test
	public void testUpdateApply() {
		
		 Apply apply=  applyService.SelectApplyById(1);
		 if(apply==null){
			 System.out.println("���ݿ�û������--���Ȳ�������");
		 }
		 System.out.println("�޸�ǰ���뵥��"+apply.getContent()+"   "+apply.getState());
		 apply.setContent("411ˮ���Ƿ��");
		 applyService.updateApply(apply);
		 Apply apply2=  applyService.SelectApplyById(1);
		 System.out.println("�޸ĺ��û���Ϣ��"+apply2.getContent()+"   "+apply2.getState());
	}

}
