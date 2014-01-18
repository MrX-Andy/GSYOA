package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.VoucherInfo;

/**
 * 报销单详细DAO接口
 * @author yang_小新
 * @date  2013年12月11日
 */
public interface VoucherInfoDAO {

	/**
	 * 保存报销详细单信息
	 * @param voucherInfo  报销详细单实体
	 * @return boolean
	 */
	public boolean saveVoucherInfo(VoucherInfo voucherInfo);	
	
	/**
	 * 删除报销详细单信息
	 * @param id
	 * @return boolean
	 */
	public boolean deleteVoucherInfo(int id);
	
	/**
	 * 
	 * @param id
	 * @return VoucherInfo
	 */
	public VoucherInfo SelectVoucherInfoById(int id);
	
	/**
	 * 查询全部报销详细单信息
	 * @return List<VoucherInfo>
	 */
	public List<VoucherInfo> SelectAllVoucherInfo();
	
	/**
	 * 修改报销详细单信息
	 * @param voucherInfo  报销详细单实体
	 * @return boolean
	 */
	public boolean updateVoucherInfo(VoucherInfo voucherInfo);
	
}
