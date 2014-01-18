package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Apply;
/**
 * ���뵥Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface ApplyService {
	/**
	 * �������뵥
	 * @param apply	����ʵ����
	 * @return	������ʵ��
	 */
	public boolean saveApply(Apply apply);	
	
	/**
	 * ɾ�����뵥
	 * @param id ���뵥Id
	 * @return	������
	 */
	public boolean deleteApply(int id);
	
	/**
	 * ����Id��ѯ
	 * @param id	���뵥Id
	 * @return Apply ���뵥ʵ�� 
	 */
	public Apply SelectApplyById(int id);
	
	/**
	 * ��ѯ�������뵥
	 * @return List<Apply>
	 */
	public List<Apply> SelectAllApply();
	
	/**
	 * �޸����뵥
	 * @param apply	���뵥ʵ��
	 * @return	�޸ĺ�����뵥ʵ��
	 */
	public boolean updateApply(Apply apply);
	
}
