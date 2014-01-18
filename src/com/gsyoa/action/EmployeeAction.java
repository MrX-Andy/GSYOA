package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Department;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Messages;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.SystemInfo;
import com.gsyoa.entity.User;
import com.gsyoa.service.DepartmentService;
import com.gsyoa.service.MessagesReplyService;
import com.gsyoa.service.MessagesService;
import com.gsyoa.service.PositionService;
import com.gsyoa.service.SystemInfoService;
import com.gsyoa.service.UserService;
import com.gsyoa.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 员工管理
 * 
 * @author 黄建伟
 * @date 2013年12月19日
 */
public class EmployeeAction extends ActionSupport {
	// 声明User 实体，用于 保存员工信息
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private MessageInfo message;

	public MessageInfo getMessage() {
		return message;
	}

	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	private PositionService positionService;

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	// 声明 User服务，并设置 Set方法
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 声明position
	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	// 声明SystemInfo服务，并设置set方法
	private SystemInfoService systemInfoService;

	public void setSystemInfoService(SystemInfoService systemInfoService) {
		this.systemInfoService = systemInfoService;
	}


	// 声明 站内信 服务，并设置 Set方法
		private MessagesService messagesService;
		public void setMessagesService(MessagesService messagesService) {
			this.messagesService = messagesService;
		}
		private DepartmentService departmentService;
		
	
	public void setDepartmentService(DepartmentService departmentService) {
			this.departmentService = departmentService;
		}

	public String execute() throws Exception {
		List<Position> positionList = positionService.SelectAllPosition();
		ServletActionContext.getRequest().setAttribute("positionList",positionList);
		List<Department> departmentList = departmentService.SelectAllDepartment();
		ServletActionContext.getRequest().setAttribute("departmentList",departmentList);
		
		if(user!=null){
			if(user.getId()!=0){
				user= userService.SelectUserById(user.getId());
			}
		}
		
		
		// ServletActionContext.getRequest().
		return SUCCESS;

	}

	public String add() {
		
		message = new MessageInfo(0, "您输入的信息不完整，请输入完整再进行提交！", "#", "上一步");
		if (!user.getState().equals("") && !user.getEmail().equals("")
				&& !user.getName().equals("") && !user.getPassword().equals("")
				&& !user.getPhone().equals("")
				&& !user.getDepartmentId().equals("")
				&& position.getId()!=0) {
			
			Set<Position>  positionsSet=new HashSet<Position>();	
			Position p=new Position(position.getId());	
			positionsSet.add(p);
			user.setPositionId(positionsSet);
			
			if(user.getId()==0){
				userService.saveUser(user);
				message = new MessageInfo(0, "添加成功！", "", "");
			}
			else {
				userService.updateUser(user);
				message = new MessageInfo(0, "修改成功！", "", "");
			}
		}

		return "message";

	}
	public String list(){
		
		List<User> userList= userService.SelectAllUser();
		
		ServletActionContext.getRequest().setAttribute("userList",userList);
		return "list";
	}
	public String delete(){
		User sessionUser = (User) ActionContext.getContext().getSession().get("User");	
		message = new MessageInfo(0, "删除失败！你没有权限", "", "");
		for (Position position : sessionUser.getPositionId()) {
			if(position.getId()!=2){
				if(userService.deleteUser(user.getId()))
					message = new MessageInfo(0, "删除成功！", "","");
				else message = new MessageInfo(0, "删除失败！", "","");
				break;
			}
		}
	
		return "message";
	}

}
