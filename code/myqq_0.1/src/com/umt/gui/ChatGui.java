package com.umt.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

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
		
		//创建scrollPane
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(1, 1, 250, 300);
		
		this.add(scrollPane1);
		
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
