package com.gsyoa.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
   private String password;
   private String passwords;   

public void setPassword(String password) {
	this.password = password;
}
public void setPasswords(String passwords) {
	this.passwords = passwords;
}

	private User user;

	public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}

 // 声明 User服务，并设置 Set方法
 	private UserService userService;
 	public void setUserService(UserService userService) {
 		this.userService = userService;
 	}

	//声明，MessageInfo 实体，用于 提示
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}
    
    

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	
	public String update() throws Exception {
		 if(!user.getEmail().equals("")||!user.getPhone().equals("")){
		User userSession = (User) ActionContext.getContext().getSession().get("User");	
        User u=   userService.SelectUserById(userSession.getId());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        userService.updateUser(u);
        message = new MessageInfo(0, "修改成功", "", "");
      
    	ServletActionContext.getRequest().getSession().removeAttribute("User");
       
    	ActionContext.getContext().getSession().put("User", u);			
		 }else{
			 message = new MessageInfo(0, "信息输入错误，或者输入不完整，请重新输入	", "", "");
			 
		 }
		return "message";
	}

	public String loginOut() throws Exception {
		ServletActionContext.getRequest().getSession().removeAttribute("User");
		message = new MessageInfo(3, "注销成功", "index", "登录界面");
		return "message";
	}

	public String updatePassword() throws Exception {
		User userSession = (User) ActionContext.getContext().getSession().get("User");	
		if(password.equals(passwords) && userSession.getPassword().equals(user.getPassword()) && !password.equals("") ){
			userSession.setPassword(password);
			userService.updateUser(userSession);
			message = new MessageInfo(3, "密码修改成功！请拿新密码重新登录！", "User_loginOut", "登录界面");
		}else{
			message = new MessageInfo(0, "信息输入错误，或者输入不完整，请重新输入	", "", "");
		}
		return "message";
	}
	
	public String contact() throws Exception {
			
		User userSession = (User) ActionContext.getContext().getSession().get("User");	
		List<User> contactList=   userService.SelectAllUser(); 
		List<User> contatList = new ArrayList<User>();
		for (User con : contactList) {		
			if (con.getId()!=userSession.getId())
				contatList.add(con);
		}			
		ServletActionContext.getRequest().setAttribute("contactList", contatList);	
		return "contact";		
	}
	
}
