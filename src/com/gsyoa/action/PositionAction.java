package com.gsyoa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Department;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PositionAction extends ActionSupport {
	private MessageInfo message;

	public MessageInfo getMessage() {
		return message;
	}

	public void setMessage(MessageInfo message) {
		this.message = message;
	}
	// 声明position
			private Position position;

			public Position getPosition() {
				return position;
			}

			public void setPosition(Position position) {
				this.position = position;
			}
			private PositionService positionService;

			public void setPositionService(PositionService positionService) {
				this.positionService = positionService;
			}

			public PositionService getPositionService() {
				return positionService;
			}
	public String add(){
		message = new MessageInfo(0, "您输入的信息不完整，请输入完整再进行提交！", "#", "上一步");
		if (!position.getName().equals("")) {
			if(position.getId()==0){
				positionService.savePosition(position);
				
				message = new MessageInfo(0, "添加成功！", "", "");
			}else{
				positionService.updatePosition(position);
				message = new MessageInfo(0, "修改成功！", "", "");
			}
		}

		return "message";

	}
	public String list() {
		List<Position> positionList = positionService.SelectAllPosition();
		ServletActionContext.getRequest().setAttribute("positionList", positionList);
		return "positionList";
	}
	public String delete() {
		User sessionUser = (User) ActionContext.getContext().getSession().get("User");
		message = new MessageInfo(0, "删除失败！你没有权限", "", "");
		for (Position ps : sessionUser.getPositionId()) {
			if (ps.getId() !=1) {
				if (positionService.deletePosition(position.getId())) {
					message = new MessageInfo(0, "删除成功！", "", "");
				} else {
					message = new MessageInfo(0, "删除失败！该部门下有人", "", "");
				}
				break;
			}
		}

		return "message";
	}
public String update(){
	if(position.getId()==1||position.getId()==2||position.getId()==3){
		message = new MessageInfo(0, "没有权限修改", "", "");
		return "message";
	}else{
	position = positionService.SelectPositionById(position.getId());
	}
	return "update";
}

}
