package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Messages;
import com.gsyoa.entity.MessagesReply;
import com.gsyoa.entity.User;
import com.gsyoa.service.MessagesReplyService;
import com.gsyoa.service.MessagesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 站内信处理
 * @author Hello_海生
 * @date 2013年12月16日
 * 韦海生 2013年12月23日，最后整理
 */
public class MessagesAction extends ActionSupport {
	//站内信实体
	private Messages messages;
	public Messages getMessages() {
		return messages;
	}
	public void setMessages(Messages messages) {
		this.messages = messages;
	}
	
	//回复实体
	private MessagesReply messagesReply;
	public MessagesReply getMessagesReply() {
		return messagesReply;
	}
	public void setMessagesReply(MessagesReply messagesReply) {
		this.messagesReply = messagesReply;
	}
	
	//声明，MessageInfo 实体，用于 提示
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}
	
	
	// 声明 站内信 服务，并设置 Set方法
	private MessagesService messagesService;
	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
	
	//声明 站内信 服务，并设置 Set方法
	private MessagesReplyService messagesReplyService;
	public void setMessagesReplyService(MessagesReplyService messagesReplyService) {
		this.messagesReplyService = messagesReplyService;
	}
	
	
	//发送站内信
	public String send(){
		if(messages.getTitle().equals("") || messages.getReceiveUserId().equals("") || messages.getContent().equals("")){
			message = new MessageInfo(0, "您输入的信息不完整，请输入完整再进行提交！", "", "");
		}else{
			User user = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
			messages.setSendUserId(new User(user.getId()));
			messages.setState("未读");
			messages.setCreateTime(new Date());
			if(messagesService.saveMessages(messages))message = new MessageInfo(0, "信息已发送成功！", "", "");
			else message = new MessageInfo(0, "信息发送失败，请联系管理员！", "", "");
		}
		return "message";
	}
	
	//站内信列表
	public String list(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
		List<Messages> messagesList= messagesService.SelectMessagesByUserId(user.getId());	//查询该用户下的所有信息
		List<Messages> msgList=new ArrayList<Messages>();		//创建一个 信息数组用于 赛选
		for (Messages messages : messagesList) {		
			if(!messages.getState().equals("删除"))msgList.add(messages);		//获取未删除的信息
		}
		ServletActionContext.getRequest().setAttribute("messagesList",msgList);
		return "list";		//返回列表页
	}
	
	//回复站内信 页面
	public String reply(){
		Messages m= messagesService.SelectMessagesById(messages.getId());		//根据Id  获取该站内信的信息
		if(m==null)message=new MessageInfo(0, "该条站内信不存在！", "", "");
		else{
			ServletActionContext.getRequest().setAttribute("messages",m);		//存储站内信 信息 
			if(!m.getState().equals("删除")){		//如果该条信息不是 已经删除，则 修改状态为已读， 
				m.setState("已读");
				messagesService.updateMessages(m);
			}
			List<MessagesReply> messagesReplyList = messagesReplyService.selectMessagesReplyByMessagesId(m.getId());		//查询回复信息
			ServletActionContext.getRequest().setAttribute("messagesReplyList",messagesReplyList);			
		}
		return "reply";
	}
	
	//处理信息回复
	public String doReply(){
		if(messagesReply.getContent().equals(""))message = new MessageInfo(0, "回复内容不能为空！", "", "");
		else{
			User u = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
			messagesReply.setReplyTime(new Date());
			messagesReply.setSendUserId(u);	
			if(messagesReplyService.saveMessagesReply(messagesReply)){
				Messages m= messagesService.SelectMessagesById(messagesReply.getMessagesId().getId());
				m.setState("新回复");
				messagesService.updateMessages(m);
				message = new MessageInfo(0, "信息回复成功！", "", "");
			}else{
				message = new MessageInfo(0, "信息回复失败！", "", "");
			}
		}
		return "message";
	}
	
	//删除站内信
	public String delete(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
		Messages m = messagesService.SelectMessagesById(messages.getId());						//查询该条站内信的 信息
		if(m.getReceiveUserId().getId()!=user.getId())message = new MessageInfo(0, "该短息不属于您，您不能删除！", "","");
		else{
			if(m.getState().equals("删除")){		//如果 该条站内信的  状态  是 删除， 则 彻底删除
				if(messagesService.deleteMessages(m.getId()))message = new MessageInfo(0, "彻底删除成功！", "","");
				else message = new MessageInfo(0, "彻底删除失败！", "","");
			}else{
				m.setState("删除");
				if(messagesService.updateMessages(m))message = new MessageInfo(0, "删除成功！", "","");
				else message = new MessageInfo(0, "删除失败！", "","");
			}
		}
		return "message";
	}
	
	//已删除信息列表
	public String deletelist(){
		User user = (User) ActionContext.getContext().getSession().get("User");						//获取用户session
		List<Messages> messagesList= messagesService.SelectMessagesByUserId(user.getId());		//查询该用户的所有信息
		List<Messages> msgList=new ArrayList<Messages>();		
		for (Messages messages : messagesList) {
			if(messages.getState().equals("删除"))msgList.add(messages);	//遍历获取  已删除的数组
		}
		ServletActionContext.getRequest().setAttribute("messagesList",msgList);	
		return "list";
	}
	
	//恢复已删除的站内信
	public String recovery(){
		Messages m = messagesService.SelectMessagesById(messages.getId());
		if(m==null)message = new MessageInfo(0, "该站内信不存在或已被删除！", "","");
		else{
			m.setState("已读");
			if(messagesService.updateMessages(m))message = new MessageInfo(0, "短信息恢复成功！", "","");
			else	message = new MessageInfo(0, "短信息恢复失败！", "","");
		}
		return "message";
	}
	
	
}
