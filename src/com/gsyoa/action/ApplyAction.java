package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Apply;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Type;
import com.gsyoa.entity.User;
import com.gsyoa.entity.Voucher;
import com.gsyoa.entity.VoucherInfo;
import com.gsyoa.service.ApplyService;
import com.gsyoa.service.TypeService;
import com.gsyoa.service.VoucherInfoService;
import com.gsyoa.service.VoucherService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ���뵥�ͱ���������
 * @author yang_С��
 * @date 2013��12��23��
 * 2013��12��23�գ�Τ��������
 */
public class ApplyAction extends ActionSupport {
	
	// ���� ����Applyʵ��
	private Apply apply;
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	
	// ���뱨����ʵ��
	private Voucher voucher;
	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	public Voucher getVoucher() {
		return voucher;
	}
	
	// ���뱨����ϸ��
	private List<VoucherInfo> VoucherInfoList = new ArrayList<VoucherInfo>();
	public List<VoucherInfo> getVoucherInfoList() {
		return VoucherInfoList;
	}
	public void setVoucherInfoList(List<VoucherInfo> voucherInfoList) {
		VoucherInfoList = voucherInfoList;
	}
	
	// ������MessageInfo ʵ�壬���� ��ʾ
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// ���� typeService ���񣬲����� Set����
	private TypeService typeService;
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	// ���� ApplyService ���񣬲����� Set����
	private ApplyService applyService;
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	// ���� VoucherService ���񣬲����� Set����
	private VoucherService voucherService;
	public void setVoucherService(VoucherService voucherService) {
		this.voucherService = voucherService;
	}
	
	// ����VoucherInfoService ���񣬲����� Set����
	private VoucherInfoService voucherInfoService;
	public void setVoucherInfoService(VoucherInfoService voucherInfoService) {
		this.voucherInfoService = voucherInfoService;
	}

	
	// ����������뵥�����б�
	public String progress() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession().get("User");	//��ȡ ��ǰ�û��� Session
		List<Apply> applyList = applyService.SelectAllApply();											//��ȡ�������뵥�б�
		List<Apply> appList = new ArrayList<Apply>();													//������һ�� ���뵥 �б�������ѡ
		//������ȡ���ڵ�ǰ�û���
		for (Apply apply : applyList) {
			if (userSession.getId() == apply.getCreateUserId().getId())
				appList.add(apply);
		}
		ServletActionContext.getRequest().setAttribute("applyList", appList);

		List<Voucher> voucherList = voucherService.SelectAllVoucher();
		List<Voucher> voList = new ArrayList<Voucher>();
		for (Voucher voucher : voucherList) {
			if (userSession.getId() == voucher.getCreateUserId().getId())voList.add(voucher);
		}
		ServletActionContext.getRequest().setAttribute("voucherList", voList);
		return "list";
	}

	// ��ȡ��δ�������뵥�б�--����ʾ��ҳ��
	public String list() throws Exception {
		List<Apply> applyList = applyService.SelectAllApply();
		List<Apply> appList = new ArrayList<Apply>();
		for (Apply apply : applyList) {
			if (apply.getState().equals("δ����"))
				appList.add(apply);
		}
		ServletActionContext.getRequest().setAttribute("applyList", appList);

		List<Voucher> voucherList = voucherService.SelectAllVoucher();
		List<Voucher> voList = new ArrayList<Voucher>();
		for (Voucher voucher : voucherList) {
			if (voucher.getState().equals("δ����"))
				voList.add(voucher);
		}
		ServletActionContext.getRequest().setAttribute("voucherList", voList);
		return "list";
	}

	// ��ȡ���������뵥�б�ͱ�������ϸ�б�-����ʾ��ҳ��
	public String dolist() throws Exception {
		List<Apply> applyList = applyService.SelectAllApply();
		List<Apply> appList = new ArrayList<Apply>();
		for (Apply apply : applyList) {
			if (apply.getState().equals("����"))
				appList.add(apply);
		}
		ServletActionContext.getRequest().setAttribute("applyList", appList);

		List<Voucher> voucherList = voucherService.SelectAllVoucher();
		List<Voucher> voList = new ArrayList<Voucher>();
		for (Voucher voucher : voucherList) {
			if (voucher.getState().equals("����"))
				voList.add(voucher);
		}
		ServletActionContext.getRequest().setAttribute("voucherList", voList);
		return "list";
	}

	// ͬ�����뵥��Ϣ
	public String doCheck() throws Exception {
		Apply a = applyService.SelectApplyById(apply.getId());
		if (a != null) {
			ServletActionContext.getRequest().setAttribute("apply", a);
			a.setState("����");
			applyService.updateApply(a);
			message = new MessageInfo(0, "�������봦����ɣ�", "", "");
		} else {
			message = new MessageInfo(0, "����վ���Ų����ڣ�", "", "");
		}
		return "message";
	}

	// ��ȡ������뵥��Ϣ--��ֵ��ҳ��
	public String check() throws Exception {
		Apply a = applyService.SelectApplyById(apply.getId());
		if (a != null) {
			ServletActionContext.getRequest().setAttribute("apply", a);
		} else {
			message = new MessageInfo(0, "����վ���벻���ڣ�", "", "");
		}
		return "check";
	}

	public String checkvoucher() throws Exception {

		Voucher vouchers = voucherService.SelectVoucherById(voucher.getId());
		List<VoucherInfo> voi = vouchers.getVoucherInfos();
		ServletActionContext.getRequest().setAttribute("voucherInfos", voi);
		ServletActionContext.getRequest().setAttribute("voucher", vouchers);
		return "checkvoucher";
	}

	// �鿴���Ƿ������뵥
	public String delete() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Apply applys = applyService.SelectApplyById(apply.getId());

		if (!applys.getState().equals("δ����")
				|| applys.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "�����ܳ����������룡", "", "");
		} else {
			if (applyService.deleteApply(applys.getId())) {
				message = new MessageInfo(0, "�������뵥�ɹ���", "", "");
			} else {
				message = new MessageInfo(0, "�������뵥ʧ�ܣ�", "", "");
			}
		}
		return "message";
	}

	// ��ȡ���뵥�����б�-��ֵ��ҳ��
	public String register() throws Exception {
		List<Type> typeList = typeService.SelectAllType();
		ServletActionContext.getRequest().setAttribute("typeList", typeList);
		return "register";
	}

	// �޸����뵥
	public String update() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Apply applys = applyService.SelectApplyById(apply.getId());
		applys.setContent(apply.getContent());

		if (applys.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "�������޸Ĵ������룡", "", "");
		} else {
			if (applyService.updateApply(applys)) {
				message = new MessageInfo(0, "�޸����뵥�ɹ���", "", "");
				ServletActionContext.getRequest().setAttribute("apply", applys);
			}else{
				message = new MessageInfo(0, "�޸����뵥ʧ�ܣ�", "", "");
			}
		}
		return "message";
	}

	// ��ȡ���뵥��Ϣ-��ֵ��ҳ���޸�
	public String updateapp() throws Exception {
        List<Type> typeList=typeService.SelectAllType();
		ServletActionContext.getRequest().setAttribute("typeList",typeList);
		
		Apply applys=applyService.SelectApplyById(apply.getId());
		ServletActionContext.getRequest().setAttribute("apply",applys );
		return "update";
	}

	// ������뵥�ύ
	public String add() throws Exception {
		if (!apply.getContent().equals("") && apply.getTypeId().getId() != 0) {
			User userSession = (User) ActionContext.getContext().getSession()
					.get("User");
			apply.setCreateTime(new Date());
			apply.setCreateUserId(userSession);
			apply.setState("δ����");
			applyService.saveApply(apply);
			message = new MessageInfo(0, "�������룬�����ĵȴ��ϼ�����", "", "");
		} else {
			message = new MessageInfo(0, "����ʧ�ܣ����ݲ�������", "", "");

		}
		return "message";
	}

	/**
	 * �����Ǳ���������ϸ��Ϣ����
	 * 
	 * @throws Exception
	 */

	// ��������������ϸ��Ϣ-ɾ��
	public String deleteVoucher() throws Exception {

		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Voucher vouchers = voucherService.SelectVoucherById(voucher.getId());
		if (!vouchers.getState().equals("δ����")
				|| vouchers.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "�����ܳ����������룡", "", "");
		} else {
			if (voucherService.deleteVoucher(vouchers)) {
				message = new MessageInfo(0, "�����ɹ���", "", "");
			} else {
				message = new MessageInfo(0, "����ʧ�ܣ�", "", "");
			}
		}
		return "message";
	}

	// �޸ı���������ϸ��Ϣ-��ֵ����ת��ҳ��
	public String updateVoucher() throws Exception {
		voucher = voucherService.SelectVoucherById(voucher.getId());
		return "updatevoucher";
	}

	// �鿴���Ƿ�ͬ�ⱨ����������
	@SuppressWarnings("unused")
	public String voucherCheck() throws Exception {

		Voucher vod = voucherService.SelectVoucherById(voucher.getId());

		if (vod != null) {
			vod.setState("����");
			voucherService.updateVoucher(vod);
			ServletActionContext.getRequest().setAttribute("voucher", vod);
			message = new MessageInfo(0, "�������봦����ɣ�", "", "");
		} else
			message = new MessageInfo(0, "����վ���Ų����ڣ�", "", "");
		return "message";
	}

	// ����������ϸ��Ϣ-�޸�
	public String updateVoucherCheck() throws Exception {

		Voucher vr = voucherService.SelectVoucherById(voucher.getId());

		voucher.setVoucherInfos(VoucherInfoList);

		voucher.setCreateTime(vr.getCreateTime());
		voucher.setCreateUserId(vr.getCreateUserId());
		voucher.setState("δ����");
		if (voucherService.updateVoucher(voucher)) {
			message = new MessageInfo(0, "����������ϸ��Ϣ-�޸ĳɹ���", "", "");
		} else {
			message = new MessageInfo(0, "����������ϸ��Ϣ-�޸�ʧ�ܣ�~~������ϵ����Ա", "", "");
		}
		return "message";
	}

	// ���뱨��������������ϸ��Ϣ
	public String addVoucher() throws Exception {

		if (VoucherInfoList != null && VoucherInfoList.size() > 0
				&& !voucher.getContent().equals("")
				&& VoucherInfoList.isEmpty() == false) {
			User userSession = (User) ActionContext.getContext().getSession()
					.get("User");
			voucher.setContent(voucher.getContent());
			voucher.setCreateTime(new Date());
			voucher.setCreateUserId(userSession);
			voucher.setState("δ����");
			voucherService.saveVoucher(voucher);
			double moeny = 0;
			for (int i = 0; i < VoucherInfoList.size(); i++) {
				VoucherInfo vo = (VoucherInfo) VoucherInfoList.get(i);
				if (vo.getContent().equals("") || vo.getItem().equals("")
						|| vo.getMoney() == 0) {
					message = new MessageInfo(0, "����ʧ�ܣ����ݲ�������", "", "");
					return "message";
				}
				moeny += vo.getMoney();
				vo.setVoucherId(voucher);
				voucherInfoService.saveVoucherInfo(vo);
				message = new MessageInfo(0, "�������룬�����ĵȴ��ϼ�����", "", "");
			}
			voucher.setMoney(moeny);
			voucherService.updateVoucher(voucher);
		} else {
			message = new MessageInfo(0, "����ʧ�ܣ����ݲ�������", "", "");
		}
		return "message";
	}

}
