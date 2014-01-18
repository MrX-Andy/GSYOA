package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Type;
/**
 * ���뵥����Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface TypeService {

	/**
	 * ��������
	 * @param Type	����ʵ��
	 * @return	����������
	 */
    public boolean saveType(Type Type);	
	
    /**
     * ɾ������
     * @param id	����Id
     * @return	������
     */
	public boolean deleteType(int id);
	
	/**
	 * ����Id��ѯѰ����
	 * @param id ����id
	 * @return	����ʵ��
	 */
	public Type SelectTypeById(int id);
	
	/**
	 * ��ѯ��������
	 * @return	List<Type> ����ʵ������
	 */
	public List<Type> SelectAllType();
	
	/**
	 * �޸�����
	 * @param type	����ʵ��
	 * @return	�޸ĺ������ʵ��
	 */
	public boolean updateType(Type type);
	
	
	
}
