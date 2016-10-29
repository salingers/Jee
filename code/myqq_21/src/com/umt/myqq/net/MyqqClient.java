package com.umt.myqq.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.umt.base.Message;
import com.umt.base.MessageType;
import com.umt.base.User;
import com.umt.myqq.gui.ClientGui;

public class MyqqClient {
	
	private Socket client;
	private InputStream is;
	private ObjectInputStream ois;
	private OutputStream os;
	private ObjectOutputStream oos;
	private ClientGui clientGui;
	private User user;
	
	public MyqqClient(){
		init();
	}
	
	
	public MyqqClient(ClientGui clientGui){
		this.clientGui = clientGui;
		init();
	}
	
	public void init(){
		try {
			client = new Socket("127.0.0.1",8888);
//			is = client.getInputStream();
			//将线程放到构造方法中启动
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 启动客户端接收的多线程
	 */
	public void start(){
		new Thread(new ClientRunnable(client)).start();
	}

	
	public void sendMsg(String msg){
		OutputStream os;
		try {
			os = client.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void sendMsg(Socket client,Message msg){
		
		try {
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(msg);
			oos.flush();
			
//			oos.reset();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从服务器端接收信息
	 * @return
	 */
	public Message receiveMsg(){
		Message message = null;
		try {
			is = this.client.getInputStream();
			ois = new ObjectInputStream(is);
			
			message = (Message) ois.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			return message;
		}
	}
	
	class ClientRunnable implements Runnable{
		private Socket client;
		private InputStream is;
		
		public ClientRunnable(Socket client){
			this.client = client;
		}
		
		public void run() {
			while(true){
				Message fromMsg = receiveMsg();
				
				if(fromMsg.getType() == MessageType.LOGIN_MESSAGE){
					DefaultListModel models = new DefaultListModel();
					
					HashSet userSet = (HashSet) fromMsg.getMsgBody();
					for(Object obj : userSet){
						String username = (String) obj;
						
						if(username.equals(user.getName().trim())){
							models.addElement("我");
						}else{
							models.addElement(username);
						}
					}
					
					clientGui.getList().setModel(models);
					
				}else if(fromMsg.getType() == MessageType.TEXT_MESSAGE){
					clientGui.setEditorPaneText(fromMsg.getFromUser().getName() + " 说：" + 
													(String)fromMsg.getMsgBody());
				}
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyqqClient myclient = new MyqqClient();
		myclient.start();
	}

	public void setClientGui(ClientGui clientGui2) {
		this.clientGui = clientGui2;
	}


	public Socket getClient() {
		return client;
	}


	public void setClient(Socket client) {
		this.client = client;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
