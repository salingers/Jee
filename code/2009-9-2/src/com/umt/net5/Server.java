package com.umt.net5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6666);
		System.out.println("����������...");

		Socket s = server.accept();

		if (s != null) {

			while (true) {
				// ���������,��ͻ��˷�����Ϣ

				System.out.println("������˵��");
				Scanner reader = new Scanner(System.in);
				String str = reader.nextLine();

				OutputStream out = s.getOutputStream();

				out.write(str.getBytes());
				out.flush();


				// ������������������ȡ�ӿͻ��̷��͵���Ϣ
				InputStream in = s.getInputStream();
				byte[] msg = new byte[1024];
				in.read(msg);
				System.out.println("�ͻ���˵��");
				System.out.println(new String(msg).trim());

			}
		}
	}

}
