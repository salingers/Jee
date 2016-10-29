package com.umt.frame;

import java.awt.Color;

import javax.swing.JFrame;

public class TestFrame {

	public static void main(String args[]){
		JFrame frame = new JFrame("第一个窗口");
		
		frame.setBounds(300, 100, 200, 300);
		
		frame.getContentPane().setBackground(Color.red);
		
		frame.setVisible(true);
		
	}
}
