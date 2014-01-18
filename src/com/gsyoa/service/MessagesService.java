package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Messages;
/**
 * ��ϢService�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface MessagesService {

	/**
	 * ������Ϣ��������Ϣ��
	 * @param Messages ��Ϣʵ��
	 * @return	��������Ϣʵ��
	 */
	public boolean saveMessages(Messages Messages);	

	/**
	 * ɾ����Ϣ
	 * @param id	��ϢId
	 * @return	������
	 */
	public boolean deleteMessages(int id);
	
	/**
	 * ����Id������Ϣ
	 * @param id	��ϢId
	 * @return	��Ϣʵ��
	 */
	public Messages SelectMessagesById(int id);
	
	/**
	 * ��ѯ������Ϣ�б�
	 * @return List<Messages> ��Ϣʵ������
	 */
	public List<Messages> SelectAllMessages();
	
	/**
	 * �޸���Ϣ
	 * @param messages	��Ϣʵ��
	 * @return	�޸ĺ����Ϣʵ��
	 */
	public boolean updateMessages(Messages messages);
	
	/**
	 * �����û�Id��ѯ����
	 * @param id
	 * @return
	 */
	public List<Messages> SelectMessagesByUserId(int id);
	
	
}
