package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.User;

/**
 * 用户DAO接口
 * @author Hello_海生
 * @date 2013年12月10日
 */
public interface UserService {

	/**
	 * 保存用户
	 * @param user	用户实体
	 * @return 修改后的用户实体
	 */
	public User saveUser(User user);	
	
	/**
	 * 删除用户
	 * @param id 用户Id
	 * @return 布尔型
	 */
	public boolean deleteUser(int id);
	
	/**
	 * 根据Id查询用户
	 * @param id 用户Id
	 * @return 用户实体
	 */
	public User SelectUserById(int id);
	
	/**
	 * 查询全部用户
	 * @return List<User> 用户实体数列
	 */
	public List<User> SelectAllUser();
	
	/**
	 * 修改用户信息
	 * @param user	用户实体
	 * @return 修改后的用户实体
	 */
	public User updateUser(User user);
	
	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	public User selectUserByName(String name);
}