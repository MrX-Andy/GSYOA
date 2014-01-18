package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.User;

/**
 * �û�DAO�ӿ�
 * @author Hello_����
 * @date 2013��12��10��
 * ����£�2013��12��13�գ��޸ģ�����
 * Τ������2013��12��14�գ����Ӷ�Զ��ϵ���޸��������
 */
public interface UserDAO {

	/**
	 * �����û�
	 * @param user	�û�ʵ��
	 * @return boolean
	 */
	public boolean saveUser(User user);	
	
	/**
	 * ɾ���û�
	 * @param id �û�Id
	 * @return boolean 
	 */
	public boolean deleteUser(int id);
	
	/**
	 * ����Id��ѯ�û�
	 * @param id �û�Id
	 * @return List
	 */
	public User SelectUserById(int id);
	
	/**
	 * ��ѯȫ���û�
	 * @return List<User>
	 */
	public List<User> SelectAllUser();
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return boolean
	 */
	public boolean updateUser(User user);
	
	/**
	 * �������Ʋ�ѯ�û�
	 * @param name
	 * @return
	 */
	public User selectUserByName(String name);
	
}
