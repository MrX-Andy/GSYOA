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
 * 职位
 * @author yang_小新
 * @date 2013年12月13日
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
 * 保存职位信息-测试成功
 */
	@Test
	public void testSavePosition() {
		Set<Position>  p=new HashSet<Position>();
		Position position=new Position();
		position.setName("普通员工");	
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
	 * 删除职位-测试成功
	 */
	@Test
	public void testDeletePosition() {
	boolean b=	positionService.deletePosition(3);
		if(b==true){
			System.out.println("删除成功----");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询职位-测试成功
	 */
	@Test
	public void testSelectPositionById() {
		   Position position=  positionService.SelectPositionById(1);
		   System.out.println("职位名称："+position.getName());	

	}
/**
 * 查询全部职位信息-测试成功
 */
	@Test
	public void testSelectAllPosition() {
		  List<Position> list=  (List<Position>) positionService.SelectAllPosition();
		  for(Position position:list){
			  System.out.println("职位名称："+position.getName());
		  }
		  
		  
	}

	/**
	 * 修改职位信息-测试成功
	 */
	@Test
	public void testUpdatePosition() {
		Position position=  positionService.SelectPositionById(3);
		 System.out.println("修改前："+position.getName());
		 position.setName(position.getName()+"第一次修改");
		 		 
		 positionService.updatePosition(position);
		Position position2=  positionService.SelectPositionById(3);
		 System.out.println("修改后："+position2.getName()+"   ");
	}

}
