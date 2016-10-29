package com.umt.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class ChatGui extends JFrame{
	
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
		JEditorPane editorPane1 = new JEditorPane();
		
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
		
		JTextArea textArea = new JTextArea();
		scrollPane3.setViewportView(textArea);	
		textArea.setLineWrap(true);	
		
		/*
		 *========================== �ı������ END================
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
