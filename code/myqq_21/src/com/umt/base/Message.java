package com.umt.base;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{
	
	private Object msgBody;//消息主题
	
	//private Socket client;	//客户端
	
	private User fromUser;	//发送人
	
	private ArrayList<User> toUsers = new ArrayList<User>();//接收人
	
	private int type;		//消息类型
	
	

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
