package com.gsyoa.test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Type;
import com.gsyoa.service.TypeService;
/**
 * ���뵥����
 * @author yang_С��
 * @date 2013��12��13��
 */
public class TypeServiceTest {

	   private static TypeService typeService;			
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				typeService = (TypeService)applicationContext.getBean("typeService");					
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}

	/**
	 * ������������-���Գɹ�	
	 */
	@Test
	public void testSaveType() {
		Type type=new Type();
		type.setTitle("����");
		typeService.saveType(type);	
		System.out.println("-------------"+type.getTitle());
		
	}

	@Test
	public void testDeleteType() {
	/**
	 * ɾ���������-���Գɹ�	
	 */
	boolean b=	typeService.deleteType(3);	
		if(b==true){
			System.out.println("ɾ���ɹ�------");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
/**
 * ����id��ѯ�������-���Գɹ�
 */
	@Test
	public void testSelectTypeById() {
		   Type type=  typeService.SelectTypeById(3);
		   if(type==null){
				 System.out.println("���ݿ�û������--���Ȳ�������");
			 }
		   System.out.println("�������"+type.getTitle());	
	}

	/**
	 * ��ѯȫ���������-���Գɹ�
	 */
	@Test
	public void testSelectAllType() {
		  List<Type> list=  (List<Type>) typeService.SelectAllType();
		  for(Type type:list){
			  System.out.println("�������"+type.getTitle());
		  }
	}

	/**
	 * �޸��������-���Գɹ�
	 */
	@Test
	public void testUpdateType() {
		
		
		 Type type=  typeService.SelectTypeById(2);
		 if(type==null){
			 System.out.println("���ݿ�û������--���Ȳ�������");
		 }
		 System.out.println("�޸�ǰ��"+type.getTitle());		
		 type.setTitle(type.getTitle()+"�ٴ��޸�");
		 typeService.updateType(type);
		 Type type2=typeService.SelectTypeById(2);
		 System.out.println("�޸ĺ�"+type2.getTitle()+"   ");
	}

}
