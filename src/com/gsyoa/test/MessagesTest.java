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
 * ��Ѷ
 * @author yang_С��
 * @date 2013��12��13��
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
	 * �������-���Գɹ�	
	 */
	@Test
	public void testSaveMessages() {
		Messages messages=new Messages();
		messages.setContent("��Һú�������Ŀ����~~");
		messages.setReceiveUserId(new User(1));
		messages.setSendUserId(new User(1));
		messages.setState("����");
		messages.setTitle("ϣ��");
		messagesService.saveMessages(messages);
		System.out.println("-------------"+messages.getContent());
	}

	@Test
	public void testDeleteMessages() {
	boolean b=	messagesService.deleteMessages(1);
		if(b==true){
			System.out.println("ɾ���ɹ�------");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	/**
	 * ����id��ѯ����-���Գɹ�
	 */
	@Test
	public void testSelectMessagesById() {
		Messages messages=  messagesService.SelectMessagesById(1);
		   System.out.println("���ű��⣺"+messages.getTitle()+"--   �������ݣ�"+messages.getContent());	

	}

	/**
	 * ��ѯȫ������-���Գɹ�
	 */
	
	@Test
	public void testSelectAllMessages() {
		  List<Messages> list=  (List<Messages>) messagesService.SelectAllMessages();
		   System.out.println("�������ݣ�"+list.get(0).getContent()+"���ű��⣺"+list.get(0).getTitle());	

	}
/**
 * �޸Ķ���-���Գɹ�
 */
	@Test
	public void testUpdateMessages() {
		Messages messages=  messagesService.SelectMessagesById(1);
		 System.out.println("�޸�ǰ��"+messages.getContent());
		 messages.setContent(messages.getContent()+"��һ���޸�");
		 		 
		 messagesService.updateMessages(messages);
		 Messages messages2=  messagesService.SelectMessagesById(1);
		 System.out.println("�޸ĺ�"+messages2.getContent()+"   ");
	}

}
