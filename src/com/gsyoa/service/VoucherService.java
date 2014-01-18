package com.gsyoa.service;

import java.util.List;

import com.gsyoa.entity.Voucher;
/**
 * ������Service�ӿ�
 * @author Hello_����
 * @date 2013��12��11��
 */
public interface VoucherService {
	/**
	 * ���汨����
	 * @param voucher	������ʵ��
	 * @return	���������ʵ��
	 */
	public boolean saveVoucher(Voucher voucher);	
	
	/**
	 * ɾ��������
	 * @param id	������Id
	 * @return	������
	 */
	public boolean deleteVoucher(Voucher voucher);
	
	/**
	 * ��ѯ������
	 * @param id	������id
	 * @return	������ʵ��
	 */
	public Voucher SelectVoucherById(int id);
	
	/**
	 * ��ѯ���б�����
	 * @return	list ������ʵ���б�
	 */
	public List<Voucher> SelectAllVoucher();

	/**
	 * �޸ı�����
	 * @param voucher	������ʵ��
	 * @return	������ʵ��
	 */
	public boolean updateVoucher(Voucher voucher);
  
}
