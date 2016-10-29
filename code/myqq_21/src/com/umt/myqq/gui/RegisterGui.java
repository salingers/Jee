package com.umt.myqq.gui;

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

public class RegisterGui {
	
	private JFrame frame;
	private String title = "MyQq_山寨版";
	
	public RegisterGui(){}
	
	public RegisterGui(String title){
		this.title = title;		
	}
	
	public void init(){
		frame = new JFrame();
		frame.setBounds(150, 200, 380, 300);
		frame.setTitle(title);
		frame.setLayout(null);
		frame.setResizable(false);
		
		JLabel titleLabel = new JLabel("QQ注册界面");
		titleLabel.setFont(new Font("",Font.BOLD,20));
		titleLabel.setBounds(145, 30, 118, 20);
		frame.add(titleLabel);
		
		
		/*
		 *添加用户名
		 */
		JLabel usernameLabel = new JLabel("用户名：");
		usernameLabel.setBounds(70, 70, 80, 20);
		frame.add(usernameLabel);
		
		final JTextField username = new JTextField();
		username.setBounds(160, 70, 170, 20);
		frame.add(username);
		
		/*
		 *添加密码
		 */
		JLabel pwdLabel = new JLabel("密    码：");
		pwdLabel.setBounds(70, 100, 80, 20);
		frame.add(pwdLabel);
		
		final JPasswordField  pwd = new JPasswordField ();
		pwd.setBounds(160, 100, 170, 20);
		frame.add(pwd);
		
		JLabel pwdLabel_1 = new JLabel("确认密码：");
		pwdLabel_1.setBounds(70, 130, 80, 20);
		frame.add(pwdLabel_1);
		
		final JPasswordField  pwd_1 = new JPasswordField ();
		pwd_1.setBounds(160, 130, 170, 20);
		frame.add(pwd_1);
		
		/*
		 * 添加按钮
		 */
		
		JButton button_reset = new JButton("清除");
		button_reset.setBounds(170, 180, 60, 30);
		frame.add(button_reset);
		
		/*
		 * 给“清除”按钮添加监听
		 */
		button_reset.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				username.setText("");
				pwd.setText("");
				pwd_1.setText("");
			}
			
		});
		
		
		JButton button_register = new JButton("注册");
		button_register.setBounds(250, 180, 60, 30);
		frame.add(button_register);
		
		
		
		
		
		
		
		
		
		
		
		
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
		RegisterGui lg = new RegisterGui();
		lg.init();
	}

}
