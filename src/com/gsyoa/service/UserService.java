package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.User;

/**
 * �û�DAO�ӿ�
 * @author Hello_����
 * @date 2013��12��10��
 */
public interface UserService {

	/**
	 * �����û�
	 * @param user	�û�ʵ��
	 * @return �޸ĺ���û�ʵ��
	 */
	public User saveUser(User user);	
	
	/**
	 * ɾ���û�
	 * @param id �û�Id
	 * @return ������
	 */
	public boolean deleteUser(int id);
	
	/**
	 * ����Id��ѯ�û�
	 * @param id �û�Id
	 * @return �û�ʵ��
	 */
	public User SelectUserById(int id);
	
	/**
	 * ��ѯȫ���û�
	 * @return List<User> �û�ʵ������
	 */
	public List<User> SelectAllUser();
	
	/**
	 * �޸��û���Ϣ
	 * @param user	�û�ʵ��
	 * @return �޸ĺ���û�ʵ��
	 */
	public User updateUser(User user);
	
	/**
	 * �����û�����ѯ
	 * @param name
	 * @return
	 */
	public User selectUserByName(String name);
}