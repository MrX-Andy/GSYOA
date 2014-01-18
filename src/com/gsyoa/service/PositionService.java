package com.gsyoa.service;

import java.util.List;


import com.gsyoa.entity.Position;

/**
 * 职位Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface PositionService {
	/**
	 * 保存职位
	 * @param position	职位实体
	 * @return	职位实体
	 */
	public boolean savePosition(Position position);	
	
	/**
	 * 删除职位
	 * @param id	职位Id
	 * @return	布尔型
	 */
	public boolean deletePosition(int id);
	
	/**
	 * 查询职位
	 * @param id 职位id
	 * @return	职位实体
	 */
	public Position SelectPositionById(int id);
	
	/**
	 * 查询所有职位
	 * @return list<Position> 
	 */
	public List<Position> SelectAllPosition();
	
	/**
	 * 修改职位
	 * @param position	职位实体
	 * @return	修改后的职位实体
	 */
	public boolean updatePosition(Position position);

}
