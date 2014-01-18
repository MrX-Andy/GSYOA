package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Conference;
/**
 * 会议Service接口
 * @author 黄建伟
 * @date 2013年12月27日
 */
public interface ConferenceService {
	/**
	 * 保存会议记录
	 * @param conference	会议实体类
	 * @return	保存后的实体
	 */
	public boolean saveConference(Conference conference);	
	
	/**
	 * 删除会议
	 * @param id 会议Id
	 * @return	布尔型
	 */
	public boolean deleteConference(int id);
	
	/**
	 * 根据Id查询
	 * @param id	会议Id
	 * @return Apply 会议实体 
	 */
	public Conference SelectConferenceById(int id);
	
	/**
	 * 查询所有会议
	 * @return List<Apply>
	 */
	public List<Conference> SelectAllConference();
	
	/**
	 * 修改会议
	 * @param apply	会议实体
	 * @return	修改后的会议实体
	 */
	public boolean updateConference(Conference conference);
	
}
