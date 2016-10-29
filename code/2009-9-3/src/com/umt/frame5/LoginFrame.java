package com.umt.frame5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	
	private JTextField username;
	
	public LoginFrame(String title) {
		super(title);
		init();
		
	}
	
	public void init(){
		this.setBounds(300, 200, 300, 200);
		
		//清空窗口的默认布局
		this.setLayout(null);
		
		//label1
		JLabel label1 = new JLabel("用户登陆");
		label1.setBounds(100, 10, 130, 20);
		label1.setFont(new Font(null,Font.BOLD | Font.ITALIC,24));
		this.add(label1);
		
		//label2
		JLabel label2 = new JLabel("用户名：");
		label2.setBounds(10, 50, 60, 15);
		this.add(label2);
		
		
		username = new JTextField();
		username.setBounds(90, 50, 150, 20);
		this.add(username);
		
		
		//添加按钮
		JButton button1 = new JButton("登陆");
		button1.setBounds(40, 130, 60, 20);
		this.add(button1);
		
		
		
		
		JButton button2 = new JButton("重置");
		button2.setBounds(150, 130, 60, 20);
		this.add(button2);
		
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("我被点了");
				System.out.println(username.getText());
				
				username.setText("");
			}
			
		});
		
		//
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		this.setResizable(false);
		
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame("登陆");
	}

}
