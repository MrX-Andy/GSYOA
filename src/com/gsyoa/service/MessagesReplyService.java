package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.MessagesReply;

/**
 * 回复信息 DAO 接口
 * @author Hello_海生
 * @date 2013年12月14日
 */
public interface MessagesReplyService {
	/**
	 * 保存回复信息
	 * @param messagesReply
	 * @return
	 */
	public boolean saveMessagesReply(MessagesReply messagesReply);
	
	/**
	 * 删除回复信息
	 * @param id
	 * @return
	 */
	public boolean deleteMessagesReply(int id);
	
	/**
	 * 根据Id查询回复信息
	 * @param id
	 * @return
	 */
	public MessagesReply selectMessagesReplyById(int id);
	
	/**
	 * 查询所有回复信息
	 * @return
	 */
	public List<MessagesReply> selectAllMessages();
	
	/**
	 * 根据信息Id 查询该Id下的所有回复
	 * @param messagesReply
	 * @return
	 */
	public List<MessagesReply> selectMessagesReplyByMessagesId(int id);
	
	/**
	 * 更新 回复信息
	 * @param messagesReply
	 * @return
	 */
	public boolean updateMessagesReply(MessagesReply messagesReply);
}
