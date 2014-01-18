package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.User;

/**
 * 用户DAO接口
 * @author Hello_海生
 * @date 2013年12月10日
 * 杨兵新，2013年12月13日，修改，整理
 * 韦海生，2013年12月14日，增加多对多关系，修改整理、检查
 */
public interface UserDAO {

	/**
	 * 保存用户
	 * @param user	用户实体
	 * @return boolean
	 */
	public boolean saveUser(User user);	
	
	/**
	 * 删除用户
	 * @param id 用户Id
	 * @return boolean 
	 */
	public boolean deleteUser(int id);
	
	/**
	 * 根据Id查询用户
	 * @param id 用户Id
	 * @return List
	 */
	public User SelectUserById(int id);
	
	/**
	 * 查询全部用户
	 * @return List<User>
	 */
	public List<User> SelectAllUser();
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return boolean
	 */
	public boolean updateUser(User user);
	
	/**
	 * 根据名称查询用户
	 * @param name
	 * @return
	 */
	public User selectUserByName(String name);
	
}
