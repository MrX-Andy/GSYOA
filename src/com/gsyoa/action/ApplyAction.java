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
 * 申请单和报销单处理
 * @author yang_小新
 * @date 2013年12月23日
 * 2013年12月23日，韦海生整理
 */
public class ApplyAction extends ActionSupport {
	
	// 声明 申请Apply实体
	private Apply apply;
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	
	// 申请报销单实体
	private Voucher voucher;
	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	public Voucher getVoucher() {
		return voucher;
	}
	
	// 申请报销详细单
	private List<VoucherInfo> VoucherInfoList = new ArrayList<VoucherInfo>();
	public List<VoucherInfo> getVoucherInfoList() {
		return VoucherInfoList;
	}
	public void setVoucherInfoList(List<VoucherInfo> voucherInfoList) {
		VoucherInfoList = voucherInfoList;
	}
	
	// 声明，MessageInfo 实体，用于 提示
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// 声明 typeService 服务，并设置 Set方法
	private TypeService typeService;
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	// 声明 ApplyService 服务，并设置 Set方法
	private ApplyService applyService;
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	// 声明 VoucherService 服务，并设置 Set方法
	private VoucherService voucherService;
	public void setVoucherService(VoucherService voucherService) {
		this.voucherService = voucherService;
	}
	
	// 声明VoucherInfoService 服务，并设置 Set方法
	private VoucherInfoService voucherInfoService;
	public void setVoucherInfoService(VoucherInfoService voucherInfoService) {
		this.voucherInfoService = voucherInfoService;
	}

	
	// 处理个人申请单进度列表
	public String progress() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession().get("User");	//获取 当前用户的 Session
		List<Apply> applyList = applyService.SelectAllApply();											//获取所有申请单列表
		List<Apply> appList = new ArrayList<Apply>();													//新声明一个 申请单 列表，用于赛选
		//遍历获取属于当前用户的
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

	// 获取“未处理”申请单列表--并显示至页面
	public String list() throws Exception {
		List<Apply> applyList = applyService.SelectAllApply();
		List<Apply> appList = new ArrayList<Apply>();
		for (Apply apply : applyList) {
			if (apply.getState().equals("未处理"))
				appList.add(apply);
		}
		ServletActionContext.getRequest().setAttribute("applyList", appList);

		List<Voucher> voucherList = voucherService.SelectAllVoucher();
		List<Voucher> voList = new ArrayList<Voucher>();
		for (Voucher voucher : voucherList) {
			if (voucher.getState().equals("未处理"))
				voList.add(voucher);
		}
		ServletActionContext.getRequest().setAttribute("voucherList", voList);
		return "list";
	}

	// 获取“处理”申请单列表和报销单详细列表-并显示至页面
	public String dolist() throws Exception {
		List<Apply> applyList = applyService.SelectAllApply();
		List<Apply> appList = new ArrayList<Apply>();
		for (Apply apply : applyList) {
			if (apply.getState().equals("处理"))
				appList.add(apply);
		}
		ServletActionContext.getRequest().setAttribute("applyList", appList);

		List<Voucher> voucherList = voucherService.SelectAllVoucher();
		List<Voucher> voList = new ArrayList<Voucher>();
		for (Voucher voucher : voucherList) {
			if (voucher.getState().equals("处理"))
				voList.add(voucher);
		}
		ServletActionContext.getRequest().setAttribute("voucherList", voList);
		return "list";
	}

	// 同意申请单信息
	public String doCheck() throws Exception {
		Apply a = applyService.SelectApplyById(apply.getId());
		if (a != null) {
			ServletActionContext.getRequest().setAttribute("apply", a);
			a.setState("处理");
			applyService.updateApply(a);
			message = new MessageInfo(0, "该条申请处理完成！", "", "");
		} else {
			message = new MessageInfo(0, "该条站内信不存在！", "", "");
		}
		return "message";
	}

	// 获取点击申请单信息--传值至页面
	public String check() throws Exception {
		Apply a = applyService.SelectApplyById(apply.getId());
		if (a != null) {
			ServletActionContext.getRequest().setAttribute("apply", a);
		} else {
			message = new MessageInfo(0, "该条站申请不存在！", "", "");
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

	// 查看并是否撤销申请单
	public String delete() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Apply applys = applyService.SelectApplyById(apply.getId());

		if (!applys.getState().equals("未处理")
				|| applys.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "您不能撤销此条申请！", "", "");
		} else {
			if (applyService.deleteApply(applys.getId())) {
				message = new MessageInfo(0, "撤销申请单成功！", "", "");
			} else {
				message = new MessageInfo(0, "撤销申请单失败！", "", "");
			}
		}
		return "message";
	}

	// 获取申请单类型列表-传值到页面
	public String register() throws Exception {
		List<Type> typeList = typeService.SelectAllType();
		ServletActionContext.getRequest().setAttribute("typeList", typeList);
		return "register";
	}

	// 修改申请单
	public String update() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Apply applys = applyService.SelectApplyById(apply.getId());
		applys.setContent(apply.getContent());

		if (applys.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "您不能修改此条申请！", "", "");
		} else {
			if (applyService.updateApply(applys)) {
				message = new MessageInfo(0, "修改申请单成功！", "", "");
				ServletActionContext.getRequest().setAttribute("apply", applys);
			}else{
				message = new MessageInfo(0, "修改申请单失败！", "", "");
			}
		}
		return "message";
	}

	// 获取申请单信息-传值至页面修改
	public String updateapp() throws Exception {
        List<Type> typeList=typeService.SelectAllType();
		ServletActionContext.getRequest().setAttribute("typeList",typeList);
		
		Apply applys=applyService.SelectApplyById(apply.getId());
		ServletActionContext.getRequest().setAttribute("apply",applys );
		return "update";
	}

	// 添加申请单提交
	public String add() throws Exception {
		if (!apply.getContent().equals("") && apply.getTypeId().getId() != 0) {
			User userSession = (User) ActionContext.getContext().getSession()
					.get("User");
			apply.setCreateTime(new Date());
			apply.setCreateUserId(userSession);
			apply.setState("未处理");
			applyService.saveApply(apply);
			message = new MessageInfo(0, "正在申请，请耐心等待上级核审", "", "");
		} else {
			message = new MessageInfo(0, "申请失败，内容不完整！", "", "");

		}
		return "message";
	}

	/**
	 * 以下是报销单及详细信息处理
	 * 
	 * @throws Exception
	 */

	// 撤销报销单及详细信息-删除
	public String deleteVoucher() throws Exception {

		User userSession = (User) ActionContext.getContext().getSession()
				.get("User");
		Voucher vouchers = voucherService.SelectVoucherById(voucher.getId());
		if (!vouchers.getState().equals("未处理")
				|| vouchers.getCreateUserId().getId() != userSession.getId()) {
			message = new MessageInfo(0, "您不能撤销此条申请！", "", "");
		} else {
			if (voucherService.deleteVoucher(vouchers)) {
				message = new MessageInfo(0, "撤销成功！", "", "");
			} else {
				message = new MessageInfo(0, "撤销失败！", "", "");
			}
		}
		return "message";
	}

	// 修改报销单及详细信息-传值并跳转至页面
	public String updateVoucher() throws Exception {
		voucher = voucherService.SelectVoucherById(voucher.getId());
		return "updatevoucher";
	}

	// 查看并是否同意报销单的申请
	@SuppressWarnings("unused")
	public String voucherCheck() throws Exception {

		Voucher vod = voucherService.SelectVoucherById(voucher.getId());

		if (vod != null) {
			vod.setState("处理");
			voucherService.updateVoucher(vod);
			ServletActionContext.getRequest().setAttribute("voucher", vod);
			message = new MessageInfo(0, "该条申请处理完成！", "", "");
		} else
			message = new MessageInfo(0, "该条站内信不存在！", "", "");
		return "message";
	}

	// 报销单及详细信息-修改
	public String updateVoucherCheck() throws Exception {

		Voucher vr = voucherService.SelectVoucherById(voucher.getId());

		voucher.setVoucherInfos(VoucherInfoList);

		voucher.setCreateTime(vr.getCreateTime());
		voucher.setCreateUserId(vr.getCreateUserId());
		voucher.setState("未处理");
		if (voucherService.updateVoucher(voucher)) {
			message = new MessageInfo(0, "报销单及详细信息-修改成功！", "", "");
		} else {
			message = new MessageInfo(0, "报销单及详细信息-修改失败！~~请你联系管理员", "", "");
		}
		return "message";
	}

	// 申请报销单及报销单详细信息
	public String addVoucher() throws Exception {

		if (VoucherInfoList != null && VoucherInfoList.size() > 0
				&& !voucher.getContent().equals("")
				&& VoucherInfoList.isEmpty() == false) {
			User userSession = (User) ActionContext.getContext().getSession()
					.get("User");
			voucher.setContent(voucher.getContent());
			voucher.setCreateTime(new Date());
			voucher.setCreateUserId(userSession);
			voucher.setState("未处理");
			voucherService.saveVoucher(voucher);
			double moeny = 0;
			for (int i = 0; i < VoucherInfoList.size(); i++) {
				VoucherInfo vo = (VoucherInfo) VoucherInfoList.get(i);
				if (vo.getContent().equals("") || vo.getItem().equals("")
						|| vo.getMoney() == 0) {
					message = new MessageInfo(0, "申请失败，内容不完整！", "", "");
					return "message";
				}
				moeny += vo.getMoney();
				vo.setVoucherId(voucher);
				voucherInfoService.saveVoucherInfo(vo);
				message = new MessageInfo(0, "正在申请，请耐心等待上级核审", "", "");
			}
			voucher.setMoney(moeny);
			voucherService.updateVoucher(voucher);
		} else {
			message = new MessageInfo(0, "申请失败，内容不完整！", "", "");
		}
		return "message";
	}

}
