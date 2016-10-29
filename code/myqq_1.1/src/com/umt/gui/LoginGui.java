package com.umt.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.umt.vo.MessageType;

public class LoginGui extends JFrame{

private JTextField username;
private JPasswordField pwd;
private LoginClient loginClient;
private ChatGui chatGui;

	
	public LoginGui(String title) {
		super(title);
		init();
		loginClient = new LoginClient();	
		
	}
	
	public void close(){
		//�رյ��촰��
		this.setVisible(false);
		
		//�������촰��
		chatGui = new ChatGui("ɽկ����",loginClient.getClient());		//loginClient�ڹ��췽���н��г�ʼ��
	}
	
	public void init(){
		this.setBounds(300, 200, 300, 200);
		
		//��մ��ڵ�Ĭ�ϲ���
		this.setLayout(null);
		
		//label1
		JLabel label1 = new JLabel("�û���½");
		label1.setIcon(new ImageIcon("qqlogo.png"));
		label1.setBounds(0, 0, 300, 40);
		label1.setFont(new Font(null,Font.BOLD | Font.ITALIC,24));
		this.add(label1);
		
		//label2
		JLabel label2 = new JLabel("�û�����");
		label2.setBounds(20, 50, 60, 15);
		this.add(label2);
		
		
		username = new JTextField();
		username.setBounds(100, 50, 150, 20);
		this.add(username);
		
		
//		label3
		JLabel label3 = new JLabel("��  �룺");
		label3.setBounds(20, 80, 60, 15);
		this.add(label3);
		
		
		pwd = new JPasswordField();
		pwd.setBounds(100, 80, 150, 20);
		this.add(pwd);
		
		
		//��Ӱ�ť
		JButton button1 = new JButton("��½");
		button1.setBounds(40, 130, 60, 20);
		this.add(button1);
		
		//����½��ť��Ӽ���
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String msg = username.getText() + "-" + pwd.getText();
				loginClient.sendMsg(0 + "&" + msg);
				
//				boolean flag = false;
				loginClient.receiveMsg();
//				
//				System.out.println(flag);
			}			
		});
		
		
		
		
		JButton button2 = new JButton("����");
		button2.setBounds(150, 130, 60, 20);
		this.add(button2);
		
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("�ұ�����");
				System.out.println(username.getText());
				
				username.setText("");
				pwd.setText("");
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
	
	public static void main(String args[]){
		LoginGui lg = new LoginGui("ɽկQQ");
		
		
	}
	
	class LoginClient{
		private Socket client;
		
		public LoginClient() {
			this.start();
		}
		
		public void start(){
			try {
				client = new Socket("127.0.0.1",8888);			
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void sendMsg(String str){
			try {
				OutputStream os = client.getOutputStream();
				os.write(str.getBytes());
				os.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public boolean receiveMsg(){
			boolean flag = false;
			try {
				InputStream in = client.getInputStream();
				
				byte[] result = new byte[1024];
				in.read(result);
				
				String[] msg = new String(result).trim().split("&");
				
				if(Integer.parseInt(msg[0]) == MessageType.LOGIN_MESSAGE){
					if(Integer.parseInt(msg[1].trim()) == MessageType.LOGIN_SUCCESS){
						
						//�رյ�½����
						//�����촰��
						close();
						
					}else if(Integer.parseInt(msg[1].trim()) == MessageType.LOGIN_FAILURE){
						JOptionPane.showMessageDialog(null, "�û��������벻��ȷ�������µ�½");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return flag;
		}
		
		
		
		public Socket getClient(){
			try {
				return client != null ? client : new Socket("127.0.0.1",8888) ;
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}

}
