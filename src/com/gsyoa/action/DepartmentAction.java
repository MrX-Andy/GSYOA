package com.gsyoa.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Department;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Messages;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.DepartmentService;
import com.gsyoa.service.PositionService;
import com.gsyoa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 部门管理
 * 
 * @author 黄建伟
 * @date 2013年12月20日
 */
public class DepartmentAction extends ActionSupport {
	private MessageInfo message;

	public MessageInfo getMessage() {
		return message;
	}

	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// 声明部门
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 声明部门实体
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	// 声明UserService
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 声明User 实体，用于 保存员工信息
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {

			List<User> userList = userService.SelectAllUser();
			List<User> managerList = new ArrayList<User>();
			for (User u : userList) {
				for (Position position : u.getPositionId()) {
					if (position.getId() == 2)managerList.add(u);
				}
				
			}
			ServletActionContext.getRequest().setAttribute("userList",managerList);
			if(department!=null){
				department = departmentService.SelectDepartmentById(department.getId());
			}
		
		return "list";
	}

	public String add() {
		message = new MessageInfo(0, "您输入的信息不完整，请输入完整再进行提交！", "#", "上一步");
		if (!department.getContent().equals("")
				&& !department.getName().equals("")) {

           if(department.getId()==0){
			departmentService.saveDepartment(department);
			message = new MessageInfo(0, "添加成功！", "", "");
           }else{
        	   departmentService.updateDepartment(department);
				message = new MessageInfo(0, "修改成功！", "", "");
           }
		}

		return "message";

	}

	public String list() {

		List<Department> dpList = departmentService.SelectAllDepartment();

		ServletActionContext.getRequest().setAttribute("dpList", dpList);
		
		return "dplist";
	}

	public String delete() {
		User sessionUser = (User) ActionContext.getContext().getSession().get("User");
		message = new MessageInfo(0, "删除失败！你没有权限", "", "");
		for (Position position : sessionUser.getPositionId()) {
			if (position.getId() !=1) {
				if (departmentService.deleteDepartment(department.getId())) {
					message = new MessageInfo(0, "删除成功！", "", "");
				} else {
					message = new MessageInfo(0, "删除失败，请见擦该部门下是否存在其他员工！", "", "");
				}
				break;
			}
		}

		return "message";
	}

}
