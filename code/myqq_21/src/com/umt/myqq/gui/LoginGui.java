package com.umt.myqq.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ConnectException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.umt.base.Message;
import com.umt.base.MessageType;
import com.umt.base.User;
import com.umt.myqq.net.MyqqClient;

public class LoginGui {
	
	private JFrame frame;
	private String title = "MyQq_山寨版";
	
	public LoginGui(){}
	
	public LoginGui(String title){
		this.title = title;		
	}
	
	public void init(){
		frame = new JFrame();
		frame.setBounds(150, 200, 380, 250);
		frame.setTitle(title);
		frame.setLayout(null);
		frame.setResizable(false);
		
		JLabel titleLabel = new JLabel("QQ登陆界面");
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
		
		/*
		 * 添加按钮
		 */
		JButton button_ok = new JButton("登陆");
		button_ok.setBounds(90, 150, 60, 30);
		frame.add(button_ok);
		
		//给“登陆”按钮添加一个监听
		button_ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				String name = username.getText();
				String password = pwd.getText();
				User user2 = new User(name,password);
				
				if(name != null && !name.equals("") 
						&& password != null && !password.equals("")){
					frame.hide();
					
					MyqqClient myqqClient = new MyqqClient();
					
					myqqClient.setUser(user2);
					
					/*
					 * 给服务器发送消息，告诉服务器有客户端登陆
					 */
					Message msg = new Message();
					msg.setType(1);	//登陆
					
					User user = new User(name,password);
					msg.setFromUser(user);
					
					myqqClient.sendMsg(myqqClient.getClient(),msg);
					
					
					/*
					 * 从服务器接收消息，获得已登陆客户端信息
					 */
					
					//................
					Message fromMsg = myqqClient.receiveMsg();
					if(fromMsg.getType() == MessageType.LOGIN_MESSAGE){
					System.out.println("登陆成功！");
						myqqClient.start();
						
						
						ClientGui clientGui = new ClientGui(myqqClient,(Set)fromMsg.getMsgBody(),user2);
						
						myqqClient.setClientGui(clientGui);
					}else{
						System.out.println("登陆失败！");
					}
					
					
				}else{
					final JDialog dialog = new JDialog();
					dialog.setTitle("警告框");
					dialog.setBounds(200, 250, 300, 150);
					dialog.setLayout(null);
					
					JLabel label = new JLabel("用户名或密码为空！");
					label.setBounds(50, 20, 200, 30);
					label.setFont(new Font("",Font.BOLD,20));
					dialog.add(label);
					
					
					JButton button = new JButton("确定");
					button.setBounds(100,60,60,30);
					dialog.add(button);
					
					//添加监听
					button.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent e) {
							dialog.hide();
						}
						
					});
					
					dialog.show();
				}
			}
			
		});
		
		
		JButton button_reset = new JButton("清除");
		button_reset.setBounds(170, 150, 60, 30);
		frame.add(button_reset);
		
		/*
		 * 给“清除”按钮添加监听
		 */
		button_reset.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				username.setText("");
				pwd.setText("");
			}
			
		});
		
		
		JButton button_register = new JButton("注册");
		button_register.setBounds(250, 150, 60, 30);
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
		LoginGui lg = new LoginGui();
		lg.init();
	}

}
