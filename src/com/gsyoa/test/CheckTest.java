package com.gsyoa.test;




import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Check;
import com.gsyoa.entity.User;
import com.gsyoa.service.CheckService;

/**
 * ������
 * @author yang_С��
 * @date 2013��12��13��
 */
public class CheckTest {

	  private static CheckService checkService;	

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				checkService = (CheckService)applicationContext.getBean("checkService");									
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * ����������-���Գɹ�
		 */
	@Test
	public void testSaveCheck() {
		
		Check 	check=new Check(); 
		check.setApplyId(new Apply(2));
		check.setCheckTime(new Date());
		
		check.setCheckUserId(new User(2));
		check.setContent("content");
		check.setResult("hao");			
		checkService.saveCheck(check);	
		System.out.println("-------------"+check.getContent());
	}
/**
 * ɾ��������-���Գɹ�
 */
	@Test
	public void testDeleteCheck() {
	boolean b=	checkService.deleteCheck(1);
		if(b==true){
			System.out.println("ɾ���ɹ�------");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * ����id��ѯ������-���Գɹ�
	 */
	@Test
	public void testSelectCheckById() {
		   Check check=  checkService.SelectCheckById(1);
		   System.out.println("��������"+check.getContent()+" ----�����Ա  "+check.getCheckUserId());	

	}

	/**
	 * ��ѯȫ��������-���Գɹ�
	 */
	@Test
	public void testSelectAllCheck() {
		   List<Check> check=  (List<Check>) checkService.SelectAllCheck();
		   System.out.println("��������"+check.get(0).getContent()+" ----�����Ա  "+check.get(0).getCheckUserId());	

	}
/**
 * �޸�������-���Գɹ�
 */
	@Test
	public void testUpdateCheck() {
		 Check check=  checkService.SelectCheckById(1);
		 System.out.println("�޸�ǰ��"+check.getContent());
		 check.setContent(check.getContent()+"��һ���޸�");
		 		 
		 checkService.updateCheck(check);
		 Check check2=  checkService.SelectCheckById(1);
		 System.out.println("�޸ĺ�"+check2.getContent()+"   ");
	}

}
