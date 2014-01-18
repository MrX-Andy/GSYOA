package com.gsyoa.test;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Department;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.PositionService;
/**
 * ְλ
 * @author yang_С��
 * @date 2013��12��13��
 */
public class PositionTest {
	 private static PositionService positionService;	
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				positionService = (PositionService)applicationContext.getBean("positionService");					
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
/**
 * ����ְλ��Ϣ-���Գɹ�
 */
	@Test
	public void testSavePosition() {
		Set<Position>  p=new HashSet<Position>();
		Position position=new Position();
		position.setName("��ͨԱ��");	
		p.add(position);
		
		Set<User> u = new  HashSet<User>();
		User user=new User(1);
		u.add(user);
		
		user.setPositionId(p);
		position.setUserId(u);
		
		positionService.savePosition(position);	
		System.out.println("-------------"+position.getName());

	}
	/**
	 * ɾ��ְλ-���Գɹ�
	 */
	@Test
	public void testDeletePosition() {
	boolean b=	positionService.deletePosition(3);
		if(b==true){
			System.out.println("ɾ���ɹ�----");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * ����id��ѯְλ-���Գɹ�
	 */
	@Test
	public void testSelectPositionById() {
		   Position position=  positionService.SelectPositionById(1);
		   System.out.println("ְλ���ƣ�"+position.getName());	

	}
/**
 * ��ѯȫ��ְλ��Ϣ-���Գɹ�
 */
	@Test
	public void testSelectAllPosition() {
		  List<Position> list=  (List<Position>) positionService.SelectAllPosition();
		  for(Position position:list){
			  System.out.println("ְλ���ƣ�"+position.getName());
		  }
		  
		  
	}

	/**
	 * �޸�ְλ��Ϣ-���Գɹ�
	 */
	@Test
	public void testUpdatePosition() {
		Position position=  positionService.SelectPositionById(3);
		 System.out.println("�޸�ǰ��"+position.getName());
		 position.setName(position.getName()+"��һ���޸�");
		 		 
		 positionService.updatePosition(position);
		Position position2=  positionService.SelectPositionById(3);
		 System.out.println("�޸ĺ�"+position2.getName()+"   ");
	}

}
