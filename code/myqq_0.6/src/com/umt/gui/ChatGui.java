package com.umt.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class ChatGui extends JFrame{
	
	private JEditorPane editorPane1;
	private JTextArea textArea;
	
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
		
		JButton button2 = new JButton("发送");
		button2.setBounds(200, 430, 60, 20);
		this.add(button2);
		
		//给发送按钮添加监听
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("button2 click");
				
				editorPane1.setText(textArea.getText());
				
				textArea.setText("");
			}
			
		});
		
		
		/*
		 *========================== 添加Checkbox================
		 */
		JCheckBox check = new JCheckBox("All|None");
		check.setBounds(300, 430, 100, 20);
		
		this.add(check);
		
		
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
	
	
	public static void main(String args[]){
		ChatGui cg = new ChatGui("Chat聊天");
	}

}
