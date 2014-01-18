package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.DepartmentDAO;
import com.gsyoa.entity.Department;
import com.gsyoa.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;
	
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
	public boolean saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDAO.saveDepartment(department);
	}

	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return departmentDAO.deleteDepartment(id);
	}

	@Override
	public Department SelectDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentDAO.SelectDepartmentById(id);
	}

	@Override
	public List<Department> SelectAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDAO.SelectAllDepartment();
	}

	@Override
	public boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDAO.updateDepartment(department);
	}

}
