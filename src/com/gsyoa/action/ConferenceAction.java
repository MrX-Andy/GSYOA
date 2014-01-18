package com.gsyoa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gsyoa.entity.Conference;
import com.gsyoa.entity.Department;
import com.gsyoa.entity.MessageInfo;
import com.gsyoa.entity.Position;
import com.gsyoa.entity.User;
import com.gsyoa.service.ConferenceService;
import com.gsyoa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ConferenceAction extends ActionSupport {
	private Conference conference;

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	// 声明UserService
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private MessageInfo message;

	public MessageInfo getMessage() {
		return message;
	}

	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// 会议
	private ConferenceService conferenceService;

	public ConferenceService getConferenceService() {
		return conferenceService;
	}

	public void setConferenceService(ConferenceService conferenceService) {
		this.conferenceService = conferenceService;
	}

	public String execute() throws Exception {
		List<User> userList = userService.SelectAllUser();
		List<User> managerList = new ArrayList<User>();
		for (User u : userList) {
			for (Position position : u.getPositionId()) {

				if (position.getId() == 2){
					managerList.add(u);
				}
			}

		}
		ServletActionContext.getRequest().setAttribute("userList", managerList);
		return "positionList";
	}

	public String add() {
		message = new MessageInfo(0, "您输入的信息不完整，请输入完整再进行提交！", "#", "上一步");
		if (!conference.getContent().equals("")
				&& !conference.getTitle().equals("")
				&& !conference.getAddress().equals("")
				&& !conference.getCreateTime().equals("")) {

			if (conference.getId() == 0) {

				conference.setCreateTime((Date) conference.getCreateTime());
				conferenceService.saveConference(conference);
				message = new MessageInfo(0, "添加成功！", "", "");
			} else {
				conferenceService.updateConference(conference);
				conferenceService.saveConference(conference);
			}
		}
		return "message";

	}
	public String list(){

		List<Conference> cfList = conferenceService.SelectAllConference();

		ServletActionContext.getRequest().setAttribute("cfList", cfList);

	
		return "list";
	}
	public String show(){
		conference=conferenceService.SelectConferenceById(conference.getId());
		ServletActionContext.getRequest().setAttribute("showList",conference);
		return "showList";
	}
	public String delete(){
		User sessionUser = (User) ActionContext.getContext().getSession().get("User");
		message = new MessageInfo(0, "删除失败！你没有权限", "", "");
		for (Position position : sessionUser.getPositionId()) {
			if (position.getId() != 1) {
				if (conferenceService.deleteConference(conference.getId())) {
					message = new MessageInfo(0, "删除成功！", "", "");
				} else {
					message = new MessageInfo(0, "删除失败", "", "");
				}
				break;
			}
		}

		return "message";
		
	}
}