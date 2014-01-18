package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.MessagesDAO;
import com.gsyoa.entity.Messages;
import com.gsyoa.service.MessagesService;
/**
 * 信息回复处理
 * @author Hello_海生
 * @date 2013年12月19日
 */
public class MessagesServiceImpl implements MessagesService {
	private MessagesDAO messagesDAO;
	
	
	public MessagesDAO getMessagesDAO() {
		return messagesDAO;
	}

	public void setMessagesDAO(MessagesDAO messagesDAO) {
		this.messagesDAO = messagesDAO;
	}

	@Override
	public boolean saveMessages(Messages Messages) {
		// TODO Auto-generated method stub
		return messagesDAO.saveMessages(Messages);
	}

	@Override
	public boolean deleteMessages(int id) {
		// TODO Auto-generated method stub
		return messagesDAO.deleteMessages(id);
	}

	@Override
	public Messages SelectMessagesById(int id) {
		// TODO Auto-generated method stub
		return messagesDAO.SelectMessagesById(id);
	}

	@Override
	public List<Messages> SelectAllMessages() {
		// TODO Auto-generated method stub
		return messagesDAO.SelectAllMessages();
	}

	@Override
	public boolean updateMessages(Messages messages) {
		// TODO Auto-generated method stub
		return messagesDAO.updateMessages(messages);
	}

	@Override
	public List<Messages> SelectMessagesByUserId(int id) {
		// TODO Auto-generated method stub
		return messagesDAO.SelectMessagesByUserId(id);
	}

}
