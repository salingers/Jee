package com.umt.frame4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginFrame extends javax.swing.JFrame {
	
	public LoginFrame(String title) {
		super(title);
		init();
	}
	
	public void init(){
		this.setBounds(300, 200, 300, 200);
		
		
		JPanel panel = new JPanel();
		//设置面板的布局
		panel.setLayout(new GridLayout(2,2));	
		
		//添加用户名
		JLabel label1 = new JLabel();
		label1.setText("用户名:");
		panel.add(label1);
		
		//添加文本框
		JTextField username = new JTextField();
		panel.add(username);
		
		//添加密码
		JLabel label2 = new JLabel("密码：");
		panel.add(label2);
		
		//添加密码框
		JPasswordField pwd = new JPasswordField();
		panel.add(pwd);
		
		this.add(panel,BorderLayout.CENTER);
		
		
		
		//
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.add(panel2,BorderLayout.SOUTH);
		
		//
		JButton button1 = new JButton("登陆");
		JButton button2 = new JButton("取消");
		
		panel2.add(button1);
		panel2.add(button2);
		
		
		
		
		
		/**
		 * 添加窗口监听
		 */
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.out.println("窗口被关闭");
				System.exit(0);
				
			}
			
		});
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame("登陆");
	}

}
