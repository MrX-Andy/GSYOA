package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Apply;

/**
 * ���뵥DAO�ӿ�
 * @author yang_С��
 * @date 2013��12��11��
 * Τ������2013��12��14�գ��������
 */

public interface ApplyDAO {

	/**
	 * �������뵥
	 * @param apply    ���뵥ʵ��
	 * @return boolean ������
	 */
	public boolean saveApply(Apply apply);

	/**
	 * ɾ���û�
	 * @param id     ���뵥id
	 * @return boolean ������
	 */
	public boolean deleteApply(int id);

	/**
	 * ����id ��ѯ���뵥
	 * 
	 * @param id    ���뵥id
	 * @return Apply
	 */
	public Apply SelectApplyById(int id);

	/**
	 * ��ѯȫ�����뵥
	 * @return List<Apply>
	 */
	public List<Apply> SelectAllApply();

	/**
	 * �޸����뵥��Ϣ
	 * @param apply  ���뵥ʵ��
	 * @return boolean
	 */
	public boolean updateApply(Apply apply);

}
