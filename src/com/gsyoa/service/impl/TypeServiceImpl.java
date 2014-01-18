package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.TypeDAO;
import com.gsyoa.entity.Type;
import com.gsyoa.service.TypeService;

public class TypeServiceImpl implements TypeService {
	private TypeDAO typeDAO;
	
	
	@Override
	public boolean saveType(Type Type) {
		// TODO Auto-generated method stub
		return typeDAO.saveType(Type);
	}

	@Override
	public boolean deleteType(int id) {
		// TODO Auto-generated method stub
		return typeDAO.deleteType(id);
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	@Override
	public Type SelectTypeById(int id) {
		// TODO Auto-generated method stub
		return typeDAO.SelectTypeById(id);
	}

	@Override
	public List<Type> SelectAllType() {
		// TODO Auto-generated method stub
		return typeDAO.SelectAllType();
	}

	@Override
	public boolean updateType(Type type) {
		// TODO Auto-generated method stub
		return typeDAO.updateType(type);
	}

}
