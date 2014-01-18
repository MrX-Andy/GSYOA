package com.gsyoa.dao;

import java.util.List;
import com.gsyoa.entity.Voucher;

/**
 * ������DAO�ӿ�
 * @author yang_С��
 * @date  2013��12��11��
 */
public interface VoucherDAO {

	/**
	 * ���汨����Ϣ
	 * @param voucher ������ʵ��
	 * @return boolean
	 */
	public boolean saveVoucher(Voucher voucher);	
	
    /**
     * ɾ����������Ϣ
     * @param id ������id
     * @return boolean
     */
	public boolean deleteVoucher(Voucher voucher);
	
	/**
	 * ����id��ѯ��������Ϣ
	 * @param id
	 * @return Voucher
	 */
	public Voucher SelectVoucherById(int id);
	
	/**
	 * ��ѯȫ����������Ϣ
	 * @return List<Voucher>
	 */
	public List<Voucher> SelectAllVoucher();

	/**
	 * �޸ı�������Ϣ
	 * @param voucher ������ʵ��
	 * @return  boolean
	 */
    public boolean updateVoucher(Voucher voucher);
    
}
