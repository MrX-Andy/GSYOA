package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Department;

/**
 * 部门DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface DepartmentDAO {

	/**
	 * 保存部门信息
	 * @param department 部门实体
	 * @return
	 */
	public boolean saveDepartment(Department department);	
	
	/**
	 * 删除部门信息
	 * @param id 部门id
	 * @return boolean
	 */
	public boolean deleteDepartment(int id);
	
	/**
	 * 根据id查询部门信息
	 * @param id 部门id
	 * @return Department
	 */
	public Department SelectDepartmentById(int id);
	
	/**
	 *  查询全部部门信息
	 * @return List<Department>
	 */
	public List<Department> SelectAllDepartment();
	
	/**
	 * 修改部门信息
	 * @param department 部门实体
	 * @return boolean
	 */
	public boolean updateDepartment(Department department);	
	
	
}
