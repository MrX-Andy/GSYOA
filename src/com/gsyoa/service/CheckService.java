package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Check;
/**
 * �������뵥Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface CheckService {

	/**
	 * �������뵥������Ϣ
	 * @param check	����ʵ��
	 * @return �ٴ��ĺ���ʵ��
	 */
	public boolean saveCheck(Check check);	
	
	/**
	 * ɾ������
	 * @param id ����Id
	 * @return	������
	 */
	public boolean deleteCheck(int id);
	
	/**
	 * ����ID��ѯ������Ϣ
	 * @param id	����ID
	 * @return	����ʵ��
	 */
	public Check SelectCheckById(int id);
	
	/**
	 * ��ѯ���к���
	 * @return	List<Check> ����ʵ������
	 */
	public List<Check> SelectAllCheck();
	
	/**
	 * �޸ĺ���
	 * @param check	����ʵ��
	 * @return	�޸ĺ�ĺ���ʵ��
	 */
	public boolean updateCheck(Check check);

}
