package com.umt.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;

import com.umt.dao.UserDAO;
import com.umt.vo.MessageType;

public class ChatServer {

	private UserDAO userDAO;
	private boolean serverFlag = true;

	public ChatServer() {
		init();
	}

	public void init() {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("������������...");

			while(serverFlag){
				Socket s = server.accept();
				new Thread(new ServerManager(s)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
	}

	class ServerManager implements Runnable {
		private Socket s;
		private boolean flag = true;

		public ServerManager(Socket s) {
			this.s = s;
		}

		public void run() {
			while (flag) {
				if (s != null) {
					try {
						InputStream in = s.getInputStream();
						byte[] msg = new byte[1024];
						in.read(msg);

						String[] receiveMsg = new String(msg).trim().split("&");

						int messageType = Integer
								.parseInt(receiveMsg[0].trim()); // �����Ϣ����

						if (messageType == MessageType.LOGIN_MESSAGE) {

							// ��½��Ϣ

							// =======================================================

							boolean flag = false;
							userDAO = new UserDAO();

							// �����Ϣ�����ݣ���������в��

							String[] str = receiveMsg[1].trim().split("-");

							flag = userDAO.isLogin(str[0], str[1]);

							String sendMsg = "0&";

							if (flag == true) {
								// Ӧ�ø��߿ͻ��ˣ���½�ɹ�
								// �ͻ�����ת���������
								sendMsg += MessageType.LOGIN_SUCCESS;
							} else {
								// ��½ʧ��
								// Ӧ�ø��߿ͻ��˵�½ʧ��
								// �ͻ��˻�����ʾ��½����
								sendMsg += MessageType.LOGIN_FAILURE;
							}

							// ����Ϣ���͵��ͻ���
							OutputStream out = s.getOutputStream();
							out.write(sendMsg.getBytes());
							out.flush();

							// =======================================================
						} else if (messageType == MessageType.CHAT_MESSAGE) {
							// ������Ϣ
							System.out.println(receiveMsg[1]);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}

	}
}
