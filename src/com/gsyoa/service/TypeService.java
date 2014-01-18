package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Type;
/**
 * 申请单类型Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface TypeService {

	/**
	 * 保存类型
	 * @param Type	类型实体
	 * @return	保存后的类型
	 */
    public boolean saveType(Type Type);	
	
    /**
     * 删除类型
     * @param id	类型Id
     * @return	布尔型
     */
	public boolean deleteType(int id);
	
	/**
	 * 根据Id查询寻类型
	 * @param id 类型id
	 * @return	类型实体
	 */
	public Type SelectTypeById(int id);
	
	/**
	 * 查询所有类型
	 * @return	List<Type> 类型实体数列
	 */
	public List<Type> SelectAllType();
	
	/**
	 * 修改类型
	 * @param type	类型实体
	 * @return	修改后的类型实体
	 */
	public boolean updateType(Type type);
	
	
	
}
