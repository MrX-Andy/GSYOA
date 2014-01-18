package com.gsyoa.service.impl;

import java.util.List;


import com.gsyoa.dao.VoucherInfoDAO;
import com.gsyoa.entity.VoucherInfo;
import com.gsyoa.service.VoucherInfoService;

public class VoucherInfoServiceImpl implements VoucherInfoService {
	private  VoucherInfoDAO voucherInfoDAO;
	
	

	@Override
	public boolean saveVoucherInfo(VoucherInfo voucherInfo) {
		// TODO Auto-generated method stub
		return voucherInfoDAO.saveVoucherInfo(voucherInfo);
	}

	@Override
	public boolean deleteVoucherInfo(int id) {
		// TODO Auto-generated method stub
		return voucherInfoDAO.deleteVoucherInfo(id);
	}

	@Override
	public VoucherInfo SelectVoucherInfoById(int id) {
		// TODO Auto-generated method stub
		return voucherInfoDAO.SelectVoucherInfoById(id);
	}

	@Override
	public List<VoucherInfo> SelectAllVoucherInfo() {
		// TODO Auto-generated method stub
		return voucherInfoDAO.SelectAllVoucherInfo();
	}

	public VoucherInfoDAO getVoucherInfoDAO() {
		return voucherInfoDAO;
	}

	public void setVoucherInfoDAO(VoucherInfoDAO voucherInfoDAO) {
		this.voucherInfoDAO = voucherInfoDAO;
	}

	@Override
	public boolean updateVoucherInfo(VoucherInfo voucherInfo) {
		// TODO Auto-generated method stub
		return voucherInfoDAO.updateVoucherInfo(voucherInfo);
	}

}
