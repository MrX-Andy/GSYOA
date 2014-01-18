package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.UserDAO;
import com.gsyoa.entity.User;
import com.gsyoa.service.UserService;
/**
 * �û�ҵ����ʵ����
 * @author Hello_����
 * @data 2013��12��11��
 */
public class UserServiceImpl implements UserService {
	//����UserDAO  �� ���� get  set
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override		//�����û�
	public User saveUser(User user) {
		User u =null;
		if(userDAO.saveUser(user)){
			u = userDAO.selectUserByName(user.getName());
		}
		return u;
	}

	@Override	//ɾ���û�
	public boolean deleteUser(int id) {
		if(id==0){
			//�������û�Id
		}else{
			if(userDAO.deleteUser(id)){
				return true;
			}else {
				//ɾ���û�ʧ�ܣ�
			}
		}
		return false;
	}

	@Override	//����Id��ѯ�û�
	public User SelectUserById(int id) {
		if (id == 0) {
			// �洢������Ϣ�� ������Id��
		} else {
			User u = userDAO.SelectUserById(id);
			if(u!=null){
				return u;
			}else{
				//�û�Id������
			}
		}
		return null;
	}

	@Override		//��ѯ�����û�
	public List<User> SelectAllUser() {
		List<User> userList = userDAO.SelectAllUser();
		if(userList != null){
			return userList;
		}else{
			//��ѯ����������û������
		}
		return null;
	}

	@Override		//�޸��û���Ϣ
	public User updateUser(User user) {
		User u=null;
		if(userDAO.updateUser(user)){
			u = userDAO.SelectUserById(user.getId());
		}
		return u;
	}
	@Override
	public User selectUserByName(String name) {
		// TODO Auto-generated method stub
		return userDAO.selectUserByName(name);
	}

}
