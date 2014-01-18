package com.gsyoa.dao;

import java.util.List;


import com.gsyoa.entity.Position;

/**
 * ְ��DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface PositionDAO {

	/**
	 * ����ְ����Ϣ
	 * @param position ְ��ʵ��
	 * @return boolean
	 */
	public boolean savePosition(Position position);	
	
	/**
	 * ɾ��ְ����Ϣ
	 * @param id ְ��id
	 * @return boolean
	 */
	public boolean deletePosition(int id);
	
	/**
	 * ����id��ѯְ����Ϣ
	 * @param id  ְ��id
	 * @return Position
	 */
	public Position SelectPositionById(int id);
	
	/**
	 * ��ѯȫ��ְ����Ϣ
	 * @return List<Position>
	 */
	public List<Position> SelectAllPosition();
	
	/**
	 * �޸�ְ����Ϣ
	 * @param position  ְ��ʵ��
	 * @return boolean
	 */ 
	public boolean updatePosition(Position position);

}
