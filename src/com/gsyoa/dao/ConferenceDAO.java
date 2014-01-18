package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Conference;

/**
 * ���뵥DAO�ӿ�
 * @author �ƽ�ΰ
 * @date 2013��12��27��
 */

public interface ConferenceDAO {

	/**
	 * �������
	 * @param apply    ���뵥ʵ��
	 * @return boolean ������
	 */
	public boolean saveConference(Conference conference);

	/**
	 * ɾ���û�
	 * @param id     ����id
	 * @return boolean ������
	 */
	public boolean deleteConference(int id);

	/**
	 * ����id ��ѯ���뵥
	 * 
	 * @param id    ����id
	 * @return Conference
	 */
	public Conference SelectConferenceById(int id);

	/**
	 * ��ѯȫ������
	 * @return List<Conference>
	 */
	public List<Conference> SelectAllConference();

	/**
	 * �޸Ļ�����Ϣ
	 * @param conference  ����ʵ��
	 * @return boolean
	 */
	public boolean updateConference(Conference conference);

}
