package com.umt.base;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{
	
	private Object msgBody;//��Ϣ����
	
	//private Socket client;	//�ͻ���
	
	private User fromUser;	//������
	
	private ArrayList<User> toUsers = new ArrayList<User>();//������
	
	private int type;		//��Ϣ����
	
	

	public Message() {
		super();
	}

	public Message(Object msgBody, User fromUser, ArrayList<User> toUsers, int type) {
		super();
		this.msgBody = msgBody;
		this.fromUser = fromUser;
		this.toUsers = toUsers;
		this.type = type;
	}

	public Object getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(Object msgBody) {
		this.msgBody = msgBody;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public ArrayList<User> getToUsers() {
		return toUsers;
	}

	public void setToUsers(ArrayList<User> toUsers) {
		this.toUsers = toUsers;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
