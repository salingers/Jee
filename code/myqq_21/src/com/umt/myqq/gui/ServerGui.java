package com.umt.myqq.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.umt.myqq.net.MyqqServer;

public class ServerGui {
	
	private JFrame frame;
	private String title = "MyQq_山寨版——服务器管理界面";
	private MyqqServer server;
	
	public ServerGui(){}
	
	public ServerGui(String title){
		this.title = title;		
	}
	
	public void init(){
		frame = new JFrame();
		frame.setBounds(150, 200, 380, 100);
		frame.setTitle(title);
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);
		
		
		
		/*
		 * 添加按钮
		 */
		
		JButton button_ok = new JButton("启动");
		frame.add(button_ok);
		
		button_ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				server = new MyqqServer();
				
				Thread t = new Thread(new Runnable(){

					public void run() {
						server.start();
					}
					
				});
				t.start();
			}
			
		});
		
		
		JButton button_close = new JButton("关闭");
		frame.add(button_close);
		
		button_close.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(server != null){
					server.close();
				}
			}
			
		});
		
		/*
		 * 添加windwoListener
		 */
		frame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
			
		});
		
		frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		ServerGui lg = new ServerGui();
		lg.init();
	}

}
