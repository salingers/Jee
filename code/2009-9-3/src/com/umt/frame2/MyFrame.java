package com.umt.frame2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame(String title){
		super(title);
		init();
	}
	
	public void init(){
		this.setBounds(300, 200, 300, 400);
		
		
		this.getContentPane().setBackground(Color.RED);
		//添加一个按钮
		JButton button1 = new JButton("提交");
		
		this.getContentPane().add(button1);
		
		//添加第二个按钮
		JButton button2 = new JButton("Button2");
		this.add(button2,BorderLayout.NORTH);
		
		JButton button3 = new JButton("Button3");
		this.add(button3,BorderLayout.SOUTH);
		
		JButton button4 = new JButton("Button4");
		this.add(button4,BorderLayout.EAST);
		
		JButton button5 = new JButton("Button5");
		this.add(button5,BorderLayout.WEST);
		
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("MyFrame");
	}

}
