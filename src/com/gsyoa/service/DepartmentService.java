package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Department;
/**
 * 部门Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface DepartmentService {
	/**
	 * 保存部门
	 * @param department	部门实体
	 * @return 保存后的 部门实体
	 */
	public boolean saveDepartment(Department department);
	
	/**
	 * 删除部门
	 * @param id	部门Id
	 * @return	布尔型
	 */
	public boolean deleteDepartment(int id);
	
	/**
	 * 根据ID查询部门
	 * @param id 部门Id
	 * @return	部门实体
	 */
	public Department SelectDepartmentById(int id);
	
	/**
	 * 查询所有部门
	 * @return List<Department> 部门实体数列
	 */
	public List<Department> SelectAllDepartment();
	
	/**
	 * 修改部门
	 * @param department	部门实体
	 * @return	修改后的部门实体
	 */
	public boolean updateDepartment(Department department);	
	
}
