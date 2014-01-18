package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.Voucher;

/**
 * 报销单DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface VoucherDAO {

	/**
	 * 保存报销信息
	 * @param voucher 报销单实体
	 * @return boolean
	 */
	public boolean saveVoucher(Voucher voucher);	
	
    /**
     * 删除报销单信息
     * @param id 报销单id
     * @return boolean
     */
	public boolean deleteVoucher(Voucher voucher);
	
	/**
	 * 根据id查询报销单信息
	 * @param id
	 * @return Voucher
	 */
	public Voucher SelectVoucherById(int id);
	
	/**
	 * 查询全部报销单信息
	 * @return List<Voucher>
	 */
	public List<Voucher> SelectAllVoucher();

	/**
	 * 修改报销单信息
	 * @param voucher 报销单实体
	 * @return  boolean
	 */
    public boolean updateVoucher(Voucher voucher);
    
}
