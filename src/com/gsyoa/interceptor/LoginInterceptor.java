package com.gsyoa.interceptor;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 登陆拦截器
 * @author 黄建伟
 * @date 2013-12-18
 * 韦海生 2013年12月23日，最后整理
 */
public class LoginInterceptor extends AbstractInterceptor {
	//声明，MessageInfo 实体，用于 提示
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	//用户信息实体
	private User user;
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		User u = (User)ActionContext.getContext().getSession().get("User");
		if(u!=null ){
			arg0.invoke();
		}
		return Action.LOGIN;
	}

}
