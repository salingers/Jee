package com.umt.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class ChatGui extends JFrame{
	
	public ChatGui(String title){
		super(title);
		
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
		JEditorPane editorPane1 = new JEditorPane();
		
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
		
		JList userList = new JList();
		
		//
		DefaultListModel model = new DefaultListModel();
		model.addElement("雷宁");
		model.addElement("李达");
		model.addElement("叶旭");
		
		userList.setModel(model);
		
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
		
		JTextArea textArea = new JTextArea();
		scrollPane3.setViewportView(textArea);	
		textArea.setLineWrap(true);	
		
		/*
		 *========================== 文本输入框 END================
		 */
		
		
		
		
		//添加窗口监听
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setVisible(true);
	}
	
	
	public static void main(String args[]){
		ChatGui cg = new ChatGui("Chat聊天");
	}

}
