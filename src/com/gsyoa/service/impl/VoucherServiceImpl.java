package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.VoucherDAO;
import com.gsyoa.entity.Voucher;
import com.gsyoa.service.VoucherService;

public class VoucherServiceImpl implements VoucherService {
	private VoucherDAO voucherDAO;
	
	public VoucherDAO getVoucherDAO() {
		return voucherDAO;
	}

	public void setVoucherDAO(VoucherDAO voucherDAO) {
		this.voucherDAO = voucherDAO;
	}

	@Override
	public boolean saveVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return voucherDAO.saveVoucher(voucher);
	}

	@Override
	
	public boolean deleteVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return voucherDAO.deleteVoucher(voucher);
	}

	@Override
	public Voucher SelectVoucherById(int id) {
		// TODO Auto-generated method stub
		return voucherDAO.SelectVoucherById(id);
	}

	@Override
	public List<Voucher> SelectAllVoucher() {
		// TODO Auto-generated method stub
		return voucherDAO.SelectAllVoucher();
	}

	@Override
	public boolean updateVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return voucherDAO.updateVoucher(voucher);
	}

}
