package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.VoucherInfo;

/**
 * ��������ϢService�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface VoucherInfoService {

	/**
	 * ���ӱ�������Ϣ
	 * @param voucherInfo ��������Ϣʵ��
	 * @return	������ʵ��
	 */
	public boolean saveVoucherInfo(VoucherInfo voucherInfo);	
	
	/**
	 * ɾ����������Ϣ
	 * @param id	��������ϢId
	 * @return	������
	 */
	public boolean deleteVoucherInfo(int id);
	
	/**
	 * ����Id��ѯ��������Ϣ
	 * @param id	��������ϢId
	 * @return	��������Ϣʵ��
	 */
	public VoucherInfo SelectVoucherInfoById(int id);
	
	/**
	 * ��ѯ���б�������Ϣ
	 * @return List<VoucherInfo> ��������Ϣ�б�
	 */
	public List<VoucherInfo> SelectAllVoucherInfo();
	
	/**
	 * ���汨������Ϣ
	 * @param voucherInfo	��������Ϣʵ��
	 * @return	�޸ĺ�ı�������Ϣʵ��
	 */
	public boolean updateVoucherInfo(VoucherInfo voucherInfo);
	
}
