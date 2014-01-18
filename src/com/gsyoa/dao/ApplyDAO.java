package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Apply;

/**
 * 申请单DAO接口
 * @author yang_小新
 * @date 2013年12月11日
 * 韦海生，2013年12月14日，整理、检查
 */

public interface ApplyDAO {

	/**
	 * 保存申请单
	 * @param apply    申请单实体
	 * @return boolean 布尔型
	 */
	public boolean saveApply(Apply apply);

	/**
	 * 删除用户
	 * @param id     申请单id
	 * @return boolean 布尔型
	 */
	public boolean deleteApply(int id);

	/**
	 * 根据id 查询申请单
	 * 
	 * @param id    申请单id
	 * @return Apply
	 */
	public Apply SelectApplyById(int id);

	/**
	 * 查询全部申请单
	 * @return List<Apply>
	 */
	public List<Apply> SelectAllApply();

	/**
	 * 修改申请单信息
	 * @param apply  申请单实体
	 * @return boolean
	 */
	public boolean updateApply(Apply apply);

}
