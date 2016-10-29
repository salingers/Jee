package com.umt.myqq.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.umt.base.Message;
import com.umt.base.MessageType;
import com.umt.base.Student;
import com.umt.base.User;
import com.umt.myqq.net.MyqqClient;

public class ClientGui {
	
	private User fromUser;
	private JFrame frame;
	private MyqqClient myqqClient;
	private JEditorPane editorPane;
	private JEditorPane editorPane_1;
	private JList list;
	private Set onLineUser;
	
	public ClientGui(){
		init();
	}
	
	public ClientGui(MyqqClient myqqClient){
		this.myqqClient = myqqClient;
		init();
	}
	
	public ClientGui(MyqqClient myqqClient, Set onLineUser){
		this.myqqClient = myqqClient;
		this.onLineUser = onLineUser;
		init();
	}
	
	public ClientGui(MyqqClient myqqClient, Set onLineUser,User user){
		this.myqqClient = myqqClient;
		this.onLineUser = onLineUser;
		this.fromUser = user;
		init();
	}
	public void init(){
		frame = new JFrame();
		frame.setTitle("山寨聊天");
		frame.setBounds(200, 20, 400, 500);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 2, 250, 300);
		frame.add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setFont(new Font("",Font.BOLD | Font.ITALIC,14));
		scrollPane.setViewportView(editorPane);
		
		
		JScrollPane crollPane_1 = new JScrollPane();
		crollPane_1.setBounds(254, 2, 138, 300);
		frame.add(crollPane_1);
		
		
		/*
		 * 
		 * 添加人员列表
		 */
		DefaultListModel models = new DefaultListModel();

		for(Object obj:onLineUser){
			String username = (String) obj;
			
			if(username.equals(fromUser.getName().trim())){
				models.addElement("我");
			}else{
				models.addElement(username);
			}
		}
		
		list = new JList(models);
		crollPane_1.setViewportView(list);
		
		
		/*
		 * 添加输入框
		 */
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(2, 304, 390, 100);
		frame.add(scrollPane_2);
		
		editorPane_1 = new JEditorPane();
		scrollPane_2.setViewportView(editorPane_1);
		
		/*
		 * 给发送框添加一个键盘监听时间
		 */
		
		editorPane_1.addKeyListener(new KeyAdapter(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					sendMsg();
				}
			}
		});
		
		/*
		 * 添加按钮
		 * 
		 */
		JButton button = new JButton("发送");
		button.setBounds(140, 420, 60, 30);
		frame.add(button);
		
		
		
		//给“发送”按钮添加监听事件
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
			
		});
		
		JButton button_1 = new JButton("清空");
		button_1.setBounds(220, 420, 60, 30);
		frame.add(button_1);
		
		//添加“清空"按钮的监听
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				editorPane_1.setText("");
			}
			
		});
		
		
		final JCheckBox checkBox = new JCheckBox("All | None");
		checkBox.setBounds(300, 420, 100, 30);
		frame.add(checkBox);
		
		//给“All | None”checkBox添加监听事件
		checkBox.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int indexs[];
				if(checkBox.isSelected()){
					indexs = new int[list.getModel().getSize()];
					for(int i = 0; i < list.getModel().getSize(); i++){
						indexs[i] = i;
					}
				}else{
					indexs = new int[0];
				}
				list.setSelectedIndices(indexs);
				
			}
			
		});
		/*
		 * windowListener
		 */
		
		frame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		frame.setVisible(true);
		
	}

	
	public void setEditorPaneText(String msg){
		String oldMsg = this.editorPane.getText();
		
		msg = oldMsg.equals("") ? msg :(oldMsg + "\n" + msg);
		
		editorPane.setText(msg);
	}
	
	
	public JList getList() {
		return list;
	}
	
	public void sendMsg(){
		String msg = editorPane_1.getText();
		
		int index = msg.indexOf("\n");
		System.err.println(index);
		if(index == 1)
			msg = msg.substring(index);
		
		
		/*
		 * 向服务器发送信息
		 */
		
		/*
		 * 获得接收人员类表
		 */
		ArrayList<User> toUsers = new ArrayList<User>();
		Object[] objs = list.getSelectedValues();
		
		if(objs.length == 0){
			JOptionPane.showMessageDialog(null, "请选择聊天对象！","聊天异常",JOptionPane.WARNING_MESSAGE);
			
		}else if(msg.equals("")){
			JOptionPane.showMessageDialog(null, "发送信息不能为空！","聊天异常",JOptionPane.WARNING_MESSAGE);
		}else {
			
			if(objs.length == 1 && ((String)objs[0]).equals("我")){
				JOptionPane.showMessageDialog(null, "不能给自己发送信息！","聊天异常",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			for (int i = 0; i < objs.length; i++) {
				String username = (String) objs[i];
				
				if(!username.equals("我")){
					toUsers.add(new User(username));
				}
				
			}
			
			Message message = new Message();
			
			message.setFromUser(fromUser);
			message.setToUsers(toUsers);
			message.setMsgBody(msg);
			message.setType(MessageType.TEXT_MESSAGE);
			
			/*
			 * 将信息显式在信息框中
			 */
			String oldMsg = editorPane.getText();
			msg = oldMsg.equals("") ? ("我说：" + msg) : (oldMsg  + "\n" +"我说：" + msg);
			editorPane.setText(msg);
			
			
			editorPane_1.setText("");
		
			editorPane_1.nextFocus();
//			editorPane_1.setCaretPosition(0);
			
			
			myqqClient.sendMsg(myqqClient.getClient(),message);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientGui cg = new ClientGui();
		cg.init();
	}

}
