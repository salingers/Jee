package com.umt.net6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public void init() throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("����������...");

		while (true) {

			Socket s = server.accept();
			
			ServerManager sm = new ServerManager(s);
			new Thread(sm).start();
			
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.init();
	}

	class ServerManager implements Runnable{
		
		private Socket s = null;
		
		public ServerManager(Socket s) {
			this.s = s;
		}
		

		public void run() {
			if (s != null) {

				while (true) {
					// ���������,��ͻ��˷�����Ϣ

					System.out.println("������˵��");
					Scanner reader = new Scanner(System.in);
					String str = reader.nextLine();

					OutputStream out;
					try {
						out = s.getOutputStream();
						out.write(str.getBytes());
						out.flush();

						// ������������������ȡ�ӿͻ��̷��͵���Ϣ
						InputStream in = s.getInputStream();
						byte[] msg = new byte[1024];
						in.read(msg);
						System.out.println("�ͻ���˵��");
						System.out.println(new String(msg).trim());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
