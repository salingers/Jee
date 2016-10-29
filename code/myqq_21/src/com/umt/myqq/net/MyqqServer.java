package com.umt.myqq.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.umt.base.Message;
import com.umt.base.MessageType;
import com.umt.base.User;

public class MyqqServer {
	private ServerSocket ss;
	private Socket client;
	//private final List<Socket> clients = new ArrayList<Socket>();
	private final HashMap<String, Socket> userMap = new HashMap<String, Socket>();

	public MyqqServer() {
		// start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
			System.err.println("�����������ɹ�...........");

			while (true) {
				client = ss.accept();
				//clients.add(client);

				new Thread(new ClientThread(client)).start();

			}

		} catch (SocketException s) {
			System.out.println("���������رգ���͹���Ա��ϵ��");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (ss != null) {
				ss.close();
			}

			System.err.println("�������ѹر�......");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ClientThread implements Runnable {

		private Socket client;
		private InputStream is;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private OutputStream os;
		private boolean flag = true;
		private Message msg;

		public ClientThread(Socket client) {
			this.client = client;

		}

		public void receiveMsg() {

			try {
				is = client.getInputStream();
				ois = new ObjectInputStream(is);
				msg = (Message) ois.readObject();

				if (msg != null) {

					if (msg.getType() == 1) { // �û���½
						System.out
								.println(msg.getFromUser().getName() + "�û���½");
						// ���µ�½�Ŀͻ��˷ŵ�������
						userMap.put(msg.getFromUser().getName().trim(), this.client);

						// ���ͻ��˷���������Ϣ
						Message toMsg = new Message();
						HashSet onLineUser = new HashSet(userMap.keySet());
						toMsg.setMsgBody(onLineUser); // ������Ա�б�
						toMsg.setType(MessageType.LOGIN_MESSAGE); // �û���½

						HashSet userSet = new HashSet(userMap.keySet());
						for (Iterator iterator = userSet.iterator(); iterator
								.hasNext();) {
						
							String username = (String) iterator.next();
							this.sendMsg(userMap.get(username.trim()), toMsg);// �� ����
							// �ͻ��˷�����Ϣ

						}
						

					}
					if (msg.getType() == 2) {// ��������
						 //�㲥��ָ���ͻ���
						 for (int i = 0; i < msg.getToUsers().size(); i++) {
						 Socket c = userMap.get(msg.getToUsers().get(i).getName().trim());
						 System.out.println("��ͻ��˷�������");
						 this.sendMsg(c, msg);
						 }
					}

				}

			} catch (SocketException s) {
				System.out.println("�ÿͻ������˳�");
				flag = false;
				//clients.remove(client);
				userMap.remove(msg.getFromUser().getName().trim());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		public void sendMsg(Socket client, String msg) {
			try {
				
				os = client.getOutputStream();

				os.write(msg.getBytes());

				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void sendMsg(Socket client, Message msg) {
			try {
				
				os = client.getOutputStream();
				oos = new ObjectOutputStream(os);

				oos.writeObject(msg);

				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			while (flag) {
				receiveMsg();
			}
		}

	}

}
