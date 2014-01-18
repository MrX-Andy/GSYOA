package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Type;

/**
 * 申请类别DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface TypeDAO {

	/**
	 * 保存申请类别信息
	 * @param Type 申请类别实体
	 * @return boolean
	 */
    public boolean saveType(Type Type);	
	
    /**
     * 删除申请类别信息
     * @param id  申请类别id
     * @return boolean
     */
	public boolean deleteType(int id);
	
	/**
	 * 根据id查询申请类别信息
	 * @param id
	 * @return Type
	 */
	public Type SelectTypeById(int id);
	
	/**
	 * 查询全部申请类别信息
	 * @return List<Type>
	 */
	public List<Type> SelectAllType();
	
	/**
	 * 修改申请类别信息
	 * @param type 申请类别实体
	 * @return
	 */
	public boolean updateType(Type type);
		
}
