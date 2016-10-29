package com.umt.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import com.umt.vo.MessageType;

public class ChatGui extends JFrame{
	
	private JEditorPane editorPane1;
	private JTextArea textArea;
	private JList userList;
	private Socket client;
	
	
	public ChatGui(String title){
		super(title);
		
		init();
	}
	
	/**
	 * 
	 * @param title
	 * @param client :�ͷ������������ӵ�Socket����
	 */
	public ChatGui(String title,Socket client){
		super(title);
		this.client = client;
		
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
		
		userList = new JList();
		
		//
		DefaultListModel model = new DefaultListModel();
		model.addElement("����");
		model.addElement("���");
		model.addElement("Ҷ��");
		
		userList.setModel(model);
		
		
		//Ĭ��ѡ�е�һ������
		//userList.setSelectedIndex(2);
//		int[] indexs = {};
//		userList.setSelectedIndices(indexs);
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
		
		//��ȡ����ť��Ӽ���
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//��շ�����Ϣ�����Ϣ
				textArea.setText("");
			}			
		});
		
		JButton button2 = new JButton("����");
		button2.setBounds(200, 430, 60, 20);
		this.add(button2);
		
		//�����Ͱ�ť��Ӽ���
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println("button2 click");
				
				String oldMsg = editorPane1.getText();
				
				String msg = oldMsg == null || oldMsg.equals("") 
												? textArea.getText() 
												: oldMsg + "\n" + textArea.getText(); 
				
				editorPane1.setText(msg);
				
				
				//��÷��Ϳ��е���Ϣ����װ�����������ݡ���
				String sendmsg = MessageType.CHAT_MESSAGE + "&" +  textArea.getText().trim();
				sendMsg(sendmsg);
				
				textArea.setText("");
			}
			
		});
		
		
		/*
		 *========================== ���Checkbox================
		 */
		final JCheckBox check = new JCheckBox("All|None");
		check.setBounds(300, 430, 100, 20);
		
		this.add(check);
		
		
		//��Ӽ���
		check.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				int[] indexs;
				if(check.isSelected()){
					indexs = new int[userList.getModel().getSize()];
					
					for(int i = 0; i < indexs.length; i++){
						indexs[i] = i;
					}
					
				}else{
					indexs = new int[0];
				}
				
				userList.setSelectedIndices(indexs);
			}
			
		});
		
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
	
	
	/**
	 *  �������������Ϣ
	 * @param msg
	 */
	public void sendMsg(String msg){
		try {
			OutputStream out = this.client.getOutputStream();
			out.write(msg.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		ChatGui cg = new ChatGui("Chat����");
	}

}
