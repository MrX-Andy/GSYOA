package com.gsyoa.test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Type;
import com.gsyoa.service.TypeService;
/**
 * 申请单类型
 * @author yang_小新
 * @date 2013年12月13日
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
	 * 保存申请类型-测试成功	
	 */
	@Test
	public void testSaveType() {
		Type type=new Type();
		type.setTitle("公开");
		typeService.saveType(type);	
		System.out.println("-------------"+type.getTitle());
		
	}

	@Test
	public void testDeleteType() {
	/**
	 * 删除申请类别-测试成功	
	 */
	boolean b=	typeService.deleteType(3);	
		if(b==true){
			System.out.println("删除成功------");
		}else{
			System.out.println("删除失败");
		}
	}
/**
 * 根据id查询申请类别-测试成功
 */
	@Test
	public void testSelectTypeById() {
		   Type type=  typeService.SelectTypeById(3);
		   if(type==null){
				 System.out.println("数据库没有数据--请先插入数据");
			 }
		   System.out.println("申请类别："+type.getTitle());	
	}

	/**
	 * 查询全部申请类别-测试成功
	 */
	@Test
	public void testSelectAllType() {
		  List<Type> list=  (List<Type>) typeService.SelectAllType();
		  for(Type type:list){
			  System.out.println("申请类别："+type.getTitle());
		  }
	}

	/**
	 * 修改申请类别-测试成功
	 */
	@Test
	public void testUpdateType() {
		
		
		 Type type=  typeService.SelectTypeById(2);
		 if(type==null){
			 System.out.println("数据库没有数据--请先插入数据");
		 }
		 System.out.println("修改前："+type.getTitle());		
		 type.setTitle(type.getTitle()+"再次修改");
		 typeService.updateType(type);
		 Type type2=typeService.SelectTypeById(2);
		 System.out.println("修改后："+type2.getTitle()+"   ");
	}

}
