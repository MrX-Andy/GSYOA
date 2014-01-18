package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Type;

/**
 * �������DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface TypeDAO {

	/**
	 * �������������Ϣ
	 * @param Type �������ʵ��
	 * @return boolean
	 */
    public boolean saveType(Type Type);	
	
    /**
     * ɾ�����������Ϣ
     * @param id  �������id
     * @return boolean
     */
	public boolean deleteType(int id);
	
	/**
	 * ����id��ѯ���������Ϣ
	 * @param id
	 * @return Type
	 */
	public Type SelectTypeById(int id);
	
	/**
	 * ��ѯȫ�����������Ϣ
	 * @return List<Type>
	 */
	public List<Type> SelectAllType();
	
	/**
	 * �޸����������Ϣ
	 * @param type �������ʵ��
	 * @return
	 */
	public boolean updateType(Type type);
		
}
