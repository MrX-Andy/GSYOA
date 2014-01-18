package com.gsyoa.dao;

import java.util.List;

import com.gsyoa.entity.Department;

/**
 * ����DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface DepartmentDAO {

	/**
	 * ���沿����Ϣ
	 * @param department ����ʵ��
	 * @return
	 */
	public boolean saveDepartment(Department department);	
	
	/**
	 * ɾ��������Ϣ
	 * @param id ����id
	 * @return boolean
	 */
	public boolean deleteDepartment(int id);
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param id ����id
	 * @return Department
	 */
	public Department SelectDepartmentById(int id);
	
	/**
	 *  ��ѯȫ��������Ϣ
	 * @return List<Department>
	 */
	public List<Department> SelectAllDepartment();
	
	/**
	 * �޸Ĳ�����Ϣ
	 * @param department ����ʵ��
	 * @return boolean
	 */
	public boolean updateDepartment(Department department);	
	
	
}
