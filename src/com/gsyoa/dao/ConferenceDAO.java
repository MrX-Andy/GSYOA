package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Conference;

/**
 * 申请单DAO接口
 * @author 黄建伟
 * @date 2013年12月27日
 */

public interface ConferenceDAO {

	/**
	 * 保存会议
	 * @param apply    申请单实体
	 * @return boolean 布尔型
	 */
	public boolean saveConference(Conference conference);

	/**
	 * 删除用户
	 * @param id     会议id
	 * @return boolean 布尔型
	 */
	public boolean deleteConference(int id);

	/**
	 * 根据id 查询申请单
	 * 
	 * @param id    会议id
	 * @return Conference
	 */
	public Conference SelectConferenceById(int id);

	/**
	 * 查询全部会议
	 * @return List<Conference>
	 */
	public List<Conference> SelectAllConference();

	/**
	 * 修改会议信息
	 * @param conference  会议实体
	 * @return boolean
	 */
	public boolean updateConference(Conference conference);

}
