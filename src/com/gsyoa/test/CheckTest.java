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
 * 审批表
 * @author yang_小新
 * @date 2013年12月13日
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
		 * 保存审批表-测试成功
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
 * 删除审批单-测试成功
 */
	@Test
	public void testDeleteCheck() {
	boolean b=	checkService.deleteCheck(1);
		if(b==true){
			System.out.println("删除成功------");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询审批表-测试成功
	 */
	@Test
	public void testSelectCheckById() {
		   Check check=  checkService.SelectCheckById(1);
		   System.out.println("审核意见："+check.getContent()+" ----审核人员  "+check.getCheckUserId());	

	}

	/**
	 * 查询全部审批表-测试成功
	 */
	@Test
	public void testSelectAllCheck() {
		   List<Check> check=  (List<Check>) checkService.SelectAllCheck();
		   System.out.println("审核意见："+check.get(0).getContent()+" ----审核人员  "+check.get(0).getCheckUserId());	

	}
/**
 * 修改审批表-测试成功
 */
	@Test
	public void testUpdateCheck() {
		 Check check=  checkService.SelectCheckById(1);
		 System.out.println("修改前："+check.getContent());
		 check.setContent(check.getContent()+"第一次修改");
		 		 
		 checkService.updateCheck(check);
		 Check check2=  checkService.SelectCheckById(1);
		 System.out.println("修改后："+check2.getContent()+"   ");
	}

}
