package com.gsyoa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.PositionService;
import com.gsyoa.service.SystemInfoService;
import com.gsyoa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 登陆处理Action
 * @author 黄建伟
 * @date 2013年12月13日
 * 韦海生 2013年12月23日，最后整理
 */
public class LoginAction extends ActionSupport {
	//声明User实体，用于接收参数
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//声明position
	private Position position;
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	//声明，MessageInfo 实体，用于 提示
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// 声明 User服务，并设置 Set方法
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	// 声明 Position 服务，并设置 Set方法
	private PositionService positionService;
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	//声明SystemInfo服务，并设置set方法
	private SystemInfoService systemInfoService;
	public void setSystemInfoService(SystemInfoService systemInfoService) {
		this.systemInfoService = systemInfoService;
	}
	
	@Override		//进登陆页面前进行 的查询，。   获取所有职位、系统信息
	public String execute() throws Exception {
		
		List<Position> positionList = positionService.SelectAllPosition();
		ServletActionContext.getRequest().setAttribute("PositionList",positionList);		//把数据库中的所有职位信息查询出来存到 PositionList 中
		
		//判断该全局变量是否存在，不存在则把数据库中的系统信息查询出来存到 SystemInfo 中
		//if(ActionContext.getContext().getApplication().get("SystemInfo")==null){
			ActionContext.getContext().getApplication().put("SystemInfo", systemInfoService.SelectSystemInfo(1));
		//}

		return SUCCESS;

	}

	//登陆信息处理方法
	public String login() {
		String certCode2 = (String) ActionContext.getContext().getSession().get("certCode");			//获取系统生成的验证码
		//判断内容是否为空，是则存入信息，返回提示页
		if (user == null 	|| (user.getId() == 0 || user.getPassword().equals("")))message = new MessageInfo(5, "输入信息不完整，登陆失败！", "index", "登陆页面");			//存入提示信息
		else if(!user.getState().equals(certCode2))message = new MessageInfo(5, "验证码错误！", "index", "登陆页面");			//存入提示信息
		else {
			User u = userService.SelectUserById(user.getId());				//根据Id查找用户信息
			if(u==null)message = new MessageInfo(5, "该编号不存在，请重新输入！", "index", "登陆页面");			//存入提示信息
			else if(!u.getState().equals("正常"))message = new MessageInfo(5, "你的账号已被限制登陆，请联系管理员或经理！", "index", "登陆页面");			//存入提示信息
			else{
				message = new MessageInfo(5, "您所选择的的登陆身份不对！", "index", "登陆页面");			//存入提示信息
				//遍历用户的  所有职务,用于判断 用户登陆身份是否存在
				for (Position p : u.getPositionId()) {
					if(p.getId()==position.getId()){						//如果所选的职务 在数据库中存在
						if (u != null && user.getPassword().equals(u.getPassword())) {		//如果查询数据库得到的结果不为空、并且密码相等
							ActionContext.getContext().getSession().put("User", u);						 // 把用户数据数据存到Session中
							ActionContext.getContext().getSession().put("UserPosition", p);						 // 把登陆登陆的身份数据存到Session中
							message = new MessageInfo(2, "登陆成功！", "Main_main", "管理首页");			//存入提示信息
						}else{
							message = new MessageInfo(5, "账号密码错误，请重新登陆！", "index", "登陆页面");			//存入提示信息
						}
						break;
					}
				}					//循环职位判断结束
			}
		}
		return "message";
	}
	
	
	
}
