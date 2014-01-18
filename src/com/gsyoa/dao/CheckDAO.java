package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Check;

/**
 * 审批单DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface CheckDAO {

	/**
	 * 保存审批单信息
	 * @param check 审批单实体
	 * @return boolean
	 */
    public boolean saveCheck(Check check);	
    
    /**
     * 删除审批单信息
     * @param id 审批单id
     * @return boolean
     */
	public boolean deleteCheck(int id);
	
	/**
	 * 根据id查询审批单信息
	 * @param id 审批单id
	 * @return  Check
	 */
	public Check SelectCheckById(int id);
	
	/**
	 * 查询全部审批单信息
	 * @return List<Check>
	 */
	public List<Check> SelectAllCheck();
	
	/**
	 * 修改审批单信息
	 * @param check  审批单实体
	 * @return boolean
	 */
	public boolean updateCheck(Check check);

}
