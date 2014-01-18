package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.VoucherInfo;

/**
 * ��������ϸDAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface VoucherInfoDAO {

	/**
	 * ���汨����ϸ����Ϣ
	 * @param voucherInfo  ������ϸ��ʵ��
	 * @return boolean
	 */
	public boolean saveVoucherInfo(VoucherInfo voucherInfo);	
	
	/**
	 * ɾ��������ϸ����Ϣ
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
	 * ��ѯȫ��������ϸ����Ϣ
	 * @return List<VoucherInfo>
	 */
	public List<VoucherInfo> SelectAllVoucherInfo();
	
	/**
	 * �޸ı�����ϸ����Ϣ
	 * @param voucherInfo  ������ϸ��ʵ��
	 * @return boolean
	 */
	public boolean updateVoucherInfo(VoucherInfo voucherInfo);
	
}
