package com.gsyoa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户实体类
 * 
 * @author Hello_海生
 * @date 2013年12月10日 
 * 杨兵新 ，2013年12月13日，增加Id构造函数 
 * 韦海生，2013年12月14日，修改、整理、检查
 */
@Entity
@Table(name = "gsyoa_user")
public class User {
	private int id; // 用户ID
	private String name; // 用户名称
	private String password; // 用户密码
	private String email; // 用户e-mail
	private String phone; // 用户电话 ，因为int型在数据库中存11位字符貌似有点问题，所以用String
	private String state; // 用户状态
	private Department departmentId; // 所属部门
	private Set<Position> positionId = new HashSet<Position>(); // 所属职务。多对多

	/**
	 * 无惨构造
	 */
	public User() {
		super();
	}

	/**
	 * 有参构造方法
	 * @param id	 用户ID
	 */
	public User(int id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造方法
	 * @param id        用户ID
	 * @param name  用户名称
	 * @param password	 用户密码
	 * @param email	用户e-mail
	 * @param phone 用户电话
	 * @param state  用户状态
	 * @param departmentId 所属部门
	 */
	public User(int id, String name, String password, String email,	String phone, String state, Department departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.departmentId = departmentId;
	}

	// get和set

	@Id	// 设置主键
	@GeneratedValue		// 主键自增
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 16)		// 设置用户名长度
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 32)		// 设置用户密码长度， 为什么是32位的？ 因为 md5 加密后是 32位的 ，密码要md5加密
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 100)		// 设置邮件地址长度
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 11)		// 设置手机号码长度
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 10)		// 设置状态长度
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@ManyToOne
	@JoinColumn(name = "departmentId")		// 设置所属部门，外键关联
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToMany(fetch=FetchType.EAGER)			//实体类加入
	@JoinTable(name = "GSYOA_User_Position", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "positionId") })
	public Set<Position> getPositionId() {
		return positionId;
	}
	public void setPositionId(Set<Position> positionId) {
		this.positionId = positionId;
	}

}
