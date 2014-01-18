package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Check;

/**
 * ������DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface CheckDAO {

	/**
	 * ������������Ϣ
	 * @param check ������ʵ��
	 * @return boolean
	 */
    public boolean saveCheck(Check check);	
    
    /**
     * ɾ����������Ϣ
     * @param id ������id
     * @return boolean
     */
	public boolean deleteCheck(int id);
	
	/**
	 * ����id��ѯ��������Ϣ
	 * @param id ������id
	 * @return  Check
	 */
	public Check SelectCheckById(int id);
	
	/**
	 * ��ѯȫ����������Ϣ
	 * @return List<Check>
	 */
	public List<Check> SelectAllCheck();
	
	/**
	 * �޸���������Ϣ
	 * @param check  ������ʵ��
	 * @return boolean
	 */
	public boolean updateCheck(Check check);

}
