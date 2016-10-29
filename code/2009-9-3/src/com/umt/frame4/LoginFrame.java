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
		//�������Ĳ���
		panel.setLayout(new GridLayout(2,2));	
		
		//����û���
		JLabel label1 = new JLabel();
		label1.setText("�û���:");
		panel.add(label1);
		
		//����ı���
		JTextField username = new JTextField();
		panel.add(username);
		
		//�������
		JLabel label2 = new JLabel("���룺");
		panel.add(label2);
		
		//��������
		JPasswordField pwd = new JPasswordField();
		panel.add(pwd);
		
		this.add(panel,BorderLayout.CENTER);
		
		
		
		//
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.add(panel2,BorderLayout.SOUTH);
		
		//
		JButton button1 = new JButton("��½");
		JButton button2 = new JButton("ȡ��");
		
		panel2.add(button1);
		panel2.add(button2);
		
		
		
		
		
		/**
		 * ��Ӵ��ڼ���
		 */
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.out.println("���ڱ��ر�");
				System.exit(0);
				
			}
			
		});
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame("��½");
	}

}
