package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Apply;
/**
 * 申请单Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface ApplyService {
	/**
	 * 保存申请单
	 * @param apply	申请实体类
	 * @return	保存后的实体
	 */
	public boolean saveApply(Apply apply);	
	
	/**
	 * 删除申请单
	 * @param id 申请单Id
	 * @return	布尔型
	 */
	public boolean deleteApply(int id);
	
	/**
	 * 根据Id查询
	 * @param id	申请单Id
	 * @return Apply 申请单实体 
	 */
	public Apply SelectApplyById(int id);
	
	/**
	 * 查询所有申请单
	 * @return List<Apply>
	 */
	public List<Apply> SelectAllApply();
	
	/**
	 * 修改申请单
	 * @param apply	申请单实体
	 * @return	修改后的申请单实体
	 */
	public boolean updateApply(Apply apply);
	
}
