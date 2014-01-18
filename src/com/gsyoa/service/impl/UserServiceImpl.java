package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.UserDAO;
import com.gsyoa.entity.User;
import com.gsyoa.service.UserService;
/**
 * 用户业务处理实现类
 * @author Hello_海生
 * @data 2013年12月11日
 */
public class UserServiceImpl implements UserService {
	//声明UserDAO  并 设置 get  set
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override		//保存用户
	public User saveUser(User user) {
		User u =null;
		if(userDAO.saveUser(user)){
			u = userDAO.selectUserByName(user.getName());
		}
		return u;
	}

	@Override	//删除用户
	public boolean deleteUser(int id) {
		if(id==0){
			//请输入用户Id
		}else{
			if(userDAO.deleteUser(id)){
				return true;
			}else {
				//删除用户失败！
			}
		}
		return false;
	}

	@Override	//根据Id查询用户
	public User SelectUserById(int id) {
		if (id == 0) {
			// 存储错误信息。 请输入Id！
		} else {
			User u = userDAO.SelectUserById(id);
			if(u!=null){
				return u;
			}else{
				//用户Id不存在
			}
		}
		return null;
	}

	@Override		//查询所有用户
	public List<User> SelectAllUser() {
		List<User> userList = userDAO.SelectAllUser();
		if(userList != null){
			return userList;
		}else{
			//查询出错，可能是没有内容
		}
		return null;
	}

	@Override		//修改用户信息
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
