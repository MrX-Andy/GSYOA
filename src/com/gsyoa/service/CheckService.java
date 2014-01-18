package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Check;
/**
 * 核审申请单Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface CheckService {

	/**
	 * 保存申请单核审信息
	 * @param check	核审实体
	 * @return 百村后的核审单实体
	 */
	public boolean saveCheck(Check check);	
	
	/**
	 * 删除核审单
	 * @param id 核审单Id
	 * @return	布尔型
	 */
	public boolean deleteCheck(int id);
	
	/**
	 * 根据ID查询和审单信息
	 * @param id	核审单ID
	 * @return	核审单实体
	 */
	public Check SelectCheckById(int id);
	
	/**
	 * 查询所有核审单
	 * @return	List<Check> 核审单实体数列
	 */
	public List<Check> SelectAllCheck();
	
	/**
	 * 修改核审单
	 * @param check	核审单实体
	 * @return	修改后的核审实体
	 */
	public boolean updateCheck(Check check);

}
