package com.gsyoa.dao;

import java.util.List;


import com.gsyoa.entity.Position;

/**
 * 职务DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface PositionDAO {

	/**
	 * 保存职务信息
	 * @param position 职务实体
	 * @return boolean
	 */
	public boolean savePosition(Position position);	
	
	/**
	 * 删除职务信息
	 * @param id 职务id
	 * @return boolean
	 */
	public boolean deletePosition(int id);
	
	/**
	 * 根据id查询职务信息
	 * @param id  职务id
	 * @return Position
	 */
	public Position SelectPositionById(int id);
	
	/**
	 * 查询全部职务信息
	 * @return List<Position>
	 */
	public List<Position> SelectAllPosition();
	
	/**
	 * 修改职务信息
	 * @param position  职务实体
	 * @return boolean
	 */ 
	public boolean updatePosition(Position position);

}
