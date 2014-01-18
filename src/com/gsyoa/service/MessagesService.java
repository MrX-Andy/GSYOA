package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Messages;
/**
 * 信息Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface MessagesService {

	/**
	 * 保存信息（发送信息）
	 * @param Messages 信息实体
	 * @return	保存后的信息实体
	 */
	public boolean saveMessages(Messages Messages);	

	/**
	 * 删除信息
	 * @param id	信息Id
	 * @return	布尔型
	 */
	public boolean deleteMessages(int id);
	
	/**
	 * 根据Id查找信息
	 * @param id	信息Id
	 * @return	信息实体
	 */
	public Messages SelectMessagesById(int id);
	
	/**
	 * 查询所有信息列表
	 * @return List<Messages> 信息实体数列
	 */
	public List<Messages> SelectAllMessages();
	
	/**
	 * 修改信息
	 * @param messages	信息实体
	 * @return	修改后的信息实体
	 */
	public boolean updateMessages(Messages messages);
	
	/**
	 * 根据用户Id查询内容
	 * @param id
	 * @return
	 */
	public List<Messages> SelectMessagesByUserId(int id);
	
	
}
