package com.gsyoa.service;

import java.util.List;


import com.gsyoa.entity.Position;

/**
 * ְλService�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface PositionService {
	/**
	 * ����ְλ
	 * @param position	ְλʵ��
	 * @return	ְλʵ��
	 */
	public boolean savePosition(Position position);	
	
	/**
	 * ɾ��ְλ
	 * @param id	ְλId
	 * @return	������
	 */
	public boolean deletePosition(int id);
	
	/**
	 * ��ѯְλ
	 * @param id ְλid
	 * @return	ְλʵ��
	 */
	public Position SelectPositionById(int id);
	
	/**
	 * ��ѯ����ְλ
	 * @return list<Position> 
	 */
	public List<Position> SelectAllPosition();
	
	/**
	 * �޸�ְλ
	 * @param position	ְλʵ��
	 * @return	�޸ĺ��ְλʵ��
	 */
	public boolean updatePosition(Position position);

}
