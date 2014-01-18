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

/** ��½����Action
 * @author �ƽ�ΰ
 * @date 2013��12��13��
 * Τ���� 2013��12��23�գ��������
 */
public class LoginAction extends ActionSupport {
	//����Userʵ�壬���ڽ��ղ���
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//����position
	private Position position;
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	//������MessageInfo ʵ�壬���� ��ʾ
	private MessageInfo message;
	public MessageInfo getMessage() {
		return message;
	}
	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	// ���� User���񣬲����� Set����
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	// ���� Position ���񣬲����� Set����
	private PositionService positionService;
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	//����SystemInfo���񣬲�����set����
	private SystemInfoService systemInfoService;
	public void setSystemInfoService(SystemInfoService systemInfoService) {
		this.systemInfoService = systemInfoService;
	}
	
	@Override		//����½ҳ��ǰ���� �Ĳ�ѯ����   ��ȡ����ְλ��ϵͳ��Ϣ
	public String execute() throws Exception {
		
		List<Position> positionList = positionService.SelectAllPosition();
		ServletActionContext.getRequest().setAttribute("PositionList",positionList);		//�����ݿ��е�����ְλ��Ϣ��ѯ�����浽 PositionList ��
		
		//�жϸ�ȫ�ֱ����Ƿ���ڣ�������������ݿ��е�ϵͳ��Ϣ��ѯ�����浽 SystemInfo ��
		//if(ActionContext.getContext().getApplication().get("SystemInfo")==null){
			ActionContext.getContext().getApplication().put("SystemInfo", systemInfoService.SelectSystemInfo(1));
		//}

		return SUCCESS;

	}

	//��½��Ϣ������
	public String login() {
		String certCode2 = (String) ActionContext.getContext().getSession().get("certCode");			//��ȡϵͳ���ɵ���֤��
		//�ж������Ƿ�Ϊ�գ����������Ϣ��������ʾҳ
		if (user == null 	|| (user.getId() == 0 || user.getPassword().equals("")))message = new MessageInfo(5, "������Ϣ����������½ʧ�ܣ�", "index", "��½ҳ��");			//������ʾ��Ϣ
		else if(!user.getState().equals(certCode2))message = new MessageInfo(5, "��֤�����", "index", "��½ҳ��");			//������ʾ��Ϣ
		else {
			User u = userService.SelectUserById(user.getId());				//����Id�����û���Ϣ
			if(u==null)message = new MessageInfo(5, "�ñ�Ų����ڣ����������룡", "index", "��½ҳ��");			//������ʾ��Ϣ
			else if(!u.getState().equals("����"))message = new MessageInfo(5, "����˺��ѱ����Ƶ�½������ϵ����Ա����", "index", "��½ҳ��");			//������ʾ��Ϣ
			else{
				message = new MessageInfo(5, "����ѡ��ĵĵ�½��ݲ��ԣ�", "index", "��½ҳ��");			//������ʾ��Ϣ
				//�����û���  ����ְ��,�����ж� �û���½����Ƿ����
				for (Position p : u.getPositionId()) {
					if(p.getId()==position.getId()){						//�����ѡ��ְ�� �����ݿ��д���
						if (u != null && user.getPassword().equals(u.getPassword())) {		//�����ѯ���ݿ�õ��Ľ����Ϊ�ա������������
							ActionContext.getContext().getSession().put("User", u);						 // ���û��������ݴ浽Session��
							ActionContext.getContext().getSession().put("UserPosition", p);						 // �ѵ�½��½��������ݴ浽Session��
							message = new MessageInfo(2, "��½�ɹ���", "Main_main", "������ҳ");			//������ʾ��Ϣ
						}else{
							message = new MessageInfo(5, "�˺�������������µ�½��", "index", "��½ҳ��");			//������ʾ��Ϣ
						}
						break;
					}
				}					//ѭ��ְλ�жϽ���
			}
		}
		return "message";
	}
	
	
	
}
