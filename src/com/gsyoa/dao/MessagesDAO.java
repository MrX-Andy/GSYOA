package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Messages;

/**
 * 短讯DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 * 2013年12月16日，韦海生 增加 根据用户Id 查询，该用户下的所有站内信
 */
public interface MessagesDAO {

	/**
	 * 保存短讯息
	 * @param Messages  短讯实体
	 * @return boolean
	 */
	public boolean saveMessages(Messages messages);	
	
	/**
	 * 删除短讯息
	 * @param id 短讯id
	 * @return boolean
	 */	
	public boolean deleteMessages(int id);
	
	/**
	 * 根据id查询短讯息
	 * @param id 短讯id
	 * @return Messages
	 */
	public Messages SelectMessagesById(int id);
	
	/**
	 * 查询全部短讯息
	 * @return List<Messages>
	 */
	public List<Messages> SelectAllMessages();
	
	/**
	 * 修改短讯息
	 * @param messages 短讯实体
	 * @return boolean
	 */
	public boolean updateMessages(Messages messages);
	
	/**
	 * 根据用户Id查询内容
	 * @param id
	 * @return
	 */
	public List<Messages> SelectMessagesByUserId(int id);
		
}
