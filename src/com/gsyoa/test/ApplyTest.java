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
 * 申请单
 * @author yang_小新
 * @date 2013年12月13日
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
 * 保存申请单-测试成功
 */
	@Test
	public void testSaveApply() {
		Apply apply = new Apply();
		apply.setContent("关于开发OA系统所开展情况");		
		apply.setCreateUserId(new User(2));		
		apply.setCreateTime(new Date());				
		apply.setDealUserId(new User(2));	
		apply.setState("正常");		
		apply.setTypeId(new Type(1));				
		applyService.saveApply(apply);
		System.out.println("-------------"+apply.getContent());
	
	}
/**
 * 删除申请单-测试成功
 */
	@Test
	public void testDeleteApply() {
		boolean b=applyService.deleteApply(1);
		if(b==true){
			System.out.println("删除成功------");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询申请单信息-测试成功
	 */
	@Test
	public void testSelectApplyById() {
		   Apply apply=  applyService.SelectApplyById(1);
		   if(apply==null){
				 System.out.println("数据库没有数据--请先插入数据");
			 }
		   System.out.println(apply.getContent()+"    "+apply.getState());	
		
	}

	/**
	 * 查询全部申请单信息-测试成功
	 */
	@Test
	public void testSelectAllApply() {
		List<Apply> list=(List<Apply>)applyService.SelectAllApply();	
		System.out.println("申请单内容："+list.get(0).getContent());
	}

	/**
	 * 修改申请单信息-测试成功
	 */
	@Test
	public void testUpdateApply() {
		
		 Apply apply=  applyService.SelectApplyById(1);
		 if(apply==null){
			 System.out.println("数据库没有数据--请先插入数据");
		 }
		 System.out.println("修改前申请单："+apply.getContent()+"   "+apply.getState());
		 apply.setContent("411水电费欠费");
		 applyService.updateApply(apply);
		 Apply apply2=  applyService.SelectApplyById(1);
		 System.out.println("修改后用户信息："+apply2.getContent()+"   "+apply2.getState());
	}

}
