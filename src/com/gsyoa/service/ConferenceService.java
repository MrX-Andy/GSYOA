package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Conference;
/**
 * ����Service�ӿ�
 * @author �ƽ�ΰ
 * @date 2013��12��27��
 */
public interface ConferenceService {
	/**
	 * ��������¼
	 * @param conference	����ʵ����
	 * @return	������ʵ��
	 */
	public boolean saveConference(Conference conference);	
	
	/**
	 * ɾ������
	 * @param id ����Id
	 * @return	������
	 */
	public boolean deleteConference(int id);
	
	/**
	 * ����Id��ѯ
	 * @param id	����Id
	 * @return Apply ����ʵ�� 
	 */
	public Conference SelectConferenceById(int id);
	
	/**
	 * ��ѯ���л���
	 * @return List<Apply>
	 */
	public List<Conference> SelectAllConference();
	
	/**
	 * �޸Ļ���
	 * @param apply	����ʵ��
	 * @return	�޸ĺ�Ļ���ʵ��
	 */
	public boolean updateConference(Conference conference);
	
}
