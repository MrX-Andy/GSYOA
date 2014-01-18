package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Messages;

/**
 * ��ѶDAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 * 2013��12��16�գ�Τ���� ���� �����û�Id ��ѯ�����û��µ�����վ����
 */
public interface MessagesDAO {

	/**
	 * �����ѶϢ
	 * @param Messages  ��Ѷʵ��
	 * @return boolean
	 */
	public boolean saveMessages(Messages messages);	
	
	/**
	 * ɾ����ѶϢ
	 * @param id ��Ѷid
	 * @return boolean
	 */	
	public boolean deleteMessages(int id);
	
	/**
	 * ����id��ѯ��ѶϢ
	 * @param id ��Ѷid
	 * @return Messages
	 */
	public Messages SelectMessagesById(int id);
	
	/**
	 * ��ѯȫ����ѶϢ
	 * @return List<Messages>
	 */
	public List<Messages> SelectAllMessages();
	
	/**
	 * �޸Ķ�ѶϢ
	 * @param messages ��Ѷʵ��
	 * @return boolean
	 */
	public boolean updateMessages(Messages messages);
	
	/**
	 * �����û�Id��ѯ����
	 * @param id
	 * @return
	 */
	public List<Messages> SelectMessagesByUserId(int id);
		
}
