package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.MessagesReplyDAO;
import com.gsyoa.entity.MessagesReply;
import com.gsyoa.service.MessagesReplyService;

public class MessagesReplyServiceImpl implements MessagesReplyService {
	private MessagesReplyDAO messagesReplyDAO;
	public MessagesReplyDAO getMessagesReplyDAO() {
		return messagesReplyDAO;
	}
	public void setMessagesReplyDAO(MessagesReplyDAO messagesReplyDAO) {
		this.messagesReplyDAO = messagesReplyDAO;
	}

	@Override
	public boolean saveMessagesReply(MessagesReply messagesReply) {
		// TODO Auto-generated method stub
		return messagesReplyDAO.saveMessagesReply(messagesReply);
	}

	@Override
	public boolean deleteMessagesReply(int id) {
		// TODO Auto-generated method stub
		return messagesReplyDAO.deleteMessagesReply(id);
	}

	@Override
	public MessagesReply selectMessagesReplyById(int id) {
		// TODO Auto-generated method stub
		return messagesReplyDAO.selectMessagesReplyById(id);
	}

	@Override
	public List<MessagesReply> selectAllMessages() {
		// TODO Auto-generated method stub
		return messagesReplyDAO.selectAllMessages();
	}

	@Override
	public List<MessagesReply> selectMessagesReplyByMessagesId(int id) {
		// TODO Auto-generated method stub
		return messagesReplyDAO.selectMessagesReplyByMessagesId(id);
	}

	@Override
	public boolean updateMessagesReply(MessagesReply messagesReply) {
		// TODO Auto-generated method stub
		return messagesReplyDAO.updateMessagesReply(messagesReply);
	}

}
