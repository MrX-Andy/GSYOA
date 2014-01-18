package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Voucher;
/**
 * 报销单Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface VoucherService {
	/**
	 * 保存报销单
	 * @param voucher	报销单实体
	 * @return	保存后报销单实体
	 */
	public boolean saveVoucher(Voucher voucher);	
	
	/**
	 * 删除报销单
	 * @param id	报销单Id
	 * @return	布尔型
	 */
	public boolean deleteVoucher(Voucher voucher);
	
	/**
	 * 查询报销单
	 * @param id	报销单id
	 * @return	报销单实体
	 */
	public Voucher SelectVoucherById(int id);
	
	/**
	 * 查询所有报销单
	 * @return	list 报销单实体列表
	 */
	public List<Voucher> SelectAllVoucher();

	/**
	 * 修改报销单
	 * @param voucher	报销单实体
	 * @return	报销单实体
	 */
	public boolean updateVoucher(Voucher voucher);
  
}
