package com.umt.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class ChatGui extends JFrame{
	
	private JEditorPane editorPane1;
	private JTextArea textArea;
	
	public ChatGui(String title){
		super(title);
		
		init();
	}

	private void init() {
		this.setBounds(300, 200, 400, 500);
		//���Ĭ�ϲ���
		this.setLayout(null);
		
		//�̶����ڵĴ�С
		this.setResizable(false);
		
		/*
		 *========================== �����¼================
		 */
		
		//����scrollPane
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(1, 1, 250, 300);
		
		//����editorPane1
		editorPane1 = new JEditorPane();
		
		editorPane1.setFont(new Font("����",Font.BOLD | Font.ITALIC,16));
		
		//��ediorPane���ɱ༭
		editorPane1.setEditable(false);
		scrollPane1.setViewportView(editorPane1);
		
		this.add(scrollPane1);
		
		/*
		 *========================== �����¼ END================
		 */
		
		/*
		 *========================== ��Ա�б�================
		 */
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(260, 1, 133, 300);
		this.add(scrollPane2);
		
		//����JList
		
		JList userList = new JList();
		
		//
		DefaultListModel model = new DefaultListModel();
		model.addElement("����");
		model.addElement("���");
		model.addElement("Ҷ��");
		
		userList.setModel(model);
		
		scrollPane2.setViewportView(userList);
		
		/*
		 *========================== ��Ա�б� END================
		 */
		
		/*
		 *========================== �ı������  ================
		 */
		
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(1, 310, 393, 100);
		this.add(scrollPane3);
		
		textArea = new JTextArea();
		scrollPane3.setViewportView(textArea);	
		textArea.setLineWrap(true);	
		
		/*
		 *========================== �ı������ END================
		 */
		
		
		/*
		 *========================== ��Ӱ�ť================
		 */
		
		JButton button1 = new JButton("ȡ��");
		button1.setBounds(100, 430, 60, 20);
		this.add(button1);
		
		JButton button2 = new JButton("����");
		button2.setBounds(200, 430, 60, 20);
		this.add(button2);
		
		//�����Ͱ�ť��Ӽ���
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("button2 click");
				
				editorPane1.setText(textArea.getText());
				
				textArea.setText("");
			}
			
		});
		
		
		/*
		 *========================== ���Checkbox================
		 */
		JCheckBox check = new JCheckBox("All|None");
		check.setBounds(300, 430, 100, 20);
		
		this.add(check);
		
		
		/*
		 *========================== ���Checkbox END================
		 */
		
		
		
		//��Ӵ��ڼ���
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setVisible(true);
	}
	
	
	public static void main(String args[]){
		ChatGui cg = new ChatGui("Chat����");
	}

}
