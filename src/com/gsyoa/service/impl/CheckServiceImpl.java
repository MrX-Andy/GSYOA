package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.CheckDAO;
import com.gsyoa.entity.Check;
import com.gsyoa.service.CheckService;

public class CheckServiceImpl implements CheckService {
	private CheckDAO checkDAO;
	
	public CheckDAO getCheckDAO() {
		return checkDAO;
	}

	public void setCheckDAO(CheckDAO checkDAO) {
		this.checkDAO = checkDAO;
	}

	@Override
	public boolean saveCheck(Check check) {
		// TODO Auto-generated method stub
		return checkDAO.saveCheck(check);
	}

	@Override
	public boolean deleteCheck(int id) {
		// TODO Auto-generated method stub
		return checkDAO.deleteCheck(id);
	}

	@Override
	public Check SelectCheckById(int id) {
		// TODO Auto-generated method stub
		return checkDAO.SelectCheckById(id);
	}

	@Override
	public List<Check> SelectAllCheck() {
		// TODO Auto-generated method stub
		return checkDAO.SelectAllCheck();
	}

	@Override
	public boolean updateCheck(Check check) {
		// TODO Auto-generated method stub
		return checkDAO.updateCheck(check);
	}

}
