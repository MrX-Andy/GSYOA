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
import com.gsyoa.service.UserService;

/**
 * 用户信息
 * @author yang_小新
 * @date 2013年12月13日
 */
public class UserTest {
	
   private static UserService userService;	
   private static PositionService positionService;	
   @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			@SuppressWarnings("resource")
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			userService = (UserService)applicationContext.getBean("userService");					
			positionService = (PositionService)applicationContext.getBean("positionService");					
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 保存用户信息-测试成功
	 */
	@Test
	public void testSaveUser() {
	
		Set<User> user1 = new  HashSet<User>();
		User user=new User();
		user.setName("yang_小新");
		user.setPassword("123456");
		user.setPhone("18269018975");
		user.setState("正常");
		user.setEmail("admin@admin.com");	
		user.setDepartmentId(new Department(1));		
		user1.add(user);
				
		Set<Position>  hh=new HashSet<Position>();	
		Position p=new Position();
		p.setId(1);		
		hh.add(p);
		
		user.setPositionId(hh);
		p.setUserId(user1);
	//	positionService.savePosition(p);
		//List<User> u = userService.saveUser(user);
		//System.out.println("-------------"+u.get(0).getName());
		
	}
	
  /**
   * 删除用户信息--测试成功
   */
	@Test
	public void testDeleteUser() {
		boolean b=userService.deleteUser(1);
		if(b==true){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}

	/**
	 * 根据id查询用户信息-测试成功
	 */
	@Test
	public void testSelectUserById() {	
	
		User user=  userService.SelectUserById(1001);
	   System.out.println(user.getName()+"    "+user.getEmail());		
	   for (Position p : user.getPositionId()) {
		   System.out.println("========="+p.getName());
	}
	}

	/**
	 * 查询全部用户信息-测试成功
	 */
	@Test
	public void testSelectAllUser() {	
		List<User> list=(List<User>)userService.SelectAllUser();		
		System.out.println(list.get(0).getName());
				
	}

	/**
	 * 更新用户信息-测试成功
	 */
	@Test
	public void testUpdateUser() {
/*		 List<User> user=  userService.SelectUserById(1);
		 System.out.println("修改前用户信息："+user.get(0).getName()+"   "+user.get(0).getPhone());
		 user.get(0).setName("yang");
		 user.get(0).setPhone("15878933958");
		 user= userService.updateUser(user.get(0));
		 List<User> user2=  userService.SelectUserById(1);
		 System.out.println("修改后用户信息："+user2.get(0).getName()+"   "+user2.get(0).getPhone());*/
	}

}
