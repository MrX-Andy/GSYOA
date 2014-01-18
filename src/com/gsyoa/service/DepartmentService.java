package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Department;
/**
 * ����Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface DepartmentService {
	/**
	 * ���沿��
	 * @param department	����ʵ��
	 * @return ������ ����ʵ��
	 */
	public boolean saveDepartment(Department department);
	
	/**
	 * ɾ������
	 * @param id	����Id
	 * @return	������
	 */
	public boolean deleteDepartment(int id);
	
	/**
	 * ����ID��ѯ����
	 * @param id ����Id
	 * @return	����ʵ��
	 */
	public Department SelectDepartmentById(int id);
	
	/**
	 * ��ѯ���в���
	 * @return List<Department> ����ʵ������
	 */
	public List<Department> SelectAllDepartment();
	
	/**
	 * �޸Ĳ���
	 * @param department	����ʵ��
	 * @return	�޸ĺ�Ĳ���ʵ��
	 */
	public boolean updateDepartment(Department department);	
	
}
