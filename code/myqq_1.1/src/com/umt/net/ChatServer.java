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
			System.out.println("服务器已启动...");

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
								.parseInt(receiveMsg[0].trim()); // 获得消息类型

						if (messageType == MessageType.LOGIN_MESSAGE) {

							// 登陆信息

							// =======================================================

							boolean flag = false;
							userDAO = new UserDAO();

							// 获得消息的内容，并对其进行拆分

							String[] str = receiveMsg[1].trim().split("-");

							flag = userDAO.isLogin(str[0], str[1]);

							String sendMsg = "0&";

							if (flag == true) {
								// 应该告诉客户端，登陆成功
								// 客户端跳转到聊天界面
								sendMsg += MessageType.LOGIN_SUCCESS;
							} else {
								// 登陆失败
								// 应该告诉客户端登陆失败
								// 客户端还是显示登陆界面
								sendMsg += MessageType.LOGIN_FAILURE;
							}

							// 将信息发送到客户端
							OutputStream out = s.getOutputStream();
							out.write(sendMsg.getBytes());
							out.flush();

							// =======================================================
						} else if (messageType == MessageType.CHAT_MESSAGE) {
							// 聊天信息
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
