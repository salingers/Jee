package com.umt.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import com.umt.vo.MessageType;

public class ChatGui extends JFrame{
	
	private JEditorPane editorPane1;
	private JTextArea textArea;
	private JList userList;
	private Socket client;
	
	
	public ChatGui(String title){
		super(title);
		
		init();
	}
	
	/**
	 * 
	 * @param title
	 * @param client :和服务器建立连接的Socket对象
	 */
	public ChatGui(String title,Socket client){
		super(title);
		this.client = client;
		
		init();
	}


	private void init() {
		this.setBounds(300, 200, 400, 500);
		//清空默认布局
		this.setLayout(null);
		
		//固定窗口的大小
		this.setResizable(false);
		
		/*
		 *========================== 聊天记录================
		 */
		
		//创建scrollPane
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(1, 1, 250, 300);
		
		//创建editorPane1
		editorPane1 = new JEditorPane();
		
		editorPane1.setFont(new Font("黑体",Font.BOLD | Font.ITALIC,16));
		
		//让ediorPane不可编辑
		editorPane1.setEditable(false);
		scrollPane1.setViewportView(editorPane1);
		
		this.add(scrollPane1);
		
		/*
		 *========================== 聊天记录 END================
		 */
		
		/*
		 *========================== 人员列表================
		 */
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(260, 1, 133, 300);
		
		
		this.add(scrollPane2);
		
		//创建JList
		
		userList = new JList();
		
		//
		DefaultListModel model = new DefaultListModel();
		model.addElement("雷宁");
		model.addElement("李达");
		model.addElement("叶旭");
		
		userList.setModel(model);
		
		
		//默认选中第一个对象
		//userList.setSelectedIndex(2);
//		int[] indexs = {};
//		userList.setSelectedIndices(indexs);
		scrollPane2.setViewportView(userList);
		
		/*
		 *========================== 人员列表 END================
		 */
		
		/*
		 *========================== 文本输入框  ================
		 */
		
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(1, 310, 393, 100);
		this.add(scrollPane3);
		
		textArea = new JTextArea();
		scrollPane3.setViewportView(textArea);	
		textArea.setLineWrap(true);	
		
		/*
		 *========================== 文本输入框 END================
		 */
		
		
		/*
		 *========================== 添加按钮================
		 */
		
		JButton button1 = new JButton("取消");
		button1.setBounds(100, 430, 60, 20);
		this.add(button1);
		
		//给取消按钮添加监听
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//清空发送信息框的信息
				textArea.setText("");
			}			
		});
		
		JButton button2 = new JButton("发送");
		button2.setBounds(200, 430, 60, 20);
		this.add(button2);
		
		//给发送按钮添加监听
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("button2 click");
				
				String oldMsg = editorPane1.getText();
				
				String msg = oldMsg == null || oldMsg.equals("") 
												? textArea.getText() 
												: oldMsg + "\n" + textArea.getText(); 
				
				editorPane1.setText(msg);
				
				
				//获得发送框中的信息，封装到“传输数据”中
				String sendmsg = MessageType.CHAT_MESSAGE + "&" +  textArea.getText().trim();
				sendMsg(sendmsg);
				
				textArea.setText("");
			}
			
		});
		
		
		/*
		 *========================== 添加Checkbox================
		 */
		final JCheckBox check = new JCheckBox("All|None");
		check.setBounds(300, 430, 100, 20);
		
		this.add(check);
		
		
		//添加监听
		check.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				int[] indexs;
				if(check.isSelected()){
					indexs = new int[userList.getModel().getSize()];
					
					for(int i = 0; i < indexs.length; i++){
						indexs[i] = i;
					}
					
				}else{
					indexs = new int[0];
				}
				
				userList.setSelectedIndices(indexs);
			}
			
		});
		
		/*
		 *========================== 添加Checkbox END================
		 */
		
		
		
		//添加窗口监听
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setVisible(true);
	}
	
	
	/**
	 *  向服务器发送信息
	 * @param msg
	 */
	public void sendMsg(String msg){
		try {
			OutputStream out = this.client.getOutputStream();
			out.write(msg.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		ChatGui cg = new ChatGui("Chat聊天");
	}

}
