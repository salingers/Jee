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
		System.out.println("服务器启动...");

		Socket s = server.accept();

		if (s != null) {

			while (true) {
				// 创建输出流,向客户端发送信息

				System.out.println("服务器说：");
				Scanner reader = new Scanner(System.in);
				String str = reader.nextLine();

				OutputStream out = s.getOutputStream();

				out.write(str.getBytes());
				out.flush();


				// 创建输入流，用来获取从客户短发送的信息
				InputStream in = s.getInputStream();
				byte[] msg = new byte[1024];
				in.read(msg);
				System.out.println("客户端说：");
				System.out.println(new String(msg).trim());

			}
		}
	}

}
