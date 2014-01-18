package com.gsyoa.interceptor;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ��½������
 * @author �ƽ�ΰ
 * @date 2013-12-18
 * Τ���� 2013��12��23�գ��������
 */
public class LoginInterceptor extends AbstractInterceptor {
	//������MessageInfo ʵ�壬���� ��ʾ
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	//�û���Ϣʵ��
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
