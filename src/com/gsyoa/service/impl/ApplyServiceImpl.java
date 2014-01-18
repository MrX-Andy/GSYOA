package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.ApplyDAO;
import com.gsyoa.entity.Apply;
import com.gsyoa.service.ApplyService;

public class ApplyServiceImpl implements ApplyService {
	private ApplyDAO applyDAO;
	public ApplyDAO getApplyDAO() {
		return applyDAO;
	}
	public void setApplyDAO(ApplyDAO applyDAO) {
		this.applyDAO = applyDAO;
	}

	
	@Override
	public boolean saveApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyDAO.saveApply(apply);
	}

	@Override
	public boolean deleteApply(int id) {
		// TODO Auto-generated method stub
		return applyDAO.deleteApply(id);
	}

	@Override
	public Apply SelectApplyById(int id) {
		// TODO Auto-generated method stub
		return applyDAO.SelectApplyById(id);
	}

	@Override
	public List<Apply> SelectAllApply() {
		// TODO Auto-generated method stub
		return applyDAO.SelectAllApply();
	}

	@Override
	public boolean updateApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyDAO.updateApply(apply);
	}

}
