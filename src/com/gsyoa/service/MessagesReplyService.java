package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.MessagesReply;

/**
 * �ظ���Ϣ DAO �ӿ�
 * @author Hello_����
 * @date 2013��12��14��
 */
public interface MessagesReplyService {
	/**
	 * ����ظ���Ϣ
	 * @param messagesReply
	 * @return
	 */
	public boolean saveMessagesReply(MessagesReply messagesReply);
	
	/**
	 * ɾ���ظ���Ϣ
	 * @param id
	 * @return
	 */
	public boolean deleteMessagesReply(int id);
	
	/**
	 * ����Id��ѯ�ظ���Ϣ
	 * @param id
	 * @return
	 */
	public MessagesReply selectMessagesReplyById(int id);
	
	/**
	 * ��ѯ���лظ���Ϣ
	 * @return
	 */
	public List<MessagesReply> selectAllMessages();
	
	/**
	 * ������ϢId ��ѯ��Id�µ����лظ�
	 * @param messagesReply
	 * @return
	 */
	public List<MessagesReply> selectMessagesReplyByMessagesId(int id);
	
	/**
	 * ���� �ظ���Ϣ
	 * @param messagesReply
	 * @return
	 */
	public boolean updateMessagesReply(MessagesReply messagesReply);
}
