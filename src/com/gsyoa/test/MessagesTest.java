package com.gsyoa.test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsyoa.entity.Messages;
import com.gsyoa.entity.User;
import com.gsyoa.service.MessagesService;
/**
 * 短讯
 * @author yang_小新
 * @date 2013年12月13日
 */
public class MessagesTest {

	 private static MessagesService messagesService;	
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			try {
				@SuppressWarnings("resource")
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				messagesService = (MessagesService)applicationContext.getBean("messagesService");					
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	
	/**
	 * 保存短信-测试成功	
	 */
	@Test
	public void testSaveMessages() {
		Messages messages=new Messages();
		messages.setContent("大家好好做好项目啊哈~~");
		messages.setReceiveUserId(new User(1));
		messages.setSendUserId(new User(1));
		messages.setState("正常");
		messages.setTitle("希望");
		messagesService.saveMessages(messages);
		System.out.println("-------------"+messages.getContent());
	}

	@Test
	public void testDeleteMessages() {
	boolean b=	messagesService.deleteMessages(1);
		if(b==true){
			System.out.println("删除成功------");
		}else{
			System.out.println("删除失败");
		}
	}
	/**
	 * 根据id查询短信-测试成功
	 */
	@Test
	public void testSelectMessagesById() {
		Messages messages=  messagesService.SelectMessagesById(1);
		   System.out.println("短信标题："+messages.getTitle()+"--   短信内容："+messages.getContent());	

	}

	/**
	 * 查询全部短信-测试成功
	 */
	
	@Test
	public void testSelectAllMessages() {
		  List<Messages> list=  (List<Messages>) messagesService.SelectAllMessages();
		   System.out.println("短信内容："+list.get(0).getContent()+"短信标题："+list.get(0).getTitle());	

	}
/**
 * 修改短信-测试成功
 */
	@Test
	public void testUpdateMessages() {
		Messages messages=  messagesService.SelectMessagesById(1);
		 System.out.println("修改前："+messages.getContent());
		 messages.setContent(messages.getContent()+"第一次修改");
		 		 
		 messagesService.updateMessages(messages);
		 Messages messages2=  messagesService.SelectMessagesById(1);
		 System.out.println("修改后："+messages2.getContent()+"   ");
	}

}
