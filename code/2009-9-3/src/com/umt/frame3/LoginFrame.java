package com.umt.frame3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class LoginFrame extends javax.swing.JFrame {
	
	public LoginFrame(String title) {
		super(title);
		init();
	}
	
	public void init(){
		this.setBounds(300, 200, 300, 200);
		
		
		
		
		/**
		 * ��Ӵ��ڼ���
		 */
		this.addWindowListener(new WindowListener(){

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("���ڱ��ر�");
				System.exit(0);
				
			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
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
