package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.VoucherInfo;

/**
 * 报销单信息Service接口
 * @author Hello_海生
 * @date 2013年12月11日
 */
public interface VoucherInfoService {

	/**
	 * 增加报销单信息
	 * @param voucherInfo 报销单信息实体
	 * @return	报销单实体
	 */
	public boolean saveVoucherInfo(VoucherInfo voucherInfo);	
	
	/**
	 * 删除报销单信息
	 * @param id	报销单信息Id
	 * @return	布尔型
	 */
	public boolean deleteVoucherInfo(int id);
	
	/**
	 * 根据Id查询报销单信息
	 * @param id	报销单信息Id
	 * @return	报销单信息实体
	 */
	public VoucherInfo SelectVoucherInfoById(int id);
	
	/**
	 * 查询所有报销单信息
	 * @return List<VoucherInfo> 报销单信息列表
	 */
	public List<VoucherInfo> SelectAllVoucherInfo();
	
	/**
	 * 保存报销单信息
	 * @param voucherInfo	报销单信息实体
	 * @return	修改后的报销单信息实体
	 */
	public boolean updateVoucherInfo(VoucherInfo voucherInfo);
	
}
